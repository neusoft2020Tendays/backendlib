package com.hitstu.oa.checkin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hitstu.oa.checkin.model.RoomModel;

@Mapper
public interface IRoomMapper {

	public void insert(RoomModel roomModel) throws Exception;

	public void delete(RoomModel roomModel) throws Exception;

	public void update(RoomModel roomModel) throws Exception;

	public List<RoomModel> selectByAll() throws Exception;

	public RoomModel selectById(String id) throws Exception;

	public List<RoomModel> selectByAllWithPage(int start, int rows) throws Exception;

	public int selectCountByAll() throws Exception;

}
