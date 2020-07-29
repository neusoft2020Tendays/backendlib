package com.hitstu.oa.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hitstu.oa.hr.model.EmployeeModel;
import com.hitstu.oa.hr.service.IEmployeeService;
import com.hitstu.oa.restresult.Result;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = { "*", "null" })
@ResponseBody
public class EmployeeController {
	@Autowired
	private IEmployeeService employeeServiceeService = null;
	
	@GetMapping("/getCountByDepartment")
	public Result<Integer> getCountByDepartment(@RequestParam(required = true) String deptid) throws Exception {
		Result<Integer> result = new Result<>();
		result.setResult(employeeServiceeService.getCountByDepartment(deptid));
		result.setMessage("根据部门ID获取员工数成功");
		return result;
	}
}
