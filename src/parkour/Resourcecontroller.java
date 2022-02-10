/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkour;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author cocog
 */
public class Resourcecontroller {
    private static BufferedImage[] imags;
    private String[] paths;
    private int count;
    private static Resourcecontroller resourcecontroller;
    public static Resourcecontroller getInstance(){
        if(resourcecontroller == null){
           resourcecontroller = new  Resourcecontroller();
        }
        return resourcecontroller;
    }
    private Resourcecontroller(){
        this.imags = new BufferedImage[2];
        this.paths = new String[2];
        this.count = 0;
    }
    public BufferedImage tryGetImage(String path){
        int n = this.findImage(path);
        if(n == -1){
            return this.addImage(path);
        }
        return imags[n];
    }
    private BufferedImage addImage(String path){
        try {
            if(this.count == this.imags.length){
                this.doubleArr();
            }
            this.imags[count] = ImageIO.read(getClass().getResource(path));
            this.paths[this.count] = path;
        } catch (IOException ex) {
           ex.printStackTrace();
        }
        return imags[count++];
    }
    public int findImage(String path){
        for(int i = 0;i < this.count;i++){
            if(path.equals(this.paths[i])){
                return i;
            }
        }
        return -1;
    }
    private void doubleArr(){
        BufferedImage[] newArr = new BufferedImage[this.imags.length*2];
        String[] newstrArr = new String[this.paths.length*2];
        for(int i = 0;i < this.imags.length;i++){
            newArr[i] = this.imags[i];
        }
        for(int i = 0;i < this.paths.length;i++){
            newstrArr[i] = this.paths[i];
        }
        this.imags = newArr;
        this.paths = newstrArr;
    }
}
