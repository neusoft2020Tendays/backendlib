package com.hitstu.oa.checkin.service;

import java.util.List;

import com.hitstu.oa.checkin.model.WardModel;

public interface IWardService {
	
	public void add(WardModel roomModel) throws Exception;

	public void delete(WardModel roomModel) throws Exception;

	public void modify(WardModel roomModel) throws Exception;

	public List<WardModel> getByAll() throws Exception;
	//获取所有楼层号
	public List<String> getFloorByAll() throws Exception;
	//查某个楼层的所有房间
	public List<String> getRoomByFloor(String floor) throws Exception;
	//查某个房间的所有床位
	public List<String> getWardByFloorAndRoom(String floor, String room) throws Exception;
	
	public WardModel getById(String floor,String room,String ward) throws Exception;

	public List<WardModel> getByAllWithPage(int rows, int page) throws Exception;

	public int getCountByAll() throws Exception;
	
	public int getPageCountByAll(int rows) throws Exception;
	
}
