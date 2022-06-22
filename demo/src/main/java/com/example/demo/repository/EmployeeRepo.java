package com.example.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.demo.controller.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository <Employee, Long>{

}