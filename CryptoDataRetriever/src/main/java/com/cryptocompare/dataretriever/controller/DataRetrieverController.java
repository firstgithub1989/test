package com.cryptocompare.dataretriever.controller;

import java.io.IOException;
import java.security.Principal;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;


import com.cryptocompare.dataretriever.bo.QuoteTicker;
import com.cryptocompare.dataretriever.bo.Ticker;
import com.cryptocompare.dataretriever.cache.HistoryData;
import com.cryptocompare.quotes.HistoryQuotes;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cryptocompare.dataretriever.cache.CacheData;

import reactor.core.publisher.Flux;
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

	    Flux<Long> interval = Flux.interval(Duration.ofSeconds(0), Duration.ofSeconds(5));
	    return Flux.zip(Flux.fromStream(Stream.generate(() -> CacheData.getTicker1(fromSym))), interval).map(Tuple2::getT1);
    }
    
    @GetMapping(value = "/{fromSym}/{toSym}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getRate(@PathVariable("fromSym") final String fromSym,
                                  @PathVariable("toSym") final String toSym
                    ) throws IOException {

        httpServletRequest.getHeader("userid");
    	return new ResponseEntity<String>(CacheData.getRate(fromSym, toSym), HttpStatus.OK);
    }

    @GetMapping(value = "/histdata/{fromSym}/{toSym}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Map<String, List<HistoryData>>> getHistoPrice(@PathVariable("fromSym") final String fromSym,
                                                              @PathVariable("toSym") final String toSym) {
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(0), Duration.ofSeconds(5));
        return Flux.zip(Flux.fromStream(Stream.generate(() -> CacheData.getHistData(fromSym,toSym))), interval).
                map(Tuple2::getT1);
    }
}


class Rate {
    public String rate;

    public Rate(String rate) {
        this.rate = rate;
    }
}