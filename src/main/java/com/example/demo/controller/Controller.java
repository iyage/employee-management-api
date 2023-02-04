package com.example.demo.controller;
import com.example.demo.model.EmployeeModel;
import com.example.demo.model.dto.DepartmentDto;
import com.example.demo.model.dto.EmployeeModelDto;
import com.example.demo.model.dto.ResponseDto;
import com.example.demo.services.serviceimpl.DeparmentServiceImpl;
import com.example.demo.services.serviceimpl.EmployerRegistrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@RestController
@CrossOrigin(origins ="${FRONTEND_URL}")
public class Controller {
    @Autowired
    EmployerRegistrationServiceImpl employerRegistrationService;
    @Autowired
    DeparmentServiceImpl deparmentService;
    @CrossOrigin(origins ="${FRONTEND_URL}")
    @PostMapping("/register_new_employee")
    @ResponseBody
    public ResponseEntity<ResponseDto>  registerNewEmployee(@Valid @RequestBody EmployeeModelDto employeeModel){

        EmployeeModel newEmployee = employerRegistrationService.RegisterEmployee(employeeModel);
        ResponseDto responseDto = new ResponseDto("success",newEmployee,new Date());

        responseDto.setData(newEmployee);
        return  new ResponseEntity<>(responseDto, HttpStatus.CREATED);

    }
    @CrossOrigin(origins = "${FRONTEND_URL}")
    @GetMapping("/get_all_dept")
    @ResponseBody
    public ResponseEntity<ResponseDto> getAllDepart()
    {
        return  new ResponseEntity<>(new ResponseDto("success",deparmentService.fetchAllDept(),new Date()),HttpStatus.OK);
    }
    @CrossOrigin(origins ="${FRONTEND_URL}")
    @GetMapping(path = "/get_all_employee")
    public ResponseEntity<ResponseDto> getAllEmployee()
    {
        return  new ResponseEntity<>(new ResponseDto("success",employerRegistrationService.employeeList(),new Date()),HttpStatus.OK);
    }
    @CrossOrigin(origins ="${FRONTEND_URL}")
    @PutMapping(path = "/update_details")
    public ResponseEntity<ResponseDto> updateEmployeeDetails(@RequestBody EmployeeModel employeeModel)
    {
        return new ResponseEntity<>(new ResponseDto("success",employerRegistrationService.updateEmployeeDetails(employeeModel),new Date()),HttpStatus.OK);
    }
    @CrossOrigin(origins ="${FRONTEND_URL}")
    @DeleteMapping(path = "/delete_employee/{id}")

    public ResponseEntity<ResponseDto> deleteEmployee(@PathVariable(value = "id") String id)
    {
        employerRegistrationService.deleteEmployee(id);
        return new ResponseEntity<>(new ResponseDto("success",null, new Date()),HttpStatus.OK);
    }

    @CrossOrigin(origins ="${FRONTEND_URL}")
    @PostMapping(path = "/add_new_dept")
    public ResponseEntity<ResponseDto> addNewDept(@Valid @RequestBody DepartmentDto dept)
    {
        return  new ResponseEntity<>(new ResponseDto("success",deparmentService.addNewDept(dept),new Date()),HttpStatus.CREATED);
    }

    @CrossOrigin(origins ="${FRONTEND_URL}")
    @GetMapping(path = "/add_new_dept/{employeeId}/{dept}")
    public ResponseEntity<ResponseDto> addEmployeeDept(@PathVariable (value = "employeeId") String employeeId,@PathVariable (value = "dept") String dept)
    {
        return  new ResponseEntity<>(new ResponseDto("success",employerRegistrationService.employeeDept(dept,employeeId),new Date()),HttpStatus.OK);
    }
    @CrossOrigin(origins ="${FRONTEND_URL}")
    @GetMapping(path = "/remove_employee_dept/{employeeId}")
    public ResponseEntity<ResponseDto> removeEmployeeDept(@PathVariable (value = "employeeId") String employeeId)
    {
        return  new ResponseEntity<>(new ResponseDto("success",employerRegistrationService.removeEmployeeFromDept(employeeId),new Date()),HttpStatus.OK);
    }

}
