package com.intern.controller;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class HamcrestTest {
    private List<String> values;

    @Before
    public void setUp() throws Exception {
        values = new ArrayList<>();
        values.add("x");
        values.add("y");
        values.add("z");
    }

    @Test
    public void withoutHamcrest() throws Exception {
        assertTrue(values.contains("x")
                || values.contains("two")
                || values.contains("three"));
    }

    @Test
    public void withHamcrest() throws Exception {
        assertThat(values, hasItem(anyOf(equalTo("x"),
                equalTo("two"), equalTo("three"))));
    }
}
