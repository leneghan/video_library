package com.playfish.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.playfish.controller.DvdDonationListener;
import com.playfish.controller.HomeListener;
import com.playfish.model.Dvd;
import com.playfish.model.Member;

public class DonationView extends JPanel{

    private DvdDonationListener dvdDonationListener;//= new DvdDonationListener();
    //private Dvd dvd;
    private Member member;
    private JButton button =  new JButton("Donate");
    private JButton homeButton =  new JButton("Home");
    private JTextField title = new JTextField();
    private JTextField year = new JTextField();
    private JTextField director = new JTextField();

    public DonationView(){


        this.setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel(new GridLayout(3, 1));
        centerPanel.setBackground(Color.LIGHT_GRAY);
        centerPanel.add(title);
        centerPanel.add(year);
        centerPanel.add(director);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(button);
        bottomPanel.add(homeButton);
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (dvdDonationListener != null){
                	dvdDonationListener.onDonateDvd(new Dvd(title.getText(), year.getText(), director.getText()));
                    //button.setEnabled(dvd.isAvailable());
                }
            }
        });

        homeButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				home.onHome();
				
			}
        	
        });
        
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
    }

//    public void displayDvd(Dvd dvd, Member member)
//    {
//        this.member = member;
//        this.dvd = dvd;
//        button.setEnabled(dvd.isAvailable());
//        title.setText(dvd.getTitle());
//        year.setText(dvd.getYear());
//        director.setText(dvd.getDirector());
//
//    }


    public void setDvdBorrowListener(DvdDonationListener listener)
    {
        this.dvdDonationListener =  listener;

    }

    private HomeListener home;
    
    public void setHome(HomeListener home) {
		this.home = home;
	}


}
