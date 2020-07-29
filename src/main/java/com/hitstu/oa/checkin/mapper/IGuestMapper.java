package com.hitstu.oa.checkin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hitstu.oa.checkin.model.GuestModel;

@Mapper
public interface IGuestMapper {
	
	public void insert(GuestModel guestModel) throws Exception;
	
	public void delete(GuestModel guestModel) throws Exception;

	public void update(GuestModel guestModel) throws Exception;
	
	//查所有访问记录
	public List<GuestModel> selectByAll() throws Exception;
//	//通过访问时间,访问人数查访问记录(动态SQL)
//	public List<GuestModel> selectByDate() throws Exception;
	
	//通过访问id查访问记录
	public GuestModel selectById(String id) throws Exception;

	public List<GuestModel> selectByAllWithPage(int start, int rows) throws Exception;

	public int selectCountByAll() throws Exception;

}
