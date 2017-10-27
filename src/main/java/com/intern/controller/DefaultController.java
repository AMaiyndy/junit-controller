package com.intern.controller;

import java.util.HashMap;
import java.util.Map;

/**
 * Default implementation of Controller interface
 *
 * @author amayindy
 */
public class DefaultController implements Controller {

    private Map<String, RequestHandler> requestHandlers = new HashMap<>();

    /**
     * The method that returns request handler for request if it exists,
     * else - throws RuntimeException.
     *
     * @param request a request for which need to find handler
     * @return        request handler if it exists
     */
    protected RequestHandler getHandler(Request request) {
        if(!this.requestHandlers.containsKey(request.getName())) {
            throw new RequestHandlerNotFoundException();
        }

        return this.requestHandlers.get(request.getName());
    }

    @Override
    public Response processRequest(Request request) {
        Response response;
        try {
            response = getHandler(request).process(request);
        } catch (Exception e) {
            response = new ErrorResponse(request, e);
        }
        return response;
    }

    @Override
    public void addHandler(Request request, RequestHandler requestHandler) {
        if(this.requestHandlers.containsKey(request.getName())) {
            String message = "A request handler has already been registered " +
                    "for request name [" + request.getName() + "]";
            throw new RuntimeException(message);
        } else {
            this.requestHandlers.put(request.getName(), requestHandler);
        }
    }

}
