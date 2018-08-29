/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Figure implements CONSTANTS{

    private static final int size = 30;
    private Image imageUp;
    private Image imageDown;
    private boolean showImage;
    private double posX;
    private double posY;
    private double direction;
    private int type;
    private Color color;

    public Figure(int pPosX, int pDirection, int pType, boolean pShowImage) {   
                
        posX = pPosX * STREET_HORIZONTAL_SCALE + 50; //Arreglar en las constantes (escalas)
        showImage = pShowImage;
        direction = pDirection;
        type = pType;
        color = generateColor();
        try{
            switch (type) {
            case 1:
                imageUp = ImageIO.read(new File("src/images/redUp.png"));
                imageUp = imageUp.getScaledInstance(RUNNER_IMAGE_WIDTH, RUNNER_IMAGE_HEIGHT, Image.SCALE_DEFAULT);
                imageDown = ImageIO.read(new File("src/images/redDown.png"));
                imageDown = imageDown.getScaledInstance(RUNNER_IMAGE_WIDTH, RUNNER_IMAGE_HEIGHT, Image.SCALE_DEFAULT);
                break;
            case 2:
                imageUp = ImageIO.read(new File("src/images/whiteUp.png"));
                imageUp = imageUp.getScaledInstance(RUNNER_IMAGE_WIDTH, RUNNER_IMAGE_HEIGHT, Image.SCALE_DEFAULT);
                imageDown = ImageIO.read(new File("src/images/whiteDown.png"));
                imageDown = imageDown.getScaledInstance(RUNNER_IMAGE_WIDTH, RUNNER_IMAGE_HEIGHT, Image.SCALE_DEFAULT);
                break;
            case 3:
                imageUp = ImageIO.read(new File("src/images/blueUp.png"));
                imageUp = imageUp.getScaledInstance(RUNNER_IMAGE_WIDTH, RUNNER_IMAGE_HEIGHT, Image.SCALE_DEFAULT);
                imageDown = ImageIO.read(new File("src/images/blueDown.png"));
                imageDown = imageDown.getScaledInstance(RUNNER_IMAGE_WIDTH, RUNNER_IMAGE_HEIGHT, Image.SCALE_DEFAULT);
                break;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        if (direction!=1)
            posY = WINDOW_WIDTH + 30 ;
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
        if(showImage){
            if (direction == 1){
                g.drawImage(imageDown, (int)posX, (int)posY, null);
            }else{
                g.drawImage(imageUp, (int)posX, (int)posY, null);
            }
        }else{
            g.setColor(color);
            switch (type) {
                case 1:
                    g.fillRect((int) posX, (int) posY, size, size);
                    break;
                case 2:
                    g.fillOval((int) posX, (int) posY, size, size);
                    break;
                case 3:
                    g.fillRect((int) posX+2, (int) posY, size-4, size+10);
                    break;
            }
        }
    }

    private Color generateColor() {
        Color color = null;
        switch (type) {
            case 1:
                color = Color.red;
                break;
            case 2:
                color = Color.white;
                break;
            case 3:
                color = Color.blue;
                break;
        }
        return color;
    }

    public void setShowImage(boolean showImage) {
        this.showImage = showImage;
    }
    
    public int getPosY(){
        return (int) posY;
    }
    
    public double getDirection(){
        return direction;
    }
    
}
