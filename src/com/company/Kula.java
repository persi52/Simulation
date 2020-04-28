package com.company;

import java.awt.*;

import static java.lang.Math.*;
import static java.lang.Math.pow;

public class Kula {
    public int x, y, sizev,sizeh,size, xspeed, yspeed;
    public Color kolor;
    private final int MAX_SPEED = 10;
    public static Files f = new Files("test.txt");
    Panel p;

    public Kula(int x, int y, int size, Panel panel) {
        this.x = x;
        this.y = y;
        this.sizev = size;
        this.sizeh = size;
        this.size = size;
        this.p = panel;

        kolor = new Color((float) random(), (float) random(), (float) random());

        do {
            xspeed = (int) (random() * MAX_SPEED * 2 - MAX_SPEED);
            yspeed = (int) (random() * MAX_SPEED * 2 - MAX_SPEED);
        } while (xspeed == 0 || yspeed == 0);

    }
    public Kula(int x,int y, int size)
    {
        this.x = x;
        this.y = y;
        this.size = size;
        kolor = new Color((float) random(), (float) random(), (float) random());

    }

    public void update() {


        if (x - (size / 2) <= 0 || x + (size / 2) >= p.getWidth()) {

            xspeed = -xspeed;
        }

        if (y - (size / 2) <= 0 || y + (size / 2) >= p.getHeight())
            yspeed = -yspeed;

        x += xspeed;
        y += yspeed;

        for (Kula a : p.listaKul) { //dziękuje za te metode, fizyka is not my cup of tea :)

            if (!a.equals(this)) {

                double ax = (double) a.x + a.size / 2;
                double ay = (double) a.y + a.size / 2;
                double bx = (double) this.x +this.size / 2;
                double by = (double) this.y +this.size / 2;

                //SUMA PROMIENI R1 + R2
                double promien = (a.size / 2.0 + this.size / 2.0);

                //ODLEGŁOŚĆ PUNKTÓW NA PŁASZCZYŹNIE
                double dystans = sqrt(pow(ax - bx, 2.0) + pow(ay - by, 2.0));

                if (dystans <= promien) {

                    if (f.getBallsSize() < 40) {
                        f.AddToBalls(new Kula(this.x, this.y, this.size));
                        f.AddToBalls(new Kula(a.x, a.y, a.size));

                       // System.out.println(f.a.size());
                    }

                    a.xspeed *= -1;
                    a.yspeed *= -1;
                    this.xspeed *= -1;
                   this.yspeed *= -1;




                }
            }


       /* for (int i = 0; i < p.listaKul.size(); i++) {

            if(p.listaKul.get(i)!=this)
            {
                double distX, distY, dist;

                distX = abs(this.x - p.listaKul.get(i).x);
                distY = abs(this.y - p.listaKul.get(i).y);
                dist = sqrt(pow(distX, 2) + pow(distY, 2));


                if (dist <= ((p.listaKul.get(i).size) / 2.0 + this.size / 2.0)) {



                    int newSpeedX1 = (p.listaKul.get(i).xspeed * (p.listaKul.get(i).size - this.size) + (2 * p.listaKul.get(i).size * this.xspeed)) / (p.listaKul.get(i).size + this.size);
                    int newSpeedY1 = (p.listaKul.get(i).yspeed * (p.listaKul.get(i).size - this.size) + (2 * p.listaKul.get(i).size * this.yspeed)) / (p.listaKul.get(i).size + this.size);
                    int newSpeedX2 = (this.xspeed * (this.size - p.listaKul.get(i).size) + (2 * this.size * p.listaKul.get(i).xspeed)) / (p.listaKul.get(i).size + this.size);
                    int newSpeedY2 = (this.yspeed * (this.size - p.listaKul.get(i).size) + (2 * this.size * p.listaKul.get(i).yspeed)) / (p.listaKul.get(i).size + this.size);

                    p.listaKul.get(i).xspeed = newSpeedX1;

                    p.listaKul.get(i).yspeed = newSpeedY1;

                    this.xspeed = newSpeedX2;

                    this.yspeed = newSpeedY2;
                    }


                }


            }*/


        }

    }
    }
