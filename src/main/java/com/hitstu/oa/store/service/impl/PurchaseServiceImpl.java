package com.hitstu.oa.store.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hitstu.oa.store.mapper.IPurchaseMapper;
import com.hitstu.oa.store.model.PurchaseModel;
import com.hitstu.oa.store.service.IPurchaseService;

@Service("purchaseService")
@Transactional
public class PurchaseServiceImpl implements IPurchaseService {

	@Autowired
	private IPurchaseMapper purchaseMapper = null;

	public void setPurchaseMapper(IPurchaseMapper purchaseMapper) {
		this.purchaseMapper = purchaseMapper;
	}

	@Override
	public void add(PurchaseModel purchaseModel) throws Exception {
		purchaseMapper.insert(purchaseModel);
	}

	@Override
	public void delete(PurchaseModel purchaseModel) throws Exception {
		purchaseMapper.delete(purchaseModel);
	}

	@Override
	public void modify(PurchaseModel purchaseModel) throws Exception {
		purchaseMapper.update(purchaseModel);
	}

	@Override
	public List<PurchaseModel> getByAll() throws Exception {
		return purchaseMapper.selectByAll();
	}
	
	@Override
	public PurchaseModel getByIdAndDate(String id, Date date) throws Exception {
		return purchaseMapper.selectByIdAndDate(id, date);
	}

	@Override
	public List<PurchaseModel> getByAllWithPage(int rows, int page) throws Exception {
		return purchaseMapper.selectByAllWithPage(rows * (page - 1), rows);
	}

	@Override
	public int getCountByAll() throws Exception {
		return purchaseMapper.selectCountByAll();
	}

	@Override
	public int getPageCountByAll(int rows) throws Exception {
		int count = this.getCountByAll();
		int pageCount = 0;
		if (count % rows == 0) {
			pageCount = count / rows;
		} else {
			pageCount = count / rows + 1;
		}
		return pageCount;
	}

	

}
