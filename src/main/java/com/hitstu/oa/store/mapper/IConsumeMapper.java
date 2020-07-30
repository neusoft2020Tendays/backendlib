package com.hitstu.oa.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hitstu.oa.store.model.ConsumeModel;

@Mapper
public interface IConsumeMapper {
	public void insert(ConsumeModel consumeModel) throws Exception;

	public void delete(ConsumeModel consumeModel) throws Exception;

	public void update(ConsumeModel consumeModel) throws Exception;

	public List<ConsumeModel> selectByAll() throws Exception;

	public ConsumeModel selectById(@Param("id")String id, @Param("date")String date) throws Exception;

	public List<ConsumeModel> selectByAllWithPage(@Param("start")int start, @Param("rows")int rows) throws Exception;

	public int selectCountByAll() throws Exception;
	
	public List<ConsumeModel> selectPageWithGoods(@Param("start")int start, @Param("rows")int rows) throws Exception; 
	
	public ConsumeModel selectByIdWithGoods(@Param("id")String id, @Param("date")String date) throws Exception;
}
