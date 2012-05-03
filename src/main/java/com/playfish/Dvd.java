package com.playfish;

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
}
