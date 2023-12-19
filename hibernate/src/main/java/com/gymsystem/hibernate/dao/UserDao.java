package com.gymsystem.hibernate.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gymsystem.hibernate.model.User;

@Repository
public interface UserDao {

	List<User> getAllUsers();

	User getUserById(long id);

	void createUser(User user);

	void updateUser(User user);

	void deleteUser(long id);
}