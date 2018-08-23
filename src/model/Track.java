/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


/**
 *
 * @author Yelson
 */
public class Track implements CONSTANTS {
    
    private Lane[] listTrack = new Lane[LANE_QUANTITY];
    
    private static Track track;
    
    //Atributos
    
    //Singleton Pattern
    //--------------------------------------|
    private Track(){
        for (int i = 0; i < LANE_QUANTITY; i++ ){
            listTrack[i] = new Lane();
        }
    }
    
    public void revertDirection(){
        for (int i = 0; i<LANE_QUANTITY; i++){
            track.getListTrack()[i].revert();
        }
    }
    
    public static Track getInstance(){
        if(track == null){
            track = new Track();
        }
        return track;
    };
    
    public void addFigure(int pLane, int pDirection, int pSpeed){
        ThreadRunner threadRunner = new ThreadRunner(pLane, pDirection, pSpeed);
        listTrack[pLane].getRunnerList().add(threadRunner);
    }
    

    public Lane[] getListTrack() {
        return listTrack;
    }

    public void setListTrack(Lane[] listTrack) {
        this.listTrack = listTrack;
    }
    
    
}
