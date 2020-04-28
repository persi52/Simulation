package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;


public class Listener implements MouseListener, ActionListener, MouseMotionListener, MouseWheelListener {

    Panel p;
    JFrame frame2;
    Panel2 panel2;

    public Listener(Panel panel){
        this.p = panel;
        this.frame2 = new JFrame("WIndow");

        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setLocation(1000,100);
        frame2.setPreferredSize(new Dimension(800,600));
        frame2.pack();
        frame2.setVisible(false);

    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {



    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        Kula k = new Kula(mouseEvent.getX(), mouseEvent.getY(), p.size,p);

        //System.out.println(p.isSpaceEmpty(k));

        if (p.isSpaceEmpty(k)) {
            p.listaKul.add(k);
        }

        p.repaint();


    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        p.isEntered = true;
        frame2.setVisible(false);
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

        p.isEntered = false;

        System.out.println(Kula.f.getBallsSize());




        try {


            if(Kula.f.getBallsSize()==40) // Przedstawienie kolizji się aktualizuje dopiero po 20 kolizjach
            {
            Kula.f.Write();

            Kula.f.getBalls().clear();

            panel2 = new Panel2(Kula.f.Read());

            frame2.setContentPane(panel2);

            frame2.setVisible(true);
            }
            else if(panel2!=null)
            {
                frame2.setVisible(true);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            e.printStackTrace();
        }



    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (p.isEntered) {


            for (Kula k : p.listaKul) {
                k.update();

                }
            }

        p.repaint();

        }





    @Override
    public void mouseDragged(MouseEvent mouseEvent) {


        Kula k = new Kula(mouseEvent.getX(), mouseEvent.getY(), p.size,p);

        if (p.isSpaceEmpty(k)) {
            p.listaKul.add(k);
        }

        p.repaint();

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent mouseEvent) {

        if (mouseEvent.getWheelRotation() < 0) p.size += 3;
        else p.size -= 3;


    }

}