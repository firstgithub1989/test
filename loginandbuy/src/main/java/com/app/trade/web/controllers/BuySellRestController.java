package com.app.trade.web.controllers;

import com.app.trade.bo.User;
import com.app.trade.web.service.BuySellService;
import com.netflix.discovery.EurekaClient;
import com.netflix.ribbon.proxy.annotation.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@RestController(value = "/crypto")
public class BuySellRestController {

	@LoadBalanced
	RestTemplate restTemplate = new RestTemplate();

	@Autowired
	EurekaClient eurekaClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
	private BuySellService buySellService;

	@PostMapping(value = "/buy/{userId}/{volume}/{fromSym}/{toSym}")
	public String buy(@PathVariable("userId") final String userId,
					  @PathVariable("volume") final double volume, @PathVariable("fromSym") final String fromSym, @PathVariable("toSym") final String toSym,
					   HttpServletRequest httpServletRequest) {
		String rate =  getRate(fromSym, toSym);
		double fromAmount = getBalanceAmount(userId, fromSym);
		double toAmount = getBalanceAmount(userId, toSym);

		double toBalAmount = volume * new Double(rate);
		buySellService.addTnxDetails(userId, toSym, volume, new Double(rate), toBalAmount, fromSym);
		updateBalanceAmount(userId, fromSym, volume+ fromAmount);
		updateBalanceAmount(userId, toSym, toAmount - toBalAmount);
		return "buy confirmed at rate: " + rate + "for " + httpServletRequest.getHeader("user");
	}

	@PostMapping(value = "/sell/{userId}/{fromSym}/{toSym}/{volume}")
	public String sell(@PathVariable("userId") final String userId,
					   @PathVariable("volume") final double volume,@PathVariable("fromSym") final String fromSym, @PathVariable("toSym") final String toSym,
					    HttpServletRequest httpServletRequest) {
		String rate =  getRate(toSym, fromSym);
		double toAmount = getBalanceAmount(userId, toSym);
		double fromAmount = getBalanceAmount(userId, fromSym);
		double fromBalAmount = volume * new Double(rate);
		buySellService.addTnxDetails(userId, toSym, volume, new Double(rate), fromBalAmount, fromSym);
		updateBalanceAmount(userId,fromSym, fromAmount + fromBalAmount);
		updateBalanceAmount(userId,toSym, toAmount - volume);
		return "sell confirmed at rate: " + rate + " for " + httpServletRequest.getHeader("user");
	}

	private String getRate(String fromSym, String toSym) {
		ServiceInstance discoveryClientInstance = discoveryClient.getInstances("data-retriever").get(0);
		//InstanceInfo instanceInfo = (InstanceInfo)eurekaClient.getInstancesById("data-retriever").get(0);
		ResponseEntity<String> response = restTemplate.exchange("http://"+ discoveryClientInstance.getHost()
						+ ":"	+ discoveryClientInstance.getPort() + "/crypto/" + fromSym + "/" + toSym,
				HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
				});

		return response.getBody();
	}

	private double getBalanceAmount(String userId, String coinName) {
		ServiceInstance discoveryClientInstance = discoveryClient.getInstances("payment").get(0);
		//InstanceInfo instanceInfo = (InstanceInfo)eurekaClient.getInstancesById("data-retriever").get(0);
		ResponseEntity<Double> response = restTemplate.exchange("http://"+ discoveryClientInstance.getHost()
						+ ":"	+ discoveryClientInstance.getPort() + "/pay/getBalanceAmount/" + userId + "/" + coinName,
				HttpMethod.GET, null, new ParameterizedTypeReference<Double>() {
				});

		return response.getBody();
	}

	private void updateBalanceAmount(String userId, String coinName, double amount) {
		ServiceInstance discoveryClientInstance = discoveryClient.getInstances("payment").get(0);
		String url = "http://"+ discoveryClientInstance.getHost()
				+ ":"	+ discoveryClientInstance.getPort() + "/pay/updateBalanceAmount";

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
		.queryParam("user", userId)
		.queryParam("coinName", coinName)
		.queryParam("amount", new Double(amount).toString());

		//InstanceInfo instanceInfo = (InstanceInfo)eurekaClient.getInstancesById("data-retriever").get(0);
		restTemplate.exchange(builder.toUriString(),
				HttpMethod.POST, null, new ParameterizedTypeReference<String>() {
				});
	}
}
