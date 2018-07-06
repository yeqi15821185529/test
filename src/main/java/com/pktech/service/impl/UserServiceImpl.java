package com.pktech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pktech.dao.UserDao;
import com.pktech.entity.User;
import com.pktech.service.UserService;
import com.pktech.service.UsernameAlreadyExistException;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	@Override
	public User findUserByPhone(String phone) {
		
		return userDao.findUserByPhone(phone);
	}
	
	@Override
	public void register(User user) {
		User user1=userDao.getUserByUsername(user.getUsername());
		if(user1==null) {
			userDao.insert(user);
		}else {
			throw new UsernameAlreadyExistException("用户名已经存在,请重新输入!");
		}
	}

	@Override
	public boolean checkUsername(String username) {
		if(userDao.getUserByUsername(username)==null) {
			return false;
		}else {
			return true;
		}

	}

/*	@Override
	public boolean checkName(String name) {
		
		return userDao.getCountByName(name)>0;
	}

	@Override
	public boolean checkPhone(String phone) {
		
		return userDao.getCountByPhone(phone)>0;
	}*/
}
