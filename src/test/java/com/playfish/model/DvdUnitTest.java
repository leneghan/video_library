package com.playfish.model;

import com.google.common.base.Optional;
import com.playfish.model.*;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class DvdUnitTest {

	Member memberA;
	Dvd dvd;

	@Before
	public void setup()
	{
		this.memberA = new Member("a@gmail.com");
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
    public void test_IfBorrowDvd_ThenRecieveACopy() {
        Copy dvdCopy = dvd.borrow(memberA);

        Assert.assertNotNull(dvdCopy);
    }

    @Test
    public void test_IfMemberABorrowsDvd_ThenRecieveACopy_LoanedToMemberA() {
        Copy dvdCopy = dvd.borrow(memberA);

        Assert.assertTrue(dvdCopy.onLoanTo(memberA));
    }

    public void test_IfMemeberHasCopyOnLoan_ItCanBeFoundFromDvd() {
        Copy copyOnLoan = dvd.borrow(memberA);
        Optional<Copy> foundCopy = dvd.findCopy(memberA);
        
        assertThat(foundCopy.get(), is(equalTo(copyOnLoan)));
    }
    
    @Test
    public void test_IfMemeberHasCopyOnLoan_ItCanBeReturned() {
        Copy copyOnLoan = dvd.borrow(memberA);
        dvd.returnDvd(memberA);
        assertThat(copyOnLoan.isAvailable(), is(true));
    }

    @Test(expected = NoCopiesException.class)
	public void test_IfMemberABorrowsDVD_ThenNoMoreCopiesAreAvailable()
	{
		dvd.borrow(memberA);
		
		Copy dvdCopy = dvd.borrow(memberA);
	}
	
	@Test
	public void test_IfMemberABorrowsDVD_ThenCopyIsACopyOfDVD()
	{
		Copy dvdCopy = dvd.borrow(memberA);
		
		Assert.assertTrue(dvdCopy.copyOf == dvd);
	}
}
