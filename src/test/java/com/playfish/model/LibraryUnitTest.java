package com.playfish.model;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.mockito.Mockito;

public class LibraryUnitTest {

    @Test 
    public void testListNewTitles_WhenNewTitlesAreAvailable(){
    	Library library = new Library(Mockito.mock(EmailClient.class, "emailClient"));
    	library.setLastNewsLetterDate(new Date());
    	library.submitDvd("title", "year", "director");
    	List<Dvd> dvds = library.listNewTitles();
    	
    	Assert.assertFalse(dvds.isEmpty());
    }
    
    @Test
    public void testListNewTitles_AllTitlesAreNewerThanNewsletter(){
    	Library library = new Library(Mockito.mock(EmailClient.class, "emailClient"));
    	List<Dvd> dvds = library.listNewTitles();
    	Date lastNewsletterDate = library.getLastNewsletterDate();
    	
    	for (Dvd dvd : dvds) {
    		Assert.assertTrue(dvd.isReleasedAfter(lastNewsletterDate));
    	}
    }
}
