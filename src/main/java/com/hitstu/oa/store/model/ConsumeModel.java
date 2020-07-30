package com.hitstu.oa.store.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;

@Alias("Consume")
public class ConsumeModel {
	private String id = null;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="UTC")
	private Date date = null;
	private double amount = 0;
	private GoodsModel goods= null;
	
	public GoodsModel getGoods() {
		return goods;
	}
	public void setGoods(GoodsModel goods) {
		this.goods = goods;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
