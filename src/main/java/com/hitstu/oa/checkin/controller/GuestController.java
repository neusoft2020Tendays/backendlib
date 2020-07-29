package com.hitstu.oa.checkin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hitstu.oa.checkin.model.GuestModel;
import com.hitstu.oa.checkin.service.IGuestService;
import com.hitstu.oa.restresult.Result;

@RestController
@RequestMapping(value = "/guest")
@CrossOrigin(origins = { "*", "null" })
public class GuestController {
	
	@Autowired
	private IGuestService guestService = null;


	@RequestMapping(value = "/add")
	public Result<String> add(GuestModel guestModel) throws Exception {
		guestService.add(guestModel);
		Result<String> result = new Result<>();
		result.setStatus("OK");
		result.setMessage("增加访问记录成功！");
		return result;
	}

	@RequestMapping(value = "/modify")
	public Result<String> modify(GuestModel guestModel) throws Exception {
		guestService.modify(guestModel);
		Result<String> result = new Result<>();
		result.setStatus("OK");
		result.setMessage("修改访问记录成功！");
		return result;
	}

	@RequestMapping(value = "/delete")
	public Result<String> delete(GuestModel guestModel) throws Exception {
		guestService.delete(guestModel);
		Result<String> result = new Result<>();
		result.setStatus("OK");
		result.setMessage("删除访问记录成功！");
		return result;
	}

	// 取得访问记录列表，分页模式
	@GetMapping(value = "/list/all/page")
	public Result<GuestModel> getListByAllWithPage(@RequestParam(required = false, defaultValue = "5") int rows,
			@RequestParam(required = false, defaultValue = "1") int page) throws Exception {
		Result<GuestModel> result = new Result<>();
		result.setCount(guestService.getCountByAll());
		result.setPageCount(guestService.getPageCountByAll(rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(guestService.getByAllWithPage(rows, page));
		result.setStatus("OK");
		result.setMessage("获取访问记录列表分页方式成功！");
		return result;
	}
	
	// 取得单个访问记录
	@GetMapping(value = "/get")
	public Result<GuestModel> getById(@RequestParam(required = true) String id) throws Exception {
		Result<GuestModel> result = new Result<>();
		result.setResult(guestService.getById(id));
		if (result.getResult() == null) {
			result.setStatus("ERROR");
			result.setMessage("访问记录" + id + "不存在！");
		} else {
			result.setStatus("OK");
			result.setMessage("获取访问记录成功！");
		}
		return result;
	}
}