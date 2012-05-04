package com.playfish.view;

import org.easymock.EasyMock;
import org.junit.Test;

import com.playfish.controller.LibraryController;

public class LibraryViewUnitTest {

	@Test
	public void test_ClickingDonate_WillInvokeDonationAction() 
	{
		// Setup the controller and view.
		LibraryController libraryController = EasyMock.createMock("libraryController", LibraryController.class);
		DefaultLibraryView libraryView = new DefaultLibraryView(libraryController);
		
		// The controller is in record mode, so record behavior.
		libraryController.triggerDotateDvd();
		
		// Now change to replay state.
		EasyMock.replay(libraryController);
		
		// Start the test call.
		libraryView.onClickDontate();
		
		// Verify recorded behavior occoured.
		EasyMock.verify(libraryController);
	}
}