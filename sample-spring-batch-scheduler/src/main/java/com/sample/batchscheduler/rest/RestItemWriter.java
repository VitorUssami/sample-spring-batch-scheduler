package com.sample.batchscheduler.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

import com.sample.batchscheduler.model.CreditCard;

public class RestItemWriter implements ItemWriter<CreditCard> {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestItemWriter.class);

    @Override
    public void write(List<? extends CreditCard> items) throws Exception {
        
        //here you could save the data retrieved from API
        LOGGER.info("saving CreditCard: {}", items);
    }
}