package com.hitstu.oa.checkin.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("Elderly")
public class ElderlyModel implements Serializable {
	private String elderlyId = null;
	private String sex = null;
	private int age = 0;
	

	public String getElderlyId() {
		return elderlyId;
	}

	public void setElderlyId(String elderlyId) {
		this.elderlyId = elderlyId;
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

}
