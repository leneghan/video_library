package com.playfish.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.playfish.controller.DvdBorrowListener;
import com.playfish.model.Dvd;
import com.playfish.model.Member;

public class DvdViewPanel extends JPanel{

    private DvdBorrowListener dvdBorrowListener = new DvdBorrowListener();
    private Dvd dvd;
    private Member member;
    private JButton button =  new JButton("Borrow");
    private JLabel title = new JLabel();
    private JLabel year = new JLabel();
    private JLabel director = new JLabel();

    public DvdViewPanel(){


        this.setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel(new GridLayout(3, 1));
        centerPanel.setBackground(Color.LIGHT_GRAY);
        centerPanel.add(title);
        centerPanel.add(year);
        centerPanel.add(director);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (dvdBorrowListener != null){
                    dvdBorrowListener.onDvdBorrowed(member, dvd);
                    button.setEnabled(dvd.isAvailable());
                }
            }
        });

        this.add(centerPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
    }

    public void displayDvd(Dvd dvd, Member member)
    {
        this.member = member;
        this.dvd = dvd;
        button.setEnabled(dvd.isAvailable());
        title.setText(dvd.getTitle());
        year.setText(dvd.getYear());
        director.setText(dvd.getDirector());

    }


    public void setDvdBorrowListener(DvdBorrowListener dvdBorrowListener)
    {
        this.dvdBorrowListener =  dvdBorrowListener;

    }



}
