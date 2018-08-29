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

public class ThreadController extends Thread implements CONSTANTS{
    
    private boolean showImages;
    private Track track;
    private int direction;
    private boolean insert;
    private ThreadCreator[] threadPool;
    private boolean state;
    
    //Singleton Pattern
    private static ThreadController controller;
    
     private ThreadController(){
        track = Track.getInstance();
        direction = 1;
        showImages = false;
        state = true;
        insert = true;
        threadPool = new ThreadCreator[3];
        for(int i = 0; i < 3; i++){
            threadPool[i] = new ThreadCreator(i+1, direction, showImages);
            threadPool[i].start();
        }
    }
     
    public static ThreadController getInstace() {
        if(controller == null){
            controller = new ThreadController();
        }
        return controller;
    }
     
    //---------------------------------------------|
      
    public void changeImageStatus(boolean pStatus){
        track.changeImageStatus(pStatus);
        for(int i = 0; i < 3; i++){
            threadPool[i].setShowImages(pStatus);
        }
    }
    public void simulateThreads(){
        int quantity = (int)((Math.random())*MAX_THREADS + 1);
        int speed = (int)((Math.random())*3 + 1);
        createThreads(quantity, speed);
    }
    public void createThreads(int pQuantity, int pSpeed){
        threadPool[pSpeed-1].setQuantity(pQuantity);
    }
    
    public void controlCollision(){
        track.controlCollision();
    }
    
    public void controlMove(){
        track.controlMove();
    }
    
    public void suspendThreads(){ // pone en espera todos los threads 
        track.suspendThreads();
        for (ThreadCreator threadPool1 : threadPool) 
            threadPool1.suspend(); // para que deje de crear
    }
    
    public void resumeThreads(){ //reanuda todos los threads
        track.resumeThreads();
        for (ThreadCreator threadPool1 : threadPool)
            threadPool1.resume();   
    }
    
    public void stopThread(){ //Para el thread cuando termina la pista y lo elimina del ArrayList
        Lane[] listTrack = track.getListTrack();
        for (Lane listTrack1 : listTrack) {
            ArrayList<ThreadRunner> threads = listTrack1.getRunnerList();
            for(int j = 0; j < threads.size(); j++){
                int posY = threads.get(j).getFigure().getPosY();
                if (posY < -52 || posY > WINDOW_WIDTH + 30 ){
                    threads.get(j).stop();
                    threads.remove(threads.get(j));
                }
            }
        }
    }
    
    public void stateThread(){
        if (state){
            this.suspendThreads();
            this.suspend();
            state = !state;
        }
        else{
            this.resumeThreads();
            this.resume();
            state = !state;
        }
    }

    public void revert(){
        direction*= -1;
        track.revertDirection();
        for(int i = 0; i < 3; i++)
            threadPool[i].setDirection(direction);
    }
    
    @Override
    public void run(){
        while(true){
            stopThread();
            controlCollision();
            controlMove();
            try{
                Thread.sleep(50);   
            }catch(Exception e){}
        }
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

    public ThreadCreator[] getThreadPool() {
        return threadPool;
    }

}
