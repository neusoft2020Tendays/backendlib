package com.hitstu.oa.store.service;

import java.util.List;

import com.hitstu.oa.store.model.PurchaseModel;

public interface IPurchaseService {
	public void add(PurchaseModel purchaseModel) throws Exception;

	public void delete(PurchaseModel purchaseModel) throws Exception;

	public void modify(PurchaseModel purchaseModel) throws Exception;

	public List<PurchaseModel> getByAll() throws Exception;

	public PurchaseModel getById(String id) throws Exception;

	public List<PurchaseModel> getByAllWithPage(int rows, int page) throws Exception;

	public int getCountByAll() throws Exception;

	public int getPageCountByAll(int rows) throws Exception;
}
