package com.hitstu.oa.checkin.service;

import java.util.List;

import com.hitstu.oa.checkin.model.RoomModel;

public interface IRoomService {
	
	public void add(RoomModel roomModel) throws Exception;

	public void delete(RoomModel roomModel) throws Exception;

	public void modify(RoomModel roomModel) throws Exception;

	public List<RoomModel> getByAll() throws Exception;

	public RoomModel getById(String id) throws Exception;

	public List<RoomModel> getByAllWithPage(int rows, int page) throws Exception;

	public int getCountByAll() throws Exception;
	
	public int getPageCountByAll(int rows) throws Exception;
	
}
