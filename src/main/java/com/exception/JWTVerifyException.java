package com.exception;

public class JWTVerifyException extends Exception{
    public JWTVerifyException(String message) {
        super(message);
    }
}
