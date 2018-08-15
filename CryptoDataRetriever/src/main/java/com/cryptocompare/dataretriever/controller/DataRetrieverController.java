package com.cryptocompare.dataretriever.controller;

import java.io.IOException;
import java.security.Principal;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;


import com.cryptocompare.dataretriever.bo.QuoteTicker;
import com.cryptocompare.dataretriever.bo.Ticker;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cryptocompare.dataretriever.cache.CacheData;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

//@FeignClient("data-retriever")
@RestController
@RequestMapping("/crypto")
public class DataRetrieverController {

    @Autowired
    HttpServletRequest httpServletRequest;

    @GetMapping(value = "/{fromSym}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<List<Ticker>> getPriceAll(@PathVariable("fromSym") final String fromSym)
	    throws IOException {

	//Flux<List<Map<String, Object>>> data = Flux.fromStream(Stream.generate(() -> CacheData.getPriceData(fromSym)));

	Flux<Long> interval = Flux.interval(Duration.ofSeconds(5));
	return Flux.zip(Flux.fromStream(Stream.generate(() -> CacheData.getTicker1(fromSym))), interval).map(Tuple2::getT1);
    //return Flux.fromIterable(CacheData.getTicker1(fromSym)).delayElements(Duration.ofSeconds(3));
	/*
	 * return Flux.fromStream( Stream.generate(() ->
	 * CacheData.getPriceData(fromSym)));
	 */
    }
    
    @GetMapping(value = "/{fromSym}/{toSym}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Rate getRate(@PathVariable("fromSym") final String fromSym,
                          @PathVariable("toSym") final String toSym
                    ) throws IOException {

            httpServletRequest.getHeader("user");
    	    return new Rate(CacheData.getRate(fromSym, toSym));// + " " + httpServletRequest.getHeader("user");
    }

    @GetMapping(value="/login")
    public User login() {
        User user = new User();
        user.userName = httpServletRequest.getHeader("user");
        return user;
    }
}

class User {
    public String userName;
}

class Rate {
    public String rate;

    public Rate(String rate) {
        this.rate = rate;
    }
}