/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omm.assingment;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Rusiru
 */
public class Snake extends JFrame implements Runnable, KeyListener {
    JPanel panel1,panel2;
    JButton[] lengthButton = new JButton[200];
    JButton bounsfood;
    JTextArea scoreTextArea;
    int x=1000, y=500, gu=2, directionx=0,directiony=0, speed=100, difference=0, oldx, score=0;
    int [] lengthButtonX = new int[600];
    int [] lengthButtonY = new int[600];
    Point[] lengthButtonPoint = new Point[600];
    Point bounsFoodPoint = new Point();
    Thread myThread;
    boolean food = false, runl = false, runr=false, runu = false, rund =false, bounsFlag = true;
    Random random = new Random();
    JMenuBar mymbar;
    JMenu game, help, level;
    boolean running = false;
    int SCREEN_WIDTH = 1000;
    int SCREEN_HEIGHT = 590;
    
    public void initializeValue(){
        gu = 3;
        lengthButtonX[0] = 200;
        lengthButtonY[0] = 300;
        directionx = 10;
        directiony = 0;
        score = 0;
        food = false;
        runl =false;
        runr = true;
        runu = true;
        rund = true;
        bounsFlag = true;
    }
    
    Snake(){
        
        super("Snake");
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        createbar();
        initializeValue();
        panel1 = new JPanel();
        panel2 = new JPanel();
        
        scoreTextArea =  new JTextArea("SCORE =>> " + score);
        scoreTextArea.setEditable(false);
        scoreTextArea.setBackground(Color.white);
        bounsfood = new JButton();
        bounsfood.setEnabled(false);
        
        createFirstSnake();
        panel1.setLayout(null);
        panel2.setLayout(new GridLayout(0,1));
        panel1.setBounds(0,0,x,y);
        panel1.setBackground(Color.BLUE);
        panel2.setBounds(0,y,x,30);
        panel2.setBackground(Color.RED);
        
        panel2.add(scoreTextArea);
        
        getContentPane().setLayout(null);
        getContentPane().add(panel1);
        getContentPane().add(panel2);
        show();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setFocusable(true);
        addKeyListener(this);
        
        myThread = new Thread(this);
        myThread.start();
        System.out.println(panel1.isFocusable());
    }
    
    private void createFirstSnake() {
        for(int i=0; i < 3; i++){
            lengthButton[i] = new JButton("lb"+ i);
            lengthButton[i].setEnabled(false);
            panel1.add(lengthButton[i]);
            lengthButton[i].setBounds(lengthButtonX[i], lengthButtonY[i], 10, 10);
            lengthButtonX[i+1] = lengthButtonX[i] - 10;
            lengthButtonY[i+1] = lengthButtonY[i];
        }
        running = true;
    }
    
