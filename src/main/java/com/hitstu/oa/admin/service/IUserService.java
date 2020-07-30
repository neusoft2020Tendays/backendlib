package com.hitstu.oa.admin.service;

import com.hitstu.oa.admin.model.UserModel;

public interface IUserService {
	public void addUser(UserModel userModel) throws Exception;
	
        public boolean validate(String id, String password) throws Exception;

        public UserModel getById(String id) throws Exception;
        
        // 修改密码的方法
        public void changePassword(String id, String password) throws Exception;

}
