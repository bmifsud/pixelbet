package com.pixel.api.steps.commons;

import com.google.common.collect.Lists;
import com.pixel.api.model.auth.request.LoginRequest;
import com.pixel.api.model.auth.response.LoginResponse;
import com.pixel.api.model.auth.response.LoginResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.*;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class ApiClient {

    @Autowired
    private ApiConfig apiConfig;

    private HttpHeaders headers = new HttpHeaders();

    public ApiClient() {
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Lists.newArrayList(MediaType.APPLICATION_JSON));
    }

    public LoginResponse apiLogin(String email, String password) {
        ResponseEntity<LoginResponseBody> response = apiConfig.getRestTemplate().exchange("/user/authenticate",
                HttpMethod.POST,
                new HttpEntity<>(new LoginRequest(email, password), headers),
                LoginResponseBody.class);


       return new LoginResponse(response.getBody(),response.getStatusCode().value());

    }



}