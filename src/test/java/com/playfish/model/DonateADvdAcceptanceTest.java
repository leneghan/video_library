package com.playfish.model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.Mockito;

public class DonateADvdAcceptanceTest {

    @Test
    public void givenThatIHaveACopyOfDvdNotInLibrary_WhenDonateACopy_ThenDvdTitleIsAddedAndCopyRegistered()
    {

        Library library = new Library(Mockito.mock(EmailClient.class, "emailClient"));

        library.submitDvd("testTitle", "testYear", "testDirector");

        assertTrue("dvd is not availalble", library.getDvds().get(0).isAvailable());


    }
}
