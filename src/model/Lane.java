/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Lane {
    private ArrayList<ThreadRunner> runnerList;
    
    public Lane() {
        this.runnerList = new ArrayList<ThreadRunner>();
    }

    public void revert(){
        for(int i = 0; i < runnerList.size(); i++){
            runnerList.get(i).getFigure().revert();
        }
    }
    public ArrayList<ThreadRunner> getRunnerList() {
        return runnerList;
    }

    public void setRunnerList(ArrayList<ThreadRunner> runnerList) {
        this.runnerList = runnerList;
    }
    
    
}
