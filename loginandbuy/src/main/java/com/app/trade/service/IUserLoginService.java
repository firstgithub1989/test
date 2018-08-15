package com.app.trade.service;

import java.util.List;
import com.app.trade.bo.User;

public interface IUserLoginService {

	void addUser(User user);
	
	List<User> getAllUsers();
	
	void deleteUser(User user);
	
	void updateUserDetails(User user);
	
	User getUserDetails(int userId);
	
}
