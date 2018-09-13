package com.cryptocurrency.payment.bo;

import java.sql.Timestamp;
import java.util.Date;

public class PayTransactionDetails {

    private String paymentDate;
    private boolean isDeposit;
    private double amount;

    public PayTransactionDetails() {

    }

    public PayTransactionDetails(String paymentDate, boolean isDeposit, double amount) {
        this.paymentDate = paymentDate;
        this.isDeposit = isDeposit;
        this.amount = amount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public boolean isDeposit() {
        return isDeposit;
    }

    public void setDeposit(boolean deposit) {
        isDeposit = deposit;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean equals(Object paytranDetail) {
        if (paytranDetail == null) {
            return false;
        }
        if(paytranDetail == this) {
            return true;
        }
        if(getClass() != paytranDetail.getClass()) {
            return false;
        }
        PayTransactionDetails other = (PayTransactionDetails) paytranDetail;
        if(!(other.isDeposit == this.isDeposit)) {
            return false;
        }
        if(!(other.amount == this.amount)) {
            return false;
        }
        if(other.paymentDate.compareTo(this.paymentDate)!= 0) {
            return false;
        }

        return true;
    }

    public String toString() {
        return "Amount: " + this.amount + "Date: " + this.paymentDate.toString() + "Is Deposit:"
                + isDeposit;
    }
}
