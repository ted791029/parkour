/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawOrder;

import static parkour.NewJPanel.count;
import static parkour.NewJPanel.delay;
import parkour.Painter;

/**
 *
 * @author cocog
 */
public class OrderB implements DrawOrder{

    @Override
    public void drawOrder(Painter pi) {
        if(count % (pi.getpDelay() * delay) == 0 ){
            pi.setpX(pi.getpX() + pi.getpWidth());
            if(pi.getpX() == pi.getMaxX()){
                pi.setpX(pi.getinitialPX());
                pi.setpY(pi.getpY() + pi.getpHeight());
                if(pi.getpY() == pi.getMaxY()){
                    pi.setpY(pi.getintitialPY());
                }
            }
        }
    }
    
}
