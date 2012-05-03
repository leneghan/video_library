package com.playfish;

import junit.framework.Assert;
import org.junit.Test;

public class CopyTest  {

    @Test
    public void givenAvailableCopy_whenMemberBorrowsCopy_thenCopyIsOnLoanToMember()
    {
        Member memberA = new Member();
        
        Copy dvdCopy = new Copy();
        
        dvdCopy.borrow(memberA);


        Assert.assertTrue(dvdCopy.onLoanTo() == memberA);
    }
    
    @Test
    public void givenMemberWithCopyOnLoan_whenMemberReturnsCopy_thenCopyIsNoLongerOnLoan()
    {
        Member memberA = new Member();
        
        Copy dvdCopy = new Copy();

        dvdCopy.borrow(memberA);
        dvdCopy.returnCopy();


        Assert.assertNull(dvdCopy.onLoanTo());
    }

}
