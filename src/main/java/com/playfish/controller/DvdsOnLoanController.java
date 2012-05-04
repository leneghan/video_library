package com.playfish.controller;

import java.util.ArrayList;
import java.util.List;

import com.playfish.model.Copy;
import com.playfish.model.Dvd;
import com.playfish.model.Member;

public class DvdsOnLoanController {
    
    private Member member;

    public DvdsOnLoanController(Member member) {
        this.member = member;
    }

    public List<Dvd> getDvdsOnLoan() {
        ArrayList<Dvd> dvds = new ArrayList<Dvd>();
        for (Copy copy : this.member.getCopiesLoaned()) {
            dvds.add(copy.copyOf);
        }
        return dvds;
    }

    public void returnDvd(final int selectedIndex) {
        getDvdsOnLoan().get(selectedIndex).returnDvd(this.member);
        
    }
}
