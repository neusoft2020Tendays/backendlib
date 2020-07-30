package com.hitstu.oa.hr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hitstu.oa.hr.mapper.ISalaryMapper;
import com.hitstu.oa.hr.model.SalaryModel;
import com.hitstu.oa.hr.service.ISalaryService;


@Service("salaryService")
@Transactional
public class SalaryServiceImpl implements ISalaryService{
	@Autowired
	private ISalaryMapper salaryMapper = null;

	public void setGoodsMapper(ISalaryMapper goodsMapper) {
		this.salaryMapper = goodsMapper;
	}
	
	@Override
	public void add(SalaryModel goodsmodel) throws Exception {
		salaryMapper.insert(goodsmodel);
		
	}

	@Override
	public void delete(SalaryModel goodsmodel) throws Exception {
		salaryMapper.delete(goodsmodel);
		
	}

	@Override
	public void modify(SalaryModel goodsmodel) throws Exception {
		salaryMapper.update(goodsmodel);
		
	}

	@Override
	public List<SalaryModel> getByAll() throws Exception {
		return salaryMapper.selectByAll();
	}

	@Override
	public SalaryModel getById(String id) throws Exception {
		return salaryMapper.selectById(id);
	}

	@Override
	public List<SalaryModel> getByAllWithPage(int rows, int page) throws Exception {
		
		return salaryMapper.selectByAllWithPage(rows*(page-1), rows);
	}

	@Override
	public int getCountByAll() throws Exception {
		return salaryMapper.selectCountByAll();
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
