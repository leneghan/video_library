package com.playfish;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;


public class DvdAcceptanceTest {

    private Member memberA;
    private Dvd dvd;

    @Before
    public void setup()
    {
        this.memberA = new Member("a@gmail.com");
        this.dvd = new Dvd("Star Wars", "1977", "George Lucas");
    }

    @Test
    public void test_IfMemeberHasCopyOnLoan_ItCanBeReturned() {
        Copy copyOnLoan = dvd.borrow(memberA);
        dvd.returnDvd(memberA);
        assertThat(copyOnLoan.isAvailable(), is(true));
    }

}
