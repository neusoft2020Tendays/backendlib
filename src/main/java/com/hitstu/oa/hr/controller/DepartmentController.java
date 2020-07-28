package com.hitstu.oa.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hitstu.oa.hr.model.DepartmentModel;
import com.hitstu.oa.hr.service.IDepartmentService;
import com.hitstu.oa.restresult.Result;

@RestController
@RequestMapping(value = "/department")
@CrossOrigin(origins = {"*", "null"})
public class DepartmentController {

	@Autowired
	private IDepartmentService departmentService = null;

	@PostMapping(value="/add")
	public Result<String> add(@RequestBody DepartmentModel DepartmentModel) throws Exception {
		departmentService.add(DepartmentModel);
		Result<String> result = new Result<>();
		result.setStatus("OK");
		result.setMessage("增加部门成功！");
		return result;
	}

	@PostMapping(value="/modify")
	public Result<String> modify(@RequestBody DepartmentModel DepartmentModel) throws Exception {
		departmentService.modify(DepartmentModel);
		Result<String> result = new Result<>();
		result.setStatus("OK");
		result.setMessage("修改部门成功！");
		return result;
	}

	@PostMapping(value="/delete")
	public Result<String> delete(@RequestBody DepartmentModel DepartmentModel) throws Exception {
		departmentService.delete(DepartmentModel);
		Result<String> result = new Result<>();
		result.setStatus("OK");
		result.setMessage("删除部门成功！");
		return result;
	}

	// 取得部门列表，分页模式
	@GetMapping(value="/list/all/page")
	public Result<DepartmentModel> getListByAllWithPage(@RequestParam(required = false, defaultValue = "5") int rows,
			@RequestParam(required = false, defaultValue = "1") int page) throws Exception {
		Result<DepartmentModel> result = new Result<>();
		result.setCount(departmentService.getCountByAll());
		result.setPageCount(departmentService.getPageCountByAll(rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(departmentService.getByAllWithPage(rows, page));
		result.setStatus("OK");
		result.setMessage("删除部门列表分页方式成功！");
		return result;
	}

	@GetMapping(value = "/get")
	public Result<DepartmentModel> getById(@RequestParam(required = true) String id) throws Exception {
		Result<DepartmentModel> result = new Result<>();
		result.setResult(departmentService.getById(id));
		result.setStatus("OK");
		result.setMessage("删除部门列表分页方式成功！");
		return result;
	}

}
