package com.hitstu.oa.store.service;

import java.util.List;

import com.hitstu.oa.store.model.WarehouseModel;
//
public interface IWarehouseService {
	public void add(WarehouseModel warehouseModel) throws Exception;

	public void delete(WarehouseModel warehouseModel) throws Exception;

	public void modify(WarehouseModel warehouseModel) throws Exception;

	public List<WarehouseModel> getByAll() throws Exception;

	public WarehouseModel getById(String warehouseid) throws Exception;

	public List<WarehouseModel> getByAllWithPage(int rows, int page) throws Exception;

	public int getCountByAll() throws Exception;

	public int getPageCountByAll(int rows) throws Exception;
}
