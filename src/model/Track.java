/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.imageio.ImageIO;

public class Track implements CONSTANTS {
    
    //Atributos
    private Lane[] listTrack = new Lane[LANE_QUANTITY];
    private Image barrierOff;
    private Image barrierOn;
    private ArrayList<Integer> listLane;
    private ArrayList<Integer> listLaneAux;
    
    //Singleton Pattern
    private static Track track;
    
    private Track(){
        listLane = new ArrayList<>();
        listLaneAux = new ArrayList<>();
        for (int i = 0; i < LANE_QUANTITY; i++ ){
            listTrack[i] = new Lane();
            listLane.add(i);
        }
        try{
            //Carga y arreglo del tamaño de las barreras
            barrierOff = ImageIO.read(new File("src/images/barrierOff.png"));
            barrierOn = ImageIO.read(new File("src/images/barrierOn.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static Track getInstance(){
        if(track == null){
            track = new Track();
        }
        return track;
    };
    //--------------------------------------|
    
    public void revertDirection(){
        for (int i = 0; i<LANE_QUANTITY; i++){
            track.getListTrack()[i].revert();
        }
    }
    
    public void drawBarriers(Graphics g) {
        for(int i = 0; i < this.listTrack.length; i++){
            if(this.listTrack[i].getBarrier())
                g.drawImage(barrierOn, 17 + (STREET_HORIZONTAL_SCALE * i), STREET_VERTICAL_SCALE, null);
            else
                g.drawImage(barrierOff, 17 + (STREET_HORIZONTAL_SCALE * i), STREET_VERTICAL_SCALE, null);   
        }
    }
     
    public void activateAllBarriers(){ //activa todas las barreras
        for (Lane listTrack1 : this.listTrack)
            listTrack1.setBarrier(true);
    }
    
    public void deactivateAllBarriers(){ //desactiva todas las barreras
        for (Lane listTrack1 : this.listTrack)
            listTrack1.setBarrier(false);
    }
    
    public void activateBarrier(int pLane){ //activa solo la barrera que se le indica
        this.listTrack[pLane].changeBarrierStatus();
    }
     
    //Crea y agrega cada thread al ArrayList del carril al que pertenece
    public ThreadRunner addFigure(int pLane, int pDirection, int pSpeed, boolean pShowImage){
        ThreadRunner threadRunner = new ThreadRunner(pLane, pDirection, pSpeed, pShowImage);
        threadRunner.setBarrier(listTrack[pLane].getBarrier());
        if (pDirection == 1)  //si va para abajo lo agrega al final
            listTrack[pLane].getRunnerList().add(threadRunner);
        else    //si va para arriba lo agrega al inicio
            listTrack[pLane].getRunnerList().add(0, threadRunner);
        return threadRunner;
    }
    
    public void changeImageStatus(boolean pStatus){
        for (int i = 0; i < LANE_QUANTITY; i++){
            for(int j = 0; j < listTrack[i].getRunnerList().size(); j++)
                listTrack[i].getRunnerList().get(j).getFigure().setShowImage(pStatus);
        }
    }
    
    public int getLane(){ //hace un aleatorio de los carriles y los va retornando 
        if (listLaneAux.isEmpty()){
            listLaneAux = (ArrayList<Integer>)listLane.clone();
            Collections.shuffle(listLaneAux);
        }
        int lane = listLaneAux.get(0);
        listLaneAux.remove(0);
        return lane;
    }
    
    public Lane[] getListTrack() {
        return listTrack;
    }

    public void setListTrack(Lane[] listTrack) {
        this.listTrack = listTrack;
    }
           
    public void controlCollision(){
        for (Lane listTrack1 : this.listTrack) 
            listTrack1.controlCollision();
    }
    
    public void controlMove(){
        for (Lane listTrack1 : this.listTrack) 
            listTrack1.controlMove();
    }
    
    public void suspendThreads(){
        for (Lane listTrack1 : this.listTrack) 
            listTrack1.suspendThreads();
    }
    
    public void resumeThreads(){
        for (Lane listTrack1 : this.listTrack) 
            listTrack1.resumeThreads();
    }
    
}
