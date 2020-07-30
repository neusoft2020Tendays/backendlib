package com.hitstu.oa.store.controller;

import java.text.SimpleDateFormat;
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
import com.hitstu.oa.store.model.PurchaseModel;
import com.hitstu.oa.store.service.IGoodsService;
import com.hitstu.oa.store.service.IPurchaseService;

@RestController
@RequestMapping("/purchase")
@CrossOrigin(origins = { "*", "null" })
@ResponseBody
public class PurchaseController {
	@Autowired
	private IPurchaseService purchaseService = null;

	@Autowired
	private IGoodsService goodsService = null;

	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody PurchaseModel purchaseModel) throws Exception {
		Result<String> result = new Result<>();
		Result<PurchaseModel> search = this.getByIdAndDate(purchaseModel.getGoodsid(), purchaseModel.getDate());
		if (search != null && search.getResult() != null) {
			result.setStatus("ERROR");
			result.setMessage("货物" + purchaseModel.getGoodsid() + "于"
					+ new SimpleDateFormat("yyyy-MM-dd").format(purchaseModel.getDate()) + "的购买记录已存在！");
		} else {
			purchaseService.add(purchaseModel);
			result.setStatus("OK");
			result.setMessage("增加货物购买记录成功！");
		}
		return result;
	}

	@PostMapping(value = "/modify")
	public Result<String> modify(@RequestBody PurchaseModel purchaseModel) throws Exception {
		Result<String> result = new Result<>();
		purchaseService.modify(purchaseModel);
		result.setStatus("OK");
		result.setMessage("修改货物购买记录成功！");
		return result;
	}

	@PostMapping(value = "/delete")
	public Result<String> delete(@RequestBody PurchaseModel purchaseModel) throws Exception {
		purchaseService.delete(purchaseModel);
		Result<String> result = new Result<>();
		result.setStatus("OK");
		result.setMessage("删除货物购买记录成功！");
		return result;
	}

	// 取得部门列表，分页模式
	@GetMapping(value = "/list/all/page")
	public Result<PurchaseModel> getListByAllWithPage(@RequestParam(required = false, defaultValue = "5") int rows,
			@RequestParam(required = false, defaultValue = "1") int page) throws Exception {
		Result<PurchaseModel> result = new Result<>();
		result.setCount(purchaseService.getCountByAll());
		result.setPageCount(purchaseService.getPageCountByAll(rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(purchaseService.getByAllWithPage(rows, page));
		result.setStatus("OK");
		result.setMessage("货物购买记录列表分页方式成功！");
		return result;
	}

	@GetMapping(value = "/get")
	public Result<PurchaseModel> getByIdAndDate(@RequestParam(required = true) String id,
			@RequestParam(required = true) Date date) throws Exception {
		Result<PurchaseModel> result = new Result<>();
		result.setResult(purchaseService.getByIdAndDate(id, date));
		if (result.getResult() == null) {
			result.setStatus("ERROR");
			result.setMessage("货物" + id + "于" + new SimpleDateFormat("yyyy-MM-dd").format(date) + "的购买记录不存在！");
		} else {
			result.setStatus("OK");
			result.setMessage("货物购买记录列表分页方式成功！");
		}
		return result;
	}
}
