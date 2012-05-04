package com.playfish.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.playfish.controller.DvdsOnLoanController;
import com.playfish.model.Dvd;

public class DvdsOnLoanJPanel extends JPanel {

    private JComboBox comboBox;

    /**
     * Create the panel.
     */
    public DvdsOnLoanJPanel(final DvdsOnLoanController controller) {
        setLayout(null);
        
        JButton btnNewButton = new JButton("Return DvD");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                controller.returnDvd(DvdsOnLoanJPanel.this.comboBox.getSelectedIndex());
            }
        });
        
        JButton btnLibraryButton = new JButton("To Library");
        btnLibraryButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                //TODO go to the other view
            }
        });
        
        btnNewButton.setBounds(326, 264, 107, 25);
        add(btnNewButton);
        
        btnLibraryButton.setBounds(14, 265, 144, 25);
        add(btnLibraryButton);
        
        comboBox = new JComboBox();
        
        for (Dvd dvd : controller.getDvdsOnLoan()) {
            comboBox.add(new JLabel(dvd.getTitle()));
        }
        
        comboBox.setBounds(149, 110, 146, 24);
        add(comboBox);
        
    }
}
