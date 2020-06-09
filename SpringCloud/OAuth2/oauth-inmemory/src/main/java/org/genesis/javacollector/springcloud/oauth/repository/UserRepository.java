package org.genesis.javacollector.springcloud.oauth.repository;


import org.genesis.javacollector.springcloud.oauth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: KG
 * @date: 2019/10/9
 * Description:
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}