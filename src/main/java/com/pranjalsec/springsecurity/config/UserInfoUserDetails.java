package com.pranjalsec.springsecurity.config;

import com.pranjalsec.springsecurity.dto.UserDTO;
import com.pranjalsec.springsecurity.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserInfoUserDetails implements UserDetails {
    private String name;
    private String password;
    private List<GrantedAuthority> authorityList;

    public UserInfoUserDetails(UserDTO userDTO){
        name = userDTO.getUserName();
        password = userDTO.getUserPassword();

        String userRoles = userDTO.getUserRoles();
        authorityList = new ArrayList<>();

        if (userRoles != null && !userRoles.isEmpty()) {
            String[] rolesArray = userRoles.split(",");

            for (String role : rolesArray) {
                authorityList.add(new SimpleGrantedAuthority(role.toUpperCase().trim()));
            }
        }


    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorityList;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
