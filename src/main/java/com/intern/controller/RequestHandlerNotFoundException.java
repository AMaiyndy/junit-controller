package com.intern.controller;

public class RequestHandlerNotFoundException extends RuntimeException {
    public RequestHandlerNotFoundException() {
        super("Cannot find handler for request!");
    }
}
