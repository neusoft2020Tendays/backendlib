package com.hitstu.oa.admin.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.hitstu.oa.admin.model.UserModel;

@Mapper
public interface IUserMapper {
	public void update(UserModel um) throws Exception;

        public UserModel selectById(String id) throws Exception;
}
