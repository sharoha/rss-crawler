package com.adr.crawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RssCrawler {
    public static void main(String[] args) {
        SpringApplication.run(RssCrawler.class);
    }
}
