package com.adr.crawler.task;

import com.adr.crawler.restclient.RssRestClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@Slf4j
public class ScheduledCrawler {
    @Autowired
    RssUrls rssUrls;

    @Autowired
    RssRestClient rssRestClient;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        Set<String> collect = rssUrls.getRssUrls()
                .stream()
                .map(rssRestClient::getResponse)
                .peek(ele -> log.info("Response received: {}", ele))
                .collect(Collectors.toSet());
    }
}
