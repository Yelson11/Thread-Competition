/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;
import view.TrackView;

/**
 *
 * @author Yelson
 */
public class ThreadController extends Thread implements CONSTANTS{
    
    private boolean showImages;
    private Track track;
    private int direction;
    private int quantity;
    private int speed;
    private boolean state;
    
     public ThreadController(){
        track = Track.getInstance();
        direction = 1;
        showImages = false;
        state = true;
    }
     
    //Este metodo debe verificar los carriles disponibles y etc
    public void insertRunners(int pQuantity, int pSpeed){
        quantity = pQuantity;
        speed = pSpeed;     
    }
    
    public void changeImageStatus(boolean pStatus){
        track.changeImageStatus(pStatus);
    }
    
    public void run(){
        try{
            for (int i = 0; i < quantity; i++){   //esto hay que cambiarlo, es una chanchada
                int num = (int)(Math.random() * 11 + 1) - 1;
                track.addFigure(num, direction, speed, showImages); // posX, posY, speed
                int index = track.getListTrack()[num].getRunnerList().size()-1;
                startRunner(track.getListTrack()[num].getRunnerList().get(index)); //Inicia el hilo que acaba de insertar
            }
            quantity = 0;
        }catch (InterruptedException ex) {
            Logger.getLogger(TrackView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void stopThread(){
        Lane[] listTrack = track.getListTrack();
        for(int i = 0; i < listTrack.length; i++){
            ArrayList<ThreadRunner> threads = listTrack[i].getRunnerList();
            for(int j = 0; j < threads.size(); j++){
                int num = threads.get(j).getFigure().getPosY();
                if (num < -30 || num > WINDOW_WIDTH + 30 ){
                    threads.get(j).stop();
                    threads.remove(threads.get(j));
                }
            }
        }
    }
    
    public void suspendThreads(){
        Lane[] listTrack = track.getListTrack();
        for(int i = 0; i < listTrack.length; i++){
            ArrayList<ThreadRunner> threads = listTrack[i].getRunnerList();
            for(int j = 0; j < threads.size(); j++){
                threads.get(j).suspend();
            }
        }
    }
    
    public void resumeThreads(){
        Lane[] listTrack = track.getListTrack();
        for(int i = 0; i < listTrack.length; i++){
            ArrayList<ThreadRunner> threads = listTrack[i].getRunnerList();
            for(int j = 0; j < threads.size(); j++){
                threads.get(j).resume();
            }
        }
    }
    
    public void stateThread(){
        if (state){
            this.suspendThreads();
            this.suspend();
            state = false;
        }
        else{
            this.resumeThreads();
            this.resume();
            state = true;
        }
           
    }
    
    public void startRunner(ThreadRunner pThread) throws InterruptedException{
        pThread.start();
        Thread.sleep(1000);
    }

    public void revert(){
        direction*= -1;
        track.revertDirection();
    }
    
    
    //Getters and Setters
    public boolean isShowImages() {
        return showImages;
    }

    public void setShowImages(boolean showImages) {
        this.showImages = showImages;
    }

    public Track getTrack() {
        return track;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

}
