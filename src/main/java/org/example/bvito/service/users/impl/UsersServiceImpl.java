package org.example.bvito.service.users.impl;

import org.example.bvito.mappers.users.UserAdsMapper;
import org.example.bvito.mappers.users.UsersMapper;
import org.example.bvito.models.Users;
import org.example.bvito.repository.AdsRepository;
import org.example.bvito.repository.UsersRepository;
import org.example.bvito.schemas.ads.out.AdsWithoutUserSchema;
import org.example.bvito.schemas.users.in.UserAuthenticateSchema;
import org.example.bvito.schemas.users.out.SecureUserSchema;
import org.example.bvito.schemas.users.out.UserAdsSchema;
import org.example.bvito.schemas.users.in.UserSchema;
import org.example.bvito.service.users.UsersService;
import org.example.bvito.service.users.exceptions.InvalidCredentials;
import org.example.bvito.service.users.utils.PasswordManager;
import org.example.bvito.service.users.utils.UserAuthentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;
    private final AdsRepository adsRepository;

    private final UsersMapper usersMapper;
    private final UserAdsMapper userAdsMapper;


    public UsersServiceImpl(UsersRepository usersRepository, AdsRepository adsRepository, UsersMapper usersMapper, UserAdsMapper userAdsMapper) {
        this.usersRepository = usersRepository;
        this.adsRepository = adsRepository;
        this.usersMapper = usersMapper;
        this.userAdsMapper = userAdsMapper;
    }


    public UserAdsSchema getUserAds(int u_id) {
        Users user = usersRepository.findById(u_id).orElseThrow();
        List<AdsWithoutUserSchema> adList = adsRepository.findAllByUser(user);

        SecureUserSchema secureUserSchema = usersMapper.toSchema(user);
        return userAdsMapper.toSchema(secureUserSchema, adList);
    }

    public SecureUserSchema getUserByCredentials(UserAuthenticateSchema userAuthenticateSchema) throws InvalidCredentials {
        Users user = usersRepository.findByUserName(userAuthenticateSchema.getUser_name());
        if (UserAuthentication.check(userAuthenticateSchema, user)) {
            return usersMapper.toSchema(user);
        } else {
            throw new InvalidCredentials();
        }
    }

    public void addUser(UserSchema userSchema) {
        Users user = usersMapper.toEntity(userSchema);
        user.setPassword(PasswordManager.hash(user.getPassword()));
        usersRepository.save(user);
    }

    public SecureUserSchema getUserById(int u_id) {
        Users user = usersRepository.findById(u_id).orElseThrow(
                () -> new NoSuchElementException("User not found"));
        return usersMapper.toSchema(user);
    }

    @Transactional
    public Users updateUser(int u_id, UserSchema userSchema) {
        Users existingUser = usersRepository.findById(u_id).orElseThrow();
        usersMapper.updateEntity(userSchema, existingUser);

        return existingUser;
    }

    @Transactional
    public void deleteUserById(int u_id) {
        usersRepository.deleteById(u_id);
    }
}
