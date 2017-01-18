package com.epam.trainings.jf.strings.pool;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class OtherTest {
    @Test
    public void literalsPool() throws Exception {
        String s1 = "Hello";
        String s2 = new StringBuffer("He").append("llo").toString();
        String s3 = s2.intern();
        assertFalse(s1 == s2);
        assertThat(s1, is(s2));
        assertTrue(s1 == s3);

        String hello = "Hello",
                lo = "lo";

        assertTrue(hello == "Hello");
        assertTrue(Other.hello == hello);
        assertTrue(com.epam.trainings.jf.strings.pool.otherpack.Other.hello == hello);
        assertTrue(hello == ("Hel" + "lo"));
        assertFalse(hello == ("Hel" + lo));
        assertThat("Hel" + lo, is(hello));
        assertTrue(hello == ("Hel" + lo).intern());
    }
}