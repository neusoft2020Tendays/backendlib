package com.hitstu.oa.checkin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hitstu.oa.checkin.mapper.IWardMapper;
import com.hitstu.oa.checkin.model.WardModel;
import com.hitstu.oa.checkin.service.IWardService;

@Service("WardService")
@Transactional
public class WardServiceImpl implements IWardService {
	
	@Autowired
	private IWardMapper wardMapper = null;
	
	@Override
	public void add(WardModel wardModel) throws Exception {
		wardMapper.insert(wardModel);
	}

	@Override
	public void delete(WardModel wardModel) throws Exception {
		wardMapper.delete(wardModel);
	}

	@Override
	public void modify(WardModel wardModel) throws Exception {
		wardMapper.update(wardModel);
	}

	@Override
	public List<WardModel> getByAll() throws Exception {
		return wardMapper.selectByAll();
	}

	@Override
	public WardModel getById(String floor,String room,String ward) throws Exception {
		return wardMapper.selectWardByFloorAndRoomAndWard(floor, room, ward);
	}

	@Override
	public List<WardModel> getByAllWithPage(int rows, int page) throws Exception {
		return wardMapper.selectByAllWithPage(rows*(page-1), rows);
	}

	@Override
	public int getCountByAll() throws Exception {
		return wardMapper.selectCountByAll();
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
	public List<String> getFloorByAll() throws Exception {
		return wardMapper.selectFloorByAll();
	}

	@Override
	public List<String> getRoomByFloor(String floor) throws Exception {
		return wardMapper.selectRoomByFloor(floor);
	}

	@Override
	public List<String> getWardByFloorAndRoom(String floor, String room) throws Exception {
		return wardMapper.selectWardByFloorAndRoom(floor,room);
	}

}
