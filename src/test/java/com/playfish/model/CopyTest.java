package com.playfish.model;

import junit.framework.Assert;

import org.junit.Test;

public class CopyTest  {

    @Test
    public void givenAvailableCopy_whenMemberBorrowsCopy_thenCopyIsOnLoanToMember()
    {
        Member memberA = new Member("a@gmail.com");
        
        Copy dvdCopy = new Copy();
        
        dvdCopy.borrow(memberA);


        Assert.assertTrue(dvdCopy.onLoanTo(memberA));
    }
    
    @Test
    public void givenMemberWithCopyOnLoan_whenMemberReturnsCopy_thenCopyIsNoLongerOnLoan()
    {
        Member memberA = new Member("a@gmail.com");
        
        Copy dvdCopy = new Copy();

        dvdCopy.borrow(memberA);
        dvdCopy.returnCopy();


        Assert.assertTrue(dvdCopy.onLoanTo(Member.NULL_MEMBER));
    }

}
