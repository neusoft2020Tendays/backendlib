package com.hitstu.oa.store.service;

import java.util.List;


import com.hitstu.oa.store.model.GoodsModel;


public interface IGoodsService {
	public void add(GoodsModel goodsmodel) throws Exception;

	public void delete(GoodsModel goodsmodel) throws Exception;

	public void modify(GoodsModel goodsmodel) throws Exception;

	public List<GoodsModel> getByAll() throws Exception;

	public GoodsModel getById(String id) throws Exception;

	public List<GoodsModel> getByAllWithPage(int rows, int page) throws Exception;

	public int getCountByAll() throws Exception;

	public int getPageCountByAll(int rows) throws Exception;
}
