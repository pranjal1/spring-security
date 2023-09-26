package com.pranjalsec.springsecurity.service;

import com.pranjalsec.springsecurity.dto.EmployeeDTO;

import java.util.ArrayList;

public interface EmployeeService {
    ArrayList<EmployeeDTO> getAllEmployees();

    EmployeeDTO addEmployee(EmployeeDTO employeeDTO);
}
