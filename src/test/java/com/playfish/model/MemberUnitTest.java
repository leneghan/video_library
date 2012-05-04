package com.playfish.model;

import org.junit.Assert;
import org.junit.Test;

public class MemberUnitTest {
    
    @Test
    public void givenMember_WhenBorrowsDvd_thenCopyIsIncludingInCopiesLoanedList() {
        Member memberA = new Member("a@gmail.com");
        Copy dvdCopy = new Copy();
        
        dvdCopy.borrow(memberA);
        
        Assert.assertTrue(memberA.getCopiesLoaned().contains(dvdCopy));
    }
    
    @Test
    public void givenMember_WhenReturnsDvd_thenCopyIsRemovedFromCopiesLoanedList() {
        Member memberA = new Member("a@gmail.com");
        Copy dvdCopy = new Copy();
        
        dvdCopy.borrow(memberA);
        Assert.assertTrue(memberA.getCopiesLoaned().contains(dvdCopy));
        
        dvdCopy.returnCopy();
        Assert.assertFalse(memberA.getCopiesLoaned().contains(dvdCopy));
    }

}
