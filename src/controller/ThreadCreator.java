/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.ThreadRunner;
import model.Track;

public class ThreadCreator extends Thread{
    
    private Track track;
    private int quantity;
    private int speed;
    private int direction;
    private int createdQuantity;
    private boolean barrier;
    private boolean showImages;
    
    public ThreadCreator(int pSpeed, int pDirection, boolean pShowImages){
        track = Track.getInstance();
        speed = pSpeed;
        direction = pDirection;
        showImages = pShowImages;
        quantity = 0;
        createdQuantity = 0;
    }
    
    //Este metodo debe verificar los carriles disponibles y etc
    public void insertRunners() throws InterruptedException{
        
        int num = track.getLane();//(int)(Math.random() * 11 + 1) - 1;
        ThreadRunner threadRunner = track.addFigure(num, direction, speed, showImages); // posX, posY, speed 
        startRunner(threadRunner); //Inicia el hilo que acaba de insertar
        createdQuantity ++;
    }
    
    public void startRunner(ThreadRunner pThread) throws InterruptedException{
        pThread.start();
        Thread.sleep(800); //distancia entre las figuras de un mismo carril
    }
    
    public void run(){
        try{
            while(quantity >= createdQuantity){
                if(quantity == createdQuantity){
                    Thread.sleep(100);
                }else{
                    insertRunners();
                }
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    
    //Getters & Setters
    public Track getTrack() {
        return track;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int pQuantity) {
        this.quantity += pQuantity;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public boolean isShowImages() {
        return showImages;
    }

    public void setShowImages(boolean showImages) {
        this.showImages = showImages;
    }

    public int getCreatedQuantity() {
        return createdQuantity;
    }

    public void setCreatedQuantity(int createdQuantity) {
        this.createdQuantity = createdQuantity;
    }
    
}
