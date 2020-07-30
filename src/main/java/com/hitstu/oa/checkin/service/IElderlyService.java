package com.hitstu.oa.checkin.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hitstu.oa.checkin.model.ElderlyModel;

public interface IElderlyService {
	public void add(ElderlyModel elderlyModel) throws Exception;

	public void delete(ElderlyModel elderlyModel) throws Exception;

	public void modify(ElderlyModel elderlyModel) throws Exception;

	public List<ElderlyModel> getByAll() throws Exception;

	public ElderlyModel getById(String id) throws Exception;

	public List<ElderlyModel> getByAllWithPage(int rows, int page) throws Exception;

	public int getCountByAll() throws Exception;

	public int getPageCountByAll(int rows) throws Exception;
	
	public List<ElderlyModel> getListByConditionWithPage(@Param("rows") int rows, @Param("page") int page,
			@Param("minAge") int minAge, @Param("maxAge") int maxAge, @Param("floor") String floor,
			@Param("room") String room, @Param("nameKey") String nameKey) throws Exception;

}
