package com.cryptocurrency.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService {

    @Autowired
    private UserDetailsDao userDetailsDao;

    public UserDetails findUser(long userId){
        return userDetailsDao.findOne(userId);
    }

    public void saveUser(UserDetails userDetails) {
        userDetailsDao.save(userDetails);
    }

    public long findUserID(String userName) {
        UserDetails userDetails = userDetailsDao.findByUserName(userName);
        return userDetails.getUserId();
    }
}
