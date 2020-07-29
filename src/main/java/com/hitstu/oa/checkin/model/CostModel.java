package com.hitstu.oa.checkin.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;

@Alias("Cost")
public class CostModel implements Serializable {
	
	private String costId=null;
	private double costAmount=0;
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date time = null;
	
	private ElderlyModel elderly = null;

	public String getCostId() {
		return costId;
	}

	public void setCostId(String costId) {
		this.costId = costId;
	}

	public double getCostAmount() {
		return costAmount;
	}

	public void setCostAmount(double costAmount) {
		this.costAmount = costAmount;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public ElderlyModel getElderly() {
		return elderly;
	}

	public void setElderly(ElderlyModel elderly) {
		this.elderly = elderly;
	}
	
}
