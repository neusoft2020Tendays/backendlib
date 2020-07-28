package com.hitstu.oa.hr.model;

import org.apache.ibatis.type.Alias;

@Alias("Employee")
public class EmployeeModel {
	private String id = null;
	private String name = null;
	private String sex = null;
	private int age = 0;
	private String fired = null;
	private String leave = null;
	private DepartmentModel department = null;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getFired() {
		return fired;
	}
	public void setFired(String fired) {
		this.fired = fired;
	}
	public String getLeave() {
		return leave;
	}
	public void setLeave(String leave) {
		this.leave = leave;
	}
	public DepartmentModel getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentModel department) {
		this.department = department;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
