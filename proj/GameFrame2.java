/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.proj;

import javax.swing.JFrame;

public class GameFrame2 extends JFrame {
    //Hard Level

 GameFrame2(){
 this.add(new GamePanel2());
 this.setTitle("Snake");
 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 this.setResizable(false);
 this.pack();
 this.setVisible(true);
 this.setLocationRelativeTo(null);
 
 }

}
