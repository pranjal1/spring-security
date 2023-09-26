package com.pranjalsec.springsecurity.dao;

import com.pranjalsec.springsecurity.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<EmployeeEntity, Long> {
}
