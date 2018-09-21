/**
 *
 */
package com.genesis.springboot.security.repository;

import java.util.Optional;

import com.genesis.springboot.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Siva
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
}
