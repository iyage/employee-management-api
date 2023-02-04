package com.example.demo.services;

import com.example.demo.model.EmployeeModel;
import com.example.demo.model.dto.EmployeeModelDto;

import java.util.ArrayList;
import java.util.List;

public interface EmployerRegistrationService {
   public EmployeeModel RegisterEmployee(EmployeeModelDto employeeModel);
   public List<EmployeeModel> employeeList();
   public EmployeeModel updateEmployeeDetails(EmployeeModel employeeModel);
   public void deleteEmployee(String id);
   public  EmployeeModel employeeDept(String deptName,String id);
   public  EmployeeModel removeEmployeeFromDept(String id);
}
