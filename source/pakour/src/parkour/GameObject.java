/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkour;

import java.awt.image.BufferedImage;

/**
 *
 * @author cocog
 */
public class GameObject {
    final int moveX = 4;
    private int x;
    private int y;
    private int width;
    private int height;
    private Painter pi;
    private BufferedImage img;
    public GameObject(int x, int y, int width, int height, String path){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.img = Resourcecontroller.getInstance().tryGetImage(path);
    }
    //getter
    public int getMoveX(){
        return this.moveX;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public int getWidth(){
        return this.width;
    }
    public int getheight(){
        return this.height;
    }
    public BufferedImage getImg(){
        return this.img;
    }
    public Painter getPi(){
        return this.pi;
    }
    //setter
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setWidth(int width){
        this.width = width;
    }
    public void setheight(int height){
        this.height = height;
    }
    public void setImg(String path){
        this.img = Resourcecontroller.getInstance().tryGetImage(path);
    }
    public void setPi(int pX, int pY, int pWidth, int pHeight, int maxX, int maxY, int pdelay){
        this.pi = new Painter(this, pX, pY, pWidth, pHeight, maxX, maxY, pdelay);
    }
    //function
    public boolean attack(GameObject gm){
        int left = this.x;
        int right = left + this.width;
        int top = this.y;
        int bottom = top + this.height;
        int gmleft = gm.getX();
        int gmright = gmleft + gm.getWidth();
        int gmtop = gm.getY();
        int gmbottom = gmtop + gm.getheight();
        if(left > gmright){
            return false;
        }
        if(right < gmleft){
            return false;
        } 
        if(top > gmbottom){
            return false;
        }
        if(bottom < gmtop){
            return false;
        }
        return true;
    }
}
