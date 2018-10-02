package com.cryptocurrency.payment.controller;

import com.cryptocurrency.payment.bo.PayTransactionDetails;
import com.cryptocurrency.payment.exceptions.XInsufficientBalance;
import com.cryptocurrency.payment.services.intf.PaymentServicesIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/pay")
@RestController
public class PaymentServiceController {

    @Autowired
    PaymentServicesIntf payService;

    @PostMapping(value = "/deposit")
    public ResponseEntity<String> depositAmount(@RequestParam("user") final String user,
                                                @RequestParam("coinName") final String coinName,
                                                @RequestParam("amount") final String amount) {
        payService.depositAmount(user, coinName, new Double(amount));
        return new ResponseEntity<String>("{message: Amount Deposit Successful}", HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "/withdraw")
    public ResponseEntity<String> withdrawAmount(@RequestParam("user") final String user,
                                                 @RequestParam("coinName") final String coinName,
                                                 @RequestParam("amount") final String amount) {

        try {
            payService.withdrawAmount(user, coinName, new Double(amount));
        } catch (XInsufficientBalance xInsufficientBalance) {
            return new ResponseEntity<String>(xInsufficientBalance.getMessage(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<String>("{message: Amount Withdraw Successful}", HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/getBalanceAmount/{user}/{coinName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public double getBalanceAmount(@PathVariable("user") final String user,
                               @PathVariable("coinName") final String coinName) {

        return payService.getBalanceAmount(user, coinName);
    }

    @PostMapping(value = "/updateBalanceAmount")
    public void updateBalanceAmount(@RequestParam("user") final String user,
            @RequestParam("coinName") final String coinName,
            @RequestParam("amount") final String amount) {

        payService.updateBalanceAmount(user, coinName, new Double(amount));
    }

    @GetMapping(value = "/getPayTranHistory/{user}/{coinName}/{page}/{isDeposit}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> getPayTranHistory(@PathVariable("user") final String user,
                                                 @PathVariable("coinName") final String coinName,
                                 @PathVariable("page") final Integer page,
                                 @PathVariable("isDeposit") final boolean isDeposit) {
        return payService.getPayTnxHistory(user, coinName, page, isDeposit);
    }
}
