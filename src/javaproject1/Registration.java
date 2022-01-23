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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.util.regex.*; 

public class Registration extends JFrame {
	
	    Registration(){
		
		setSize(500,460);
		setDefaultCloseOperation(3);
		setLayout(null);
		setLocationRelativeTo(null);
		//setResizable(false);
		
		JPanel headerpanel = new JPanel();
		//headerpanel.setBackground(new Color(95, 151, 207));
		headerpanel.setBackground(Color.cyan);
		headerpanel.setBounds(5,5,490,60);
		add(headerpanel);
		
		JLabel headertext = new JLabel("Registration Form");
		headertext.setFont(new Font("Arial",Font.BOLD,30));
		headerpanel.add(headertext);
		
		

		JPanel inputPanel = new JPanel();
		//inputPanel.setBackground(new Color(199,227,240));
		inputPanel.setBackground(new Color(199,227,240));
		inputPanel.setBounds(5,70,490,425);
		inputPanel.setLayout(null);
		add(inputPanel);
		
		Font labelFont = new Font("Arial",Font.BOLD,16);
		
		
		JLabel name = new JLabel("Name : ");
		name.setBounds(130,5,100,25);
		name.setFont(labelFont);
		inputPanel.add(name);
		
		JTextField nameText = new JTextField();
		nameText.setBounds(200,5,200,25);
		//nameText.setBackground(new Color(240, 226, 189));
		nameText.setFont(labelFont);
		inputPanel.add(nameText);
		
		JLabel email = new JLabel("Email : ");
		email.setBounds(130,50,100,25);
		email.setFont(labelFont);
		inputPanel.add(email);
		
		JTextField emailText = new JTextField();
		emailText.setBounds(200,50,200,25);
		emailText.setFont(labelFont);
		inputPanel.add(emailText);
		
		
		JLabel pass = new JLabel("Password : ");
		pass.setBounds(100,100,100,25);
		pass.setFont(labelFont);
		inputPanel.add(pass);
		
		JTextField passText = new JTextField();
		passText.setBounds(200,100,200,25);
		passText.setFont(labelFont);
		inputPanel.add(passText);
		
		

		JLabel conPass = new JLabel("Confirm Password : ");
		conPass.setBounds(35,150,170,25);
		conPass.setFont(labelFont);
		inputPanel.add(conPass);
		
		JTextField conPassText = new JTextField();
		conPassText.setBounds(200,150,200,25);
		conPassText.setFont(labelFont);
		inputPanel.add(conPassText);
		
		
		JLabel mob = new JLabel("Mobile : ");
		mob.setBounds(130,200,100,25);
		mob.setFont(labelFont);
		inputPanel.add(mob);
		
		JTextField mobText = new JTextField();
		mobText.setBounds(200,200,200,25);
		mobText.setFont(labelFont);
		inputPanel.add(mobText);
		
		

		JLabel address = new JLabel("Address : ");
		address.setBounds(115,250,100,25);
		address.setFont(labelFont);
		inputPanel.add(address);
		
		JTextField addText = new JTextField();
		addText.setBounds(200,250,200,25);
		addText.setFont(labelFont);
		inputPanel.add(addText);
		
		JButton regBtn = new JButton("Register");
		regBtn.setBounds(300,300,100,30);
		regBtn.setBackground(new Color(219,143,160));
		regBtn.setFont(labelFont);
		regBtn.setForeground(Color.WHITE);
		regBtn.setBorder(new LineBorder(Color.RED));
		inputPanel.add(regBtn);
		
		
		JButton loginBtn = new JButton("Login");
		loginBtn.setBounds(100,300,100,30);
		loginBtn.setBackground(new Color(93,161,217));
		loginBtn.setFont(labelFont);
		loginBtn.setForeground(Color.WHITE);
		loginBtn.setBorder(new LineBorder(Color.BLUE));
		inputPanel.add(loginBtn);
		
		setVisible(true);
		
		
		loginBtn.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
					
					
		dispose();
		new Login();
					
		}
			 });
		
		regBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			String userName = nameText.getText();
			String email = emailText.getText();
			String pass = passText.getText();
			String conPass = conPassText.getText();
			String mob = mobText.getText();
			String address = addText.getText();
			
			String mobileRegex = "(\\+88)?01[3-9]\\d{8}";
			String userNameRegex = "^[a-zA-Z .]+$";
			String emailRegex = "^[a-z0-9]+@[a-z]+.[a-z]+$";
			
			if(!Pattern.matches(userNameRegex, userName)) {
				
			JOptionPane.showMessageDialog(null, "Invalid Username");
				
			}
			else if(!Pattern.matches(emailRegex, email)) {
			 JOptionPane.showMessageDialog(null, "Invalid Email");
				
			}
			else if(!pass.equals(conPass)) {
				
			JOptionPane.showMessageDialog(null, "Password and Confirm Password isn't matching");
				
			}
			else if(!Pattern.matches(mobileRegex, mob)) {
				
			JOptionPane.showMessageDialog(null, "Invalid Mobile Number");
				
			}
			
			else {
				
			DbConn db = new DbConn();
				
			String queryInsert = "INSERT INTO `register`(`username`, `email`, `pass`, `mobile`, `address`) VALUES ('"+userName+"','"+email+"','"+pass+"','"+mob+"','"+address+"')";
			//System.out.println(" "+queryInsert);
			db.RegisterInsert(queryInsert);
			
		}
			
	}
			  
 });
		  
	}
}
