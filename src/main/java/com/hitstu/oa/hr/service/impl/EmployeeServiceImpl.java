package com.hitstu.oa.hr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hitstu.oa.hr.mapper.IEmployeeMapper;
import com.hitstu.oa.hr.model.EmployeeModel;
import com.hitstu.oa.hr.service.IEmployeeService;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private IEmployeeMapper employeeMapper = null;
	
	@Override
	public void add(EmployeeModel em) throws Exception {
		employeeMapper.insert(em);
	}

	@Override
	public void modify(EmployeeModel em) throws Exception {
		employeeMapper.update(em);
	}

	@Override
	public void delete(EmployeeModel em) throws Exception {
		employeeMapper.delete(em);
	}

	@Override
	public EmployeeModel getById(String id) throws Exception {
		return employeeMapper.selectById(id);
	}

	@Override
	public List<EmployeeModel> getByAll() throws Exception {
		return employeeMapper.selectByAll();
	}

	@Override
	public List<EmployeeModel> getByAllWithPage(int rows, int page) throws Exception {
		return employeeMapper.selectByAllWithPage(rows*(page-1), rows);
	}

	@Override
	public int getCountByAll() throws Exception {
		return employeeMapper.selectCountByAll();
	}

	@Override
	public int getPageCountByAll(int rows) throws Exception {
		int count = getCountByAll();
		int page = count / rows;
		int ys = count - page*rows;
		if(ys != 0) {
			page += 1;
		}
		return page;
	}

	@Override
	public EmployeeModel getByIdWithDepartment(String id) throws Exception {
		return employeeMapper.selectByIdWithDepartment(id);
	}

	@Override
	public List<EmployeeModel> getByAllWithDepartment() throws Exception {
		return employeeMapper.selectByAllWithDepartment();
	}

	@Override
	public List<EmployeeModel> getByAllWithDepartmentWithPage(int rows, int page) throws Exception {
		return employeeMapper.selectByAllWithDepartmentWithPage(rows*(page - 1), rows);
	}
	
	private String getSex(String sex) {
        	if (sex != null && sex.trim().length() == 0) {
                        return null;
                }
        	return sex;
	}
	
        private String getNameKey(String nameKey) {
        	if (nameKey != null && nameKey.trim() .length() >0) {
                        nameKey = "%"+nameKey+"%";
                }
        	return nameKey;
	}

	@Override
	public List<EmployeeModel> getListByConditionWithDepartmentWithPage(int rows, int page, int lowAge, int highAge,
			String sex, String nameKey, String leave, String fired, String deptid) throws Exception {
		sex = getSex(sex);
		nameKey = getNameKey(nameKey);
		if (leave != null) {
			leave = leave.trim();
		}
		if (fired != null) {
			fired = fired.trim();
		}
		if (deptid != null) {
			deptid = deptid.trim();
		}
		return employeeMapper.selectListByConditionWithDepartmentWithPage(rows*(page-1), rows,  lowAge, highAge, sex, nameKey, leave, fired, deptid);
	}

	@Override
	public int getCountByCondition(int lowAge, int highAge, String sex, String nameKey, String leave, String fired, String deptid)
			throws Exception {
		sex = getSex(sex);
		nameKey = getNameKey(nameKey);
		if (leave != null) {
			leave = leave.trim();
		}
		if (fired != null) {
			fired = fired.trim();
		}
		if (deptid != null) {
			deptid = deptid.trim();
		}
		return employeeMapper.selectCountByCondition(lowAge, highAge, sex, nameKey, leave, fired, deptid);
	}
	
	@Override
	public int getPageCountByCondition(int rows, int lowAge, int highAge, String sex, String nameKey,
			String leave, String fired, String deptid) throws Exception {
		int count = getCountByCondition(lowAge, highAge, sex, nameKey, leave, fired, deptid);
		int page = count / rows;
		int ys = count - page*rows;
		if(ys != 0) {
			page += 1;
		}
		return page;
	}

	@Override
	public int getCountByDepartment(String deptid) throws Exception {
		return employeeMapper.selectCountByDepartment(deptid);
	}
}
