package com.sample.batchscheduler.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.sample.batchscheduler.model.CreditCard;

public class RestItemProcessor implements ItemProcessor<CreditCard, CreditCard> {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestItemProcessor.class);

    @Override
    public CreditCard process(CreditCard item) throws Exception {
        LOGGER.info("processing CreditCard info: {}", item);
        //here you can apply business rules, data manipulation, and so on
        return item;
    }
}