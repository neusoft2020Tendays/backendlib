package com.hitstu.oa.hr.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("Department")
public class DepartmentModel implements Serializable {

	private String deptid = null;
	private String deptname = null;

	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public String getName() {
		return deptname;
	}

	public void setName(String name) {
		this.deptname = name;
	}

}
