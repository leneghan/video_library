package com.playfish;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;

public class DvdUnitTest {

	Member memberA;
	Dvd dvd;
	
	@Before
	public void setup()
	{
		this.memberA = new Member();
		this.dvd = new Dvd("","","");
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

}
