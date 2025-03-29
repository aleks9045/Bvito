package org.example.bvito.repository;

import org.example.bvito.models.Users;
import org.example.bvito.schemas.users.out.SecureUserSchema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 *  @author Aleksey
 */
public interface UsersRepository extends JpaRepository<Users, Integer> {

    Users findByUserName(String userName);

}
