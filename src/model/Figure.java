/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.awt.Color;
import java.awt.Graphics;

public class Figure implements CONSTANTS {

    private static final int size = 30;

    private double posX;
    private double posY;
    private double direction;
    private int type;
    private Color color;

    public Figure(int pPosX, int pDirection, int pType) {   
        
        posX = pPosX * 50; //Arreglar en las constantes (escalas)
        direction = pDirection;
        type = pType;
        color = generateColor();
        if (direction!=1)
            posY = WINDOW_WIDTH;
        else 
            posY = -30;
    }

    public void move() {
        posY += direction;
    }
    
    public void revert(){
        direction *= -1; 
    }

    public void draw(Graphics g) {
        g.setColor(color);
        switch (type) {
            case 1:
                g.fillRect((int) posX, (int) posY, size, size);
                break;
            case 2:
                g.fillRect((int) posX, (int) posY, size, size);
                break;
            case 3:
                g.fillRect((int) posX, (int) posY, size, size);
                break;
        }
    }

    private Color generateColor() {
        Color color = null;
        switch (type) {
            case 1:
                color = Color.red;
                break;
            case 2:
                color = Color.green;
                break;
            case 3:
                color = Color.blue;
                break;
        }
        return color;
    }
    
}
