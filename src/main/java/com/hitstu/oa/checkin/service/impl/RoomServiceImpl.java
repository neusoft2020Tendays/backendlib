package com.hitstu.oa.checkin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hitstu.oa.checkin.mapper.IRoomMapper;
import com.hitstu.oa.checkin.model.RoomModel;
import com.hitstu.oa.checkin.service.IRoomService;

@Service("roomService")
@Transactional
public class RoomServiceImpl implements IRoomService {
	
	@Autowired
	private IRoomMapper roomMapper = null;
	
	@Override
	public void add(RoomModel roomModel) throws Exception {
		roomMapper.insert(roomModel);
	}

	@Override
	public void delete(RoomModel roomModel) throws Exception {
		roomMapper.delete(roomModel);
	}

	@Override
	public void modify(RoomModel roomModel) throws Exception {
		roomMapper.update(roomModel);
	}

	@Override
	public List<RoomModel> getByAll() throws Exception {
		return roomMapper.selectByAll();
	}

	@Override
	public RoomModel getById(String id) throws Exception {
		return roomMapper.selectById(id);
	}

	@Override
	public List<RoomModel> getByAllWithPage(int rows, int page) throws Exception {
		return roomMapper.selectByAllWithPage(rows*(page-1), rows);
	}

	@Override
	public int getCountByAll() throws Exception {
		return roomMapper.selectCountByAll();
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
