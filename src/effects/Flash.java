/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package effects;

import parkour.GameObject;

/**
 *
 * @author cocog
 */
public class Flash implements Effect{

    @Override
    public void set(GameObject gm) {
        gm.setImg("/resources/Light3.png");
        if(gm.getheight() > 200 ){
            gm.setY(gm.getY() + gm.getPi().getpHeight() / 2);    
        }
        gm.setWidth(192);
        gm.setheight(192);
        gm.getPi().setinitialPX(0);
        gm.getPi().setpX(0);
        gm.getPi().setpWidth(192);
        gm.getPi().setinitialPY(0);
        gm.getPi().setpY(0);
        gm.getPi().setpHeight(192);
        gm.getPi().setmaxX(192 * 5);
        gm.getPi().setmaxY(192 * 6);
        gm.getPi().setpDelay(1);
        gm.getPi().setTime(18);
    }
    
}
