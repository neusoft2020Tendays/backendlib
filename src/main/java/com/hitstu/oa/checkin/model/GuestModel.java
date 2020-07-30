package com.hitstu.oa.checkin.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

//Guest的Model类
@Alias("Guest")
public class GuestModel implements Serializable {
	
	private String guestId = null;
	private int num = 0;
	private String identity = null;
	
	private ElderlyModel elderly=null;

	public String getGuestId() {
		return guestId;
	}

	public void setGuestId(String guestId) {
		this.guestId = guestId;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public ElderlyModel getElderly() {
		return elderly;
	}

	public void setElderly(ElderlyModel elderly) {
		this.elderly = elderly;
	}

}
