package com.hitstu.oa.checkin.service;

import java.util.List;

import com.hitstu.oa.checkin.model.BedModel;

public interface IBedService {
	public void add(BedModel bedModel) throws Exception;

	public void delete(BedModel bedModel) throws Exception;

	public void modify(BedModel bedModel) throws Exception;

	public List<BedModel> getByAll() throws Exception;

	public BedModel getById(String id) throws Exception;

	public List<BedModel> getByAllWithPage(int rows, int page) throws Exception;

	public int getCountByAll() throws Exception;
	
	public int getPageCountByAll(int rows) throws Exception;
	
	public List<BedModel> getFreeBeds()throws Exception;
}
