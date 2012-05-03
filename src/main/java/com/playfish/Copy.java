package com.playfish;

public class Copy {

    public Member onLoanTo;

    public void borrow(Member member) {

        onLoanTo = member;

    }

    public void returnCopy() {
        onLoanTo = null;
    }

    public boolean isAvailable() {
        return onLoanTo == null;
    }
}
