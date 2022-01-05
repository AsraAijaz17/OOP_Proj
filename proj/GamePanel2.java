
package com.mycompany.proj;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import java.util.Random;
//Hard Level
public class GamePanel2 extends JPanel implements ActionListener{
JButton b4;

 static final int SCREEN_WIDTH = 600;
 static final int SCREEN_HEIGHT = 600;
 static final int UNIT_SIZE = 25;
 static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
 static final int DELAY = 65;
 final int x[] = new int[GAME_UNITS];
 final int y[] = new int[GAME_UNITS];
 int bodyParts = 6;
static int applesEaten;
 int appleX;
 int appleY;
 char direction = 'R';
 boolean running = false;
 Timer timer;
 Random random;
 
 GamePanel2(){
  random = new Random();
  this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
  this.setBackground(Color.black);
  this.setFocusable(true);
  this.addKeyListener(new MyKeyAdapter());
  startGame();
 
 }
 public void startGame() {
  newApple();
  running = true;
  timer = new Timer(DELAY,this);
  timer.start();
 }
 public void paintComponent(Graphics g) {
  super.paintComponent(g);
  draw(g);
 }
 public void draw(Graphics g) {
  
  if(running) {
   
   g.setColor(Color.red);
   g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
  
   for(int i = 0; i< bodyParts;i++) {
    if(i == 0) {
     g.setColor(Color.green);
     g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
    }
    else {
     g.setColor(new Color(45,180,0));
     //g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
     g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
    }   
   }
   g.setColor(Color.red);
   g.setFont( new Font("Ink Free",Font.BOLD, 40));
   FontMetrics metrics = getFontMetrics(g.getFont());
   g.drawString("Score: "+applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: "+applesEaten))/2, g.getFont().getSize());
  }
  else {
   gameOver(g);
  }
  
 }
 public void newApple(){
  appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
  appleY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
 }
 public void move(){
  for(int i = bodyParts;i>0;i--) {
   x[i] = x[i-1];
   y[i] = y[i-1];
  }
  
  switch(direction) {
  case 'U':
   y[0] = y[0] - UNIT_SIZE;
   break;
  case 'D':
   y[0] = y[0] + UNIT_SIZE;
   break;
  case 'L':
   x[0] = x[0] - UNIT_SIZE;
   break;
  case 'R':
   x[0] = x[0] + UNIT_SIZE;
   break;
  }
  
 }
 public void checkApple() {
  if((x[0] == appleX) && (y[0] == appleY)) {
   bodyParts++;
   applesEaten++;
   newApple();
  }
 }
 public void checkCollisions() {
  
  for(int i = bodyParts;i>0;i--) {
   if((x[0] == x[i])&& (y[0] == y[i])) {
    running = false;
   }
  }
  //check if head touches left border
  if(x[0] < 0) {
   running = false;
  }
  //check if head touches right border
  if(x[0] > SCREEN_WIDTH) {
   running = false;
  }
  //check if head touches top border
  if(y[0] < 0) {
   running = false;
  }
  //check if head touches bottom border
  if(y[0] > SCREEN_HEIGHT) {
   running = false;
  }
  
  if(!running) {
   timer.stop();
  }
 }
 public void gameOver(Graphics g) {
  //Score
  g.setColor(Color.red);
  g.setFont( new Font("Ink Free",Font.BOLD, 40));
  FontMetrics metrics1 = getFontMetrics(g.getFont());
  g.drawString("Score: "+applesEaten, (SCREEN_WIDTH - metrics1.stringWidth("Score: "+applesEaten))/2, g.getFont().getSize());

  File myFile = new File("HardlevelScore.txt");
        try {
            myFile.createNewFile();
            System.out.println("File created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
         try {
            FileWriter fileWriter = new FileWriter("HardlevelScore.txt");
             if(applesEaten > 0){
            fileWriter.write("Your last Score of Hard level is"+" "+ applesEaten);
            fileWriter.close();}

        } catch (IOException e) {
            e.printStackTrace();
        }


  //Game Over text
  g.setColor(Color.red);
  g.setFont( new Font("Ink Free",Font.BOLD, 75));
  FontMetrics metrics2 = getFontMetrics(g.getFont());
  g.drawString("Game Over", (SCREEN_WIDTH - metrics2.stringWidth("Game Over"))/2, SCREEN_HEIGHT/2);
 
//Back button

 b4= new JButton("back");

b4.setBounds(240,500,120,25);
b4.setBackground(Color.WHITE);
b4.setForeground(Color.RED);
b4.addActionListener(this);
add(b4);
               
               
 }
 @Override
 public void actionPerformed(ActionEvent e) {
  
  if(running) {
   move();
   checkApple();
   checkCollisions();
  }
  repaint();

  if(e.getSource()==b4){
  this.setVisible(false);
  new SnakeGame();
  }

 }
 
 public class MyKeyAdapter extends KeyAdapter{
  @Override
  public void keyPressed(KeyEvent e) {
   switch(e.getKeyCode()) {
   case KeyEvent.VK_LEFT:
    if(direction != 'R') {
     direction = 'L';
    }
    break;
   case KeyEvent.VK_RIGHT:
    if(direction != 'L') {
     direction = 'R';
    }
    break;
   case KeyEvent.VK_UP:
    if(direction != 'D') {
     direction = 'U';
    }
    break;
   case KeyEvent.VK_DOWN:
    if(direction != 'U') {
     direction = 'D';
    }
    break;
    case KeyEvent.VK_ENTER:
                    if(!running){
                      new GameFrame2();
                        }
                    break;
  }
 }
 
}
 public int getScores(){
  return applesEaten;
 }
}
