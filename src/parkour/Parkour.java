/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkour;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author cocog
 */
public class Parkour {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame j = new JFrame();
        j.setTitle("³¾¥Í");
        j.setSize(800, 600);
        NewJPanel gm = new NewJPanel();
        j.add(gm);
        j.setVisible(true);
        //System.out.println(j.getContentPane().getHeight());
        Timer t1 = new Timer(25, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                j.repaint();
            }
        });
        t1.start();
    }
    
}
