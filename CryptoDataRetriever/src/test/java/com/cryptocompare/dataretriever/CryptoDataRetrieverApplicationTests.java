package com.cryptocompare.dataretriever;

import com.cryptocompare.dataretriever.cache.CacheData;
import com.cryptocompare.dataretriever.controller.DataRetrieverController;
import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.junit.Assert;
import org.junit.Test;

import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.easymock.PowerMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(EasyMockRunner.class)
@WebMvcTest(value = DataRetrieverController.class, secure = false)
public class CryptoDataRetrieverApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Mock
	CacheData cacheData;

	@Test
	public void contextLoads() throws  Exception{
		/*Mockito.mock(CacheData.class);
		Mockito.doReturn("1.345").when(cacheData).getRate(Mockito.anyString(),Mockito.anyString());*/
/*
		EasyMock.createNiceMock(CacheData.class);
		EasyMock.expect(CacheData.getRate(EasyMock.anyString(),EasyMock.anyString())).andReturn("1.345");
		EasyMock.replay();
*/
		PowerMock.mockStatic(CacheData.class);
		EasyMock.expect(CacheData.getRate(EasyMock.anyString(),EasyMock.anyString())).andReturn("1.345");
		EasyMock.replay();
		RequestBuilder requestBuilder = MockMvcRequestBuilders
											.get("/crypto/USD/LTC")
											.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse().getContentAsString());

		Assert.assertEquals(result.getResponse().getContentAsString(),"1.345");
	}

}
