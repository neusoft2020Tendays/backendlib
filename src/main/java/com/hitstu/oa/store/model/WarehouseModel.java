package com.hitstu.oa.store.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("Warehouse")

public class WarehouseModel  implements Serializable{

	/**
	 * 1
	 */
	private static final long serialVersionUID = 1L;
	
	private String warehouseid = null;
	private String empid = null;
	private String address = null;
	public String getWarehouseid() {
		return warehouseid;
	}
	public void setWarehouseid(String warehouseid) {
		this.warehouseid = warehouseid;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
