package com.playfish;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class DvdUnitTest {

	Member memberA;
	Dvd dvd;

	@Before
	public void setup()
	{
		this.memberA = new Member();
		this.dvd = new Dvd("star wars", "1977", "George Lucas");
	}

    @Test
    public void testYearIsSetCorrectly()
    {
        assertEquals("year is incorrect", "1977", dvd.getYear());
    }

    @Test
    public void testTitleIsSetCorrectly()
    {
        assertEquals("title is incorrect", "star wars", dvd.getTitle());
    }

    @Test
    public void testDirectorIsSetCorrectly()
    {
        assertEquals("director is incorrect", "George Lucas", dvd.getDirector());
    }

    @Test
    public void shouldCreateDvdWithCopy(){
        Dvd dvd = new Dvd("title", "1990", "director");

        assertTrue("A dvd copy should be available", dvd.isAvailable());

    }
    
	@Test
	public void test_IfBorrowDVD_ThenRecieveACopy()
	{	
		Copy dvdCopy = dvd.borrow(memberA);
		
		Assert.assertNotNull(dvdCopy);
	}
	
	@Test
	public void test_IfMemberABorrowsDVD_ThenRecieveACopy_LoanedToMemberA()
	{	
		Copy dvdCopy = dvd.borrow(memberA);
		
		Assert.assertEquals(dvdCopy.onLoanTo(), memberA);
	}

	@Test
	public void test_IfMemberABorrowsDVD_ThenNoMoreCopiesAreAvailable()
	{
		dvd.borrow(memberA);
		
		Copy dvdCopy = dvd.borrow(memberA);
		
		Assert.assertNull(dvdCopy);
	}
	
	@Test
	public void test_IfMemberABorrowsDVD_ThenCopyIsACopyOfDVD()
	{
		Copy dvdCopy = dvd.borrow(memberA);
		
		Assert.assertTrue(dvdCopy.copyOf == dvd);
	}
}
