package com.hitstu.oa.store.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;

@Alias("Purchase")
public class PurchaseModel implements Serializable {
	private String goodsid = null;
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="UTC")
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

	public double getPuramount() {
		return puramount;
	}

	public void setPuramount(double puramount) {
		this.puramount = puramount;
	}


}
