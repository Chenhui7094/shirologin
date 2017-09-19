package com.birdsh.chen.service;

import java.util.List;

import com.birdsh.chen.entity.Permission;
import com.birdsh.chen.entity.Role;
import com.birdsh.chen.entity.User;

public interface UserService {
	
	public User getByUsername(String username);

	public List<Role> getRoles(String username);

	public List<Permission> getPermissions(String username);
}
