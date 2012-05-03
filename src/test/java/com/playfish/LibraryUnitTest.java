package com.playfish;

import junit.framework.Assert;
import org.junit.Test;

import java.util.List;

public class LibraryUnitTest {

    @Test
    public void testSendNewsLetter_WhenHasNewTitle_Send(){
        Library library = new Library();
        boolean rs = library.sendNewsLetter();

        Assert.assertTrue(rs);
    }

    @Test
    public void testListNewTitles_WhenNewTitlesAreAvailable(){
        Library library = new Library();
        List<Dvd> dvds = library.listNewTitles();

        Assert.assertFalse(dvds.isEmpty());
    }
}
