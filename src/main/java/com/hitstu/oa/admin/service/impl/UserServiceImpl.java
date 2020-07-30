package com.hitstu.oa.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hitstu.oa.admin.mapper.IUserMapper;
import com.hitstu.oa.admin.model.UserModel;
import com.hitstu.oa.admin.service.IUserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserMapper userMapper = null;
	@Override
	public boolean validate(String id, String password) throws Exception {
		UserModel uModel = userMapper.selectById(id);
		if (uModel == null) {
                        return false;
                } else if (uModel.getPassword().equals(password)) {
                        return true;
                } else {
                        return false;
                }
	}

	@Override
	public UserModel getById(String id) throws Exception {
		return userMapper.selectById(id);
	}

	@Override
	public void changePassword(String id, String password) throws Exception {
		UserModel uModel = userMapper.selectById(id);
		if (uModel != null) {
                        uModel.setPassword(password);
                        userMapper.update(uModel);
                }
	}

}
