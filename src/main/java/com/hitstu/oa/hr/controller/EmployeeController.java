package com.hitstu.oa.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hitstu.oa.checkin.model.BedModel;
import com.hitstu.oa.hr.model.EmployeeModel;
import com.hitstu.oa.hr.service.IEmployeeService;
import com.hitstu.oa.restresult.Result;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = { "*", "null" })
@ResponseBody
public class EmployeeController {
	@Autowired
	private IEmployeeService employeeService = null;
	
	@PostMapping("/add")
	public Result<String> add(@RequestBody EmployeeModel employeeModel) throws Exception {
		employeeService.add(employeeModel);
		Result<String> result = new Result<>();
		result.setStatus("OK");
		result.setMessage("增加员工成功");
		return result;
	}
	
	@PostMapping("/modify")
	public Result<String> modify(@RequestBody EmployeeModel employeeModel) throws Exception {
		employeeService.modify(employeeModel);
		Result<String> result = new Result<>();
		result.setStatus("OK");
		result.setMessage("修改员工成功");
		return result;
	}
	
	@PostMapping("/delete")
	public Result<String> delete(@RequestBody EmployeeModel employeeModel) throws Exception {
		employeeService.delete(employeeModel);
		Result<String> result = new Result<>();
		result.setStatus("OK");
		result.setMessage("删除员工成功");
		return result;
	}
	
	@GetMapping("/listAll")
	public Result<EmployeeModel> getListByAll() throws Exception {
		Result<EmployeeModel> result = new Result<>();
		result.setCount(employeeService.getCountByAll());
		result.setList(employeeService.getByAll());
		result.setStatus("OK");
		result.setMessage("取得全部床位成功");
		return result;
	}

	@GetMapping("/listAllPage")
	public Result<EmployeeModel> getListByAllWithPage(@RequestParam(required = false, defaultValue = "10") int rows,
			@RequestParam(required = false, defaultValue = "1") int page) throws Exception {
		
		Result<EmployeeModel> result = new Result<>();
		result.setCount(employeeService.getCountByAll());
		result.setPage(employeeService.getPageCountByAll(rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(employeeService.getByAllWithPage(rows, page));
		result.setStatus("OK");
		result.setMessage("取得分页床位成功");
		return result;
	}
	
	@GetMapping("/get")
	public Result<EmployeeModel> getById(@RequestParam(required = true) String id) throws Exception {
		
		Result<EmployeeModel> result = new Result<>();
		result.setResult(employeeService.getById(id));
		result.setStatus("OK");
		result.setMessage("取得特定床位成功");
		return result;
	}
	
	@GetMapping("/getCountByDepartment")
	public Result<Integer> getCountByDepartment(@RequestParam(required = true) String deptid) throws Exception {
		Result<Integer> result = new Result<>();
		result.setIntResult(employeeService.getCountByDepartment(deptid));
		result.setStatus("OK");
		result.setMessage("根据部门ID获取员工数成功");
		return result;
	}
}
