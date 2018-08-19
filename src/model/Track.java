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
public class Track {
    
    //Variable estatica para el singleton patter
    private static Track track;
    
    //Atributos
    
    //Singleton Pattern
    //--------------------------------------|
    private Track(){
    };
    public static Track getInstance(){
        if(track == null){
            track = new Track();
        }
        return track;
    };
    //--------------------------------------|
}
