package com.pktech.service;

import org.springframework.stereotype.Service;

import com.pktech.entity.User;
@Service
public interface UserService {
	public User findUserByPhone(String phone);
	//用户注册
	void register(User user);
	//验证用户名是否存在
	boolean checkUsername(String username);
/*	//验证名字是否存在
	boolean checkName(String name);
	//验证电话号码
	boolean checkPhone(String phone);*/
}
