package com.hitstu.oa.checkin.service;

import java.util.List;

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
	

}
