package com.hitstu.oa.checkin.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hitstu.oa.checkin.model.CostModel;

@Mapper
public interface ICostMapper {
	
	public void insert(CostModel costModel) throws Exception;
	
	public void delete(CostModel costModel) throws Exception;

	public void update(CostModel costModel) throws Exception;
	
	//查所有访问记录
	public List<CostModel> selectByAll() throws Exception;
//	//通过访问时间,访问人数查访问记录(动态SQL)
//	public List<CostModel> selectByDate() throws Exception;
	
	//通过访问id查访问记录
	public CostModel selectById(String id) throws Exception;
	//通过老人id获取分页列表
	public List<CostModel> selectByElderlyWithPage(String id, int start, int rows) throws Exception;

	public int selectCountByElderly(String id) throws Exception;
	
	
	public List<CostModel> selectListByConditionWithPage(@Param("start") int start, @Param("rows") int rows,
			@Param("minMoney") double minMoney, @Param("maxMoney") double maxMoney, @Param("minDate") Date minDate,
			@Param("maxDate") Date maxDate, @Param("elderlyid") String elderlyid,@Param("nameKey") String nameKey) throws Exception;
	
}
