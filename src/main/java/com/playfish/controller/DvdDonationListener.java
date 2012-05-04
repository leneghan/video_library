package com.playfish.controller;

import com.playfish.model.Dvd;
import com.playfish.model.Library;

public class DvdDonationListener {

	private Library library;
	
	public DvdDonationListener(Library library)
	{
		this.library = library;
	}
	
	public void onDonateDvd(Dvd dvd)
	{
		library.submitDvd(dvd.getTitle(), dvd.getYear(), dvd.getDirector());
	}

}
