package com.pixel.api;

import com.pixel.api.model.auth.request.LoginRequest;
import com.pixel.api.model.auth.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Service
@Scope(SCOPE_CUCUMBER_GLUE)
public class ApiClient {

    @Autowired
    private ApiConfig apiConfig;

    private HttpHeaders headers = new HttpHeaders();

    public ApiClient() {
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    public LoginResponse apiLogin(String username, String password) {
        ResponseEntity<LoginResponse> response = apiConfig.getRestTemplate().exchange("/user/authenticate",
                HttpMethod.POST,
                new HttpEntity<>(new LoginRequest(username, password), headers),
                LoginResponse.class);


        return new LoginResponse(response.getBody(),response.getStatusCode());

    }
}