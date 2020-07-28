package com.hitstu.oa.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hitstu.oa.hr.model.DepartmentModel;

@Mapper
public interface IDepartmentMapper {

	public void insert(DepartmentModel departmentModel) throws Exception;

	public void delete(DepartmentModel departmentModel) throws Exception;

	public void update(DepartmentModel departmentModel) throws Exception;

	public List<DepartmentModel> selectByAll() throws Exception;

	public DepartmentModel selectById(String id) throws Exception;

	public List<DepartmentModel> selectByAllWithPage(int start, int rows) throws Exception;

	public int selectCountByAll() throws Exception;

}
