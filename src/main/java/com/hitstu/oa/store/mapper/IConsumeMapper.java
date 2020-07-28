package com.hitstu.oa.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hitstu.oa.store.model.ConsumeModel;

@Mapper
public interface IConsumeMapper {
	public void insert(ConsumeModel consumeModel) throws Exception;

	public void delete(ConsumeModel consumeModel) throws Exception;

	public void update(ConsumeModel consumeModel) throws Exception;

	public List<ConsumeModel> selectByAll() throws Exception;

	public ConsumeModel selectById(String id) throws Exception;

	public List<ConsumeModel> selectByAllWithPage(int start, int rows) throws Exception;

	public int selectCountByAll() throws Exception;
}
