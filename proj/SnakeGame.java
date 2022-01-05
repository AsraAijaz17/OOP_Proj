/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.proj;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static com.mycompany.proj.GamePanel.applesEaten;

public class SnakeGame extends JFrame implements ActionListener{
JButton b1,b2,b3;
JTextField t1;
SnakeGame(){
setBounds(300,100,600,700);
getContentPane().setBackground(Color.BLACK);
setLayout(null);
 this.setResizable(false);
JLabel l2 = new JLabel("SNAKE GAME"); 
l2.setFont( new Font("Ink Free",Font.BOLD, 25));
l2.setForeground(Color.RED);
l2.setBounds(180,40,180,50);
add(l2);
JLabel l3 = new JLabel("Enter Your Name:"); 
l3.setFont( new Font("Ink Free",Font.BOLD, 15));
l3.setForeground(Color.RED);
l3.setBounds(190,100,180,20);
add(l3);
t1 = new JTextField();
t1.setBounds(170,150,180,25);
add(t1);
JLabel l1 = new JLabel("Levels"); 
l1.setFont( new Font("Ink Free",Font.BOLD, 20));
l1.setForeground(Color.RED);
l1.setBounds(220,210,180,50);
add(l1);
b1=new JButton("Easy");
b1.setBounds(70,260,120,25);
b1.setBackground(Color.WHITE);
b1.setForeground(Color.RED);
b1.addActionListener(this);
add(b1);
b2=new JButton("Medium");
b2.setBounds(200,260,120,25);
b2.setBackground(Color.WHITE);
b2.setForeground(Color.RED);
b2.addActionListener(this);
add(b2);
b3=new JButton("Hard");
b3.setBounds(330,260,120,25);
b3.setBackground(Color.WHITE);
b3.setForeground(Color.RED);
b3.addActionListener(this);
add(b3);



setVisible(true);
}

public void actionPerformed(ActionEvent e){
  if(e.getSource()==b1){
      this.setVisible(false);
      new GameFrame1();
  }
 if(e.getSource()==b2){
     this.setVisible(false);
      new GameFrame();
  }
  if(e.getSource()==b3){
      this.setVisible(false);
      new GameFrame2();
  }

}

 public static void main(String[] args) {
 new SnakeGame(); 
 

}
 }     