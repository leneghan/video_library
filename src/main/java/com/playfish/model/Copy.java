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
        member.addCopyLoaned(this);
    }

    public void returnCopy() {
        onLoanTo.removeCopyLoaned(this);
        onLoanTo = NULL_MEMBER;
    }
    
    public Boolean onLoanTo(Member member)
    {
        return onLoanTo.equals(member);
    }

    public boolean isAvailable() {
        return onLoanTo == NULL_MEMBER;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((copyOf == null) ? 0 : copyOf.hashCode());
        result = prime * result
                + ((onLoanTo == null) ? 0 : onLoanTo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Copy other = (Copy) obj;
        if (copyOf == null) {
            if (other.copyOf != null)
                return false;
        } else if (!copyOf.equals(other.copyOf))
            return false;
        if (onLoanTo == null) {
            if (other.onLoanTo != null)
                return false;
        } else if (!onLoanTo.equals(other.onLoanTo))
            return false;
        return true;
    }
}
