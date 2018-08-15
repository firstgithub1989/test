package com.app.trade.dao;


import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.trade.bo.User;

@Transactional
@Repository
public interface IUserLoginDao extends CrudRepository<User, Integer> {
	public User findByuserId(Integer id);
}
