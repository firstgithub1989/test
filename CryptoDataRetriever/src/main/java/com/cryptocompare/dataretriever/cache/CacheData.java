package com.cryptocompare.dataretriever.cache;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.cryptocompare.dataretriever.bo.QuoteTicker;
import com.cryptocompare.dataretriever.bo.Ticker;
import com.cryptocompare.quotes.HistoryQuotes;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cryptocompare.CyrptoCompare;
import com.cryptocompare.quotes.TradingInfo;
import com.cryptocompare.quotes.TradingStats;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Component
public class CacheData {

    static String[] coinsList = new String[]{"INR","USD","BTC","ETH","LTC","XRP"};
    String coins =  "INR,USD,BTC,ETH,LTC,XRP";
    
    private static Map<String, TradingInfo> priceData = new ConcurrentHashMap<>();
	private static Map<String, HistoryQuotes> histData = new ConcurrentHashMap<>();

    @Scheduled(fixedRate = 3000)
    public void getData() throws JsonParseException, JsonMappingException, IOException {
		for(String coin : coinsList) {
			priceData.put(coin, CyrptoCompare.getTradingInfo(coin, coins, null));
		}

		histData.put("INR",
				CyrptoCompare.getHistoricalQuotes(
						"INR", "BTC", "", "30", "Day"));
    }

	public static List<Ticker> getTicker1(String fromSym) {
		QuoteTicker stats = new QuoteTicker();
		List<Ticker> tickers  = new ArrayList<>();
		for (String coin : coinsList) {
			try {
				Map<String, Object> info = priceData.get(fromSym).getRawTradingInfo(fromSym, coin);
				if (info.get("PRICE") instanceof Double)
					tickers.add(new Ticker(coin, new Double(((Double) info.get("PRICE"))),new Double((Double)info.get("CHANGEPCT24HOUR"))));
				else {
					tickers.add(new Ticker(coin, new Double(((Integer) info.get("PRICE"))),new Double((Double)info.get("CHANGEPCT24HOUR"))));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return tickers;
	}

	public static Map<String, Double> getTicker(String fromSym) {
		Map<String, Double> stats = new HashMap<>();
		for (String coin : coinsList) {
			try {
				if (priceData.get(fromSym).getRawTradingInfo(fromSym, coin).get("PRICE") instanceof Double)
					stats.put(coin, new Double(((Double) priceData.get(fromSym).getRawTradingInfo(fromSym, coin).get("PRICE"))));
				else {
					stats.put(coin, new Double(((Integer) priceData.get(fromSym).getRawTradingInfo(fromSym, coin).get("PRICE"))));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return stats;
	}

    public static List<Map<String, Object>> getPriceData(String fromSym) {
	List<Map<String, Object>> stats = new ArrayList<>();
	for(String coin : coinsList) {
	    try {
		stats.add(priceData.get(fromSym).getRawTradingInfo(fromSym, coin));
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
	return stats;
    }

    public static HistoryQuotes getHistData(String fromSym, String toSym) {
    	return histData.get("INR");
	}
    
    public static String getRate(String fromSym, String toSym) throws IOException {
		TradingInfo info = priceData.get(fromSym);
		return info.getTradingStats(info.getRawTradingInfo(fromSym, toSym)).getPRICE();
    }
}
