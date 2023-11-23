package com.adr.crawler.task;

import com.adr.crawler.parser.RssAtomFeedParser;
import com.adr.crawler.parser.RssParser;
import com.adr.producer.RssDataMapper;
import com.adr.util.RssContent;
import com.adr.util.RssRecord;
import com.adr.crawler.restclient.RssRestClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@Slf4j
public class ScheduledCrawler {
    @Autowired
    RssUrls rssUrls;
    @Autowired
    RssRestClient rssRestClient;
    private static final RssParser rssParser = new RssAtomFeedParser();

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        Set<RssContent> data = rssUrls.getRssUrls()
                .stream()
                .map(url -> new RssRecord(url, rssRestClient.getResponse(url)))
                .map(rssParser::parse)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .flatMap(entry -> new RssDataMapper().apply(entry).stream())
                .collect(Collectors.toSet());

    }
}
