package com.app.trade.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

import com.app.trade.bo.CoinList;

@Transactional
@Repository
public interface CoinListDao extends CrudRepository<CoinList, String> {
	
}
