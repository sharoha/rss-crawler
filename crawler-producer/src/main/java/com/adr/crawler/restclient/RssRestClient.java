package com.adr.crawler.restclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RssRestClient implements RestClient {
    @Autowired
    RestTemplate restTemplate;

    @Override
    public String getResponse(String url) {
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        return forEntity.getBody();
    }
}
