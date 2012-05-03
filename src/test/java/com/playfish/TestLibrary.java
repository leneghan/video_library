package com.playfish;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: christopher.wardrop
 * Date: 03/05/2012
 * Time: 14:49
 * To change this template use File | Settings | File Templates.
 */
public class TestLibrary {


    @Test
    public void givenThatIHaveACopyOfDvdNotInLibrary_WhenDonateACopy_ThenDvdTitleIsAddedAndCopyRegistered()
    {


    }
    
    @Test
    public void testSendNewsLetter_WhenHasNewTitle_Send(){
    	Library library = new Library();
    	boolean rs = library.sendNewsLetter();
    	
    	Assert.assertTrue(rs);
    }
    
    @Test 
    public void testListNewTitles_WhenNewTitlesAreAvailable(){
    	Library library = new Library();
    	library.setLastNewsLetterDate(new Date());
    	library.addDvd(new Dvd());
    	List<Dvd> dvds = library.listNewTitles();
    	
    	Assert.assertFalse(dvds.isEmpty());
    }
    
    @Test
    public void testListNewTitles_AllTitlesAreNewerThanNewsletter(){
    	Library library = new Library();
    	List<Dvd> dvds = library.listNewTitles();
    	Date lastNewsletterDate = library.getLastNewsletterDate();
    	
    	for (Dvd dvd : dvds) {
    		Assert.assertTrue(dvd.isReleasedAfter(lastNewsletterDate));
    	}
    }
}
