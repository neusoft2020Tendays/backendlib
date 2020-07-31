package com.hitstu.oa.store.controller;

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

import com.hitstu.oa.restresult.Result;
import com.hitstu.oa.store.model.GoodsModel;
import com.hitstu.oa.store.service.IGoodsService;

@RestController
@RequestMapping("/goods")
@CrossOrigin(origins = { "*", "null" })
@ResponseBody
public class GoodsController {
	@Autowired
	private IGoodsService goodsService = null;
	
	@PostMapping("/add")
	public Result<String> add(@RequestBody GoodsModel goodsModel) throws Exception {
		goodsService.add(goodsModel);
		Result<String> result = new Result<>();
		result.setStatus("OK");
		result.setMessage("增加货物信息成功");
		return result;
	}

	@PostMapping("/modify")
	public Result<String> modify(@RequestBody GoodsModel goodsModel) throws Exception {
		goodsService.modify(goodsModel);
		Result<String> result = new Result<>();
		result.setStatus("OK");
		result.setMessage("修改货物信息成功");
		return result;
	}

	@PostMapping("/delete")
	public Result<String> delete(@RequestBody GoodsModel goodsModel) throws Exception {
		goodsService.delete(goodsModel);
		Result<String> result = new Result<>();
		result.setStatus("OK");
		result.setMessage("删除货物信息成功");
		return result;
	}

	@GetMapping("/listAll")
	public Result<GoodsModel> getListByAll() throws Exception {
		Result<GoodsModel> result = new Result<>();
		result.setCount(goodsService.getCountByAll());
		result.setList(goodsService.getByAll());
		result.setStatus("OK");
		result.setMessage("取得全部货物信息成功");
		return result;
	}

	@GetMapping("/listAllPage")
	public Result<GoodsModel> getListByAllWithPage(@RequestParam(required = false, defaultValue = "10") int rows,
			@RequestParam(required = false, defaultValue = "1") int page) throws Exception {
		
		Result<GoodsModel> result = new Result<>();
		result.setCount(goodsService.getCountByAll());
		result.setPageCount(goodsService.getPageCountByAll(rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(goodsService.getByAllWithPage(rows, page));
		result.setStatus("OK");
		result.setMessage("取得分页货物使用信息成功");
		return result;
	}
	
	@GetMapping("/listAllPageWithGoods")
	public Result<GoodsModel> getListByAllWithPageWithGoods(@RequestParam(required = false, defaultValue = "10") int rows,
			@RequestParam(required = false, defaultValue = "1") int page) throws Exception {
		
		Result<GoodsModel> result = new Result<>();
		result.setCount(goodsService.getCountByAll());
		result.setPageCount(goodsService.getPageCountByAll(rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(goodsService.getByAllWithPage(rows, page));
		result.setStatus("OK");
		result.setMessage("取得分页货物使用信息成功");
		return result;
	}
	
	@GetMapping("/get")
	public Result<GoodsModel> getById(@RequestParam(required = true) String id) throws Exception {
		Result<GoodsModel> result = new Result<>();
		
		result.setResult(goodsService.getById(id));
		result.setStatus("OK");
		result.setMessage("取得特定货品单成功");
//		org.apache.ibatis.type.JdbcType.DATETIMEOFFSET
		return result;
	}
	
	
}
