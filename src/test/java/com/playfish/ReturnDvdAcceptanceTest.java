package com.playfish;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;


public class ReturnDvdAcceptanceTest {

    private Member memberA;
    private Dvd dvd;

    @Before
    public void setup()
    {
        this.memberA = new Member();
        this.dvd = new Dvd("Star Wars", "1977", "George Lucas");
    }

    @Test
    public void givenMemeberHasCopyOnLoan_whenItIsReturned_thenItBecomesAvailable() {
        Copy copyOnLoan = dvd.borrow(memberA);
        dvd.returnDvd(memberA);
        assertThat(copyOnLoan.isAvailable(), is(true));
    }

}
