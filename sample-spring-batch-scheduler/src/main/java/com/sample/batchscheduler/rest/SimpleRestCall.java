package com.sample.batchscheduler.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sample.batchscheduler.model.CreditCard;

@Component
public class SimpleRestCall {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleRestCall.class);

    @Value("${sample.api.url}")
    private String apiUrl;
    
    @Autowired
    private RestTemplate restTemplate;
    
    public void callApi() {
        
        //simple rest call
        LOGGER.info("calling api without spring batch");
        CreditCard creditCard = restTemplate.getForObject(apiUrl, CreditCard.class);
        LOGGER.info("CreditCard info {}", creditCard);
        
    }
}
