package com.playfish;
import static com.playfish.Member.NULL_MEMBER;

public class Copy {

    private Member onLoanTo;

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
        return onLoanTo != NULL_MEMBER;
    }
}
