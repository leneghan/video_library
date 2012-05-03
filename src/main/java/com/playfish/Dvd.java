package com.playfish;

import java.util.ArrayList;
import java.util.Date;

public class Dvd {

	private Date dateAdded;

	public boolean isReleasedAfter(Date lastNewsletterDate) {
		return dateAdded.after(lastNewsletterDate);
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

    private final ArrayList<Copy> copies = new ArrayList<Copy>();

    public Dvd(String title, String year, String director) {
        Copy copy = new Copy();
        copies.add(copy);
    }

    public boolean isAvailable() {
        return copies.get(copies.size() - 1).isAvailable();
    }

	public Copy borrow(Member member) {
		
		Copy result = new Copy();
		result.onLoanTo = member;
		return result;
	}
}
