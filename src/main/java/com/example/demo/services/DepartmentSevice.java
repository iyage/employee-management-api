package com.example.demo.services;

import com.example.demo.model.DepartmentModel;
import com.example.demo.model.Departments;
import com.example.demo.model.dto.DepartmentDto;
import com.example.demo.model.dto.DepartmentModelDto;

import java.util.List;

public interface DepartmentSevice {
    List<DepartmentModelDto> fetchAllDept();
    DepartmentModel addNewDept(DepartmentDto dept);
    DepartmentModelDto fetchDept(String id);

}
