package com.playfish.controller;

import com.playfish.view.LibraryView;

public class LibraryController {

	private LibraryView _view;
	
	private DonationController _donationController;
	
	public void setView(LibraryView view)
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
}
