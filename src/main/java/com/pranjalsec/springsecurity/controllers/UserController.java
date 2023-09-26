package com.pranjalsec.springsecurity.controllers;

import com.pranjalsec.springsecurity.dto.AuthRequest;
import com.pranjalsec.springsecurity.dto.UserDTO;
import com.pranjalsec.springsecurity.service.JwtService;
import com.pranjalsec.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.PasswordAuthentication;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/addUser")
    public ResponseEntity<Object> addUser(@RequestBody UserDTO userDTO){
        System.out.println(userDTO);
        UserDTO user = userService.addUser(userDTO);
        if (user!=null){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>("Can not add the user", HttpStatus.BAD_REQUEST);

    }

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest){
        //ensure that the user is authenticated, I don't know why you can't just use preauthorize here
        //it seems preauthorize is used for not just authentication but also checking if the user has permission for accessing this method
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
        System.out.println("Authentication -> ");
        System.out.println(authentication);
        if (authentication.isAuthenticated()){
            String token = jwtService.createToken(authRequest);
            System.out.println(token);
            return token;
        }
        throw new UsernameNotFoundException("Can not find the user!");
    }
}
