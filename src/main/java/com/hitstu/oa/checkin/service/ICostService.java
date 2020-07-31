package com.hitstu.oa.checkin.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hitstu.oa.checkin.model.CostModel;
import com.hitstu.oa.checkin.model.ElderlyModel;

public interface ICostService {
	
	public void add(CostModel costModel) throws Exception;

	public void delete(CostModel costModel) throws Exception;

	public void modify(CostModel costModel) throws Exception;

	public List<CostModel> getByAll() throws Exception;
	
	public CostModel getById(String id) throws Exception;

	public List<CostModel> getByElderlyIdWithPage(String id, int rows, int page) throws Exception;

	public int getCountByElderlyId(String id) throws Exception;
	
	public int getPageCountByElderlyId(String id,int rows) throws Exception;
	
	public List<CostModel> getListByConditionWithPage(@Param("start") int start, @Param("rows") int rows,
			@Param("minMoney") double minMoney, @Param("maxMoney") double maxMoney, @Param("minDate") Date minDate,
			@Param("maxDate") Date maxDate, @Param("elderlyid") String elderlyid,@Param("nameKey") String nameKey) throws Exception;

}
