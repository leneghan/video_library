package com.playfish.view;

import com.playfish.controller.LibraryController;

public class LibraryView {

	private LibraryController _controller;
	
	public LibraryView(LibraryController controller)
	{
		_controller = controller;
	}
	
	public void onClickDontate()
	{
		_controller.triggerDotateDvd();
	}
}
