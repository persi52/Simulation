package com.company;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Files {

   String f;
   ArrayList<Kula> balls;


    public Files(String filename){
       this.f = filename;
       this.balls = new ArrayList<>();
   }




    public void Write() throws IOException {

        FileWriter f = new FileWriter(this.f);

        for(Kula p : this.balls)
            f.write(p.x + " " + p.y + " "+ p.size +" \n");

        f.close();
    }
    public ArrayList<Kula> Read() throws IOException {

        FileReader file = new FileReader(f);
        Scanner scanner = new Scanner(file);
        //StringBuilder s = new StringBuilder();

        ArrayList<Kula> k = new ArrayList<>();

        while (scanner.hasNext()) {
            String x = scanner.next();
            String y = scanner.next();
            String size = scanner.next();
            k.add(new Kula(Integer.parseInt(x),Integer.parseInt(y),Integer.parseInt(size)));
            //System.out.println("Kula" + k.size()   + "X: " + k.get(k.size()-1).x + "Y: " + k.get(k.size()-1).y) ;

        }
        scanner.close();
        file.close();

        return k;

    }
    public void AddToBalls(Kula k){
        balls.add(k);
    }
    public ArrayList<Kula> getBalls(){
        return balls;
    }
    public int getBallsSize(){
        return balls.size();
    }
}
