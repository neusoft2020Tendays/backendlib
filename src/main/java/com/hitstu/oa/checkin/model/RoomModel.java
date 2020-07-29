package com.hitstu.oa.checkin.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

//房间的Model类
@Alias("Room")
public class RoomModel implements Serializable {
	
	private String roomId=null;
	private int floor = 0;
	private int bedNum = 0;
	
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public int getBedNum() {
		return bedNum;
	}
	public void setBedNum(int bedNum) {
		this.bedNum = bedNum;
	}
	
}
