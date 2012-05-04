package com.playfish;

public class Copy {

    private Member onLoanTo;
	
    public Dvd copyOf;
  
    public void borrow(Member member) {

        onLoanTo = member;
    }

    public void returnCopy() {
        onLoanTo = null;
    }
    
    public Member onLoanTo()
    {
        return onLoanTo;
    }

    public boolean isAvailable() {
        return onLoanTo == null;
    }
}
