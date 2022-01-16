package com.pixel.api;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Configuration
public class ApiConfig {

    private RestTemplate restTemplate;

    @PostConstruct
    public void init(){
        initRestTemplate();
    }

    private void initRestTemplate(){
        restTemplate = new RestTemplateBuilder()
                .rootUri("https://backend.pixel.bet/rest")
                .build();
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

}