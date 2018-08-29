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
    
     public ThreadController(){
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
      
    public void changeImageStatus(boolean pStatus){
        track.changeImageStatus(pStatus);
        for(int i = 0; i < 3; i++){
            threadPool[i].setShowImages(pStatus);
        }
    }
    
    public void createThreads(int pQuantity, int pSpeed){
        threadPool[pSpeed-1].setQuantity(pQuantity);
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
    
    public void controlCollision(){
        track.controlCollision();
    }
    
    public void controlCollision_Aux(){
        track.controlMove();
    }
    
    public void suspendThreads(){
        Lane[] listTrack = track.getListTrack();
        for(int i = 0; i < listTrack.length; i++){
            ArrayList<ThreadRunner> threads = listTrack[i].getRunnerList();
            for(int j = 0; j < threads.size(); j++){
                threads.get(j).suspend();
            }
        }
        for(int i = 0; i<threadPool.length; i++){
            threadPool[i].suspend();    // para que deje de crear
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
        for(int i = 0; i<threadPool.length; i++){
            threadPool[i].resume();   
        }
    }
    
    public void barrier(ArrayList<Integer> listNum){
        int size = listNum.size();
        for(int i = 0; i < size; i++){
            ArrayList<ThreadRunner> threads = track.getListTrack()[listNum.get(i)].getRunnerList();
            for(int j = 0; j < threads.size(); j++){
                //threads.get(j).suspend();
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

    public void revert(){
        direction*= -1;
        track.revertDirection();
        for(int i = 0; i < 3; i++){
            threadPool[i].setDirection(direction);
        }
    }
    
    @Override
    public void run(){
        while(true){
            stopThread();
            controlCollision();
            controlCollision_Aux();
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

}
