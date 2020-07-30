package com.hitstu.oa.store.service;

import java.util.List;

import com.hitstu.oa.store.model.ConsumeModel;

public interface IConsumeService {
	public void add(ConsumeModel consumeModel) throws Exception;

	public void delete(ConsumeModel consumeModel) throws Exception;

	public void modify(ConsumeModel consumeModel) throws Exception;

	public List<ConsumeModel> getByAll() throws Exception;

	public ConsumeModel getById(String id, String date) throws Exception;

	public List<ConsumeModel> getByAllWithPage(int rows, int page) throws Exception;

	public int getCountByAll() throws Exception;

	public int getPageCountByAll(int rows) throws Exception;
	
	public ConsumeModel getByIdWithGoods(String id, String date) throws Exception;

	public List<ConsumeModel> getPageWithGoods(int rows, int page) throws Exception;
}
