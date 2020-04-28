package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Panel2 extends JPanel {

    ArrayList<Kula> balls;


    public Panel2(ArrayList<Kula> balls){
        this.balls = balls;
        this.setBackground(Color.BLACK);

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

            for(Kula k : this.balls)
            {
            g.setColor(k.kolor);
            g.drawOval(k.x - (k.size / 2), k.y - (k.size / 2), k.size,k.size);
            }

    }

}
