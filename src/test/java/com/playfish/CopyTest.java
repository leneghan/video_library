package com.playfish;

import junit.framework.TestCase;

public class CopyTest extends TestCase {

	public void test_IfMemberABorrowsCopy_CopyIsOnLoadToMemberA()
	{
		Member memberA = new Member();
		
		Copy dvdCopy = new Copy();
		
		dvdCopy.borrow(memberA);
		
		assertTrue(dvdCopy.onLoanTo == memberA);
	}
}
