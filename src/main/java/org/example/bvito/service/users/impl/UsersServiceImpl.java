package org.example.bvito.service.users.impl;

import org.example.bvito.mappers.ads.AdsMapper;
import org.example.bvito.mappers.users.UsersMapper;
import org.example.bvito.models.Users;
import org.example.bvito.repository.AdsRepository;
import org.example.bvito.repository.UsersRepository;
import org.example.bvito.schemas.ads.out.AdWithoutUserSchema;
import org.example.bvito.schemas.ads.out.NoUserAdSchema;
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

import java.util.*;

/**
 * Class which contains all business logic for {@link Users} model
 * <p>
 * Implementation of {@link UsersService} interface
 * <p>
 * Depends on {@link UsersRepository}, {@link AdsRepository}, {@link AdsMapper}
 *
 * @author Aleksey
 */
@Service
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;
    private final AdsRepository adsRepository;

    private final UsersMapper usersMapper;


    public UsersServiceImpl(UsersRepository usersRepository, AdsRepository adsRepository, UsersMapper usersMapper) {
        this.usersRepository = usersRepository;
        this.adsRepository = adsRepository;
        this.usersMapper = usersMapper;
    }

    public UserAdsSchema getUserAds(int u_id) {
        Map<AdWithoutUserSchema, List<String>> mapAdPhotos = new HashMap<>();
        Users user = usersRepository.findById(u_id).orElseThrow();
        adsRepository.findAllByUser(user).forEach(row -> {
            AdWithoutUserSchema adWithoutUserSchema = (AdWithoutUserSchema) row[0];
            String photoUrl = (String) row[1];
            mapAdPhotos.computeIfAbsent(adWithoutUserSchema, v -> new ArrayList<>()).add(photoUrl);
        });

        List<NoUserAdSchema> noUserAdSchemaList = mapAdPhotos.entrySet().stream().map(
                entry -> new NoUserAdSchema(entry.getKey(), entry.getValue())
        ).toList();

        SecureUserSchema secureUserSchema = usersMapper.toSchema(user);

        return new UserAdsSchema(secureUserSchema, noUserAdSchemaList);
    }

    public SecureUserSchema getUserByCredentials(UserAuthenticateSchema userAuthenticateSchema) throws InvalidCredentials {
        Users user = usersRepository.findByUserName(userAuthenticateSchema.getUser_name());
        if (UserAuthentication.authorize(userAuthenticateSchema, user)) {
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
    public SecureUserSchema updateUser(int u_id, UserSchema userSchema) {
        Users existingUser = usersRepository.findById(u_id).orElseThrow();
        usersMapper.updateEntity(userSchema, existingUser);
        return usersMapper.toSchema(existingUser);
    }

    @Transactional
    public void deleteUserById(int u_id) {
        usersRepository.deleteById(u_id);
    }
}
