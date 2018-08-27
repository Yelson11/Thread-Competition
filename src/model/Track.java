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
import javax.imageio.ImageIO;


/**
 *
 * @author Yelson
 */
public class Track implements CONSTANTS {
    
    //Atributos
    private Lane[] listTrack = new Lane[LANE_QUANTITY];
    private Image barrierOff;
    private Image barrierOn;
    
    //Singleton Pattern
    private static Track track;
    
    private Track(){
        for (int i = 0; i < LANE_QUANTITY; i++ ){
            listTrack[i] = new Lane();
        }
        try{
            //Carga y arreglo del tamaño de las barreras
            barrierOff = ImageIO.read(new File("src/images/barrierOff.png"));
            //barrierOff = barrierOff.getScaledInstance(20, 20, Image.SCALE_DEFAULT);
            barrierOn = ImageIO.read(new File("src/images/barrierOn.png"));
            //barrierOn = barrierOn.getScaledInstance(60, 20, Image.SCALE_DEFAULT);
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
             if(this.listTrack[i].getBarrier()){
                 g.drawImage(barrierOn, 17 + (STREET_HORIZONTAL_SCALE * i), STREET_VERTICAL_SCALE, null);   
             }else{
                 g.drawImage(barrierOff, 17 + (STREET_HORIZONTAL_SCALE * i), STREET_VERTICAL_SCALE, null);   
             }
         }
    }
     
    public void activateAllBarriers(){
        for(int i = 0; i < this.listTrack.length; i++){
             this.listTrack[i].setBarrier(true);
         }
    }
    
    public void deactivateAllBarriers(){
        for(int i = 0; i < this.listTrack.length; i++){
             this.listTrack[i].setBarrier(false);
         }
    }
    
    public void activateBarrier(int pLane){
        this.listTrack[pLane].changeBarrierStatus();
    }
     
    public void addFigure(int pLane, int pDirection, int pSpeed, boolean pShowImage){
        ThreadRunner threadRunner = new ThreadRunner(pLane, pDirection, pSpeed, pShowImage);
        listTrack[pLane].getRunnerList().add(threadRunner);
    }
    
    public void changeImageStatus(boolean pStatus){
        for (int i = 0; i < LANE_QUANTITY; i++){
            for(int j = 0; j < listTrack[i].getRunnerList().size(); j++){
                listTrack[i].getRunnerList().get(j).getFigure().setShowImage(pStatus);
            }
        }
    }
    
    public Lane[] getListTrack() {
        return listTrack;
    }

    public void setListTrack(Lane[] listTrack) {
        this.listTrack = listTrack;
    }
}
