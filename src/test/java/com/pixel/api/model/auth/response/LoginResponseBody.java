package com.pixel.api.model.auth.response;

public class LoginResponseBody {

    private final String result;
    private final int attenmptsLeft;
    private final String sessionId;

    public LoginResponseBody(String result, int attenmptsLeft, String sessionId) {
        this.result = result;
        this.attenmptsLeft = attenmptsLeft;
        this.sessionId = sessionId;
    }
}
