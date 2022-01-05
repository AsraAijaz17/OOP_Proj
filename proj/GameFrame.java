/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.proj;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFrame;

public class GameFrame extends JFrame {


    //Medium Level
 GameFrame(){
 this.add(new GamePanel());
 this.setTitle("Snake");
 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 this.setResizable(false);
 this.pack();
 this.setVisible(true);
 this.setLocationRelativeTo(null);
 
 }
 
}