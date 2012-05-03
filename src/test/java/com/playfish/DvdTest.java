package com.playfish;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class DvdTest {
	
	@Test
	public void testIsReleasedAfter_WhenDateIsBefore() {
		Dvd dvd = new Dvd();
		Date dateAdded = new Date(1336056415000l);
		dvd.setDateAdded(dateAdded);
		Date dateNow = new Date(1336056415005l);
		
		Assert.assertFalse(dvd.isReleasedAfter(dateNow));
		
		
	}

}
