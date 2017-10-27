package com.intern.controller;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class DefaultControllerTest {
    private DefaultController controller;
    private Request request;
    private RequestHandler requestHandler;

    @Before
    public void setUp() throws Exception {
        controller = new DefaultController();
        request = new SampleRequest();
        requestHandler = new SampleHandler();

        controller.addHandler(request, requestHandler);
    }

    @Test
    public void testAddHandler() throws Exception {
        RequestHandler actualHandler = controller.getHandler(request);
        assertSame("Handler we set in controller should be the" +
                " same handler we get", requestHandler, actualHandler);
    }

    @Test(expected = RuntimeException.class)
    public void testAddRequestDuplicateName() throws Exception {
        controller.addHandler(request, requestHandler);
    }

    @Test
    public void testProcessRequest() throws Exception {
        Response response = controller.processRequest(request);
        assertNotNull("Must not return null", response);
        assertEquals("Returned response must be equal to SampleResponse", new SampleResponse(), response);
    }

    @Test
    public void testProcessRequestAnswersErrorResponse() throws Exception {
        SampleRequest request = new SampleRequest("testError");
        SampleExceptionHandler handler = new SampleExceptionHandler();
        controller.addHandler(request, handler);
        Response response = controller.processRequest(request);

        assertNotNull("Must not return null", response);
        assertSame("Response must be of type ErrorResponse", ErrorResponse.class, response.getClass());
    }

    @Test(expected = RequestHandlerNotFoundException.class)
    public void testGetHandlerNotDefined() throws Exception {
        SampleRequest request = new SampleRequest("testNotDefined");

        controller.getHandler(request);
    }

    @Test(timeout = 120)
    @Ignore(value = "Ignore for now until we decide a decent time-limit")
    public void testProcessMultipleRequestsTimeout() throws Exception {
        Request request;
        Response response;
        RequestHandler handler = new SampleHandler();
        for (int i = 0; i < 99999; i++) {
            request = new SampleRequest(String.valueOf(i));
            controller.addHandler(request, handler);
            response = controller.processRequest(request);
            assertNotNull(response);
            assertNotSame(ErrorResponse.class, response.getClass());
        }
    }

    private class SampleRequest implements Request {

        private static final String DEFAULT_NAME = "Test";
        private String name;

        public SampleRequest(String name) {
            this.name = name;
        }

        public SampleRequest() {
            this(DEFAULT_NAME);
        }

        @Override
        public String getName() {
            return name;
        }
    }

    private class SampleHandler implements RequestHandler {
        @Override
        public Response process(Request request) throws Exception {
            return new SampleResponse();
        }
    }

    private class SampleExceptionHandler implements RequestHandler {
        @Override
        public Response process(Request request) throws Exception {
            throw new Exception("error processing request!");
        }
    }

    private class SampleResponse implements Response {
        private static final String NAME = "Test";

        @Override
        public String getName() {
            return NAME;
        }

        @Override
        public boolean equals(Object obj) {
            boolean result = false;

            if(obj instanceof SampleResponse) {
                SampleResponse other = (SampleResponse) obj;
                result = this.getName().equals(other.getName());
            }

            return result;
        }

        @Override
        public int hashCode() {
            return this.getName().hashCode();
        }
    }
}