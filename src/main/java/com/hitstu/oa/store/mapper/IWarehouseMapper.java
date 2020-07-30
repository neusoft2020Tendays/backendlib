package com.hitstu.oa.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hitstu.oa.store.model.WarehouseModel;

@Mapper
public interface IWarehouseMapper {
	public void insert(WarehouseModel warehouseModel) throws Exception;

	public void delete(WarehouseModel warehouseModel) throws Exception;

	public void update(WarehouseModel warehouseModel) throws Exception;

	public List<WarehouseModel> selectByAll() throws Exception;

	public WarehouseModel selectById(String warehouseid) throws Exception;

	public List<WarehouseModel> selectByAllWithPage(@Param("start")int start, @Param("rows")int rows) throws Exception;

	public int selectCountByAll() throws Exception;
}
