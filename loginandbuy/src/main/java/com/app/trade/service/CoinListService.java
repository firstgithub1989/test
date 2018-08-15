package com.app.trade.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.app.trade.bo.CoinList;
import com.app.trade.dao.CoinListDao;
import com.cryptocompare.CyrptoCompare;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;

@Service
public class CoinListService {

	
	private CoinListDao coinListDao;
	
	public CoinListService(CoinListDao coinListDao) throws JsonParseException, JsonMappingException, IOException {
		this.coinListDao = coinListDao;
		//loadAndSave();
	}
	
	private void loadAndSave() throws JsonParseException, JsonMappingException, IOException {
		Map<Object, Object> coinList = CyrptoCompare.getCoinList();
		
		@SuppressWarnings("unchecked")
		Map<String, Map<String, String>> coinData = (Map<String, Map<String, String>>)coinList.get("Data");
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS);
		mapper.setVisibilityChecker(VisibilityChecker.Std.defaultInstance()
			.withFieldVisibility(JsonAutoDetect.Visibility.ANY));
		
		coinData.forEach((k,v)-> { 
			try {
				coinListDao.save((CoinList)mapper.readValue(mapper.writeValueAsString(v),
						CoinList.class));
			} catch (Exception e) {
				e.printStackTrace();
			}});
	}	
}
