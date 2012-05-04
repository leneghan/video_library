package com.playfish.view;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.playfish.controller.LibraryController;
import com.playfish.model.Library;
import com.playfish.model.Newsletter;

public class DefaultLibraryView extends JPanel{

	private Library library;
	private LibraryController controller;
	
	private JButton newsletterButton;
	
	public DefaultLibraryView(Library library)
	{
		this.library=  library;
		this.controller = new LibraryController(library);
		
		createNewsLetterButton();
	}
	
	public void onClickDontate()
	{
		controller.triggerDotateDvd();
	}
	
	public void onClickSendNewsletter()
	{
	    Newsletter newsLetter = controller.triggerSendNewsletter();
	}
	
	private void createNewsLetterButton(){
	    newsletterButton = new JButton();
	    newsletterButton.setText("Send NewsLetter");
	    newsletterButton.setLocation(new Point(100, 100));
	    this.add(newsletterButton);
	    newsletterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                onClickSendNewsletter();
            }
        });
	}
	
}
