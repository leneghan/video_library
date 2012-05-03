package com.playfish;

import junit.framework.Assert;

import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class DVDTest {

    Member memberA;
    Dvd dvd;

    @Before
    public void setup() {
        this.memberA = new Member();
        this.dvd = new Dvd("", "", "");
    }

    @Test
    public void test_IfBorrowDVD_ThenRecieveACopy() {
        Copy dvdCopy = dvd.borrow(memberA);

        Assert.assertNotNull(dvdCopy);
    }

    @Test
    public void test_IfMemberABorrowsDVD_ThenRecieveACopy_LoanedToMemberA() {
        Copy dvdCopy = dvd.borrow(memberA);

        Assert.assertTrue(dvdCopy.onLoanTo() == memberA);
    }

    public void test_IfMemeberHasCopyOnLoan_ItCanBeFoundFromDvd() {
        Copy copyOnLoan = dvd.borrow(memberA);
        Copy foundCopy = dvd.findCopy(memberA);
        
        assertThat(foundCopy, is(equalTo(copyOnLoan)));
    }
}
