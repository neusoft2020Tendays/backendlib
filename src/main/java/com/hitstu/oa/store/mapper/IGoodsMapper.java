package com.hitstu.oa.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hitstu.oa.store.model.GoodsModel;

@Mapper
public interface IGoodsMapper {
	public void insert(GoodsModel goodsModel) throws Exception;

	public void delete(GoodsModel goodsModel) throws Exception;

	public void update(GoodsModel goodsModel) throws Exception;

	public List<GoodsModel> selectByAll() throws Exception;

	public GoodsModel selectById(String id) throws Exception;

	public List<GoodsModel> selectByAllWithPage(@Param("start")int start, @Param("rows")int rows) throws Exception;

	public int selectCountByAll() throws Exception;
}
