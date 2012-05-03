package com.playfish;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: christopher.wardrop
 * Date: 03/05/2012
 * Time: 14:49
 * To change this template use File | Settings | File Templates.
 */
public class LibraryAcceptanceTest {


    @Test
    public void givenThatIHaveACopyOfDvdNotInLibrary_WhenDonateACopy_ThenDvdTitleIsAddedAndCopyRegistered()
    {

        Library library = new Library();

        library.submitDvd();
    }
}
