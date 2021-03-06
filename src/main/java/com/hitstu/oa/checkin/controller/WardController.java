package com.hitstu.oa.checkin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hitstu.oa.checkin.model.WardModel;
import com.hitstu.oa.checkin.service.IWardService;
import com.hitstu.oa.restresult.Result;

@RestController
@RequestMapping(value = "/ward")
@CrossOrigin(origins = { "*", "null" })
public class WardController {
	
	@Autowired
	private IWardService wardService = null;


	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody WardModel wardModel) throws Exception {
		System.out.println(wardModel.getFloor());
		System.out.println(wardModel.getRoom());
		System.out.println(wardModel.getBed());
		wardService.add(wardModel);
		Result<String> result = new Result<>();
		result.setStatus("OK");
		result.setMessage("增加床位成功！");
		return result;
	}

	@RequestMapping(value = "/modify")
	public Result<String> modify(@RequestBody WardModel wardModel) throws Exception {
		wardService.modify(wardModel);
		Result<String> result = new Result<>();
		result.setStatus("OK");
		result.setMessage("修改床位成功！");
		return result;
	}

	@RequestMapping(value = "/delete")
	public Result<String> delete(@RequestBody WardModel wardModel) throws Exception {
		//增加判断，若床位上有老人，则不应该删除
		Result<String> result = new Result<>();
		result.setStatus("Error");
		result.setMessage("该床位上有老人！");
		WardModel search = wardService.getById(wardModel.getFloor(), wardModel.getRoom(), wardModel.getBed());
		if(search.getElderly()==null) {
			wardService.delete(wardModel);
			result.setStatus("OK");
			result.setMessage("删除床位成功！");
		}
		return result;
	}

	// 取得部门列表，分页模式
	@GetMapping(value = "/list/all/page")
	public Result<WardModel> getListByAllWithPage(@RequestParam(required = false, defaultValue = "5") int rows,
			@RequestParam(required = false, defaultValue = "1") int page) throws Exception {
		Result<WardModel> result = new Result<>();
		result.setCount(wardService.getCountByAll());
		result.setPageCount(wardService.getPageCountByAll(rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(wardService.getByAllWithPage(rows, page));
		result.setStatus("OK");
		result.setMessage("获取床位列表分页方式成功！");
		return result;
	}

	@GetMapping(value = "/list/all")
	public Result<WardModel> getListByFloor(@RequestParam(required = false, defaultValue = "L01") String floor) throws Exception {
		Result<WardModel> result = new Result<>();
		result.setList(wardService.getByFloor(floor));
		result.setStatus("OK");
		result.setMessage("获取床位列表成功！");
		return result;
	}
	
	@GetMapping(value = "/bed")
	public Result<String> getById(@RequestParam(required = true) String floor
			,@RequestParam(required = true) String room) throws Exception {
		Result<String> result = new Result<>();
		result.setList(wardService.getWardByFloorAndRoom(floor, room));
		result.setStatus("OK");
		result.setMessage("获取床位成功！");
		return result;
	}

	@GetMapping(value = "/floor")
	public Result<String> getFloorByAll() throws Exception {
		Result<String> result = new Result<>();
		result.setList(wardService.getFloorByAll());
		result.setStatus("OK");
		result.setMessage("获取楼层成功！");
		return result;
	}
	
	@GetMapping(value = "/room")
	public Result<String> getRoomByFloor(String floor) throws Exception {
		Result<String> result = new Result<>();
		result.setList(wardService.getRoomByFloor(floor));
		result.setStatus("OK");
		result.setMessage("获取第"+floor+"层的房间成功！");
		return result;
	}
	
}
