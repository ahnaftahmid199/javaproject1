/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject1;

/**
 *
 * @author User
 */
import java.sql.*;

import javax.swing.JOptionPane;
public class DbConn {
	
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private int flag = 0;
	
	
	public DbConn() {
    try {  
	Class.forName("com.mysql.cj.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project1","root","");
	st = con.createStatement();
    } catch (Exception e) {
    	
    System.out.println("Error : "+e);
    }
		
	}


	public void RegisterInsert(String queryInsert) {
		
	try {
	st.executeUpdate(queryInsert);
	JOptionPane.showMessageDialog(null, "Registration Completed!");
        //System.out.println("  "+queryInsert);
	
	} catch (Exception e) {
	JOptionPane.showMessageDialog(null, "Registration not Completed!"+e);	 
	//System.out.println("Insert Error :"+e);
	e.printStackTrace();
	}
		
	}


	public void Login(String queryLogin, String userName , String pass) {
	try {
	rs = st.executeQuery(queryLogin);	
	
	while (rs.next()) {
	
	String tableUsername = rs.getString(2);
	String tablePass = rs.getString(4);
	
	//System.out.println(tableUsername+ "     " +tablePass);
	
	
	if(userName.equals(tableUsername) && pass.equals(tablePass)) {
	
	JOptionPane.showMessageDialog(null, "Welcome! You are a valid user");	
	flag = 1;
	//new MainWindow();
	
	break;
		
	}
		
	}
	
	if (flag == 0) {
		
	JOptionPane.showMessageDialog(null,"Username and Password isn't matching");		
	}
	
	
	
	} catch (Exception e) {
			
			
		}
		
		
		
		}
}
