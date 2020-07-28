package com.hitstu.oa.checkin.service;

import java.util.List;

import com.hitstu.oa.checkin.model.ElderlyModel;

public interface IElderlyService {
	public void add(ElderlyModel elderlyModel) throws Exception;

	public void delete(ElderlyModel elderlyModel) throws Exception;

	public void modify(ElderlyModel elderlyModel) throws Exception;

	public List<ElderlyModel> getByAll() throws Exception;

	public ElderlyModel getById(String id) throws Exception;

	public List<ElderlyModel> getByAllWithPage(int rows, int page) throws Exception;

	public int getCountByAll() throws Exception;

	public int getPageCountByAll(int rows) throws Exception;

}
