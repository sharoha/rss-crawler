package com.adr.crawler.parser;

import com.adr.util.RssRecord;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Optional;


@Slf4j
public class RssAtomFeedParser implements RssParser {

    @Override
    public Optional<SyndFeed> parse(RssRecord record) {
        StringReader stringReader = new StringReader(record.content());
        SyndFeed feed = null;
        try {
            feed = new SyndFeedInput().build(new BufferedReader(stringReader));
        } catch (FeedException e) {
            log.info("Call to {} failed with exception", record.url());
        }
        return Optional.ofNullable(feed);
    }
}
