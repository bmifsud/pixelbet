package com.pixel.api.model.auth.response;

import org.springframework.http.HttpHeaders;

public class LoginResponse {

    private  LoginResponseBody responseBody;

    private  int statusCode;

    public LoginResponse(LoginResponseBody body, int statusCode) {
        this.responseBody = body;
        this.statusCode = statusCode;
    }

    public LoginResponse(){}

    public LoginResponseBody getResponseBody() {
        return responseBody;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
