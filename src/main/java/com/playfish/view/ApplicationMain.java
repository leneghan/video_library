package com.playfish.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.playfish.model.*;

public class ApplicationMain {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Before frame opened");
        JFrame frame = new JFrame();
        frame.setSize(600, 500);
        frame.setVisible(true);
        System.out.println(" After frame opened");
        
        EmailClient emailClient = new EmailClientImpl();
        Library library  = new Library(emailClient);
        JPanel libraryPanel = new DefaultLibraryView(library);
        
        frame.add(libraryPanel);
    }

}
