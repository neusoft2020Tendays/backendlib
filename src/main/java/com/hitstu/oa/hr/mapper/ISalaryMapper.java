package com.hitstu.oa.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hitstu.oa.hr.model.SalaryModel;

@Mapper
public interface ISalaryMapper {
	public void insert(SalaryModel salaryModel) throws Exception;

	public void delete(SalaryModel salaryModel) throws Exception;

	public void update(SalaryModel salaryModel) throws Exception;

	public List<SalaryModel> selectByAll() throws Exception;

	public SalaryModel selectById(String id) throws Exception;

	public List<SalaryModel> selectByAllWithPage(@Param("start")int start, @Param("rows")int rows) throws Exception;

	public int selectCountByAll() throws Exception;
}
