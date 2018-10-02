package com.cryptocompare.quotes;

import java.util.List;

public class HistoryQuotes {

    private String Response;
    private String Type;
    private String Aggregated;
    private String TimeTo;
    private String TimeFrom;
    private String FirstValueInArray;
    private ConversionType ConversionType;
    private Iterable<Data> values;
    
    public String getResponse() {
        return Response;
    }
    public String getType() {
        return Type;
    }
    public String getAggregated() {
        return Aggregated;
    }
    public Iterable<Data> getData() {
        return values;
    }
    public String getTimeTo() {
        return TimeTo;
    }
    public String getTimeFrom() {
        return TimeFrom;
    }
    public String getFirstValueInArray() {
        return FirstValueInArray;
    }
    public ConversionType getConversionType() {
        return ConversionType;
    }

    public void setValues(Iterable<Data> values) {
        this.values = values;
    }

    @Override
    public String toString() {
	return "HistoryQuotes [Response=" + Response + ", Type=" + Type
		+ ", Aggregated=" + Aggregated + ", TimeTo=" + TimeTo
		+ ", TimeFrom=" + TimeFrom + ", FirstValueInArray="
		+ FirstValueInArray + ", ConversionType=" + ConversionType
		+ ", Data=" + values + "]";
    }
}

class ConversionType {
    private String type;
    private String conversionSymbol;
    
    public String getType() {
        return type;
    }
    public String getConversionSymbol() {
        return conversionSymbol;
    }
    @Override
    public String toString() {
	return "ConversionType [type=" + type + ", conversionSymbol="
		+ conversionSymbol + "]";
    }    
    
    
}
