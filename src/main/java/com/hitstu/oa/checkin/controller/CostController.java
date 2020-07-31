package com.hitstu.oa.checkin.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hitstu.oa.checkin.model.CostModel;
import com.hitstu.oa.checkin.model.ElderlyModel;
import com.hitstu.oa.checkin.service.ICostService;
import com.hitstu.oa.restresult.Result;

@RestController
@RequestMapping(value = "/cost")
@CrossOrigin(origins = { "*", "null" })
public class CostController {
	
	@Autowired
	private ICostService costService = null;


	@RequestMapping(value = "/add")
	public Result<String> add(@RequestBody CostModel costModel) throws Exception {
		costService.add(costModel);
		Result<String> result = new Result<>();
		result.setStatus("OK");
		result.setMessage("增加账单记录成功！");
		return result;
	}

	@RequestMapping(value = "/modify")
	public Result<String> modify(@RequestBody CostModel costModel) throws Exception {
		costService.modify(costModel);
		Result<String> result = new Result<>();
		result.setStatus("OK");
		result.setMessage("修改账单记录成功！");
		return result;
	}

	@PostMapping(value = "/delete")
	public Result<String> delete(@RequestBody CostModel costModel) throws Exception {
		costService.delete(costModel);
		Result<String> result = new Result<>();
		result.setStatus("OK");
		result.setMessage("删除账单记录成功！");
		return result;
	}

	// 取得访问记录列表，分页模式
	@GetMapping(value = "/list/all/page")
	public Result<CostModel> getListByElderlyIdWithPage(@RequestParam(required = false, defaultValue = "0001") String id,
			@RequestParam(required = false, defaultValue = "5") int rows,
			@RequestParam(required = false, defaultValue = "1") int page) throws Exception {
		Result<CostModel> result = new Result<>();
		result.setCount(costService.getCountByElderlyId(id));
		result.setPageCount(costService.getPageCountByElderlyId(id, rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(costService.getByElderlyIdWithPage(id,rows, page));
		result.setStatus("OK");
		result.setMessage("获取访问记录列表分页方式成功！");
		return result;
	}
	
	// 取得单个访问记录
	@GetMapping(value = "/get")
	public Result<CostModel> getById(@RequestParam(required = true) String id) throws Exception {
		Result<CostModel> result = new Result<>();
		result.setResult(costService.getById(id));
		if (result.getResult() == null) {
			result.setStatus("ERROR");
			result.setMessage("访问记录" + id + "不存在！");
		} else {
			result.setStatus("OK");
			result.setMessage("获取访问记录成功！");
		}
		return result;
	}
	
	
	@GetMapping(value = "/list/condition/page")
	public Result<CostModel> getListByConditionWithPage(@RequestParam(required = false, defaultValue = "5") int rows,
			@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "-1") double minMoney,
			@RequestParam(required = false, defaultValue = "-1") double maxMoney,
			@RequestParam(required = false, defaultValue = "null") String minDate,
			@RequestParam(required = false, defaultValue = "null") String maxDate,
			@RequestParam(required = false, defaultValue = "") String elderlyid,
			@RequestParam(required = false, defaultValue = "") String nameKey) throws Exception {
		SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" ); 
		Date minDate1 = null;
		if(!minDate.equals("null")) {
			minDate1=sdf.parse(minDate);
		}
		Date maxDate1 = null;
		if(!maxDate.equals("null")) {
			maxDate1=sdf.parse(maxDate);
		}
		Result<CostModel> result = new Result<>();
		result.setRows(rows);
		result.setPage(page);
		result.setList(costService.getListByConditionWithPage(rows, page, minMoney, maxMoney, minDate1, 
				maxDate1, elderlyid,nameKey));
		result.setStatus("OK");
		result.setMessage("收费记录列表分页方式成功！");
		return result;
	}
	
	
	
}