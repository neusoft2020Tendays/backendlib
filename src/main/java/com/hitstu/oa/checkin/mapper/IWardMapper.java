package com.hitstu.oa.checkin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hitstu.oa.checkin.model.WardModel;

@Mapper
public interface IWardMapper {

	public void insert(WardModel wardModel) throws Exception;
	
	public void delete(WardModel wardModel) throws Exception;

	public void update(WardModel wardModel) throws Exception;
	
	
	public List<WardModel> selectByAll() throws Exception;
	//查所有的楼层
	public List<String> selectFloorByAll() throws Exception;
	//通过楼层查所有的房间
	public List<String> selectRoomByFloor(String floor) throws Exception;
	//通过楼层和房间号查所有的床位
	public List<String> selectWardByFloorAndRoom(String floor, String room) throws Exception;

	public WardModel selectWardByFloorAndRoomAndWard(String floor, String room, String bed) throws Exception;

	public List<WardModel> selectByAllWithPage(int start, int rows) throws Exception;

	public int selectCountByAll() throws Exception;
	
	//通过楼层查所有的房间
	public List<WardModel> selectByFloor(String floor) throws Exception;
	//通过楼层和房间号查所有的床位
	public List<WardModel> selectByFloorAndRoom(String floor, String room) throws Exception;

}
