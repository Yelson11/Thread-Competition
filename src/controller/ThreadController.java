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
    
     public ThreadController(){
        track = Track.getInstance();
        direction = 1;
        showImages = false;
    }
     
    //Este metodo debe verificar los carriles disponibles y etc
    public void insertRunners(int pQuantity, int pSpeed){
        quantity = pQuantity;
        speed = pSpeed;     
        /*
        try{
            for (int i = 0; i < pQuantity; i++){
                int num = 0; //(int)(Math.random() * 11 + 1) - 1;
                track.addFigure(num, direction, Speed); // posX, posY, speed
            //Inicia el hilo que acaba de insertar
                int index = track.getListTrack()[num].getRunnerList().size()-1;
                startRunner(track.getListTrack()[num].getRunnerList().get(index));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        */
    }
    
    public void changeImageStatus(boolean pStatus){
        track.changeImageStatus(pStatus);
    }
    
    public void run(){
        try{
            for (int i = 0; i < quantity; i++){
                int num = (int)(Math.random() * 11 + 1) - 1;
                track.addFigure(num, direction, speed, showImages); // posX, posY, speed
            //Inicia el hilo que acaba de insertar
                int index = track.getListTrack()[num].getRunnerList().size()-1;
                startRunner(track.getListTrack()[num].getRunnerList().get(index));
            }
            quantity = 0;
        }catch (InterruptedException ex) {
            Logger.getLogger(TrackView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void startRunner(ThreadRunner pThread) throws InterruptedException{
        Thread.sleep(1000);
        pThread.start();
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
