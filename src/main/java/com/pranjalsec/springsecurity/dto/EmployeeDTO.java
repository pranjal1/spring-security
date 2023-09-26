package com.pranjalsec.springsecurity.dto;


public class EmployeeDTO {

    private Long empId;
    private String empName;
    private double empSalary;
    private String email;

    public EmployeeDTO(String empName, double empSalary, String email) {
        this.empName = empName;
        this.empSalary = empSalary;
        this.email = email;
    }

    public EmployeeDTO() {
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(double empSalary) {
        this.empSalary = empSalary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}




