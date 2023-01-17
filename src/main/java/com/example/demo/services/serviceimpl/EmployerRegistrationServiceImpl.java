package com.example.demo.services.serviceimpl;

import com.example.demo.exceptions.ResourceNotFoundExption;
import com.example.demo.model.EmployeeModel;
import com.example.demo.repository.EmployeeModelRepository;
import com.example.demo.services.EmployerRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployerRegistrationServiceImpl implements EmployerRegistrationService {
    @Autowired
    EmployeeModelRepository employeeModelRepository;
    @Override
    public EmployeeModel RegisterEmployee(EmployeeModel employeeModel) {
        return employeeModelRepository.save(employeeModel);
    }

    @Override
    public List<EmployeeModel> employeeList() {
        return employeeModelRepository.findAll();
    }

    @Override
    public EmployeeModel updateEmployeeDetails(EmployeeModel employeeModel) {
        EmployeeModel employee = (employeeModelRepository.findById(employeeModel.getId()).orElseThrow(() ->
                new ResourceNotFoundExption("user not found")));
        if(employeeModel.getDepartment()!=null){

            if( !employeeModel.getDepartment().equals(""))
            {
             employee.setDepartment(employeeModel.getDepartment());
            }
        }
        if(employeeModel.getFirst_name()!=null||!employeeModel.getFirst_name().equals("")){
            employee.setFirst_name(employeeModel.getFirst_name());
        }
        if(employeeModel.getLast_name()!=null||!employeeModel.getLast_name().equals(""))
           employee.setLast_name(employeeModel.getLast_name());
        if(employeeModel.getSalary()!=null)
            employee.setSalary(employeeModel.getSalary());
        if(employeeModel.getJoinDate()!=null){
            System.out.println(employeeModel.getJoinDate());
            employee.setJoinDate(employeeModel.getJoinDate());
        }
        if(employeeModel.getJoinDate()!=null || employeeModel.getImgUrl().equals(""))
            employee.setImgUrl(employeeModel.getImgUrl());

        return employeeModelRepository.save(employee);
    }

    @Override
    public void deleteEmployee(String id) {
        EmployeeModel employeeModel = employeeModelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundExption("id does not exit"));
        System.out.println(employeeModel);
        employeeModelRepository.delete(employeeModel);
    }
}
