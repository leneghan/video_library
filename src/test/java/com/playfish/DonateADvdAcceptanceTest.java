package com.playfish;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DonateADvdAcceptanceTest {

    @Test
    public void givenThatIHaveACopyOfDvdNotInLibrary_WhenDonateACopy_ThenDvdTitleIsAddedAndCopyRegistered()
    {

        Library library = new Library();

        library.submitDvd("testTitle", "testYear", "testDirector");

        assertTrue("dvd is not availalble", library.getDvds().get(0).isAvailable());

        
    }
}
