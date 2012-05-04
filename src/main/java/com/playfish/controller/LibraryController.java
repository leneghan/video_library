package com.playfish.controller;

import com.playfish.model.Library;
import com.playfish.model.Newsletter;
import com.playfish.view.DefaultLibraryView;


public class LibraryController {

    private Library library;
	//private DefaultLibraryView view;
	
	public LibraryController(Library library) {
        this.library = library;
    }
	
	private DonationController _donationController;
	
	public void setView(DefaultLibraryView view)
	    {
	    //  this.view = view;
	}

    public void triggerDotateDvd()
	{
		_donationController.showDonation();
	}
	
	public void setDonationController(DonationController donationController)
	{
		_donationController = donationController;
	}

    public Newsletter triggerSendNewsletter() {
        Newsletter newsLetter = library.sendNewsLetter();
        return newsLetter;
        
    }
}
