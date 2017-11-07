package com.intern.stubs;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.net.URL;

import static org.junit.Assert.assertEquals;

public class TestWebClientSkeleton {
    @Before
    public void setUp()
    {
    }

    @After
    public void tearDown()
    {
    }

    @Test
    @Ignore( value = "This is just initial skeleton of a test. " + "Therefore if we run it now it will fail." )
    public void testGetContentOk()
            throws Exception
    {
        WebClient client = new WebClient();
        String result = client.getContent( new URL( "http://localhost:8080/testGetContentOk" ) );

        assertEquals( "It works", result );
    }
}
