package com.playfish.model;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.easymock.EasyMock;
import org.junit.Test;

import com.playfish.model.Dvd;
import com.playfish.model.Library;

public class LibraryUnitTest {

    @Test 
    public void testListNewTitles_WhenNewTitlesAreAvailable(){
    	Library library = new Library();
    	library.setLastNewsLetterDate(new Date());
    	library.submitDvd("title", "year", "director");
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
