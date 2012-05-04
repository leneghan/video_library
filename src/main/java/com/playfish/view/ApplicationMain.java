package com.playfish.view;

import javax.swing.JFrame;

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
    }

}
