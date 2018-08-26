/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import model.ThreadRunner;

/**
 *
 * @author Yelson
 */
public class TrackView extends javax.swing.JPanel implements Runnable{
    
    Thread hilo;
    private Image background;
    private Track track;
    private int sleepThreadTime;
    private int sleepTimePaint;
    private boolean runningThread;
    private Graphics g;
    private boolean state;

    
    public TrackView() {
        initComponents();
        this.runningThread = true;
        hilo = new Thread(this);
        track = Track.getInstance();
        state = true;
        try{
            background = ImageIO.read(new File("src/images/street.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void paint(Graphics g){
        //Background
        g.drawImage(background, 0, 0, this);
        
        Lane[] listTrack = track.getListTrack();
        track.drawBarriers(g);
        for(int i = 0; i < listTrack.length; i++){
            ArrayList<ThreadRunner> threads = listTrack[i].getRunnerList();
            for(int j = 0; j < threads.size(); j++){
                threads.get(j).getFigure().draw(g);
            }
        }
        
    }
   
    
    public void create(){
        hilo.start();
    }
    
    public void interrput(){
        hilo.suspend();
    }
    
    public void continueThread(){
        hilo.resume();
    }
    
    public void stateThread(){
        if (state){
            state = false;
            hilo.suspend();
        }
        else{
            state = true;
            hilo.resume();
        }       
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    //Toda la animación que quiera
    @Override
    public void run(){
        //Este es el método que repinta la interfaz...
        while(true){
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(TrackView.class.getName()).log(Level.SEVERE, null, ex);
            }
            repaint();   
        }
        
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
