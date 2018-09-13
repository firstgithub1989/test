package com.cryptocurrency.payment.services;

import com.cryptocurrency.payment.bo.PayTransactionDetails;
import com.cryptocurrency.payment.bo.PaymentDetails;
import com.cryptocurrency.payment.dao.PaymentDetailsRepository;
import com.cryptocurrency.payment.exceptions.XInsufficientBalance;
import com.cryptocurrency.payment.services.intf.PaymentServicesIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PaymentServiceImpl implements PaymentServicesIntf{

    private double balanceAmount;

    @Autowired
    PaymentDetailsRepository paymentDetailsRepository;

    @Override
    public void depositAmount(String userId, double amount) {
        double balanceAmount = this.getINRAmount(userId) + amount;
        PaymentDetails paymentDetails = new PaymentDetails(userId, amount, balanceAmount, true);
        paymentDetailsRepository.save(paymentDetails);
    }

    @Override
    public void withdrawAmount(String userId, double amount) throws XInsufficientBalance {
        double balanceAmount = this.getINRAmount(userId) - amount;
        if(balanceAmount < 0) {
            throw new XInsufficientBalance("Insufficient Balance");
        }
        PaymentDetails paymentDetails = new PaymentDetails(userId, amount, balanceAmount, false);
        paymentDetailsRepository.save(paymentDetails);
    }

    @Override
    public double getINRAmount(String userId) {
        return paymentDetailsRepository.findTop1ByUserIdOrderByTnxIdDesc(userId).getBalanceAmount();
    }

    @Override
    public Map<String, Object> getPayTnxHistory(String userId, int page, boolean isDeposit) {
        Map<String, Object> data = new HashMap<>();
        Page<PaymentDetails> paymentDetails = paymentDetailsRepository.findByUserIdAndIsDepositOrderByTnxIdDesc(
                userId, isDeposit,new PageRequest(page,10) );

        List<PayTransactionDetails> payTransactionDetailsList = new ArrayList<>();
        paymentDetails.forEach(p -> payTransactionDetailsList.add(
                new PayTransactionDetails(p.getTnxDate().toString(), p.isDeposit(), p.getAmount())));

        data.put("total",paymentDetails.getTotalElements());
        data.put("data",payTransactionDetailsList);
        return data;
    }
}
