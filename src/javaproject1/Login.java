/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Login extends JFrame {
	
	 Login(){
			
         setSize(500,300);
         setDefaultCloseOperation(3);
	 setLayout(null);
	 setLocationRelativeTo(null);
	 //setResizable(false);
	 
	 
	 
	 JPanel headerpanel = new JPanel();
	 //headerpanel.setBackground(new Color(95, 151, 207));
	 headerpanel.setBackground(Color.cyan);
	 headerpanel.setBounds(5,5,490,60);
	 add(headerpanel);
		
	 JLabel headertext = new JLabel("Login Form");
	 headertext.setFont(new Font("Arial",Font.BOLD,30));
	 headerpanel.add(headertext);
	 
	 JPanel inputPanel = new JPanel();
	 //inputPanel.setBackground(new Color(199,227,240));
	 inputPanel.setBackground(new Color(199,227,240));
	 inputPanel.setBounds(5,70,490,425);
	 inputPanel.setLayout(null);
	 add(inputPanel);
		
	 Font labelFont = new Font("Arial",Font.BOLD,16);
	 
	 
	 JLabel name = new JLabel("Username : ");
	 name.setBounds(80,25,100,25);
	 name.setFont(labelFont);
	 inputPanel.add(name);
		
	 JTextField nameText = new JTextField();
	 nameText.setBounds(200,25,200,25);
	 nameText.setFont(labelFont);
	 inputPanel.add(nameText);
	 
	 JLabel pass = new JLabel("Password : ");
	 pass.setBounds(80,70,100,25);
	 pass.setFont(labelFont);
	 inputPanel.add(pass);
		
	 JTextField passText = new JTextField();
	 passText.setBounds(200,70,200,25);
	 passText.setFont(labelFont);
	 inputPanel.add(passText);
	 
	 JButton loginBtn = new JButton("Login");
	 loginBtn.setBounds(300,120,100,30);
	 loginBtn.setBackground(new Color(93,161,217));
	 loginBtn.setFont(labelFont);
	 loginBtn.setForeground(Color.WHITE);
	 loginBtn.setBorder(new LineBorder(Color.BLUE));
	 inputPanel.add(loginBtn);
	 
	 JButton regBtn = new JButton("Register");
	 regBtn.setBounds(100,120,100,30);
	 regBtn.setBackground(new Color(219,143,160));
	 regBtn.setFont(labelFont);
	 regBtn.setForeground(Color.WHITE);
	 regBtn.setBorder(new LineBorder(Color.RED));
	 inputPanel.add(regBtn);
		
	 setVisible(true);
	  
	 regBtn.addActionListener(new ActionListener() {

	 @Override
	  public void actionPerformed(ActionEvent e) {
			
			
	   dispose();
	   new Registration();
	  
		}
	  });
	  
	  
	  loginBtn.addActionListener(new ActionListener() {

	  @Override
	  public void actionPerformed(ActionEvent e) {
		  
	  String userName = nameText.getText();
	 
	  String pass = passText.getText();
	  
	
				
			
	  DbConn db = new DbConn();
			
	  String queryLogin = "SELECT * FROM `register`";
	  db.Login(queryLogin,userName,pass);	  
		  
		  
      	  dispose();
      	  new MainWindow();
		  
		  }
					  
	   });
	
         }	 
   }
