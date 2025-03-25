package org.example.bvito.service.impl;

import org.example.bvito.mappers.UsersMapper;
import org.example.bvito.models.Users;
import org.example.bvito.repository.UsersRepository;
import org.example.bvito.schemas.UsersSchema;
import org.example.bvito.service.UsersService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;
    private final UsersMapper usersMapper;

    public UsersServiceImpl(UsersRepository usersRepository, UsersMapper usersMapper) {
        this.usersRepository = usersRepository;
        this.usersMapper = usersMapper;
    }

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public Users addUser(UsersSchema usersSchema) {
        Users user = usersMapper.toEntity(usersSchema);
        return usersRepository.save(user);
    }

    public Optional<Users> getUserById(int u_id) {
        return usersRepository.findById(u_id);
    }

    @Transactional
    public Users updateUser(int u_id, UsersSchema usersSchema) {
        Users user = usersMapper.toEntity(usersSchema);
        user.setU_id(u_id);
        return usersRepository.save(user);
    }

    @Transactional
    public void deleteUserById(int u_id) {
        usersRepository.deleteById(u_id);
    }
}
