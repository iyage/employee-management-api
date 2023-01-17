package com.example.demo.services;

import com.example.demo.model.EmployeeModel;

import java.util.ArrayList;
import java.util.List;

public interface EmployerRegistrationService {
   public EmployeeModel RegisterEmployee(EmployeeModel employeeModel);
   public List<EmployeeModel> employeeList();
   public EmployeeModel updateEmployeeDetails(EmployeeModel employeeModel);
   public void deleteEmployee(String id);
}
