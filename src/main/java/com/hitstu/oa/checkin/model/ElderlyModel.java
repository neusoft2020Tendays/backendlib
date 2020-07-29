package com.hitstu.oa.checkin.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("Elderly")
public class ElderlyModel implements Serializable {
	private String elderlyid = null;
	private String eldername = null;
	private String eldersex = null;
	private int elderage = 0;
	private String floor = null;
	private String room = null;
	private String bed = null;

	public String getElderlyid() {
		return elderlyid;
	}

	public void setElderlyid(String elderlyid) {
		this.elderlyid = elderlyid;
	}

	public String getEldername() {
		return eldername;
	}

	public void setEldername(String eldername) {
		this.eldername = eldername;
	}

	public String getEldersex() {
		return eldersex;
	}

	public void setEldersex(String eldersex) {
		this.eldersex = eldersex;
	}

	public int getElderage() {
		return elderage;
	}

	public void setElderage(int elderage) {
		this.elderage = elderage;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getBed() {
		return bed;
	}

	public void setBed(String bed) {
		this.bed = bed;
	}

}
