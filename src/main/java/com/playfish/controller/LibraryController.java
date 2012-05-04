package com.playfish.controller;

import com.playfish.view.DefaultLibraryView;


public class LibraryController {

	private DefaultLibraryView _view;
	
	private DonationController _donationController;
	
	public void setView(DefaultLibraryView view)
	{
		_view = view;
	}
	
	public void triggerDotateDvd()
	{
		_donationController.showDonation();
	}
	
	public void setDonationController(DonationController donationController)
	{
		_donationController = donationController;
	}

    public void triggerSendNewsletter() {
        
    }
}
