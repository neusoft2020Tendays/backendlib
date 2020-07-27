package com.hitstu.oa.checkin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hitstu.oa.checkin.mapper.IBedMapper;
import com.hitstu.oa.checkin.model.BedModel;
import com.hitstu.oa.checkin.service.IBedService;

@Service("elderlyService")
@Transactional
public class BedServiceImpl implements IBedService {
	@Autowired
	private IBedMapper bedMapper = null;
	
	@Override
	public void add(BedModel bedModel) throws Exception {
		bedMapper.insert(bedModel);
	}

	@Override
	public void delete(BedModel bedModel) throws Exception {
		bedMapper.delete(bedModel);
	}

	@Override
	public void modify(BedModel bedModel) throws Exception {
		bedMapper.update(bedModel);
	}

	@Override
	public List<BedModel> getByAll() throws Exception {
		return bedMapper.selectByAll();
	}

	@Override
	public BedModel getById(String id) throws Exception {
		return bedMapper.selectById(id);
	}

	@Override
	public List<BedModel> getByAllWithPage(int rows, int page) throws Exception {
		return bedMapper.selectByAllWithPage(rows*(page - 1), rows);
	}

	@Override
	public int getCountByAll() throws Exception {
		return bedMapper.selectCountByAll();
	}

	@Override
	public int getPageCountByAll(int rows) throws Exception {
		if (rows <= 0) {
                        throw new Exception();
                }
		int count = getCountByAll();
		int pages = count / rows;
		int ys = count - pages*rows;
		if (ys != 0) {
			pages += 1;
		}
		return pages;
	}

}
