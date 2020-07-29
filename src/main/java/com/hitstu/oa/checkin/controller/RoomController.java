package com.hitstu.oa.checkin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hitstu.oa.checkin.model.RoomModel;
import com.hitstu.oa.checkin.service.IRoomService;
import com.hitstu.oa.restresult.Result;

@RestController
@RequestMapping(value = "/room")
public class RoomController {
	
	@Autowired
	private IRoomService roomService = null;


	@RequestMapping(value = "/add")
	public Result<String> add(RoomModel roomModel) throws Exception {
		roomService.add(roomModel);
		Result<String> result = new Result<>();
		result.setStatus("OK");
		result.setMessage("增加房间成功！");
		return result;
	}

	@RequestMapping(value = "/modify")
	public Result<String> modify(RoomModel roomModel) throws Exception {
		roomService.modify(roomModel);
		Result<String> result = new Result<>();
		result.setStatus("OK");
		result.setMessage("修改房间成功！");
		return result;
	}

	@RequestMapping(value = "/delete")
	public Result<String> delete(RoomModel roomModel) throws Exception {
		roomService.delete(roomModel);
		Result<String> result = new Result<>();
		result.setStatus("OK");
		result.setMessage("删除房间成功！");
		return result;
	}

	// 取得部门列表，分页模式
	@GetMapping(value = "/list/all/page")
	public Result<RoomModel> getListByAllWithPage(@RequestParam(required = false, defaultValue = "5") int rows,
			@RequestParam(required = false, defaultValue = "1") int page) throws Exception {
		Result<RoomModel> result = new Result<>();
		result.setCount(roomService.getCountByAll());
		result.setPageCount(roomService.getPageCountByAll(rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(roomService.getByAllWithPage(rows, page));
		result.setStatus("OK");
		result.setMessage("获取房间列表分页方式成功！");
		return result;
	}

	@GetMapping(value = "/get")
	public Result<RoomModel> getById(@RequestParam(required = true) String id) throws Exception {
		Result<RoomModel> result = new Result<>();
		result.setResult(roomService.getById(id));
		result.setStatus("OK");
		result.setMessage("获取房间成功！");
		return result;
	}

}
