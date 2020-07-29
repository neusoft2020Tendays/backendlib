package com.hitstu.oa.test;

import com.hitstu.oa.hr.model.DepartmentModel;
import com.hitstu.oa.hr.model.EmployeeModel;


public class Test {
	private static EmployeeModel getEmployeeModel(String id, String deptid, String name, String sex, int age, String fired, String leave) {
		EmployeeModel employeeModel = new EmployeeModel();
		DepartmentModel departmentModel = new DepartmentModel();
		departmentModel.setDeptid(deptid);
		
		employeeModel.setId(id);
		employeeModel.setDepartment(departmentModel);
		employeeModel.setName(name);
		employeeModel.setSex(sex);
		employeeModel.setAge(age);
		employeeModel.setFired(fired);
		employeeModel.setLeave(leave);
		
		return employeeModel;
	}
	
	public static void main(String[] args) {
		/* 已弃用 */
//		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigForSM.class);
//		IEmployeeService employeeService = context.getBean(IEmployeeService.class);
//		try {
//			System.out.println(employeeService.getById("1705004").getName());
//			EmployeeModel employeeModel = getEmployeeModel(
//					"1705004", "D05", "孙悟空", "男", 27, "否", "否");
//			employeeService.modify(employeeModel);
//			System.out.println(employeeService.getById("1705004").getName());
//			employeeService.delete(employeeModel);
//			System.out.println(employeeService.getByAll().size());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
