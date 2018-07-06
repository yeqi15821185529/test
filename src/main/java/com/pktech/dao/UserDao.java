package com.pktech.dao;

import org.apache.ibatis.annotations.Mapper;

import com.pktech.entity.User;

@Mapper
public interface UserDao {
	public User findUserByPhone(String phone);
	//添加用户信息
	void  insert(User user);
	//用户注册
	void register(User user);
	//根据用户名查询用户信息
	User getUserByUsername(String username);
/*	//根据名字查询
	Integer getCountByName(String name);
	//根据手机号查询
	Integer getCountByPhone(String phone);
	*/
}
