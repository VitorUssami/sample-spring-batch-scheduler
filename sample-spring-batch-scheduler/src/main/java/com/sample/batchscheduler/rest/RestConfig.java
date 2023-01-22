package com.sample.batchscheduler.rest;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.sample.batchscheduler.model.CreditCard;

@Configuration
public class RestConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Bean
    public ItemReader<CreditCard> itemReader() {
        return new RestItemReader(restTemplate);
    }

    @Bean
    public ItemWriter<CreditCard> itemWriter() {
        return new RestItemWriter();
    }
    
    @Bean
    public ItemProcessor<CreditCard, CreditCard> itemProcessor() {
        return new RestItemProcessor();
    }

    @Bean
    public Step exampleJobStep() {
        return stepBuilderFactory.get("exampleJobStep")
                .<CreditCard, CreditCard>chunk(1)
                .reader(itemReader())
                .processor(itemProcessor())
                .writer(itemWriter())
                .build();
    }

    @Bean(name = "exampleJobBean")
    public Job exampleJob() {
        return jobBuilderFactory
                .get("exampleJob")
                .start(exampleJobStep())
                .build();
    }

}
