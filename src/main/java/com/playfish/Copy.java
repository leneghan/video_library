package com.playfish;

public class Copy {

	public Member onLoanTo;

	public void borrow(Member member) {

		onLoanTo = member;
		
	}

    public boolean isAvailable() {
        return onLoanTo == null;
    }
}
