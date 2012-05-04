package com.playfish.view;

import com.playfish.controller.LibraryController;

public class DefaultLibraryView {

	private LibraryController _controller;
	
	public DefaultLibraryView(LibraryController controller)
	{
		_controller = controller;
	}
	
	public void onClickDontate()
	{
		_controller.triggerDotateDvd();
	}
	
	public void onClickSendNewsletter()
	{
	    _controller.triggerSendNewsletter();
	}
}
