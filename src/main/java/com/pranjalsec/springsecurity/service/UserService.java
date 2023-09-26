package com.pranjalsec.springsecurity.service;

import com.pranjalsec.springsecurity.dto.UserDTO;

import java.util.Optional;

public interface UserService {
    UserDTO addUser(UserDTO userDTO);

    UserDTO getUserByName(String userName);
}
