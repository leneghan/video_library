package com.playfish.view;

import javax.swing.*;
import java.awt.*;

import com.playfish.model.Dvd;
import com.playfish.model.Member;

public class DvdMain extends JFrame {

    private DvdViewPanel dvdViewPanel = new DvdViewPanel();

    public DvdMain()
    {
        this.getContentPane().add(dvdViewPanel, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        dvdViewPanel.displayDvd(new Dvd("star wars", "1977", "george lucase"), new Member(""));
    }


    public static void main(String args[]){

        DvdMain main = new DvdMain();
        main.setBounds(200, 200, 400, 400);
        main.show();
    }




}
