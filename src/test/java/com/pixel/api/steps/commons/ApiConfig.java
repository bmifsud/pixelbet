package com.pixel.api.steps.commons;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Configuration
@Scope(SCOPE_CUCUMBER_GLUE)
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