package com.playfish;

import junit.framework.TestCase;

public class DVDTest extends TestCase {

	public void test_IfBorrowDVD_ThenRecieveACopy()
	{
		Member memberA = new Member();
		Dvd dvd = new Dvd();
		
		Copy dvdCopy = dvd.borrow(memberA);
		
		assertNotNull(dvdCopy);
	}
	
	public void test_IfMEmberABorrowsDVD_ThenRecieveACopy_LoanedToMemberA()
	{
		Member memberA = new Member();
		Dvd dvd = new Dvd();
		
		Copy dvdCopy = dvd.borrow(memberA);
		
		assertTrue(dvdCopy.onLoanTo == memberA);
	}
}
