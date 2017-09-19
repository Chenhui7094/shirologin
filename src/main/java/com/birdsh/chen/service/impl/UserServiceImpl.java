package com.birdsh.chen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.birdsh.chen.dao.UserDao;
import com.birdsh.chen.entity.Permission;
import com.birdsh.chen.entity.Role;
import com.birdsh.chen.entity.User;
import com.birdsh.chen.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Override
	public User getByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.getByUsername(username);
	}

	@Override
	public List<Role> getRoles(String username) {
		// TODO Auto-generated method stub
		return userDao.getRoles(username);
	}

	@Override
	public List<Permission> getPermissions(String username) {
		// TODO Auto-generated method stub
		return userDao.getPermissions(username);
	}

}
