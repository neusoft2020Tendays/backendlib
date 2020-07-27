package com.hitstu.oa.checkin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hitstu.oa.checkin.mapper.IElderlyMapper;
import com.hitstu.oa.checkin.model.ElderlyModel;
import com.hitstu.oa.checkin.service.IElderlyService;

@Service("elderlyService")
@Transactional
public class ElderlyServiceImpl implements IElderlyService {

	@Autowired
	private IElderlyMapper elderlyMapper = null;
	
	public void setElderlyMapper(IElderlyMapper elderlyMapper) {
		this.elderlyMapper = elderlyMapper;
	}

	@Override
	public void add(ElderlyModel elderlyModel) throws Exception {
		elderlyMapper.insert(elderlyModel);
	}

	@Override
	public void delete(ElderlyModel elderlyModel) throws Exception {
		elderlyMapper.delete(elderlyModel);
	}

	@Override
	public void modify(ElderlyModel elderlyModel) throws Exception {
		elderlyMapper.update(elderlyModel);
	}

	@Override
	public List<ElderlyModel> getByAll() throws Exception {
		return elderlyMapper.selectByAll();
	}

	@Override
	public ElderlyModel getById(String id) throws Exception {
		return elderlyMapper.selectById(id);
	}

	@Override
	public List<ElderlyModel> getByAllWithPage(int rows, int page) throws Exception {
		return elderlyMapper.selectByAllWithPage(rows * (page - 1), rows);
	}

	@Override
	public int getCountByAll() throws Exception {
		return elderlyMapper.selectCountByAll();
	}

}
