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
import com.hitstu.oa.store.model.WarehouseModel;
import com.hitstu.oa.store.service.IWarehouseService;

@RestController
@RequestMapping("/warehouse")
@CrossOrigin(origins = { "*", "null" })
@ResponseBody
public class WarehouseController {
	@Autowired
	private IWarehouseService warehouseService = null;
	
	@PostMapping("/add")
	public Result<String> add(@RequestBody WarehouseModel warehouseModel) throws Exception {
		warehouseService.add(warehouseModel);
		Result<String> result = new Result<>();
		result.setStatus("OK");
		result.setMessage("增加仓库信息成功");
		return result;
	}
	//

	@PostMapping("/modify")
	public Result<String> modify(@RequestBody WarehouseModel warehouseModel) throws Exception {
		warehouseService.modify(warehouseModel);
		Result<String> result = new Result<>();
		result.setStatus("OK");
		result.setMessage("修改仓库信息成功");
		return result;
	}

	@PostMapping("/delete")
	public Result<String> delete(@RequestBody WarehouseModel warehouseModel) throws Exception {
		warehouseService.delete(warehouseModel);
		Result<String> result = new Result<>();
		result.setStatus("OK");
		result.setMessage("删除仓库信息成功");
		return result;
	}

	@GetMapping("/listAll")
	public Result<WarehouseModel> getListByAll() throws Exception {
		Result<WarehouseModel> result = new Result<>();
		result.setCount(warehouseService.getCountByAll());
		result.setList(warehouseService.getByAll());
		result.setStatus("OK");
		result.setMessage("取得全部仓库信息成功");
		return result;
	}

	@GetMapping("/listAllPage")
	public Result<WarehouseModel> getListByAllWithPage(@RequestParam(required = false, defaultValue = "10") int rows,
			@RequestParam(required = false, defaultValue = "1") int page) throws Exception {
		
		Result<WarehouseModel> result = new Result<>();
		result.setCount(warehouseService.getCountByAll());
		result.setPageCount(warehouseService.getPageCountByAll(rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(warehouseService.getByAllWithPage(rows, page));
		result.setStatus("OK");
		result.setMessage("取得分页仓库信息成功");
		return result;
	}
	
	@GetMapping("/listAllPageWithWarehouse")
	public Result<WarehouseModel> getListByAllWithPageWithGoods(@RequestParam(required = false, defaultValue = "10") int rows,
			@RequestParam(required = false, defaultValue = "1") int page) throws Exception {
		
		Result<WarehouseModel> result = new Result<>();
		result.setCount(warehouseService.getCountByAll());
		result.setPageCount(warehouseService.getPageCountByAll(rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(warehouseService.getByAllWithPage(rows, page));
		result.setStatus("OK");
		result.setMessage("取得分页仓库信息成功");
		return result;
	}
	
	@GetMapping("/get")
	public Result<WarehouseModel> getById(@RequestParam(required = true) String id, 
			@RequestParam(required = true) Date date) throws Exception {
		Result<WarehouseModel> result = new Result<>();
		
		result.setResult(warehouseService.getById(id));
		result.setStatus("OK");
		result.setMessage("取得特定仓库信息成功");
//		org.apache.ibatis.type.JdbcType.DATETIMEOFFSET
		return result;
	}
}
