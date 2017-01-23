package com.taz;
/**
 * Created by  Maninesan on 12/06/16.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends JFrame {
    private static JPanel panel1;
    private JButton normalButton = new JButton();
    private JButton stackButton = new JButton();
    private JButton outOfMemoryButton = new JButton();


    private JTextArea textArea = new JTextArea();

    public GUI() {
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(40, 400, 200, 100);

        // Buttons setbounds
        normalButton.setBounds(40, 100, 200, 80);
        normalButton.setText("Normal");
        stackButton.setBounds(40, 200, 200, 80);
        stackButton.setText("StackOverFlow");
        outOfMemoryButton.setBounds(40, 300, 200, 80);
        outOfMemoryButton.setText("Out of Memory");


        panel1 = new JPanel(new BorderLayout());
        normalButton.setEnabled(true);
        stackButton.setEnabled(true);
        outOfMemoryButton.setEnabled(true);
        // JPanel bounds
        panel1.setBounds(0, 0, 600, 400);

        //JFrame layout
        this.setLayout(null);

        //JPanel layout
        panel1.setLayout(null);
        // Adding to JFrame
        panel1.add(outOfMemoryButton);
        panel1.add(stackButton);
        panel1.add(normalButton);


        panel1.add(scrollPane);
        add(panel1);

        // JFrame properties
        setSize(300, 500);
        setBackground(Color.BLACK);
        setTitle("GC Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


        normalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getActionCommand());
//                MemoryLeakGenerator.startAnomalous();
                MemoryLeakGenerator.startNormal();
            }


        });

        stackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getActionCommand());
//                StackOverflowErrorRunner.start();
                MemoryLeakGenerator.startAnomalous();
            }
        });

        outOfMemoryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getActionCommand());
//                OutOfMemoryHeapSpaceRunner.start();
                MemoryLeakGenerator.startAnomaly3();
            }
        });

    }



    public static void main(String[] args) {

        new GUI();



    }
}
