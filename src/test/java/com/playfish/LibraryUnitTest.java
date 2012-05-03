package com.playfish;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Date;
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
    	library.setLastNewsLetterDate(new Date());
    	library.addDvd(new Dvd("title", "year", "director"));
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
