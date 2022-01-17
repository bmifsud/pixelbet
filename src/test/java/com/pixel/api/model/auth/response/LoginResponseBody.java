package com.pixel.api.model.auth.response;

public class LoginResponseBody {

    private  String result;
    private  int attenmptsLeft;
    private  String sessionId;

    public LoginResponseBody() {}

    public LoginResponseBody(String result, int attenmptsLeft, String sessionId) {
        this.result = result;
        this.attenmptsLeft = attenmptsLeft;
        this.sessionId = sessionId;
    }

    public String getResult() {
        return result;
    }

    public int getAttenmptsLeft() {
        return attenmptsLeft;
    }

    public String getSessionId() {
        return sessionId;
    }
}
