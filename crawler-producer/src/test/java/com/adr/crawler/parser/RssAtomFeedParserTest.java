package com.adr.crawler.parser;

import com.rometools.rome.feed.synd.SyndFeed;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.nio.charset.Charset;

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
        SyndFeed parse = parser.parse(fileContent);
        assertEquals(parse.getEntries().size(), 15);
        assertEquals(parse.getTitle(), "Coding Horror");
    }
}