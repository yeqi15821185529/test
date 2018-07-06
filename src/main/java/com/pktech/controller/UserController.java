package com.pktech.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pktech.entity.ResponseResult;
import com.pktech.entity.User;
import com.pktech.service.UserService;
import com.pktech.service.UsernameAlreadyExistException;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	@CrossOrigin
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public Map<String, Object> login(@RequestParam String phone,@RequestParam String password){
		Map<String, Object> map=new HashMap<String,Object>();
		User user=new User();
		user=userService.findUserByPhone(phone);

			if(password.equals(user.getPassword())) {
				map.put("code", "0000");
				map.put("msg", "登录成功");
			}else {
				map.put("code", "0001");
				map.put("msg", "密码错误");
			}

		return map;
	}
	
	@CrossOrigin
	@RequestMapping(value="/Register",method=RequestMethod.POST)	
	public Map<String, Object> register(
			@RequestParam String phone,@RequestParam String password,	
			@RequestParam String username,@RequestParam String name){
		Map<String, Object> map=new HashMap<String,Object>();
		
		User user=new User();
		user.setName(name);
		user.setPassword(password);
		user.setPhone(phone);
		user.setUsername(username);
		userService.register(user);
		map.put("code","0000");
		map.put("msg", "注册成功");
		return  map;
	}


	
	/*@CrossOrigin
	@RequestMapping(value="/Register",method=RequestMethod.GET)
	public ResponseResult<Void> register(@RequestParam String username,
			@RequestParam String name,
			@RequestParam String password,
			@RequestParam String phone){
		ResponseResult<Void> rr;
		User user=new User();
		user.setUsername(username);
		user.setName(name);
		user.setPassword(password);
		user.setPhone(phone);
		try {
			userService.register(user);
			rr=new ResponseResult<Void>(1,"注册成功");
		}catch (UsernameAlreadyExistException e) {
			rr=new ResponseResult<Void>(0,e.getMessage());
		}
		return rr;	
	}*/
	
}
