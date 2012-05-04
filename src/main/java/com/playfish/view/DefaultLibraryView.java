package com.playfish.view;

import javax.swing.JPanel;

import com.playfish.controller.LibraryController;
import com.playfish.model.Library;
import com.playfish.model.Newsletter;

public class DefaultLibraryView extends JPanel{

	private Library library;
	private LibraryController controller;
	
	public DefaultLibraryView(Library library)
	{
		this.library=  library;
		this.controller = new LibraryController(library);
	}
	
	public void onClickDontate()
	{
		controller.triggerDotateDvd();
	}
	
	public void onClickSendNewsletter()
	{
	    Newsletter newsLetter = controller.triggerSendNewsletter();
	}
}
