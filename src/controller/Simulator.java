/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yelson
 */
public class Simulator extends Thread{
    
    private ThreadController controller;
    
    public Simulator(){
        controller = ThreadController.getInstace();
    }
    
    @Override
    public void run(){
        while(true){
            int time = (int)((Math.random())*5 + 1);
            controller.simulateThreads();
            try {
                Thread.sleep(time*1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Simulator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
