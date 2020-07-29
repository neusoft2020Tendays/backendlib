package com.hitstu.oa.hr.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hitstu.oa.hr.model.DepartmentModel;
import com.hitstu.oa.hr.model.EmployeeModel;

@Mapper
public interface IEmployeeMapper {
	// 增加员工
	public void insert(EmployeeModel em) throws Exception;

	// 修改员工
	public void update(EmployeeModel em) throws Exception;

	// 刪除员工
	public void delete(EmployeeModel em) throws Exception;
	
	// 取得指定员工对象，无部门
	public EmployeeModel selectById(String id) throws Exception;
	
	// 取得全部员工对象，无部门
	public List<EmployeeModel> selectByAll() throws Exception;
	
	// 取得全部员工，无部门，分页
	public List<EmployeeModel> selectByAllWithPage(@Param("start") int start, @Param("rows") int rows)
			throws Exception;
	
	// 取得全部员工数目
	public int selectCountByAll() throws Exception;
	
	// 取得特定部门的员工数目
	public int selectCountByDepartment(String deptid) throws Exception;
		
	// 取得指定员工对象，带部门
	public EmployeeModel selectByIdWithDepartment(String id) throws Exception;
	
	// 取得全部员工对象，带部门
	public List<EmployeeModel> selectByAllWithDepartment() throws Exception;
	
	// 取得所有员工列表，取关联的部门，分页模式
	public List<EmployeeModel> selectByAllWithDepartmentWithPage(@Param("start") int start, @Param("rows") int rows)
			throws Exception;

//---------------------------------------------------------------------------------------------------------------------------------------------
//---------------------------------------------动态SQL练习--------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------------------------------------
	// 按综合条件检索员工列表，分页模式，取关联的部门属性对象
	public List<EmployeeModel> selectListByConditionWithDepartmentWithPage(@Param("start") int start,
			@Param("rows") int rows, @Param("lowAge") int lowAge, @Param("highAge") int highAge,
			@Param("sex") String sex, @Param("nameKey") String nameKey) throws Exception;

	// 按综合条件检索员工个数
	public int selectCountByCondition(@Param("start") int start, @Param("rows") int rows,
			@Param("lowAge") int lowAge, @Param("highAge") int highAge,
			@Param("sex") String sex, @Param("nameKey") String nameKey) throws Exception;
}
