package com.app.trade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.trade.bo.User;
import com.app.trade.dao.IUserLoginDao;

@Service
public class UserLoginService implements IUserLoginService {

	@Autowired
	private IUserLoginDao userLoginDao; 
	
	@Override
	public void addUser(User user) {
		userLoginDao.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		
		return null;
	}

	@Override
	public void deleteUser(User user) {
		userLoginDao.delete(user);
	}

	@Override
	public void updateUserDetails(User user) {
		userLoginDao.save(user);		
	}

	@Override
	public User getUserDetails(int userId) {
		return userLoginDao.findByuserId(userId); 
	}
}
