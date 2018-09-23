package com.app.trade.dao;

import com.app.trade.bo.CurrencyPurchases;
import org.springframework.data.repository.CrudRepository;

public interface CurrencyPurchasesRepository extends CrudRepository<CurrencyPurchases, String> {
}
