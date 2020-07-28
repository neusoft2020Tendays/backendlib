package com.hitstu.oa.hr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hitstu.oa.hr.mapper.IDepartmentMapper;
import com.hitstu.oa.hr.model.DepartmentModel;
import com.hitstu.oa.hr.service.IDepartmentService;

@Service("departmentService")
@Transactional
public class DepartmentServiceImpl implements IDepartmentService {

	@Autowired
	private IDepartmentMapper departmentMapper = null;

	public void setDepartmentMapper(IDepartmentMapper departmentMapper) {
		this.departmentMapper = departmentMapper;
	}

	@Override
	public void add(DepartmentModel departmentModel) throws Exception {
		this.departmentMapper.insert(departmentModel);
	}

	@Override
	public void delete(DepartmentModel departmentModel) throws Exception {
		this.departmentMapper.delete(departmentModel);
	}

	@Override
	public void modify(DepartmentModel departmentModel) throws Exception {
		this.departmentMapper.update(departmentModel);
	}

	@Override
	public List<DepartmentModel> getByAll() throws Exception {
		return this.departmentMapper.selectByAll();
	}

	@Override
	public DepartmentModel getById(String id) throws Exception {
		return this.departmentMapper.selectById(id);
	}

	@Override
	public List<DepartmentModel> getByAllWithPage(int rows, int page) throws Exception {
		return this.departmentMapper.selectByAllWithPage(rows * (page - 1), rows);
	}

	@Override
	public int getCountByAll() throws Exception {
		return this.departmentMapper.selectCountByAll();
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
