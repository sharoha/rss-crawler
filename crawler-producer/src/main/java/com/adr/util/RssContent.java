package com.adr.util;

import com.rometools.rome.feed.synd.SyndEntry;

public record RssContent(
        String author,
        String url,
        String title,
        String contentType,
        String content
) {
    public static RssContent mapToRssContent(SyndEntry entry) {
        return new RssContent(
                entry.getAuthor(),
                entry.getUri(),
                entry.getTitle(),
                entry.getDescription().getType(),
                entry.getDescription().getValue()
        );
    }
}
