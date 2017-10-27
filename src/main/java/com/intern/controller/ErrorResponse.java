package com.intern.controller;

/**
 * Component that represents error response implementation
 *
 * @author amayindy
 */
public class ErrorResponse implements Response {
    private Request originalRequest;
    private Exception originalException;

    public ErrorResponse(Request originalRequest, Exception originalException) {
        this.originalRequest = originalRequest;
        this.originalException = originalException;
    }

    public Request getOriginalRequest() {
        return originalRequest;
    }

    public Exception getOriginalException() {
        return originalException;
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("not implemented!");
    }
}
