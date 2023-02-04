package com.example.demo.services.serviceimpl;

import com.example.demo.exceptions.ResourceNotFoundExption;
import com.example.demo.model.DepartmentModel;
import com.example.demo.model.EmployeeModel;
import com.example.demo.model.dto.EmployeeModelDto;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeModelRepository;
import com.example.demo.services.EmployerRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployerRegistrationServiceImpl implements EmployerRegistrationService {
    @Autowired
    EmployeeModelRepository employeeModelRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Override
    public EmployeeModel RegisterEmployee(EmployeeModelDto employeeModel) {
        return employeeModelRepository.save(EmployeeModel.builder()
                .email(employeeModel.getEmail())
                .first_name(employeeModel.getFirst_name())
                .last_name(employeeModel.getLast_name())
                .password(employeeModel.getPassword())
                .salary(employeeModel.getSalary())
                .joinDate(employeeModel.getJoinDate())
        .build());
    }

    @Override
    public List<EmployeeModel> employeeList() {
        return employeeModelRepository.findAll();
    }

    @Override
    public EmployeeModel updateEmployeeDetails(EmployeeModel employeeModel) {
        EmployeeModel employee = (employeeModelRepository.findById(employeeModel.getId()).orElseThrow(() ->
                new ResourceNotFoundExption("user not found")));
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
        return employeeModelRepository.save(employee);
    }
    @Transactional
    public EmployeeModel employeeDept(String deptName,String employeeId)
        {
            DepartmentModel dept = departmentRepository.findDepartmentModelByName(deptName).orElseThrow(()->new ResourceNotFoundExption("Dept not found"));
            EmployeeModel employeeModel = employeeModelRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundExption("Employee not found"));
            employeeModel.setDept(dept);
            dept.getEmployee().add(employeeModel);
            return employeeModel;
        }
@Transactional
    @Override
    public EmployeeModel removeEmployeeFromDept( String employeeId) {
        EmployeeModel employeeModel = employeeModelRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundExption("Employee not found"));
        DepartmentModel dept =  employeeModel.getDept();
        dept.getEmployee().remove(employeeModel);
        employeeModel.setDept(null);
        return employeeModel;
    }

    @Override
    public void deleteEmployee(String id) {
        EmployeeModel employeeModel = employeeModelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundExption("id does not exit"));
        System.out.println(employeeModel);
        employeeModelRepository.delete(employeeModel);
    }
}
