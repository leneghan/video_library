package com.playfish;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
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
    public void test_IfBorrowDvd_ThenRecieveACopy() {
        Copy dvdCopy = dvd.borrow(memberA);

        Assert.assertNotNull(dvdCopy);
    }

    @Test
    public void test_IfMemberABorrowsDvd_ThenRecieveACopy_LoanedToMemberA() {
        Copy dvdCopy = dvd.borrow(memberA);

        Assert.assertTrue(dvdCopy.onLoanTo() == memberA);
    }

    public void test_IfMemeberHasCopyOnLoan_ItCanBeFoundFromDvd() {
        Copy copyOnLoan = dvd.borrow(memberA);
        Copy foundCopy = dvd.findCopy(memberA);
        
        assertThat(foundCopy, is(equalTo(copyOnLoan)));
    }
    
    @Test
    public void test_IfMemeberHasCopyOnLoan_ItCanBeReturned() {
        Copy copyOnLoan = dvd.borrow(memberA);
        dvd.returnDvd(memberA);
        assertThat(copyOnLoan.isAvailable(), is(true));
    }

}
