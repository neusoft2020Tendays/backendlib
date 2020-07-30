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
		result.setMessage("取得全部员工信息(无部门)成功");
		return result;
	}
	
	@GetMapping("/listAllWithDepartment")
	public Result<EmployeeModel> getListByAllWithDepartment() throws Exception {
		Result<EmployeeModel> result = new Result<>();
		result.setCount(employeeService.getCountByAll());
		result.setList(employeeService.getByAllWithDepartment());
		result.setStatus("OK");
		result.setMessage("取得全部员工信息(带部门)成功");
		return result;
	}

	@GetMapping("/listPage")
	public Result<EmployeeModel> getListWithPage(@RequestParam(required = false, defaultValue = "10") int rows,
			@RequestParam(required = false, defaultValue = "1") int page) throws Exception {
		
		Result<EmployeeModel> result = new Result<>();
		result.setCount(employeeService.getCountByAll());
		result.setPageCount(employeeService.getPageCountByAll(rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(employeeService.getByAllWithPage(rows, page));
		result.setStatus("OK");
		result.setMessage("取得分页全部员工信息(无部门)成功");
		return result;
	}
	
	@GetMapping("/listPageWithDepartment")
	public Result<EmployeeModel> getListWithPageWithDepartment(@RequestParam(required = false, defaultValue = "10") int rows,
			@RequestParam(required = false, defaultValue = "1") int page) throws Exception {
		
		Result<EmployeeModel> result = new Result<>();
		result.setCount(employeeService.getCountByAll());
		result.setPageCount(employeeService.getPageCountByAll(rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(employeeService.getByAllWithDepartmentWithPage(rows, page));
		result.setStatus("OK");
		result.setMessage("取得分页员工信息(带部门)成功");
		return result;
	}
	
	@GetMapping("/get")
	public Result<EmployeeModel> getById(@RequestParam(required = true) String id) throws Exception {
		
		Result<EmployeeModel> result = new Result<>();
		result.setResult(employeeService.getById(id));
		result.setStatus("OK");
		result.setMessage("取得特定员工信息(无部门)成功");
		return result;
	}
	
	@GetMapping("/getWithDepartment")
	public Result<EmployeeModel> getByIdWithDepartment(@RequestParam(required = true) String id) throws Exception {
		Result<EmployeeModel> result = new Result<>();
		result.setResult(employeeService.getByIdWithDepartment(id));
		result.setStatus("OK");
		result.setMessage("取得特定员工信息(带部门)成功");
		return result;
	}
	
	@GetMapping("/listPageByConditionWithDepartment")
	public Result<EmployeeModel> getListByConditionWithDepartmentWithPage(@RequestParam(required = false, defaultValue = "10") int rows, 
			@RequestParam(required = false, defaultValue = "1") int page, @RequestParam(required = false, defaultValue = "0")int lowAge, 
			@RequestParam(required = false, defaultValue = "0")int highAge, @RequestParam(required = false, defaultValue = "")String sex,
			@RequestParam(required = false, defaultValue = "")String nameKey,@RequestParam(required = false, defaultValue = "")String leave,
			@RequestParam(required = false, defaultValue = "")String fired) throws Exception {
		Result<EmployeeModel> result = new Result<>();
		result.setPage(page);
		result.setRows(rows);
		result.setCount(employeeService.getCountByAll());
		result.setPageCount(employeeService.getPageCountByAll(rows));
		result.setList(employeeService.getListByConditionWithDepartmentWithPage(rows, page, lowAge, highAge, sex, nameKey, leave, fired));
		result.setStatus("OK");
		result.setMessage("取得特定员工信息(带部门)成功");
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
