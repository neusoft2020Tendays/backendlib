package com.hitstu.oa.hr.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hitstu.oa.hr.model.SalaryModel;
import com.hitstu.oa.hr.service.ISalaryService;
import com.hitstu.oa.restresult.Result;

@RestController
@RequestMapping("/salary")
@CrossOrigin(origins = { "*", "null" })
@ResponseBody
public class SalaryController {
	@Autowired
	private ISalaryService salaryService = null;
	
	@PostMapping("/add")
	public Result<String> add(@RequestBody SalaryModel salaryModel) throws Exception {
		salaryService.add(salaryModel);
		Result<String> result = new Result<>();
		result.setStatus("OK");
		result.setMessage("增加薪水信息成功");
		return result;
	}

	@PostMapping("/modify")
	public Result<String> modify(@RequestBody SalaryModel salaryModel) throws Exception {
		salaryService.modify(salaryModel);
		Result<String> result = new Result<>();
		result.setStatus("OK");
		result.setMessage("修改薪水信息成功");
		return result;
	}

	@PostMapping("/delete")
	public Result<String> delete(@RequestBody SalaryModel salaryModel) throws Exception {
		salaryService.delete(salaryModel);
		Result<String> result = new Result<>();
		result.setStatus("OK");
		result.setMessage("删除薪水信息成功");
		return result;
	}

	@GetMapping("/listAll")
	public Result<SalaryModel> getListByAll() throws Exception {
		Result<SalaryModel> result = new Result<>();
		result.setCount(salaryService.getCountByAll());
		result.setList(salaryService.getByAll());
		result.setStatus("OK");
		result.setMessage("取得全部薪水信息成功");
		return result;
	}

	@GetMapping("/listAllPage")
	public Result<SalaryModel> getListByAllWithPage(@RequestParam(required = false, defaultValue = "10") int rows,
			@RequestParam(required = false, defaultValue = "1") int page) throws Exception {
		
		Result<SalaryModel> result = new Result<>();
		result.setCount(salaryService.getCountByAll());
		result.setPageCount(salaryService.getPageCountByAll(rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(salaryService.getByAllWithPage(rows, page));
		result.setStatus("OK");
		result.setMessage("取得分页薪水信息成功");
		return result;
	}
	
	@GetMapping("/listAllPageWithSalary")
	public Result<SalaryModel> getListByAllWithPageWithGoods(@RequestParam(required = false, defaultValue = "10") int rows,
			@RequestParam(required = false, defaultValue = "1") int page) throws Exception {
		
		Result<SalaryModel> result = new Result<>();
		result.setCount(salaryService.getCountByAll());
		result.setPageCount(salaryService.getPageCountByAll(rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(salaryService.getByAllWithPage(rows, page));
		result.setStatus("OK");
		result.setMessage("取得分页薪水使用信息成功");
		return result;
	}
	
	@GetMapping("/get")
	public Result<SalaryModel> getById(@RequestParam(required = true) String id, 
			@RequestParam(required = true) Date date) throws Exception {
		Result<SalaryModel> result = new Result<>();
		
		result.setResult(salaryService.getById(id));
		result.setStatus("OK");
		result.setMessage("取得特定薪水条目成功");
//		org.apache.ibatis.type.JdbcType.DATETIMEOFFSET
		return result;
	}
	
	
}
