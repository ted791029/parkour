/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkour;

import static parkour.NewJPanel.yBottom;


/**
 *
 * @author cocog
 */
public class Player extends GameObject{
    private int lastState;
    private int state;
    private int g;
    private int pY;
    public Player(int x, int y, int width, int height, String path, int pX, int pY, int pWidth, int pHeight, int maxX, int maxY, int pdelay){
        super(x, y, width, height, path);
        this.setPi(pX, pY, pWidth, pHeight, maxX, maxY, pdelay);
        this.lastState = this.state = 0;
        this.g = 0;
        this.pY = pY;
    }
    //setter
    public void setState(int state){
        this.state = state;
    }
    //function
    public void move(){
        g = g + 1 ;
        switch(state){
            case 1 :
                this.setY(this.getY() - (this.getMoveX() + g));
                if(this.getY() < 0){
                    this.setY(0);
                    return;
                }
                break;
            case 2 :
                this.setY(this.getY() + (this.getMoveX() + g));
                if(this.getY() > yBottom - 75){
                    this.setY(yBottom -75);
                    this.state = 0;
                    return;
                }
                break;
        }
    }
    public void reG(){
        if(lastState != state){
            lastState = state;
            this.g = 0;
        }
    }
    public void ation(){
        switch(this.state){
            case 0 :
                this.getPi().setpY(this.pY);
                this.getPi().setpDelay(8);
                this.getPi().getdOrder().drawOrder(this.getPi());
                break;
            case 1 :
                this.getPi().setpY(this.pY + this.getPi().getpHeight() * 4);
                this.getPi().setpDelay(4);
                this.getPi().getdOrder().drawOrder(this.getPi());
                break;
            case 2 :
                this.getPi().setpY(this.pY + this.getPi().getpHeight() * 4);
                this.getPi().setpDelay(7);
                this.getPi().getdOrder().drawOrder(this.getPi());
                break;
        }
        reG();
    }
    public boolean start(){
        this.setX(this.getX() + 4);
        if(this.getX() >= 120){
            return true;
        }
        return false;
    }
}
