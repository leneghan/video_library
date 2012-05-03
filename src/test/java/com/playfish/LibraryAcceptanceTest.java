package com.playfish;

import org.junit.Ignore;
import org.junit.Test;

public class LibraryAcceptanceTest {


    @Test
    @Ignore
    public void givenThatIHaveACopyOfDvdNotInLibrary_WhenDonateACopy_ThenDvdTitleIsAddedAndCopyRegistered()
    {

        Library library = new Library();

        library.submitDvd();
    }
}
