package com.hitstu.oa.store.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("Consume")
public class ConsumeModel {
	private String consumeid = null;
	private Date date = null;
	private double amount = 0;

	public String getConsumeid() {
		return consumeid;
	}

	public void setConsumeid(String consumeid) {
		this.consumeid = consumeid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
