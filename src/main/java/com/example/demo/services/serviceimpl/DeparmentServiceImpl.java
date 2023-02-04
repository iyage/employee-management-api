package com.example.demo.services.serviceimpl;

import com.example.demo.exceptions.ResourceNotFoundExption;
import com.example.demo.model.DepartmentModel;

import com.example.demo.model.EmployeeModel;
import com.example.demo.model.dto.DepartmentDto;
import com.example.demo.model.dto.DepartmentModelDto;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.services.DepartmentSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DeparmentServiceImpl implements DepartmentSevice {
    @Autowired
    DepartmentRepository departmentRepository;
    @Override
    public List<DepartmentModelDto> fetchAllDept() {
        List<DepartmentModel>deptModelList = departmentRepository.findAll();
        Set<DepartmentModelDto> deptList = new HashSet<>();
        deptModelList.forEach((dept)->{

            deptList.add( DepartmentModelDto.builder()
                    .employee(dept.getEmployee())
                    .id(dept.getId())
                    .name(dept.getName())
                    .build());
        });
        return new ArrayList<>(deptList);
    }

    @Override
    public DepartmentModel addNewDept(DepartmentDto dept) {
        DepartmentModel departmentModel = new DepartmentModel();
        departmentModel.setName(dept.getName());
        return  departmentRepository.save(departmentModel);
    }

    @Override
    public DepartmentModelDto fetchDept(String id) {
     DepartmentModel dept =  departmentRepository.findById(id).orElseThrow(()->new ResourceNotFoundExption("fail"));
       return DepartmentModelDto.builder()
               .employee(dept.getEmployee())
               .name(dept.getName())
               .id(dept.getId())
               .build();
    }
}
