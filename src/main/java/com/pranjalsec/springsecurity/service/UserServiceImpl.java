package com.pranjalsec.springsecurity.service;

import com.pranjalsec.springsecurity.dao.UserDao;
import com.pranjalsec.springsecurity.dto.UserDTO;
import com.pranjalsec.springsecurity.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userDTO.setUserPassword(passwordEncoder.encode(userDTO.getUserPassword()));
        BeanUtils.copyProperties(userDTO, userEntity);
        UserEntity user = userDao.save(userEntity);
        if (user!=null){
            UserDTO userDTO1 = new UserDTO();
            BeanUtils.copyProperties(user, userDTO1);
            return userDTO1;
        }
        return null;
    }

    @Override
    public UserDTO getUserByName(String userName) {
        Optional<UserEntity> userEntity = userDao.findByUserName(userName);
        System.out.println(userEntity);
        System.out.println(userEntity.isPresent());
        if (userEntity.isPresent()){
            UserDTO userDTO1 = new UserDTO();
            BeanUtils.copyProperties(userEntity.get(), userDTO1);
            return userDTO1;
        }
        return null;
    }
}
