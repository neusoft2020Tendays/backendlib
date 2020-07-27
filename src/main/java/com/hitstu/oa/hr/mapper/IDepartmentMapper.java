package com.hitstu.oa.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hitstu.oa.hr.model.DepartmentModel;

@Mapper
public interface IDepartmentMapper {

	public void insert() throws Exception;

	public void delete() throws Exception;

	public void update() throws Exception;

	public List<DepartmentModel> selectByAll() throws Exception;

	public DepartmentModel selectById() throws Exception;

	public List<DepartmentModel> selectByAllWithPage() throws Exception;

	public int selectCountByAll() throws Exception;

}
