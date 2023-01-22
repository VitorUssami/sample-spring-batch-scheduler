package com.sample.batchscheduler.rest;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class RestScheduler {

    private final Logger logger = LoggerFactory.getLogger(RestScheduler.class);
    
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private JobLauncher jobLauncher;
    
    @Autowired
    private SimpleRestCall simpleRestCall;
    
    @Autowired
    @Qualifier("exampleJobBean")
    private Job exampleJobStep;
    
//    @Autowired
//    private RestTemplate restTemplate;
    
    
    @Scheduled(cron = "*/9 * * * * ?")
    public void usingSpringBatch() throws Exception {
        Date date = new Date();
        logger.info("*******************************************************");
        logger.info("[usingSpringBatch ]start {}", date);
        jobLauncher.run(exampleJobStep, new JobParametersBuilder().addDate("launchDate", date).toJobParameters());
        logger.info("[usingSpringBatch ] end {}", new Date());
        logger.info("*******************************************************");
    }
    
    
    @Scheduled(cron = "*/20 * * * * ?")
    public void simpleScheduler() throws Exception {
        Date date = new Date();
        logger.info("*******************************************************");
        logger.info("[simpleScheduler]start {}", date);
        simpleRestCall.callApi();
        logger.info("[simpleScheduler] end {}", new Date());
        logger.info("*******************************************************");
    }
    
    
//    @Bean
//    public ItemReader<CreditCard> itemReader() {
//        return new RestItemReader(restTemplate);
//    }
//
//    @Bean
//    public ItemWriter<CreditCard> itemWriter() {
//        return new RestItemWriter();
//    }
//    
//    @Bean
//    public ItemProcessor<CreditCard, CreditCard> itemProcessor() {
//        return new RestItemProcessor();
//    }
//
//    @Bean
//    public Step exampleJobStep() {
//        return stepBuilderFactory.get("exampleJobStep")
//                .<CreditCard, CreditCard>chunk(1)
//                .reader(itemReader())
//                .processor(itemProcessor())
//                .writer(itemWriter())
//                .build();
//    }
//
//    @Bean
//    public Job exampleJob() {
//        return jobBuilderFactory
//                .get("exampleJob")
//                .start(exampleJobStep())
//                .build();
//    }
}
