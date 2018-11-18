package com.wcc.threadtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class ThreadtestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThreadtestApplication.class, args);
    }


    @Bean
    public ExecutorService getExecutorService() {
        return Executors.newFixedThreadPool(20);

    }
}

