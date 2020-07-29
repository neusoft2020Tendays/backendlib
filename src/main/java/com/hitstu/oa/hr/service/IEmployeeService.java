package com.hitstu.oa.hr.service;

import java.util.List;

import com.hitstu.oa.hr.model.EmployeeModel;

public interface IEmployeeService {
	// 增加员工
	public void add(EmployeeModel em) throws Exception;

	// 修改员工
	public void modify(EmployeeModel em) throws Exception;

	// 刪除员工
	public void delete(EmployeeModel em) throws Exception;

	// 取得指定员工对象，无部门
	public EmployeeModel getById(String id) throws Exception;

	// 取得全部员工对象，无部门
	public List<EmployeeModel> getByAll() throws Exception;

	// 取得全部员工，无部门，分页
	public List<EmployeeModel> getByAllWithPage(int rows, int page)
			throws Exception;

	// 取得全部员工数目
	public int getCountByAll() throws Exception;
	
	// 根据行数确定总页数
	public int getPageCountByAll(int rows) throws Exception;
	
	// 根据部门获取员工数目
	public int getCountByDepartment(String deptid) throws Exception;

	// 取得指定员工对象，带部门
	public EmployeeModel getByIdWithDepartment(String id) throws Exception;

	// 取得全部员工对象，带部门
	public List<EmployeeModel> getByAllWithDepartment() throws Exception;

	// 取得所有员工列表，取关联的部门，分页模式
	public List<EmployeeModel> getByAllWithDepartmentWithPage(int rows, int page)
			throws Exception;

// ---------------------------------------------------------------------------------------------------------------------------------------------
// ---------------------------------------------动态SQL练习--------------------------------------------------------------------------------------------------------------
// ---------------------------------------------------------------------------------------------------------------------------------------------
// 按综合条件检索员工列表，分页模式，只取关联的部门属性对象
	public List<EmployeeModel> getListByConditionWithDepartmentWithPage(int rows, int page,  int lowAge, int highAge,
			String sex, String nameKey) throws Exception;

	// 按综合条件检索员工个数
	public int getCountByCondition(int rows, int page,  int lowAge,  int highAge, String sex, String nameKey) throws Exception;
}
