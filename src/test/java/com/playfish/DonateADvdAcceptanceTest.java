package com.playfish;

import org.junit.Ignore;
import org.junit.Test;

public class DonateADvdAcceptanceTest {

    @Test
    @Ignore
    public void givenThatIHaveACopyOfDvdNotInLibrary_WhenDonateACopy_ThenDvdTitleIsAddedAndCopyRegistered()
    {

        Library library = new Library();

        library.submitDvd();
    }
}
