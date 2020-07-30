package com.hitstu.oa.checkin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hitstu.oa.checkin.model.ElderlyModel;

@Mapper
public interface IElderlyMapper {

	public void insert(ElderlyModel elderlyModel) throws Exception;

	public void insertWithPhoto(ElderlyModel elderlyModel) throws Exception;

	public void delete(ElderlyModel elderlyModel) throws Exception;

	public void update(ElderlyModel elderlyModel) throws Exception;
	public void updatePhoto(ElderlyModel elderlyModel) throws Exception;

	public void updateWithPhoto(ElderlyModel elderlyModel) throws Exception;

	public List<ElderlyModel> selectByAll() throws Exception;

	public ElderlyModel selectById(String id) throws Exception;

	public List<ElderlyModel> selectByAllWithPage(int start, int rows) throws Exception;

	public int selectCountByAll() throws Exception;

	public List<ElderlyModel> selectListByConditionWithPage(@Param("start") int start, @Param("rows") int rows,
			@Param("minAge") int minAge, @Param("maxAge") int maxAge, @Param("floor") String floor,
			@Param("room") String room, @Param("nameKey") String nameKey) throws Exception;

}
