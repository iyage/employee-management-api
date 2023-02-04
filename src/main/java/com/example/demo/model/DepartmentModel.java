package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class DepartmentModel {
    @Id
    @GeneratedValue(generator = "uuid-id")
    @GenericGenerator(name="uuid-id",
            strategy = "com.example.demo.IdGenerator")
    private String id;
    @Column(unique = true)
    String name;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "dept")
    private Set<EmployeeModel> employee = new HashSet<>();

}
