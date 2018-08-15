package com.app.trade.web.controllers;

import com.app.trade.bo.User;
import com.netflix.discovery.EurekaClient;
import com.netflix.ribbon.proxy.annotation.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;


@RestController(value = "/crypto")
public class BuySellRestController {

	@LoadBalanced
	RestTemplate restTemplate = new RestTemplate();

	@Autowired
	EurekaClient eurekaClient;

    @Autowired
    private DiscoveryClient discoveryClient;

	@GetMapping(value = "/buy/{fromSym}/{toSym}")
	public String buy(@PathVariable("fromSym") final String fromSym, @PathVariable("toSym") final String toSym
				, HttpServletRequest httpServletRequest) {

        ServiceInstance discoveryClientInstance = discoveryClient.getInstances("data-retriever").get(0);
        //InstanceInfo instanceInfo = (InstanceInfo)eurekaClient.getInstancesById("data-retriever").get(0);
		ResponseEntity<String> response = restTemplate.exchange("http://"+ discoveryClientInstance.getHost()
					+ ":"	+ discoveryClientInstance.getPort() + "/crypto/" + fromSym + "/" + toSym,
				HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
				});

		return "buy confirmed at rate: " + response.getBody()  + "for " + httpServletRequest.getHeader("user");
	}
}
