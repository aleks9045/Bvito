package org.example.bvito.service.impl;

import org.example.bvito.mappers.UserAdsMapper;
import org.example.bvito.mappers.UsersMapper;
import org.example.bvito.models.Users;
import org.example.bvito.repository.AdsRepository;
import org.example.bvito.repository.UsersRepository;
import org.example.bvito.schemas.ads.out.AdsWithoutUserSchema;
import org.example.bvito.schemas.users.out.UserAdsSchema;
import org.example.bvito.schemas.users.in.UserSchema;
import org.example.bvito.service.UsersService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public UserAdsSchema getUserAds(int u_id) {
        Users user = usersRepository.findById(u_id).orElseThrow();
        List<AdsWithoutUserSchema> adList = adsRepository.findAllByUser(user);
        return userAdsMapper.toSchema(user, adList);
    }

    public Users addUser(UserSchema userSchema) {
        Users user = usersMapper.toEntity(userSchema);
        return usersRepository.save(user);
    }

    public Optional<Users> getUserById(int u_id) {
        return usersRepository.findById(u_id);
    }

    @Transactional
    public Users updateUser(int u_id, UserSchema userSchema) {
        Users existingUser = usersRepository.findById(u_id).orElseThrow();
        System.out.println(existingUser);
        usersMapper.updateEntity(userSchema, existingUser);
        System.out.println(existingUser);

        return existingUser;
    }

    @Transactional
    public void deleteUserById(int u_id) {
        usersRepository.deleteById(u_id);
    }
}
