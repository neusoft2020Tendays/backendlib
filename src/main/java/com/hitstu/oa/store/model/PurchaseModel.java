package com.hitstu.oa.store.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("Purchase")
public class PurchaseModel implements Serializable {
	private String goodsid = null;
	private Date date = null;
	private double puramount = 0;

	public String getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getAmount() {
		return puramount;
	}

	public void setAmount(double amount) {
		this.puramount = amount;
	}

}
