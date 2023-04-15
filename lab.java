package javacasestudy;
import javax.swing.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class lab
{
	public lab () throws ClassNotFoundException, SQLException
	{
		
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection conn=DriverManager.getConnection("jdbc:mySql://localhost:3306/pro","root","Lalli@2003");
		        String ins="insert into flight values(?,?,?,?)";	
		        String ins1="delete from flight where p_name=?";
		        String ins2="update flight set seatno=? where p_name=?";
		
		
		
		     JFrame f =new JFrame();
		     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    JLabel l1=new JLabel("passenger name");
		    l1.setBounds(600,150,100,30);
		    JTextField t1=new JTextField();
		    t1.setBounds(750,150,150,30);
		    
		    
		    
		    JLabel l2=new JLabel("seat no");
			l2.setBounds(600,250,100,30);
			JTextField t2=new JTextField();
			t2.setBounds(750,250,150,30);
			
			
			JLabel l3=new JLabel("depature time");
			l3.setBounds(600,350,150,30);
			JTextField t3=new JTextField();
			t3.setBounds(750,350,150, 30);
			
			
			
			JLabel l4=new JLabel("arrival time");
			l4.setBounds(600,450,250,30);
			JTextField t4=new JTextField();
			t4.setBounds(750,450,150, 30);
			
			
	      JButton b1 = new JButton("INSERT");
	      b1.setBounds(600,550,80,30);
	      JButton b2 = new JButton("DELETE");
	      b2.setBounds(800,550,80,30);
	      JButton b3 = new JButton("UPDATE");
	      b3.setBounds(800,750,80,30);
	      
	      b1.addActionListener((ActionListener) new ActionListener() {

	 			@Override
	 			public void actionPerformed(ActionEvent e) { 
	 				
	 				try
	 				{
	 					
	 			        PreparedStatement st = conn.prepareStatement(ins);
	 			        st.setString(1, t1.getText());
	 			       st.setString(2, t2.getText());
	 			      st.setString(3, t3.getText());
	 			     st.setString(4, t4.getText());
	 			     st.executeUpdate();
	 			     
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
	 			}
	      });
	      
	      
	      
	      b2.addActionListener((ActionListener) new ActionListener() {

	 			@Override
	 			public void actionPerformed(ActionEvent e) { 
	 				
	 				try {
	 					
	 			        PreparedStatement st1 = conn.prepareStatement(ins1);
	 			       st1.setString(1, t1.getText());
	 			        st1.executeUpdate();
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
	 			}
	      });
	      
	      

	      b3.addActionListener((ActionListener) new ActionListener() {

	 			@Override
	 			public void actionPerformed(ActionEvent e) { 
	 				
	 				try {
	 					
	 			        PreparedStatement st2 = conn.prepareStatement(ins2);
	 			        st2.setString(1, t2.getText());
	 			       st2.setString(2, t1.getText());
	 			        st2.executeUpdate();
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
	 			}
	      });
			
			
		 		
		 	    f.setTitle("dbms lab");
				f.setResizable(true);
				f.setSize(1600,1600);
				f.setLayout(null);
				
				f.add(b1);
				f.add(b2);
				f.add(b3);
				f.add(l1);
				f.add(l2);
				f.add(l3);
				f.add(l4);
				f.add(t1);
				f.add(t2);
				f.add(t3);
				f.add(t4);
				
				f.setVisible(true);
				
	}
				
			public static void main(String args[])
			{
		
					try {
						new lab();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				
			
			
	}
	
}


