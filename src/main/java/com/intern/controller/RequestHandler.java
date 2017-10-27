package com.intern.controller;

/**
 * Request handler that can process a Request and return Response
 *
 * @author amayindy
 */
public interface RequestHandler {
    /**
     * The method that processes a Request and return Response
     *
     * @param request incoming request
     * @return        response
     * @throws Exception
     */
    Response process(Request request) throws Exception;
}
