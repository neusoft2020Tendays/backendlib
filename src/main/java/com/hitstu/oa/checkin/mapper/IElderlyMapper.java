package com.hitstu.oa.checkin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hitstu.oa.checkin.model.ElderlyModel;

@Mapper
public interface IElderlyMapper {

	public void insert(ElderlyModel elderlyModel) throws Exception;

	public void delete(ElderlyModel elderlyModel) throws Exception;

	public void update(ElderlyModel elderlyModel) throws Exception;

	public List<ElderlyModel> selectByAll() throws Exception;

	public ElderlyModel selectById(String id) throws Exception;

	public List<ElderlyModel> selectByAllWithPage(int start, int rows) throws Exception;

	public int selectCountByAll() throws Exception;

}
