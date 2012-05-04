package com.playfish.controller;

import com.playfish.model.Dvd;
import com.playfish.model.Member;

public class DvdBorrowListener {

    public void onDvdBorrowed(Member member, Dvd dvd){
        dvd.borrow(member);
    }
}
