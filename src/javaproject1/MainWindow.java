/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject1;

package myproject5;
import javax.swing.JFrame;
import javax.swing.JLabel;
    


public class MainWindow extends JFrame {
    public MainWindow(){
        setSize(800,400);
         setDefaultCloseOperation(3);
	 //setLayout(null);
	 setLocationRelativeTo(null);
         JLabel hello = new JLabel("Welcome to main window");
         add(hello);
         setVisible(true);
	 
    
    
    
    }
    
}

