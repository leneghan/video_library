package com.playfish;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;

public class DvdUnitTest {


    @Test
    public void shouldCreateDvdWithCopy(){
        Dvd dvd = new Dvd("title", "1990", "director");

        assertTrue("A dvd copy should be available", dvd.isAvailable());

    }


}
