package com.example.demo.model.dto;

import com.example.demo.model.EmployeeModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DepartmentModelDto {
    private String id;
    String name;
    private Set<EmployeeModel> employee;

}
