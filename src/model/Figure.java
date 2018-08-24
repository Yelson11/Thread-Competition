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
import javax.imageio.ImageIO;

public class Figure implements CONSTANTS{

    private static final int size = 30;
    private Image imageRed;
    private Image imageBlue;
    private Image imageWhite;
    private boolean showImage;
    private double posX;
    private double posY;
    private double direction;
    private int type;
    private Color color;

    public Figure(int pPosX, int pDirection, int pType, boolean pShowImage) {   
                
        posX = pPosX * 50; //Arreglar en las constantes (escalas)
        showImage = pShowImage;
        direction = pDirection;
        type = pType;
        color = generateColor();
        try{
            Image image = ImageIO.read(new File("src/images/rojo2.png"));
            imageRed = image.getScaledInstance(RUNNER_IMAGE_WIDTH, RUNNER_IMAGE_HEIGHT, Image.SCALE_DEFAULT);
            Image image2 = ImageIO.read(new File("src/images/azul2.png"));
            imageBlue = image.getScaledInstance(RUNNER_IMAGE_WIDTH, RUNNER_IMAGE_HEIGHT, Image.SCALE_DEFAULT);
            Image image3 = ImageIO.read(new File("src/images/blanco2.png"));
            imageWhite = image.getScaledInstance(RUNNER_IMAGE_WIDTH, RUNNER_IMAGE_HEIGHT, Image.SCALE_DEFAULT);
        }catch(IOException e){
            e.printStackTrace();
        }
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
        if(showImage){
            Image image;
            Image imageScaled;
            switch (type) {
            case 1:
                g.drawImage(imageRed, (int)posX, (int)posY, null);
                break;
            case 2:
                g.drawImage(imageWhite, (int)posX, (int)posY, null);
                break;
            case 3:
                g.drawImage(imageBlue, (int)posX, (int)posY, null);
                break;
            }
        }else{
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

    public void setShowImage(boolean showImage) {
        this.showImage = showImage;
    }
}
