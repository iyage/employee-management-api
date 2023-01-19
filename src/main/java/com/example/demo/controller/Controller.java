package com.example.demo.controller;

import com.example.demo.model.Departments;
import com.example.demo.model.EmployeeModel;
import com.example.demo.model.dto.ResponseDto;
import com.example.demo.services.serviceimpl.EmployerRegistrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
public class Controller {
    @Autowired
    EmployerRegistrationServiceImpl employerRegistrationService;
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/register_new_employee")
    @ResponseBody
    public ResponseDto registerNewEmployee(@Valid @RequestBody EmployeeModel employeeModel){
        ResponseDto responseDto = new ResponseDto();

        EmployeeModel newEmployee = employerRegistrationService.RegisterEmployee(employeeModel);
        responseDto.setMessage("Employee Successfully Registered");

        responseDto.setData(newEmployee);
        return responseDto;

    }
    @GetMapping("/get_all_dept")
    @ResponseBody
    public ResponseDto getAllDepart()
    {
        ResponseDto responseDto = new ResponseDto();
        ArrayList<String>depts = new ArrayList<>();
        for(Departments dept:Departments.values())
        {
            depts.add(dept.getDept());
        }
        responseDto.setMessage("Department List Successfully Retrieve");
        responseDto.setData(depts);
        return  responseDto;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/get_all_employee")
    public ResponseDto getAllEmployee()
    {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(employerRegistrationService.employeeList());
        responseDto.setMessage("Employee List Successfully Retrieved");
        return  responseDto;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(path = "/update_details")
    public ResponseDto updateEmployeeDetails(@RequestBody EmployeeModel employeeModel)
    {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(employerRegistrationService.updateEmployeeDetails(employeeModel));
        responseDto.setMessage("Employee Details Successfully Updated");
        return  responseDto;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/delete_employee/{id}")
    @ResponseBody
    public  ResponseDto deleteEmployee(@PathVariable(value = "id") String id)
    {
        ResponseDto responseDto = new ResponseDto();
        employerRegistrationService.deleteEmployee(id);
        responseDto.setMessage("Employee Successfully Deleted");
        return responseDto;
    }

}
