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
    private boolean stateMove;
    private boolean barrier;

    public ThreadRunner(int pPosX, int pPosY, int pSpeed, boolean pShowImage){
        figure = new Figure(pPosX ,pPosY, pSpeed, pShowImage); //posX tiene que * la "metrica"
        speed = pSpeed;
        x = pPosX; //aqui es la posicion del carril
        y = pPosY;
        stateMove = true;
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
            while(true){
                if (stateMove){ 
                    if (!(barrier && figure.getPosY() == STREET_VERTICAL_SCALE+20) && figure.getDirection()!=1){
                        figure.move();
                        Thread.sleep(speed*25);
                    }
                    //else if (!(barrier && figure.getPosY() == STREET_VERTICAL_SCALE-25) && figure.getDirection()==1){
                    else if (!(barrier && figure.getPosY() == STREET_VERTICAL_SCALE-50) && figure.getDirection()==1){
                        figure.move();
                        Thread.sleep(speed*25);
                    }
                    else
                        Thread.sleep(125);
                }else{
                    if(!barrier){
                        stateMove = true;
                    }
                    Thread.sleep(125);
                }
            }
        }catch (InterruptedException ex) {
            Logger.getLogger(TrackView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    //Getters and Setters
     public int getSpeed() {
        return speed;
    }
     
    public void setStateMove(boolean state){
        stateMove = state;
    }
    
    public boolean getStateMove(){
        return stateMove;
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

    public void setBarrier(boolean barrier) {
        this.barrier = barrier;
    }
    
    public void changeBarrier() {
        this.barrier = !barrier;
    }
    
}
