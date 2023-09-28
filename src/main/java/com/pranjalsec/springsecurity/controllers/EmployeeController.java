package com.pranjalsec.springsecurity.controllers;

import com.pranjalsec.springsecurity.dto.EmployeeDTO;
import com.pranjalsec.springsecurity.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

//        if (authentication != null && authentication.isAuthenticated()) {
//            System.out.println("User roles:");
//
//            for (GrantedAuthority authority : authentication.getAuthorities()) {
//                System.out.println(authority.getAuthority());
//            }
//        } else {
//            // Redirect or handle unauthenticated users
//            System.out.println("user is not authenticated!");
//        }

        List<EmployeeDTO> allEmps = employeeService.getAllEmployees();
        return new ResponseEntity<>(allEmps, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/addEmployees")
    public ResponseEntity<Object> addEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO emp = employeeService.addEmployee(employeeDTO);
        if (emp!=null) {
            return new ResponseEntity<>(emp, HttpStatus.OK);
        }
        return new ResponseEntity<>("Error adding employee", HttpStatus.BAD_REQUEST);
    }

}
