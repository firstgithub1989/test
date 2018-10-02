package com.cryptocurrency.payment.services.intf;

import com.cryptocurrency.payment.bo.PayTransactionDetails;
import com.cryptocurrency.payment.exceptions.XInsufficientBalance;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Service
public interface PaymentServicesIntf {

    public void depositAmount(String user, String coinName,double amount);

    public void withdrawAmount(String user, String coinName, double withdraw) throws XInsufficientBalance;

    public double getBalanceAmount(String user, String coinName);

    public void updateBalanceAmount(String user, String coinName, double amount);

    public Map<String, Object> getPayTnxHistory(String user, String coinName, int page, boolean isDeposit);

}
