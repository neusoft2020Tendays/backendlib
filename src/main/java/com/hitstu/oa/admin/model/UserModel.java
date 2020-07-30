package com.hitstu.oa.admin.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("User")
public class UserModel implements Serializable {
	private String id = null;
        private String name = null;
        private String password = null;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
        
}
