package com.hitstu.oa.checkin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hitstu.oa.checkin.mapper.IGuestMapper;
import com.hitstu.oa.checkin.model.GuestModel;
import com.hitstu.oa.checkin.service.IGuestService;

@Service("GuestService")
@Transactional
public class GuestServiceImpl implements IGuestService {

	@Autowired
	private IGuestMapper guestMapper = null;
	
	@Override
	public void add(GuestModel guestModel) throws Exception {
		guestMapper.insert(guestModel);
	}

	@Override
	public void delete(GuestModel guestModel) throws Exception {
		guestMapper.delete(guestModel);
	}

	@Override
	public void modify(GuestModel guestModel) throws Exception {
		guestMapper.update(guestModel);
	}

	@Override
	public List<GuestModel> getByAll() throws Exception {
		return guestMapper.selectByAll();
	}

	@Override
	public GuestModel getById(String id) throws Exception {
		return guestMapper.selectById(id);
	}

	@Override
	public List<GuestModel> getByAllWithPage(int rows, int page) throws Exception {
		return guestMapper.selectByAllWithPage(rows*(page-1), rows);
	}

	@Override
	public int getCountByAll() throws Exception {
		return guestMapper.selectCountByAll();
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
