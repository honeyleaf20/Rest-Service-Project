package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.EmployeeRepo;

@RestController

public class DemoController {
	@Autowired
	EmployeeRepo erepo;
	
	@GetMapping(path="/getDetails")
     public String getDetails() {
    	 return "new";
     }
	@PostMapping(path="/postDetails")
    public Employee postDetails() {
		
		Employee emp= new Employee(4, "Ram", "Delhi", "SDE", 2000);
   	 return erepo.save(emp);
    }
	
}
