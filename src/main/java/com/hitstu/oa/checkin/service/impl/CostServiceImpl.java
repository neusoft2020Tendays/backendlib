package com.hitstu.oa.checkin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hitstu.oa.checkin.mapper.ICostMapper;
import com.hitstu.oa.checkin.model.CostModel;
import com.hitstu.oa.checkin.service.ICostService;

@Service
public class CostServiceImpl implements ICostService {

	@Autowired
	private ICostMapper costMapper = null;
	
	@Override
	public void add(CostModel costModel) throws Exception {
		costMapper.insert(costModel);
	}

	@Override
	public void delete(CostModel costModel) throws Exception {
		costMapper.delete(costModel);
	}

	@Override
	public void modify(CostModel costModel) throws Exception {
		costMapper.update(costModel);
	}

	@Override
	public List<CostModel> getByAll() throws Exception {
		return costMapper.selectByAll();
	}

	@Override
	public CostModel getById(String id) throws Exception {
		return costMapper.selectById(id);
	}

	@Override
	public List<CostModel> getByElderlyIdWithPage(String id, int rows, int page) throws Exception {
		return costMapper.selectByElderlyWithPage(id, rows*(page-1), rows);
	}

	@Override
	public int getCountByElderlyId(String id) throws Exception {
		return costMapper.selectCountByElderly(id);
	}

	@Override
	public int getPageCountByElderlyId(String id,int rows) throws Exception {
		int count = this.getCountByElderlyId(id);
		int pageCount = 0;
		if (count % rows == 0) {
			pageCount = count / rows;
		} else {
			pageCount = count / rows + 1;
		}
		return pageCount;
	}
	
}
