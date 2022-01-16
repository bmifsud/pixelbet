package com.pixel.api.model.auth.response;

import org.springframework.http.HttpStatus;

public class LoginResponse {

    private final LoginResponseBody body;
    private final HttpStatus statusCode;

    public LoginResponse(LoginResponse body, HttpStatus statusCode) {
        this.body = body;
        this.statusCode = statusCode;
    }


}
