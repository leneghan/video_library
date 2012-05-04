package com.playfish.model;

import junit.framework.Assert;

import org.junit.Test;

public class BorrowAcceptanceTest {

	@Test(expected = NoCopiesException.class)
	public void given_ASelectedDVDWithOneCopy_WhenBorrowed_ThenThatCopyIsMarkedAsOnLoanToMeAndThereAreNoMoreAvailable() 
	{
		Member memberA = new Member("email@domain.com");
		Dvd dvd = new Dvd("Title","Year", "Director");
		
		Copy dvdCopy = dvd.borrow(memberA);
		Assert.assertTrue(dvdCopy.onLoanTo(memberA));
		
		Copy secondDvdCopy = dvd.borrow(memberA);
	}

}
