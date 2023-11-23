package com.adr.producer;

import com.adr.util.RssContent;
import com.rometools.rome.feed.synd.SyndFeed;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RssDataMapper implements Function<SyndFeed, Set<RssContent>> {
    @Override
    public Set<RssContent> apply(SyndFeed feed) {
        return feed.getEntries()
                .stream()
                .map(RssContent::mapToRssContent)
                .collect(Collectors.toSet());
    }
}
