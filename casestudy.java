package javacasestudy;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.*;

public class casestudy{

	public casestudy() {
		    
     		JFrame f= new JFrame();
		    JButton b = new JButton("WELCOME");
		    b.setFont(new Font("ALGERIAN",Font.BOLD,10));
		    b.setBounds(195, 140, 100, 40);
		    b.setFocusable(false);
		   
		    JLabel l1 = new JLabel();
			l1.setText("TO");
			l1.setFont(new Font("Bahnschrift SemiBold",Font.CENTER_BASELINE,11));
			l1.setBounds(235,186,80,50);
		   
			JLabel l2 = new JLabel();
			l2.setText("Flight Reservation System");
            l2.setFont(new Font("ALGERIAN",Font.BOLD,14));
			l2.setBounds(120,240,250,50);
			

  		    JButton  b2 = new JButton("login");
  		    
  		    b2.setFont(new Font("Classic",Font.BOLD,10));
 		    b2.setBounds(150, 325, 200, 20);
 		    b2.setFocusable(false);
 		   b2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					try {
						new caselogin();
					} catch (ClassNotFoundException | SQLException e1) {
						
						e1.printStackTrace();
					}
					
				}
		    	
		    });
 		    
			
  		    JButton  b1 = new JButton("sign up");
  		    b1.setFont(new Font("Classic",Font.BOLD,10));
 		    b1.setBounds(150, 365, 200, 20);
 		    b1.setFocusable(false);
 		    b1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					try {
						new casesignup();
					}
					catch (Exception e1) {
						
						e1.printStackTrace();
					}
					
				}
 		    	
 		    });
 		    
	       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      f.getContentPane().setBackground(new Color(10,20,10,10));
	       f.setTitle("Flight.com");
	       f.setResizable(false);
	       f.setSize(500,500);
	       f.setLayout(null);
	       f.setBackground(Color.gray);
	       f.add(b);
	       f.add(l1);
	       f.add(l2);
	       f.add(b2);
	       f.add(b1);
	       f.setVisible(true);
 
	       
	       
	}

	public static void main(String[] args) {
		
		new casestudy();

	}}



