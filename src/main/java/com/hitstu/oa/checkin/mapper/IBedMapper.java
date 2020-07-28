package com.hitstu.oa.checkin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hitstu.oa.checkin.model.BedModel;

@Mapper
public interface IBedMapper {
	public void insert(BedModel bedModel) throws Exception;

	public void delete(BedModel bedModel) throws Exception;

	public void update(BedModel bedModel) throws Exception;

	public List<BedModel> selectByAll() throws Exception;

	public BedModel selectById(String id) throws Exception;

	public List<BedModel> selectByAllWithPage(int start, int rows) throws Exception;

	public int selectCountByAll() throws Exception;
	
	public List<BedModel> getFreeBeds() throws Exception;
}
