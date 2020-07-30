package com.hitstu.oa.hr.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;


@Alias("Salary")
public class SalaryModel {
	private String salaryId = null;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="UTC")
	private Date time = null;
	private double salAccount = 0;
	private String empid = null;
	public String getSalaryId() {
		return salaryId;
	}
	public void setSalaryId(String salaryId) {
		this.salaryId = salaryId;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public double getSalAccount() {
		return salAccount;
	}
	public void setSalAccount(double salAccount) {
		this.salAccount = salAccount;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	
	
}
