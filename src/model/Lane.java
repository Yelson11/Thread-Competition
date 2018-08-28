/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

public class Lane implements CONSTANTS{
    private ArrayList<ThreadRunner> runnerList;
    private boolean barrier;
    private int direction;
    
    public Lane(){
        this.runnerList = new ArrayList<ThreadRunner>();
        barrier = false;
        direction = 1;
    }

    public void revert(){
        for(int i = 0; i < runnerList.size(); i++){
            runnerList.get(i).getFigure().revert();
        }
        direction *= -1;
    }
    
    public void controlCollision(){
        int size = runnerList.size();
        for(int j = 0; j < size-1; j++){
            if (direction == 1){
                if(runnerList.get(j).getFigure().getPosY() < runnerList.get(j+1).getFigure().getPosY()+35)
                    runnerList.get(j+1).setStateMove(false);
            }
            else{
                if(runnerList.get(j).getFigure().getPosY() < runnerList.get(j+1).getFigure().getPosY()+35)
                    runnerList.get(j).setStateMove(false);
            }
        }
    }
    
    public void changeBarrierStatus(){
        barrier = !barrier;
    }
    
    //Getters & Setters
    public ArrayList<ThreadRunner> getRunnerList() {
        return runnerList;
    }

    public void setRunnerList(ArrayList<ThreadRunner> runnerList) {
        this.runnerList = runnerList;
    }
    
    public void setBarrier(boolean pState){
        barrier = pState;
        for(int i = 0; i<runnerList.size(); i++){
            runnerList.get(i).setBarrier(barrier);
        }
    }
    public boolean getBarrier(){
        return barrier;
    }
}
