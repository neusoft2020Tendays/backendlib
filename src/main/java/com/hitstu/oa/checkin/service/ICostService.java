package com.hitstu.oa.checkin.service;

import java.util.List;

import com.hitstu.oa.checkin.model.CostModel;

public interface ICostService {
	
	public void add(CostModel costModel) throws Exception;

	public void delete(CostModel costModel) throws Exception;

	public void modify(CostModel costModel) throws Exception;

	public List<CostModel> getByAll() throws Exception;
	
	public CostModel getById(String id) throws Exception;

	public List<CostModel> getByElderlyIdWithPage(String id, int rows, int page) throws Exception;

	public int getCountByElderlyId(String id) throws Exception;
	
	public int getPageCountByElderlyId(String id,int rows) throws Exception;

}
