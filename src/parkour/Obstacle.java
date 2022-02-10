/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkour;

import effects.*;
import static parkour.NewJPanel.speed;

/**
 *
 * @author cocog
 */
public class Obstacle extends GameObject{
    private boolean state;
    private int count;
    private Effect e;
    public Obstacle(int x, int y, int width, int height, String path, int pX, int pY, int pWidth, int pHeight, int maxX, int maxY, int pDelay){
        super(x, y, width, height, path);
        this.setPi(pX, pY, pWidth, pHeight, maxX, maxY, pDelay);
        this.state = false;
        this.count = 0;
    }
    public boolean move(int Ospeed){
        this.getPi().getdOrder().drawOrder(this.getPi());
        if(state){
            count++;
            return false;
        }
        int x = this.getX() - ((this.getMoveX() * Ospeed) + speed);
        if(x < - this.getWidth()){
            return true;
        }
        this.setX(x);
        return false;
    }
    //getter
    public int getCount(){
        return this.count;
    }
    public boolean getState(){
        return this.state;
    }
    public Effect getEffect(){
        return this.e;
    }
    //setter
    public void setCount(int count){
        this.count = count;
    }
    public void setState(boolean state){
        this.state = state;
    }
    public void setEffect(Effect e){
        this.e = e;
    }
}
