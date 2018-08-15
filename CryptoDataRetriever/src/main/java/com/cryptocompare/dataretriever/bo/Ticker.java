package com.cryptocompare.dataretriever.bo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

public class Ticker implements Serializable {

    public String currency;
    public Double rate;
    public Double change;

    public Ticker (String currency, Double rate, Double change) {
        this.currency = currency;
        this.rate = rate;
        this.change = change;
    }
}
