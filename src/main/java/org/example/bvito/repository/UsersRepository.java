package org.example.bvito.repository;

import org.example.bvito.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *  Works with Users model
 *  <p>
 *  Implements JpaRepository, so it has a set of ready-made methods
 *  @see User Users model
 *  @author Aleksey
 */
public interface UsersRepository extends JpaRepository<User, Integer> {

    User findByUserName(String userName);

}
