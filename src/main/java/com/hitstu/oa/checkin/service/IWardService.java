package com.hitstu.oa.checkin.service;

import java.util.List;

import com.hitstu.oa.checkin.model.WardModel;

public interface IWardService {
	
	public void add(WardModel roomModel) throws Exception;

	public void delete(WardModel roomModel) throws Exception;

	public void modify(WardModel roomModel) throws Exception;

	public List<WardModel> getByAll() throws Exception;
	//获取所有楼层号String
	public List<String> getFloorByAll() throws Exception;
	//查某个楼层的所有房间
	public List<WardModel> getByFloor(String floor) throws Exception;
	//查某个房间的所有床位
	public List<WardModel> getByFloorAndRoom(String floor, String room) throws Exception;
	//获取特定床位
	public WardModel getById(String floor,String room,String ward) throws Exception;
	//获取分页列表
	public List<WardModel> getByAllWithPage(int rows, int page) throws Exception;
	//获取全部数据
	public int getCountByAll() throws Exception;
	//获取页数
	public int getPageCountByAll(int rows) throws Exception;
	//获取特定房间床位
	public List<String> getWardByFloorAndRoom(String floor, String room) throws Exception;
	//获取楼层房间String
	public List<String> getRoomByFloor(String floor) throws Exception;
}
