package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.lang.Math.*;

import static java.lang.Math.*;

public class Panel extends JPanel {

    public ArrayList<Kula> listaKul;
    public int size = 50;
    private Timer timer;
    private final int DELAY = 33; //dla 30fps ls/30=0,033s
    boolean isEntered;



    public Panel() {

        listaKul = new ArrayList<>();
        setBackground(Color.BLACK);

        addMouseListener(new Listener(this));//,new Panel2()));
        addMouseMotionListener(new Listener(this));//,new Panel2()));
        addMouseWheelListener(new Listener(this));//,new Panel2()));

        timer = new Timer(DELAY, new Listener(this));//,new Panel2()));
        timer.start();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Kula k : listaKul) {
            g.setColor(k.kolor);
            g.fillOval(k.x - (k.size / 2), k.y - (k.size / 2), k.size, k.size);
        }
        //licznik kul
        g.setColor(Color.YELLOW);
        g.drawString(Integer.toString(listaKul.size()), 40, 40);

    }


    boolean isSpaceEmpty(Kula k2) {
        double distX, distY, dist;

        if (listaKul != null) {
            for (Kula k : listaKul) {
                distX = abs(k.x - k2.x);
                distY = abs(k.y - k2.y);
                dist = sqrt(pow(distX, 2) + pow(distY, 2));

                if (dist - 3 <= (k2.size / 2.0 + k.size / 2.0) ||  k2.x - (size / 2) <= 0 || k2.x + (size / 2) >= getWidth() || k2.y - (size / 2) <= 0 || k2.y + (size / 2) >= getHeight())
                    return false;
            }
        }
        return true;
    }



}





