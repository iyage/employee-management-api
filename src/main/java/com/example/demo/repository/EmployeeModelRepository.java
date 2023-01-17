package com.example.demo.repository;

import com.example.demo.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeModelRepository extends JpaRepository<EmployeeModel, String> {
}