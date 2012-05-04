package com.playfish;

public class Member {
    private String email;

    public String getEmail() {
        return email;
    }

    public Member(String email) {
        this.email = email;
    }

    public static final Member NULL_MEMBER = new Member("");

}
