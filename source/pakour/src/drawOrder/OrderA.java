/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawOrder;

import parkour.*;
import static parkour.NewJPanel.count;
import static parkour.NewJPanel.delay;
/**
 *
 * @author cocog
 */
public class OrderA implements DrawOrder{
    private boolean ischecked;
    public OrderA(){
        this.ischecked = true;
    }
    @Override
    public void drawOrder(Painter pi) {
        if(count % (pi.getpDelay() * delay) == 0 ){
            if(pi.getpX() == pi.getMaxX()){
                this.ischecked = false;
            }else if(pi.getpX() == pi.getinitialPX()){
                this.ischecked = true;
            }
            if(ischecked){
                pi.setpX(pi.getpX() + pi.getpWidth());
            }else{
                pi.setpX(pi.getpX() - pi.getpWidth());
            }
        }
    }
    
}
