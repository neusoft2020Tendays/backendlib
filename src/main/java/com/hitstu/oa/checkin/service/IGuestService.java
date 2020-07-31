package com.hitstu.oa.checkin.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hitstu.oa.checkin.model.CostModel;
import com.hitstu.oa.checkin.model.GuestModel;

public interface IGuestService {
	
	public void add(GuestModel guestModel) throws Exception;

	public void delete(GuestModel guestModel) throws Exception;

	public void modify(GuestModel guestModel) throws Exception;

	public List<GuestModel> getByAll() throws Exception;
	
	public GuestModel getById(String id) throws Exception;

	public List<GuestModel> getByAllWithPage(int rows, int page) throws Exception;

	public int getCountByAll() throws Exception;
	
	public int getPageCountByAll(int rows) throws Exception;
	
	public List<GuestModel> getListByConditionWithPage(@Param("start") int start, @Param("rows") int rows,
			@Param("minNum") int minNum, @Param("maxNum") int maxNum
			, @Param("elderlyid") String elderlyid,@Param("nameKey") String nameKey) throws Exception;


}
