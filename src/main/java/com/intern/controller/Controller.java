package com.intern.controller;

/**
 * The component that interacts with a client, controlling and managing
 * the handling of each request.
 *
 * @author amayindy
 */
public interface Controller {
    /**
     * A top-level method for processing an incoming request.
     *
     * @param request incoming request
     * @return        response
     */
    Response processRequest(Request request);

    /**
     * The method that allows to extend the Controller without modifying the Java source.
     *
     * @param request           request
     * @param requestHandler    handler for request
     */
    void addHandler(Request request, RequestHandler requestHandler);
}
