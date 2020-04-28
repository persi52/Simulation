package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main extends JFrame {



    public static void main(String[] args) throws IOException {


        JFrame frame = new JFrame("Moje okno!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Panel());
        frame.setPreferredSize(new Dimension(800,600));
        frame.pack();
        frame.setVisible(true);


    }
}
