package com.app.trade.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.app.trade.bo.User;


@Transactional
@Repository
public class AdminUserLoginDao implements IUserLoginDao {

	@Override
	public <S extends User> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findOne(Integer id) {
		return null;
	}

	@Override
	public boolean exists(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<User> findAll(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(User entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends User> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findByuserId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public List<User> getAllUsers() {
		String hql = "FROM CC_USER";
		session.get
		return (List<User>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public void deleteUser(User user) {
		
	}

	@Override
	public void updateUserDetails(User user) {
		
	}

	@Override
	public User getUserDetails() {
		return null;
	}*/
}
