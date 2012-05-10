package com.playfish;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Test;

import com.playfish.controller.DonationController;
import com.playfish.controller.LibraryController;

public class LibraryControllerUnitTest {

	@Test
	public void test_TriggeringDonateDvd_WillInvokeDonationController() {
		
		DonationController donationController = EasyMock.createMock("donationController", DonationController.class);
		
		donationController.showDonation();
		
		EasyMock.replay(donationController);
		
		LibraryController libraryController = new LibraryController();
		libraryController.setDonationController(donationController);
		libraryController.triggerDotateDvd();
		
		EasyMock.verify(donationController);
	}

}
