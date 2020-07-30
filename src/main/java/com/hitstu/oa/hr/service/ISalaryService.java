package com.hitstu.oa.hr.service;

import java.util.List;

import com.hitstu.oa.hr.model.SalaryModel;

public interface ISalaryService {
	public void add(SalaryModel salaryModel) throws Exception;

	public void delete(SalaryModel salaryModel) throws Exception;

	public void modify(SalaryModel salaryModel) throws Exception;

	public List<SalaryModel> getByAll() throws Exception;

	public SalaryModel getById(String id) throws Exception;

	public List<SalaryModel> getByAllWithPage(int rows, int page) throws Exception;

	public int getCountByAll() throws Exception;

	public int getPageCountByAll(int rows) throws Exception;
}
