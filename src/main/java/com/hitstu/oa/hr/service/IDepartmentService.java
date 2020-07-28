package com.hitstu.oa.hr.service;

import java.util.List;

import com.hitstu.oa.hr.model.DepartmentModel;

public interface IDepartmentService {
	public void add(DepartmentModel departmentModel) throws Exception;

	public void delete(DepartmentModel departmentModel) throws Exception;

	public void modify(DepartmentModel departmentModel) throws Exception;

	public List<DepartmentModel> getByAll() throws Exception;

	public DepartmentModel getById(String id) throws Exception;

	public List<DepartmentModel> getByAllWithPage(int rows, int page) throws Exception;

	public int getCountByAll() throws Exception;

	public int getPageCountByAll(int rows) throws Exception;
}
