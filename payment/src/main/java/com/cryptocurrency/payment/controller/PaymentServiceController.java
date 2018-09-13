package com.cryptocurrency.payment.controller;

import com.cryptocurrency.payment.bo.PayTransactionDetails;
import com.cryptocurrency.payment.exceptions.XInsufficientBalance;
import com.cryptocurrency.payment.services.intf.PaymentServicesIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/pay")
@RestController
public class PaymentServiceController {

    @Autowired
    PaymentServicesIntf payService;

    @PostMapping(value = "/deposit/{user}/{amount}")
    public ResponseEntity<String> depositAmount(@PathVariable("user") final String user,
                                        @PathVariable("amount") final double amount) {
        payService.depositAmount(user, amount);
        return new ResponseEntity<String>("{message: Amount Deposit Successful}", HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "/withdraw/{user}/{amount}")
    public ResponseEntity<String> withdrawAmount(@PathVariable("user") final String user,
                                 @PathVariable("amount") final double amount) {
        try {
            payService.withdrawAmount(user, amount);
        } catch (XInsufficientBalance xInsufficientBalance) {
            return new ResponseEntity<String>(xInsufficientBalance.getMessage(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<String>("{message: Amount Withdraw Successful}", HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/getINRAmount/{user}", produces = MediaType.APPLICATION_JSON_VALUE)
    public double getINRAmount(@PathVariable("user") final String user) {
        return payService.getINRAmount(user);
    }

    @GetMapping(value = "/getPayTranHistory/{user}/{page}/{isDeposit}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> getPayTranHistory(@PathVariable("user") final String user,
                                 @PathVariable("page") final Integer page,
                                 @PathVariable("isDeposit") final boolean isDeposit) {
        return payService.getPayTnxHistory(user, page, isDeposit);
    }
}