    private void createbar() {
        mymbar = new JMenuBar();
        game = new JMenu("Game");
        
        JMenuItem exit = new JMenuItem("Exit");
        JMenuItem newgame = new JMenuItem("New Game");
        newgame.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        }
        );
        
        exit.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }
        );
        game.add(newgame);
        game.addSeparator();
        game.add(exit);
        mymbar.add(game);
        level = new JMenu("Level");
        help = new JMenu("Help");
        JMenuItem creator = new JMenuItem("Creator");
        
        creator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panel2, "Name" + ": Rusiru Ishan");
            }
        }
        );
        
        help.add(creator);
        mymbar.add(help);
        setJMenuBar(mymbar); 
    }
    
    void grouwp(){
        lengthButton[gu] = new JButton();
        lengthButton[gu].setEnabled(false);
        panel1.add(lengthButton[gu]);
        int a = 10 + (10 * random.nextInt(48));
        int b = 10 + (10 * random.nextInt(23));
        lengthButtonX[gu] = a;
        lengthButtonY[gu] = b;
        lengthButton[gu].setBounds(a,b,10,10);
        gu++;
        
    }
    
    void moveForward(){
        for(int i=0; i < gu; i++){
            lengthButtonPoint[i] = lengthButton[i].getLocation();
        }
        lengthButtonX[0] += directionx;
        lengthButtonY[0] += directiony;
        lengthButton[0].setBounds(lengthButtonX[0],lengthButtonY[0],10,10);
        for(int i=1; i<gu;i++){
            lengthButton[i].setLocation(lengthButtonPoint[i-1]);
        }
        if(lengthButtonX[0] == x){
            lengthButtonX[0] = 10;
        }else if(lengthButtonX[0] == 0){
            lengthButtonX[0] = x - 10;
        }else if(lengthButtonY[0] == y){
            lengthButtonY[0] = 10;
        }else if (lengthButtonY[0] == 0){
            lengthButtonY[0] = y - 10;
        }
        if(lengthButtonX[0] == lengthButtonX[gu-1] && lengthButtonY[0] == lengthButtonY[gu - 1]){
            food = false;
            score += 25;
            scoreTextArea.setText("Score ->> " + score);
//            if(score%50 == 0 && bounsFlag == true){
//                panel1.add(bounsfood);
//                bounsfood.setBounds((10*random.nextInt(50)), (10*random.nextInt(25)), 15, 15);
//                bounsFoodPoint = bounsfood.getLocation();
//                bounsFlag = false;
//            }
        }
        
        if(bounsFlag == false){
            if(bounsFoodPoint.x <= lengthButtonX[0] && bounsFoodPoint.y <= lengthButtonY[0] && bounsFoodPoint.x + 10 >= lengthButtonX[0] && bounsFoodPoint.y + 10 >= lengthButtonY[0]){
                panel1.remove(bounsfood);
                score += 100;
                scoreTextArea.setText("Score ->>" + score);
                bounsFlag = true;
            }
        }
        
        if(food == false){
            grouwp();
            food = true;
        }else {
            lengthButton[gu-1].setBounds(lengthButtonX[gu - 1], lengthButtonY[gu - 1], 10, 10);
        }
        
        for(int i= 1; i < gu; i++){
            if(lengthButtonPoint[0] == lengthButtonPoint[i]){
                Gameover();
                break;
            }
        }
        panel1.repaint();

        
        if(lengthButtonX[0] < 0){
            Gameover();
        }

        if(lengthButtonX[0] > 989){
            Gameover();
        }

        if(lengthButtonY[0] < 0){
            Gameover();
        }

        if(lengthButtonY[0] > 489){
            Gameover();
        }
        show();
    }
    
    void Gameover(){
        scoreTextArea.setText("Game over ->>" + score);
        try{
            myThread.join();
        }catch(InterruptedException ex){}
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        //left arrow key
        if(runl == true && e.getKeyCode() == KeyEvent.VK_LEFT){
            directionx =-10;
            directiony = 0;
            runr = false;
            runu = true;
            rund = true;
        }
        
        // up arrow key
        if(runu == true && e.getKeyCode() == KeyEvent.VK_UP){
            directionx = 0;
            directiony =-10;
            rund = false;
            runr = true;
            runl = true;
        }
        
        // right arrow key
        if(runr == true && e.getKeyCode() == KeyEvent.VK_RIGHT){
            directionx =+10;
            directiony = 0;
            runl = false;
            runu = true;
            rund = true;
        }
        
        // down arrow key 
        if(rund == true && e.getKeyCode() == KeyEvent.VK_DOWN){
            directionx = 0;
            directiony =+10;
            runu = false;
            runr = true;
            runl = true;
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e){
    }
    
    @Override
    public void keyTyped(KeyEvent e){
    }
    
    @Override
    public void run(){
        
        for(;;){
            moveForward();
            try{
                Thread.sleep(speed);
            }catch(InterruptedException ex){
                
            }
        }
    }
    
    public static void main(String[] args) {
        Snake snake = new Snake() {};
    }
    
    void reset(){
        initializeValue();
        setFocusable(true);
        addKeyListener(this);
        panel1.removeAll();
        myThread.stop();
        createFirstSnake();
        scoreTextArea.setText("Score ->> " + score);
        myThread = new Thread(this);
        myThread.start();
        running = true;
    }
}
