package com.adr.crawler.parser;

import com.adr.util.RssRecord;
import com.rometools.rome.feed.synd.SyndFeed;

import java.util.Optional;

public interface RssParser {
    Optional<SyndFeed> parse(RssRecord record);
}
