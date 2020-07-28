package com.hitstu.oa.checkin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hitstu.oa.checkin.model.ElderlyModel;
import com.hitstu.oa.checkin.service.IElderlyService;
import com.hitstu.oa.restresult.Result;

@RestController
@RequestMapping(value = "/elderly")
public class ElderlyController {
	
	@Autowired
	private IElderlyService elderlyService = null;

	@RequestMapping(value = "/add")
	public Result<String> add(ElderlyModel ElderlyModel) throws Exception {
		elderlyService.add(ElderlyModel);
		Result<String> result = new Result<>();
		result.setStatus("OK");
		result.setMessage("增加老人成功！");
		return result;
	}

	@RequestMapping(value = "/modify")
	public Result<String> modify(ElderlyModel ElderlyModel) throws Exception {
		elderlyService.modify(ElderlyModel);
		Result<String> result = new Result<>();
		result.setStatus("OK");
		result.setMessage("修改老人成功！");
		return result;
	}

	@RequestMapping(value = "/delete")
	public Result<String> delete(ElderlyModel ElderlyModel) throws Exception {
		elderlyService.delete(ElderlyModel);
		Result<String> result = new Result<>();
		result.setStatus("OK");
		result.setMessage("删除老人成功！");
		return result;
	}

	// 取得部门列表，分页模式
	@GetMapping(value = "/list/all/page")
	public Result<ElderlyModel> getListByAllWithPage(@RequestParam(required = false, defaultValue = "5") int rows,
			@RequestParam(required = false, defaultValue = "1") int page) throws Exception {
		Result<ElderlyModel> result = new Result<>();
		result.setCount(elderlyService.getCountByAll());
		result.setPageCount(elderlyService.getPageCountByAll(rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(elderlyService.getByAllWithPage(rows, page));
		result.setStatus("OK");
		result.setMessage("删除老人列表分页方式成功！");
		return result;
	}

	@GetMapping(value = "/get")
	public Result<ElderlyModel> getById(@RequestParam(required = true) String id) throws Exception {
		Result<ElderlyModel> result = new Result<>();
		result.setResult(elderlyService.getById(id));
		result.setStatus("OK");
		result.setMessage("删除部门列表分页方式成功！");
		return result;
	}

}
