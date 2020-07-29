package com.hitstu.oa.checkin.controller;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hitstu.oa.checkin.model.ElderlyModel;
import com.hitstu.oa.checkin.service.IElderlyService;
import com.hitstu.oa.checkin.service.IWardService;
import com.hitstu.oa.restresult.Result;

@RestController
@RequestMapping(value = "/elderly")
@CrossOrigin(origins = { "*", "null" })
public class ElderlyController {

	@Autowired
	private IElderlyService elderlyService = null;

	@Autowired
	private IWardService wardService = null;

	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody ElderlyModel elderlyModel) throws Exception {
		Result<String> result = new Result<>();
		Result<ElderlyModel> search = this.getById(elderlyModel.getElderlyid());
		result.setStatus("ERROR");
		if (search.getResult() != null) {
			result.setMessage("老人 " + elderlyModel.getElderlyid() + " 已存在！");
		} else if (!elderlyModel.getEldersex().equals("男") && !elderlyModel.getEldersex().equals("女")) {
			result.setMessage("性别必须为“男”或“女”");
		} else if (!new HashSet<>(wardService.getFloorByAll()).contains(elderlyModel.getFloor())) {
			result.setMessage("楼层 " + elderlyModel.getFloor() + " 不存在！");
		} else if (new HashSet<>(wardService.getFloorByAll()).contains(elderlyModel.getFloor())
				&& !new HashSet<>(wardService.getRoomByFloor(elderlyModel.getFloor()))
						.contains(elderlyModel.getRoom())) {
			result.setMessage("楼层 " + elderlyModel.getFloor() + " 的房间 " + elderlyModel.getRoom() + " 不存在！");
		} else if (new HashSet<>(wardService.getFloorByAll()).contains(elderlyModel.getFloor())
				&& new HashSet<>(wardService.getRoomByFloor(elderlyModel.getFloor())).contains(elderlyModel.getRoom())
				&& !new HashSet<>(wardService.getWardByFloorAndRoom(elderlyModel.getFloor(), elderlyModel.getRoom()))
						.contains(elderlyModel.getBed())) {
			result.setMessage("楼层 " + elderlyModel.getFloor() + " 的房间  " + elderlyModel.getRoom() + " 中的床位号 "
					+ elderlyModel.getBed() + " 不存在！");
		} else if (elderlyModel.getElderage() <= 0 || elderlyModel.getElderage() >= 150) {
			result.setMessage("年龄 " + elderlyModel.getElderage() + " 不合法！");
		} else {
			elderlyService.add(elderlyModel);
			result.setStatus("OK");
			result.setMessage("增加老人成功！");
		}
		return result;
	}

	@PostMapping(value = "/modify")
	public Result<String> modify(@RequestBody ElderlyModel elderlyModel) throws Exception {
		elderlyService.modify(elderlyModel);
		Result<String> result = new Result<>();
		result.setStatus("OK");
		result.setMessage("修改老人成功！");
		return result;
	}

	@PostMapping(value = "/delete")
	public Result<String> delete(@RequestBody ElderlyModel elderlyModel) throws Exception {
		elderlyService.delete(elderlyModel);
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
		result.setMessage("老人列表分页方式成功！");
		return result;
	}

	@GetMapping(value = "/get")
	public Result<ElderlyModel> getById(@RequestParam(required = true) String id) throws Exception {
		Result<ElderlyModel> result = new Result<>();
		result.setResult(elderlyService.getById(id));
		if (result.getResult() == null) {
			result.setStatus("ERROR");
			result.setMessage("老人" + id + "不存在！");
		} else {
			result.setStatus("OK");
			result.setMessage("获取老人成功！");
		}
		return result;
	}

}
