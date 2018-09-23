package com.app.trade.web.service;

import com.app.trade.bo.CurrencyPurchases;
import com.app.trade.dao.CurrencyPurchasesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuySellService {

    @Autowired
    CurrencyPurchasesRepository currencyPurchasesRepository;

    public void addTnxDetails(String userId, String fromSym, double volume, double rate, double totalAmt,
        String toSym) {
        CurrencyPurchases currencyPurchases = new CurrencyPurchases(userId, fromSym, volume, rate,
               totalAmt,
                toSym);
        currencyPurchasesRepository.save(currencyPurchases);
    }
}
