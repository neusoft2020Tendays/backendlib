package com.hitstu.oa.checkin.controller;

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
import com.hitstu.oa.checkin.service.IBedService;
import com.hitstu.oa.restresult.Result;

@RestController
@RequestMapping("/bed")
@CrossOrigin(origins = { "*", "null" })
@ResponseBody
public class BedController {
	@Autowired
	private IBedService bedService = null;

	@PostMapping("/add")
	public Result<String> add(@RequestBody BedModel bedModel) throws Exception {
		bedService.add(bedModel);
		Result<String> result = new Result<>();
		result.setStatus("OK");
		result.setMessage("增加床位成功");
		return result;
	}

	@PostMapping("/modify")
	public Result<String> modify(@RequestBody BedModel bedModel) throws Exception {
		bedService.modify(bedModel);
		Result<String> result = new Result<>();
		result.setStatus("OK");
		result.setMessage("修改床位成功");
		return result;
	}

	@PostMapping("/delete")
	public Result<String> delete(@RequestBody BedModel bedModel) throws Exception {
		bedService.delete(bedModel);
		Result<String> result = new Result<>();
		result.setStatus("OK");
		result.setMessage("删除床位成功");
		return result;
	}

	@GetMapping("/listAll")
	public Result<BedModel> getListByAll() throws Exception {
		Result<BedModel> result = new Result<>();
		result.setCount(bedService.getCountByAll());
		result.setList(bedService.getByAll());
		result.setStatus("OK");
		result.setMessage("取得全部床位成功");
		return result;
	}

	@GetMapping("/listAllPage")
	public Result<BedModel> getListByAllWithPage(@RequestParam(required = false, defaultValue = "10") int rows,
			@RequestParam(required = false, defaultValue = "1") int page) throws Exception {
		
		Result<BedModel> result = new Result<>();
		result.setCount(bedService.getCountByAll());
		result.setPage(bedService.getPageCountByAll(rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(bedService.getByAllWithPage(rows, page));
		result.setStatus("OK");
		result.setMessage("取得分页床位成功");
		return result;
	}
	
	@GetMapping("/get")
	public Result<BedModel> getById(@RequestParam(required = true) String id) throws Exception {
		
		Result<BedModel> result = new Result<>();
		result.setResult(bedService.getById(id));
		result.setStatus("OK");
		result.setMessage("取得特定床位成功");
		return result;
	}
}
