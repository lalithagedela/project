package javacasestudy;
import java.awt.Color;
//import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
public class border{

	public border() {
		
		JFrame jf=new JFrame();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(1600,1600);
		
		
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		p1.setBackground(new Color(0x01a3a0));
		p1.setBounds(0, 0, 1500, 200);
		p2.setBackground(new Color(0x2d3c50));
		p2.setBounds(0, 200, 1500,1300);
		
		
	    JLabel l1=new JLabel("NLVR AIRLINES");
     	l1.setFont(new Font("Algerian",Font.BOLD,65));	
		l1.setForeground(Color.darkGray);
		l1.setBounds(490,35,700,70);
		
		
	
		ImageIcon i4=new ImageIcon("C:\\Users\\HP\\Downloads\\New folder\\a2.png");
		JLabel label4 = new JLabel(); 
 		label4.setIcon(i4);
 		label4.setBounds(0, 0, 250,190);
 		
 		
	    

		ImageIcon i1=new ImageIcon("home.png");
		JButton label1 = new JButton(); 
 		label1.setIcon(i1);
 		label1.setBackground( new Color(0x2d3c50));
 		label1.setBounds(360, 400, 150,200);
 		label1.setBorderPainted(false);
 		
 		label1.addActionListener((ActionListener) new ActionListener() {

 			@Override
 			public void actionPerformed(ActionEvent e) { 
 				
 				new ways();
 			}
 		 });
 	
 		
 		
 		ImageIcon i2=new ImageIcon("login5.jpg");
		JButton label2 = new JButton(); 
 		label2.setIcon(i2);
 		label2.setBackground( new Color(0x2d3c50));
 		label2.setBounds(700, 400, 150,200);
 		label2.setBorderPainted(false);
 	 	

 		 label2.addActionListener((ActionListener) new ActionListener() {

 			@Override
 			public void actionPerformed(ActionEvent e) { 
 				
 				try {
					new caselogin();
				} catch (ClassNotFoundException e1) {
					
					e1.printStackTrace();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
 			}
 		 });
 		
 		ImageIcon i3=new ImageIcon("signup7.jpg");
		JButton label3= new JButton(); 
 		label3.setIcon(i3);
 		label3.setBackground( new Color(0x2d3c50));
 		label3.setBounds(1000, 400, 150,200);
 		label3.setBorderPainted(false);
 		


 		 label3.addActionListener((ActionListener) new ActionListener() {

  			@Override
  			public void actionPerformed(ActionEvent e) { 
  				
  				try {
 					new casesignup();
 				} catch (ClassNotFoundException e1) {
 					
 					e1.printStackTrace();
 				} catch (SQLException e1) {
 					
 					e1.printStackTrace();
 				}
  			}
  		 });
 		
 		
	
 		
		
		jf.add(label1);
		jf.add(label2);
		jf.add(label3);
		jf.add(label4);
		jf.add(l1);
		jf.add(p1);
	
		jf.add(p2);
		jf.setLayout(null);
		jf.setVisible(true);
	}



	public static void main(String[] args) {
		
        new border();
	}

}