package com.adr.crawler.parser;

import com.rometools.rome.feed.synd.SyndFeed;

public interface RssParser {
    SyndFeed parse(String content);
}
