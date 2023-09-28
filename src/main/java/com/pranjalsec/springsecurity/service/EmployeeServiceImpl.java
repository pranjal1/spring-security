package com.pranjalsec.springsecurity.service;

import com.pranjalsec.springsecurity.dao.EmployeeDao;
import com.pranjalsec.springsecurity.dto.EmployeeDTO;
import com.pranjalsec.springsecurity.entity.EmployeeEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeDao employeeDao;
    @Override
    public ArrayList<EmployeeDTO> getAllEmployees() {
        ArrayList<EmployeeEntity> employeeEntities = (ArrayList<EmployeeEntity>) employeeDao.findAll();

        ArrayList<EmployeeDTO> employeeDTOS = new ArrayList<>();

        for (EmployeeEntity ee: employeeEntities){
            EmployeeDTO empDTO = new EmployeeDTO();
            BeanUtils.copyProperties(ee, empDTO);
            employeeDTOS.add(empDTO);
        }
        return employeeDTOS;
    }

    @Override
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employeeDTO, employeeEntity);
        EmployeeEntity res = employeeDao.save(employeeEntity);
        if (res!=null){
            EmployeeDTO empDTO = new EmployeeDTO();
            BeanUtils.copyProperties(res, empDTO);
            return empDTO;
        }
        return null;
    }
}
