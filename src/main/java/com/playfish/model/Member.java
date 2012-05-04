package com.playfish.model;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String email;
    private List<Copy> copiesLoaned = new ArrayList<Copy>();

    public List<Copy> getCopiesLoaned() {
        return copiesLoaned;
    }

    public String getEmail() {
        return email;
    }

    public Member(String email) {
        this.email = email;
    }
    
    public void addCopyLoaned(Copy newCopy) {
        copiesLoaned.add(newCopy);
    }
    
    public void removeCopyLoaned(Copy copy) {
        copiesLoaned.remove(copy);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
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
        Member other = (Member) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        return true;
    }

    public static final Member NULL_MEMBER = new Member("");

}
