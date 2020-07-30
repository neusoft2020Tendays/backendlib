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
@CrossOrigin(origins = { "*", "null" })
public class DepartmentController {

	@Autowired
	private IDepartmentService departmentService = null;

	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody DepartmentModel departmentModel) throws Exception {
		Result<String> result = new Result<>();
		Result<DepartmentModel> search = this.getById(departmentModel.getDeptid());
		if (search != null && search.getResult() != null) {
			result.setStatus("ERROR");
			result.setMessage("部门" + departmentModel.getDeptid() + "已存在！");
		} else {
			departmentService.add(departmentModel);
			result.setStatus("OK");
			result.setMessage("增加部门成功！");
		}
		return result;
	}

	@PostMapping(value = "/modify")
	public Result<String> modify(@RequestBody DepartmentModel departmentModel) throws Exception {
		Result<String> result = new Result<>();
		departmentService.modify(departmentModel);
		System.out.println(departmentModel.getDeptid());
		System.out.println(departmentModel.getName());
		result.setStatus("OK");
		result.setMessage("修改部门成功！");
		return result;
	}

	@PostMapping(value = "/delete")
	public Result<String> delete(@RequestBody DepartmentModel departmentModel) throws Exception {
		departmentService.delete(departmentModel);
		Result<String> result = new Result<>();
		result.setStatus("OK");
		result.setMessage("删除部门成功！");
		return result;
	}

	// 取得部门列表，分页模式
	@GetMapping(value = "/list/all/page")
	public Result<DepartmentModel> getListByAllWithPage(@RequestParam(required = false, defaultValue = "5") int rows,
			@RequestParam(required = false, defaultValue = "1") int page) throws Exception {
		Result<DepartmentModel> result = new Result<>();
		result.setCount(departmentService.getCountByAll());
		result.setPageCount(departmentService.getPageCountByAll(rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(departmentService.getByAllWithPage(rows, page));
		result.setStatus("OK");
		result.setMessage("部门列表分页方式成功！");
		return result;
	}

	@GetMapping(value = "/get")
	public Result<DepartmentModel> getById(@RequestParam(required = true) String id) throws Exception {
		Result<DepartmentModel> result = new Result<>();
		result.setResult(departmentService.getById(id));
		if (result.getResult() == null) {
			result.setStatus("ERROR");
			result.setMessage("部门" + id + "不存在！");
		} else {
			result.setStatus("OK");
			result.setMessage("部门列表分页方式成功！");
		}
		return result;
	}
	
	@GetMapping(value = "/get/all/deptid")
	public Result<String> getDeptidByAll() throws Exception {
		Result<String> result = new Result<>();
		result.setStatus("OK");
		result.setMessage("获取全部部门名称成功！");
		result.setList(departmentService.getDeptidByAll());
		return result;
	}

}
