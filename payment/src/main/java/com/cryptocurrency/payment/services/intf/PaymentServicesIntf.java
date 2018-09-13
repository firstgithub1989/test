package com.cryptocurrency.payment.services.intf;

import com.cryptocurrency.payment.bo.PayTransactionDetails;
import com.cryptocurrency.payment.exceptions.XInsufficientBalance;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface PaymentServicesIntf {

    public void depositAmount(String user, double amount);

    public void withdrawAmount(String user, double withdraw) throws XInsufficientBalance;

    public double getINRAmount(String user);

    public Map<String, Object> getPayTnxHistory(String user, int page, boolean isDeposit);

}
