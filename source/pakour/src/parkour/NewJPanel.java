/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkour;

import drawOrder.*;
import effects.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.Timer;
/**
 *
 * @author cocog
 */
public class NewJPanel extends javax.swing.JPanel{
    public static final int delay = 1;
    public static int speed  = 1;
    public static int count  = 0;
    public static final int yBottom = 546;
    public static final int yTop = 0;
    public boolean start;
    private ArrayList<Map> maps;
    private Player player;
    private int playerX;
    private int playerY;
    private ArrayList<Obstacle> airplanes;
    private ArrayList<Obstacle> warnings;
    private ArrayList<Obstacle> fences;
    class CMKeyListener1 extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            if(start){
                switch(e.getKeyCode()){
                    case KeyEvent.VK_SPACE :
                        player.setState(1);
                        break;
                    case KeyEvent.VK_C : 
                        speed += 2;
                        if(speed >= 8){
                            speed = 1;
                        }
                    break;
                }
            }
        }
        @Override
        public void keyReleased(KeyEvent e) {
            switch(e.getKeyCode()){
                case KeyEvent.VK_SPACE :
                    player.setState(2);
                    break;
            }
        }
    }
    public NewJPanel(){
        this.addKeyListener(new CMKeyListener1());
        this.setFocusable(true);
        this.start = false;
        this.maps = new ArrayList<>();
        this.fences = new ArrayList<>();
        this.airplanes = new ArrayList<>();
        this.warnings = new ArrayList<>();
        this.playerX = 9;
        this.playerY = 2;
        this.player = new Player(0, yBottom - 75, 68, 75, "/resources/Actor1.png", playerX * 45, playerY * 50, 45, 50, (playerX + 2) * 45, playerY * 50, 1);
        this.player.getPi().setDrawOrder(new OrderA());
        createMaps();
        
        Timer t1 = new Timer(25, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(start){
                    mapsMove(maps);
                    if(count % (delay * (45 - speed * 2)) == 0){
                        createFences();
                    }
                    if(count % (delay * (60 - speed * 2) ) == 0){
                        createWarnings();
                    }
                    warningChecked();
                    ObstacleMvoe(fences, 2,new Flash());
                    ObstacleMvoe(airplanes, 6,new Explosion());
                }else{ 
                    if(player.start()){
                        start = true;
                    }
                }
                if(count % delay == 0){
                    player.ation();
                    player.move();
                }
                count++;
            }
        });
        t1.start();
    }
    public void newMap(int x, int y, int width, int height, String path, int pX, int pY, int pWidth, int pHeight, int maxX, int maxY){
        Map map = new Map(x, y, width, height, path);
        map.setPi(pX, pY, pWidth, pHeight, maxX, maxY, 1);
        maps.add(map);
    }
    public void createMaps(){
        newMap(0, 0, 800, 578 , "/resources/CloudySky1.png", 0, 0, 544, 544, 1, 1);
        newMap(800, 0, 0, 578 , "/resources/CloudySky1.png", 544, 0, -544, 544, 1, 1);
        for(int i = 0;i < 26;i++){
            for(int j = 16;j < 18;j++){
                newMap(32 * i, 32 * j, 32 , 32, "/resources/Inside_A5.png", 5 * 32, 1 * 32 , 32, 32, 1, 1);
            }
        }
        
    }
    public void mapsMove(ArrayList<Map> maps){
        for(int i = 0;i < maps.size();i++){
            maps.get(i).mapOffsetPlus();
            int offset ;
            if(i == 0){
                if(maps.get(i).getMapOffest() <= 800){
                    offset = (int)((544f/800f) * maps.get(i).getMapOffest());
                    maps.get(i).setX(0);
                    maps.get(i).setWidth(800 - maps.get(i).getMapOffest());
                    maps.get(i).getPi().reset(offset, 0, 544 - offset, 544, 1, 1, 1);
                }else{
                    offset = (int)((544f/800f) * (maps.get(i).getMapOffest() % 801));
                    maps.get(i).setX(800 - (maps.get(i).getMapOffest() % 801));
                    maps.get(i).setWidth(maps.get(i).getMapOffest() % 801);
                    maps.get(i).getPi().reset(0, 0, offset, 544, 1, 1, 1);
                }
            }else if(i == 1){
                if(maps.get(i).getMapOffest() <= 800){
                    offset = (int)((544f/800f) * maps.get(i).getMapOffest());
                    maps.get(i).setX(800 - maps.get(i).getMapOffest());
                    maps.get(i).setWidth(maps.get(i).getMapOffest());
                    maps.get(i).getPi().reset(544, 0, -offset, 544, 1, 1, 1);
                }else{
                    offset = (int)((544f/800f) * (maps.get(i).getMapOffest() % 801));
                    maps.get(i).setX(0);
                    maps.get(i).setWidth(800 - (maps.get(i).getMapOffest()) % 801);
                    maps.get(i).getPi().reset(544 - offset, 0, -(544 - offset), 544, 1, 1, 1);
                }
            }
            else{
                maps.get(i).setX(maps.get(i).getX() - (6 + speed));
                if(maps.get(2).getX() - (6 + speed) <= -32 ){
                    int n = maps.get(2).getX();
                    for(int j = 2; j < maps.size();j++){
                        maps.get(j).setX(maps.get(j).getX() -  n);  
                    }
                }
            }
        }
    }
    public void createObstacle(ArrayList<Obstacle> arr, int x, int y, int width, int height, String path, int pX, int pY, int pWidth, int pHeight, int maxX, int maxY, int max, DrawOrder order, int pDelay){
        if(arr.size() < max){
            Obstacle ob = new Obstacle(x, y, width, height, path, pX, pY, pWidth, pHeight , maxX, maxY, pDelay);
            ob.getPi().setDrawOrder(order);
            arr.add(ob);
        }
    }
    public void ObstacleMvoe(ArrayList<Obstacle> arr, int Ospeed,Effect effect){ // arr = 要移動的物件陣列, change = 動畫變化速度 ,effect = 碰撞後的特效, time = 動畫持續時間(設定和動畫張數一樣)
        for(int i = 0;i < arr.size();i++){
            if(arr.get(i).move(Ospeed)){
                arr.remove(i);
                continue;
            }
            if(!arr.get(i).getState()){
                if(arr.get(i).attack(player)){
                    arr.get(i).setEffect(effect);
                    arr.get(i).getEffect().set(arr.get(i));
                    arr.get(i).setState(true);
                }
            }else{
                if(arr.get(i).getCount() >= arr.get(i).getPi().getTime()){
                    arr.remove(i);
                }
            }
        }
    }
    public void createAirplanes(int y){
        createObstacle(airplanes, 801, y, 96, 32, "/resources/helicopter.png", 0, 0, 96, 32 , 8 * 96, 1 * 32 , 9, new OrderB(), 1);
    }
    public void createWarnings(){ 
        createObstacle(warnings, 740, player.getY() + 30, 60, 59, "/resources/warning.png", 0, 0, 60, 59 , 16 * 60, 1 * 59 , 9, new OrderB(), 1);
    }
    public void createFences(){
        int y = 0;
            switch((int)(Math.random()*3)){
                case 0 :
                    y = 0;
                    break;
                case 1 :
                    y = 200;
                    break;
                case 2 :
                    y = 378;
                    break;
            }
            int dy = (int)(Math.random() * (401 - y)) + (y + 1);
            if(dy + y > 578){
                dy = 578 - y;
            }else if(dy < 200){
              dy = 200;  
            }else if(dy > 300){
               dy = 300; 
            }
        createObstacle(fences, 801, y, 32, dy, "/resources/Thunder3.png", 0, 0, 192, 192 , 3 * 192, 1 * 192 , 4, new OrderB(), 8);
    }
    public void warningChecked(){
        for(int i = 0;i < warnings.size();i++){
            warnings.get(i).getPi().getdOrder().drawOrder(warnings.get(i).getPi());
            warnings.get(i).getPi().setpDelay(2);
            warnings.get(i).setCount(warnings.get(i).getCount() + 1);
            warnings.get(i).setY(player.getY() + 30);
            if(warnings.get(i).getCount() == 32){
                int y = warnings.get(i).getY();
                warnings.remove(i);
                createAirplanes(y);
            }
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        for(int i = 0; i < maps.size();i++){
            maps.get(i).getPi().paint(g);
        }
        for(int i = 0;i < fences.size();i++){
            fences.get(i).getPi().paint(g);
        }
        for(int i = 0; i < warnings.size();i++){
            warnings.get(i).getPi().paint(g);
        }
        for(int i = 0;i < airplanes.size();i++){
            airplanes.get(i).getPi().paint(g);
        }
        player.getPi().paint(g);
    }
}
