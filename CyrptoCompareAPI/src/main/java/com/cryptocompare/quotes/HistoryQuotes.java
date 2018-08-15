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
    private List<Data> Data;
    
    public String getResponse() {
        return Response;
    }
    public String getType() {
        return Type;
    }
    public String getAggregated() {
        return Aggregated;
    }
    public List<Data> getData() {
        return Data;
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
    
    @Override
    public String toString() {
	return "HistoryQuotes [Response=" + Response + ", Type=" + Type
		+ ", Aggregated=" + Aggregated + ", TimeTo=" + TimeTo
		+ ", TimeFrom=" + TimeFrom + ", FirstValueInArray="
		+ FirstValueInArray + ", ConversionType=" + ConversionType
		+ ", Data=" + Data + "]";
    }
}

class Data {
    private String time;
    private String close;
    private String high;
    private String low;
    private String open;
    private String volumefrom;
    private String volumeto;
    
    public String getTime() {
        return time;
    }
    public String getClose() {
        return close;
    }
    public String getHigh() {
        return high;
    }
    public String getLow() {
        return low;
    }
    public String getOpen() {
        return open;
    }
    public String getVolumefrom() {
        return volumefrom;
    }
    public String getVolumeto() {
        return volumeto;
    }
    @Override
    public String toString() {
	return "Data [time=" + time + ", close=" + close + ", high=" + high
		+ ", low=" + low + ", open=" + open + ", volumefrom="
		+ volumefrom + ", volumeto=" + volumeto + "]";
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
