/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkour;

import static parkour.NewJPanel.speed;


/**
 *
 * @author cocog
 */
public class Map extends GameObject{
    private int mapOffset;
    public Map(int x, int y, int width, int height, String path){
        super(x, y, width, height, path);
        this.mapOffset = 0;
    }
    //getter
    public int getMapOffest(){
        return this.mapOffset;
    }
    //function
    public void mapOffsetPlus(){
        this.mapOffset += (this.getMoveX() + speed);
        if(this.mapOffset > 1600){
                this.mapOffset = 0;
        }

    }
}
