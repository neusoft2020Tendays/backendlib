package com.hitstu.oa.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hitstu.oa.store.mapper.IWarehouseMapper;
import com.hitstu.oa.store.model.WarehouseModel;
import com.hitstu.oa.store.service.IWarehouseService;

@Service("warehouseService")
@Transactional
public class WarehouseServiceImpl implements IWarehouseService{
	@Autowired
	private IWarehouseMapper warehouseMapper = null;

	public void setGoodsMapper(IWarehouseMapper warehouseMapper) {
		this.warehouseMapper = warehouseMapper;
	}
	
	@Override
	public void add(WarehouseModel warehouseModel) throws Exception {
		warehouseMapper.insert(warehouseModel);
		
	}

	@Override
	public void delete(WarehouseModel warehouseModel) throws Exception {
		warehouseMapper.delete(warehouseModel);
		
	}

	@Override
	public void modify(WarehouseModel warehouseModel) throws Exception {
		warehouseMapper.update(warehouseModel);
		
	}

	@Override
	public List<WarehouseModel> getByAll() throws Exception {
		return warehouseMapper.selectByAll();
	}

	@Override
	public WarehouseModel getById(String id) throws Exception {
		return warehouseMapper.selectById(id);
	}

	@Override
	public List<WarehouseModel> getByAllWithPage(int rows, int page) throws Exception {
		
		return warehouseMapper.selectByAllWithPage(rows*(page-1), rows);
	}

	@Override
	public int getCountByAll() throws Exception {
		return warehouseMapper.selectCountByAll();
	}

	@Override
	public int getPageCountByAll(int rows) throws Exception {
		int count = this.getCountByAll();
		int pageCount = 0;
		if (count % rows == 0) {
			pageCount = count / rows;
		} else {
			pageCount = count / rows + 1;
		}
		return pageCount;
	}

}
