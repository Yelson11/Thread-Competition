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
    
    public boolean f = true;
    private int speed;
    private int x;
    private int y;

    public ThreadRunner(int pPosX, int pPosY, int pSpeed){
        speed = pSpeed;
        x = pPosX;
        y = pPosY;
    }
    public void run(){
        try{
            while(true){
                while(y<WINDOW_HEIGHT-30){
                    Thread.sleep(5 * speed);
                    y+=1;
                }
                while(y>10){
                    Thread.sleep(5 * speed);
                    y-=1;                   
                }
                f = !f;
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
}
