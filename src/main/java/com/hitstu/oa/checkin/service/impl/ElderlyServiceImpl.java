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

	@Override
	public List<ElderlyModel> getListByConditionWithPage(int rows, int page, int minAge, int maxAge, String floor,
			String room, String nameKey) throws Exception {

		if (nameKey != null && nameKey.trim().length() > 0) {
			nameKey = "%" + nameKey + "%";
		}
		return elderlyMapper.selectListByConditionWithPage(rows * (page - 1), rows, minAge, maxAge, floor, room,
				nameKey);
	}

}
