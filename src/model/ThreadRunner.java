/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.logging.Level;
import java.util.logging.Logger;
import view.TrackView;

/**
 *
 * @author Yelson
 */
public class ThreadRunner extends Thread implements CONSTANTS{    
    
    private int sleepTime;
    private Figure figure;
    private int speed;
    private int x;
    private int y;

    public ThreadRunner(int pPosX, int pPosY, int pSpeed, boolean pShowImage){
        figure = new Figure(pPosX ,pPosY, pSpeed, pShowImage); //posX tiene que * la "metrica"
        speed = pSpeed;
        x = pPosX; //aqui es la posicion del carril
        y = pPosY;
    }
    public void breakRunner(){
        try {
            Thread.sleep(50);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadRunner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void run(){
        try{
            //Thread.sleep(500);
            while(true){
                figure.move();
                Thread.sleep(speed*25);
            }
        }catch (InterruptedException ex) {
            Logger.getLogger(TrackView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Getters and Setters
     public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public Figure getFigure(){
        return this.figure;
    }
}
