package com.adr.crawler.parser;

import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.StringReader;

@Service
public class RssAtomFeedParser implements RssParser {

    @SneakyThrows
    @Override
    public SyndFeed parse(String content) {
        StringReader stringReader = new StringReader(content);
        return new SyndFeedInput().build(new BufferedReader(stringReader));
    }
}
