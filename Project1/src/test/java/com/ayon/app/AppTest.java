package com.ayon.app;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AppTest {

    @Test
    public void shouldDoSomethingWhenTested () {
        int i = 10;
        int j = 11;
        assertThat(i+j,is(21));
    }

    @Test
    public void shouldDoSomethingWhenTestedAgain () {
        int i = 10;
        int j = 12;
        assertThat(i+j,is(22));
    }
}
