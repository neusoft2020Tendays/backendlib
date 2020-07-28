package com.hitstu.oa.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hitstu.oa.store.model.PurchaseModel;

@Mapper
public interface IPurchaseMapper {
	
	public void insert(PurchaseModel purchaseModel) throws Exception;

	public void delete(PurchaseModel purchaseModel) throws Exception;

	public void update(PurchaseModel purchaseModel) throws Exception;

	public List<PurchaseModel> selectByAll() throws Exception;

	public PurchaseModel selectById(String id) throws Exception;

	public List<PurchaseModel> selectByAllWithPage(int start, int rows) throws Exception;

	public int selectCountByAll() throws Exception;

}
