
package com.playfish.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.playfish.controller.DvdDonationListener;
import com.playfish.controller.HomeListener;
import com.playfish.model.Library;

public class DonateMain extends JFrame {

    private DonationView donationView = new DonationView();
    private DvdViewPanel dvdViewPanel = new DvdViewPanel();


    private CardLayout cardLayout = new CardLayout();
    
    
    private JButton donateButton = new JButton("Donate");
    private JButton borrowButton = new JButton("Borrow");
    JPanel centerPanel = new JPanel(cardLayout);
    
    public DonateMain()
    {
        this.getContentPane().add(centerPanel, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        //JPanel centerPanel = new JPanel(cardLayout);
     
     
        
        
        JPanel panel = new JPanel();
        panel.add(donateButton);
        panel.add(borrowButton);
        
        
        centerPanel.add(panel, "home");
        centerPanel.add(donationView, "donation");
        centerPanel.add(dvdViewPanel, "borrow");
        
        donateButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				 cardLayout.show(centerPanel, "donation");
			}
        	
        });
        
        borrowButton.addActionListener(new ActionListener(){

   			@Override
   			public void actionPerformed(ActionEvent arg0) {
   				

   			 cardLayout.show(centerPanel, "borrow");
   				
   			}
           	
           });
        
        this.donationView.setDvdBorrowListener(new DvdDonationListener(new Library(null)));
        this.donationView.setHome(new HomeListener(){

			@Override
			public void onHome() {
				 cardLayout.show(centerPanel, "home");
	   				
			}
        	
        });
        
        //dvdViewPanel.displayDvd(new Dvd("star wars", "1977", "george lucas"), new Member(""));
    }


    public static void main(String args[]){

    	DonateMain main = new DonateMain();
        main.setBounds(200, 200, 400, 400);
        main.show();
    }




}