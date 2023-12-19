package com.gymsystem.hibernate.service.impl;

import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymsystem.hibernate.dao.UserDao;
import com.gymsystem.hibernate.model.User;
import com.gymsystem.hibernate.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public void createUser(User user) {
		user = generateUsername(user);
		user = generatePassword(user);
		userDao.createUser(user);
	}

	@Override
	public User getUserById(Long id) {
		return userDao.getUserById(id);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Override
	public void deleteUser(Long id) {
	    userDao.deleteUser(id);;
	}

	@Override
	public List<User> getAllUsers() {
	    return userDao.getAllUsers();
	}
	
	private User generateUsername(User user) {
		String firstName = user.getFirstName().toLowerCase();
		String lastName = user.getLastName().toLowerCase();
		String username = firstName + "." + lastName;
		/*List<User> users = userDao.getAllUsers();
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().getUsername().equals(username)) {
				username.concat("2");
				break;
			}
		}*/
		user.setUsername(username);
		
		return user;
	}
	
	private User generatePassword(User user) {
		int passwordLength = 10;
		String password = RandomStringUtils.randomAlphabetic(passwordLength);
		user.setPassword(password);
		return user;
	}
}