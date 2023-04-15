package javacasestudy;
import java.awt.Color;
//import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class forgot{
      boolean k=false;
      boolean n=false;
	public forgot()throws Exception {
		     
		
		     Class.forName("com.mysql.cj.jdbc.Driver");
		     Connection conn=  DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","Lalli@2003");
			String ins1="update login set psw=? where username=?";
		    PreparedStatement st1 = conn.prepareStatement(ins1);
		

		JFrame f =new JFrame();
 	    f.setTitle("forgot password frame");
		f.setResizable(true);
		f.setSize(1600,1600);
		f.setLayout(null);
	    ImageIcon i4=new ImageIcon("pay6.jpg");
		JLabel lb = new JLabel(i4);
		lb.setBounds(0,0,900,900);
		f.add(lb);
		
	    JLabel l1=new JLabel("Username:");
	    l1.setBounds(600,150,100,30);
	    JTextField t1=new JTextField();
	    t1.setBounds(750,150,150,30);
	    
	    
		JLabel l2=new JLabel("Create Password:");
		l2.setBounds(600,250,100,30);
		JTextField t2=new JTextField();
		t2.setBounds(750,250,150,30);
		

		JLabel l3=new JLabel("Confirm Password:");
		l3.setBounds(600,350,150,30);
		JPasswordField t3=new JPasswordField();
		t3.setBounds(750,350,150, 30);
		JButton b1=new JButton("RESET");
		b1.setBounds(700,400,150,30);
		
		
		
	    b1.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					
					String ins="select username from login where username=? ";
				    PreparedStatement st = conn.prepareStatement(ins);
					st.setString(1,t1.getText());
					ResultSet rs = st.executeQuery();
					if(rs.next())
					{
//						if(rs.getString(1).equals(t1.getText())){
							k=true;
//						}
					}
					if ((t2.getText()).equals(t3.getText())) {
						n=true;
					}
					if (k ==true&& n==true ) {
						
						
						 st1.setString(1, t3.getText());
						st1.setString(2, t1.getText());
						st1.executeUpdate();
						
						String ins2="update signup2 set creatpsw=? where username=?";
						PreparedStatement st2 = conn.prepareStatement(ins2);
						 
						 st2.setString(1, t3.getText());
						st2.setString(2, t1.getText());
						st2.executeUpdate();
						
						new caselogin();
					}
					
					else if(k==false && n==false) {
						JOptionPane.showInternalMessageDialog(null,"ENTER A VALID EMAIL AND BOTH PASSWORDS SHOULD BE SAME", "message", JOptionPane.INFORMATION_MESSAGE);
						
					}
					else if(k==false) {
						JOptionPane.showInternalMessageDialog(null,"ENTER A VALIDD MAIL", "message", JOptionPane.INFORMATION_MESSAGE);
						}
						
					else if(n==false)
					{
						JOptionPane.showInternalMessageDialog(null,"BOTH PASSWORDS FIELDS SHOULD BE SAME", "message", JOptionPane.INFORMATION_MESSAGE);
						

					}
			}catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
	    	
	    });
         
	   
    	f.add(lb);
		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(t1);
		f.add(t2);
		f.add(t3);
		f.add(b1);
		
		
		f.setVisible(true);	
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) throws Exception {
		new forgot();
	
	}

}