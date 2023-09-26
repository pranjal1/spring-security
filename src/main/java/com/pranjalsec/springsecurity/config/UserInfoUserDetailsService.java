package com.pranjalsec.springsecurity.config;

import com.pranjalsec.springsecurity.dto.UserDTO;
import com.pranjalsec.springsecurity.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {
    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO userInfo = userService.getUserByName(username);
        if (userInfo != null) {
            UserInfoUserDetails userInfoUserDetails = new UserInfoUserDetails(userInfo);
            return userInfoUserDetails;
        }
        throw new UsernameNotFoundException("User not found" + username);
    }
}
