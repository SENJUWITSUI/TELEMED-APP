package com.example.telemed;

public class LoginResponse {

    private boolean error;
    private String message;
    private String token;

    public LoginResponse(boolean error, String message, String token) {
        this.error = error;
        this.message = message;
        this.token = token;
    }

    public boolean isError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getToken() {
        return token;
    }
}