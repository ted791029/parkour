/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkour;

import drawOrder.*;
import java.awt.Graphics;

/**
 *
 * @author cocog
 */
public class Painter {
    private GameObject gm;
    private int pWidth;
    private int pHeight;
    private int initialPX; //圖片初始x
    private int pX; 
    private int initialPY; // 圖片初始y
    private int pY;
    private int maxX;  // x軸圖片個數
    private int maxY;  // y軸圖片個數
    private DrawOrder dOrder;
    private int pDelay; //換圖速度
    private int time; //動畫持續時間
    public Painter(GameObject gm, int pX, int pY, int pWidth, int pHeight, int maxX, int maxY, int pDelay){
        this.gm = gm;
        this.initialPX = this.pX = pX;
        this.initialPY = this.pY = pY;
        this.pWidth = pWidth;
        this.pHeight = pHeight;
        this.maxX = maxX;
        this.maxY = maxY;
        this.pDelay = pDelay;
    }
    //getter
    public int getinitialPX(){
        return this.initialPX;
    }
    public int getintitialPY(){
        return this.initialPY;
    }
    public int getpX(){
        return this.pX;
    }
    public int getpY(){
        return this.pY;
    }
    public int getpWidth(){
        return this.pWidth;
    }
    public int getpHeight(){
        return this.pHeight;
    }
    public int getMaxX(){
        return this.maxX;
    }
    public int getMaxY(){
        return this.maxY;
    }
    public DrawOrder getdOrder(){
        return this.dOrder;
    }
    public int getpDelay(){
        return this.pDelay;
    }
    public int getTime(){
        return this.time;
    }
    //setter
    public void setinitialPX(int initialPX){
        this.initialPX = initialPX;
    }
    public void setinitialPY(int initialPY){
        this.initialPY = initialPY;
    }
    public void setpX(int pX){
        this.pX = pX;
    }
    public void setpY(int pY){
        this.pY = pY;
    }
    public void setpWidth(int pWidth){
        this.pWidth = pWidth;
    }
    public void setpHeight(int pHeight){
        this.pHeight = pHeight;
    }
    public void setmaxX(int maxX){
        this.maxX = maxX;
    }
    public void setmaxY(int maxY){
        this.maxY = maxY;
    }
    public void setDrawOrder(DrawOrder order){
        this.dOrder = order;
    }
    public void setpDelay(int pDelay){
        this.pDelay = pDelay;
    }
    public void setTime(int time){
        this.time = time;
    }
    //function
    public void paint(Graphics g){
        g.drawImage(gm.getImg(), gm.getX(), gm.getY(), gm.getX() + gm.getWidth(), gm.getY() + gm.getheight(), pX, pY, pX + pWidth, pY + pHeight, null);
    }
    public void reset(int pX, int pY, int pWidth, int pHeight, int maxX, int maxY, int pDelay){
        this.initialPX = this.pX = pX;
        this.initialPY = this.pY = pY;
        this.pWidth = pWidth;
        this.pHeight = pHeight;
        this.maxX = maxX;
        this.maxY = maxY;
        this.pDelay = pDelay;
    }
}
