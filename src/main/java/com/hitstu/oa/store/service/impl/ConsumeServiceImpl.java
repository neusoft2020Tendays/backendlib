package com.hitstu.oa.store.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hitstu.oa.store.mapper.IConsumeMapper;
import com.hitstu.oa.store.model.ConsumeModel;
import com.hitstu.oa.store.service.IConsumeService;

@Service("consumeService")
@Transactional
public class ConsumeServiceImpl implements IConsumeService {

	@Autowired
	private IConsumeMapper consumeMapper = null;

	public void setConsumeMapper(IConsumeMapper consumeMapper) {
		this.consumeMapper = consumeMapper;
	}

	@Override
	public void add(ConsumeModel consumeModel) throws Exception {
		consumeMapper.insert(consumeModel);
	}

	@Override
	public void delete(ConsumeModel consumeModel) throws Exception {
		consumeMapper.delete(consumeModel);
	}

	@Override
	public void modify(ConsumeModel consumeModel) throws Exception {
		consumeMapper.update(consumeModel);
	}

	@Override
	public List<ConsumeModel> getByAll() throws Exception {
		return consumeMapper.selectByAll();
	}

	@Override
	public ConsumeModel getById(String id, String date) throws Exception {
		return consumeMapper.selectById(id, date);
	}

	@Override
	public List<ConsumeModel> getByAllWithPage(int rows, int page) throws Exception {
		return consumeMapper.selectByAllWithPage(rows * (page - 1), rows);
	}

	@Override
	public int getCountByAll() throws Exception {
		return consumeMapper.selectCountByAll();
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
