package com.hitstu.oa.store.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hitstu.oa.restresult.Result;
import com.hitstu.oa.store.model.ConsumeModel;
import com.hitstu.oa.store.service.IConsumeService;

@RestController
@RequestMapping("/consume")
@CrossOrigin(origins = { "*", "null" })
@ResponseBody
public class ConsumeController {
	@Autowired
	private IConsumeService consumeService = null;
	
	@PostMapping("/add")
	public Result<String> add(@RequestBody ConsumeModel consumeModel) throws Exception {
		consumeService.add(consumeModel);
		Result<String> result = new Result<>();
		result.setStatus("OK");
		result.setMessage("增加货物使用信息成功");
		return result;
	}

	@PostMapping("/modify")
	public Result<String> modify(@RequestBody ConsumeModel consumeModel) throws Exception {
		consumeService.modify(consumeModel);
		Result<String> result = new Result<>();
		result.setStatus("OK");
		result.setMessage("修改货物使用信息成功");
		return result;
	}

	@PostMapping("/delete")
	public Result<String> delete(@RequestBody ConsumeModel consumeModel) throws Exception {
		consumeService.delete(consumeModel);
		Result<String> result = new Result<>();
		result.setStatus("OK");
		result.setMessage("删除货物使用信息成功");
		return result;
	}

	@GetMapping("/listAll")
	public Result<ConsumeModel> getListByAll() throws Exception {
		Result<ConsumeModel> result = new Result<>();
		result.setCount(consumeService.getCountByAll());
		result.setList(consumeService.getByAll());
		result.setStatus("OK");
		result.setMessage("取得全部货物使用信息成功");
		return result;
	}

	@GetMapping("/listAllPage")
	public Result<ConsumeModel> getListByAllWithPage(@RequestParam(required = false, defaultValue = "10") int rows,
			@RequestParam(required = false, defaultValue = "1") int page) throws Exception {
		
		Result<ConsumeModel> result = new Result<>();
		result.setCount(consumeService.getCountByAll());
		result.setPageCount(consumeService.getPageCountByAll(rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(consumeService.getByAllWithPage(rows, page));
		result.setStatus("OK");
		result.setMessage("取得分页货物使用信息成功");
		return result;
	}
	
	@GetMapping("/listAllPageWithGoods")
	public Result<ConsumeModel> getListByAllWithPageWithGoods(@RequestParam(required = false, defaultValue = "10") int rows,
			@RequestParam(required = false, defaultValue = "1") int page) throws Exception {
		Result<ConsumeModel> result = new Result<>();
		result.setCount(consumeService.getCountByAll());
		result.setPageCount(consumeService.getPageCountByAll(rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(consumeService.getByAllWithPage(rows, page));
		result.setStatus("OK");
		result.setMessage("取得分页货物使用信息成功");
		return result;
	}
	
	@GetMapping("/get")
	public Result<ConsumeModel> getById(@RequestParam(required = true) String id, 
			@RequestParam(required = true) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date) throws Exception {
		Result<ConsumeModel> result = new Result<>();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		result.setResult(consumeService.getById(id, dateFormat.format(date)));
		result.setStatus("OK");
		result.setMessage("取得特定货品单成功");
//		org.apache.ibatis.type.JdbcType.DATETIMEOFFSET
		return result;
	}
	
	@GetMapping("/listPageWithGoods")
	public Result<ConsumeModel> getListPageWithGoods(@RequestParam(required = false, defaultValue = "10") int rows,
			@RequestParam(required = false, defaultValue = "1") int page) throws Exception {
		
		Result<ConsumeModel> result = new Result<>();
		result.setCount(consumeService.getCountByAll());
		result.setPageCount(consumeService.getPageCountByAll(rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(consumeService.getPageWithGoods(rows, page));
		result.setStatus("OK");
		result.setMessage("取得分页货物使用信息(带Goods信息)成功");
		return result;
	}
	
	
	@GetMapping("/getWithGoods")
	public Result<ConsumeModel> getByIdWithGoods(@RequestParam(required = true) String id, 
			@RequestParam(required = true) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date) throws Exception {
		Result<ConsumeModel> result = new Result<>();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		result.setResult(consumeService.getByIdWithGoods(id, dateFormat.format(date)));
		result.setStatus("OK");
		result.setMessage("取得特定货品消耗单(带Goods信息)成功");
		return result;
	}
}
