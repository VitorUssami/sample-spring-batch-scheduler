package com.sample.batchscheduler.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import com.sample.batchscheduler.model.CreditCard;

public class RestItemReader implements ItemReader<CreditCard> {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestItemReader.class);

    @Value("${sample.api.url}")
    private String apiUrl;
    
    private final RestTemplate restTemplate;
    private int counter = 0;


    public RestItemReader(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public CreditCard read() throws Exception {
        
        //workaround to call api only once, cause you want to use spring batch and the job will run until a null response
        if(counter > 0) {
            counter = 0;
            return null;
        }
        
        
        //here you're calling the API to retrieve data
        LOGGER.info("Calling API {}", apiUrl);
        counter++;
        return restTemplate.getForObject(apiUrl, CreditCard.class);
    }
    
}

