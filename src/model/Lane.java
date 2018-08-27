/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

public class Lane {
    private ArrayList<ThreadRunner> runnerList;
    private boolean barrier;
    
    public Lane() {
        this.runnerList = new ArrayList<ThreadRunner>();
        barrier = false;
    }

    public void revert(){
        for(int i = 0; i < runnerList.size(); i++){
            runnerList.get(i).getFigure().revert();
        }
    }
    public void changeBarrierStatus(){
        barrier = !barrier;
    }
    public ArrayList<ThreadRunner> getRunnerList() {
        return runnerList;
    }

    public void setRunnerList(ArrayList<ThreadRunner> runnerList) {
        this.runnerList = runnerList;
    }
    
    public void setBarrier(boolean pState){
        barrier = pState;
    }
    public boolean getBarrier(){
        return barrier;
    }
}
