package com.playfish.model;
import static com.playfish.model.Member.NULL_MEMBER;

public class Copy {

    private Member onLoanTo;
	
    public Dvd copyOf;

    public Copy() {
        this.onLoanTo = NULL_MEMBER;
    }

    public void borrow(Member member) {

        onLoanTo = member;
    }

    public void returnCopy() {
        onLoanTo = NULL_MEMBER;
    }
    
    public Boolean onLoanTo(Member member)
    {
        return onLoanTo.equals(member);
    }

    public boolean isAvailable() {
        return onLoanTo == NULL_MEMBER;
    }
}
