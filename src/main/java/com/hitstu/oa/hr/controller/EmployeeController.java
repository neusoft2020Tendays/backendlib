package com.hitstu.oa.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hitstu.oa.hr.service.IEmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = {"*","null"})
public class EmployeeController {
	@Autowired
	private IEmployeeService employeeService = null;
	
	
}
