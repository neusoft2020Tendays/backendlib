package com.hitstu.oa.checkin.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

//房间的Model类
@Alias("Ward")
public class WardModel implements Serializable {
	
	private String floor = null;
	private String room = null;
	private String bed = null;
	
	private ElderlyModel elderly = null;

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

	public ElderlyModel getElderly() {
		return elderly;
	}

	public void setElderlyModel(ElderlyModel elderModel) {
		this.elderly = elderModel;
	}
	
}
