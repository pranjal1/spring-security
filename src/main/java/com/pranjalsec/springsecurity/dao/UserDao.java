package com.pranjalsec.springsecurity.dao;

import com.pranjalsec.springsecurity.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUserName(String userName);
}
