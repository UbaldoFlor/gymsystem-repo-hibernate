package com.gymsystem.hibernate.service;

import java.util.List;

import com.gymsystem.hibernate.model.User;

public interface UserService {
	
	public void createUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(Long id);
	
	public User getUserById(Long id);
	
	public List<User> getAllUsers();
}