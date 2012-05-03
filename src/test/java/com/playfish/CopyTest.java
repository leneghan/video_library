package com.playfish;

import junit.framework.Assert;
import org.junit.Test;

public class CopyTest  {

    @Test
    public void test_IfMemberABorrowsCopy_CopyIsOnLoanToMemberA()
    {
        Member memberA = new Member();
        
        Copy dvdCopy = new Copy();
        
        dvdCopy.borrow(memberA);


        Assert.assertTrue(dvdCopy.onLoanTo == memberA);
    }
    
    @Test
    public void test_IfMemberAReturnsCopy_CopyIsNotOnLoanToMemberA()
    {
        Member memberA = new Member();
        
        Copy dvdCopy = new Copy();

        dvdCopy.borrow(memberA);
        dvdCopy.returnCopy();


        Assert.assertNull(dvdCopy.onLoanTo);
    }

}
