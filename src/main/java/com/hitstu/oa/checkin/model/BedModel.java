package com.hitstu.oa.checkin.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

// 床位模型类
@Alias("Bed")
public class BedModel implements Serializable {
	private String id = null;
	private String roomId = null;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	
}
