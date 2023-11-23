package com.adr.crawler.parser;

import com.adr.util.RssRecord;
import com.rometools.rome.feed.synd.SyndFeed;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
public class RssAtomFeedParserTest {
    private final RssParser parser = new RssAtomFeedParser();

    @Value("classpath:rss_test_source.xml")
    private Resource resource;

    @Test
    void parse() {
        String fileContent;
        try {
            fileContent = resource.getContentAsString(Charset.defaultCharset());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Optional<SyndFeed> parse = parser.parse(new RssRecord("dummUrl", fileContent));
        assertEquals(parse.get().getEntries().size(), 15);
        assertEquals(parse.get().getTitle(), "Coding Horror");
    }
}