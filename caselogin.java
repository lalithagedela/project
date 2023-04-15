package javacasestudy;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class caselogin {
	boolean k=false;
	
	public caselogin()throws SQLException,ClassNotFoundException {
		
		JFrame f=new JFrame(); 
		JLabel l2=new JLabel();
		
		
		ImageIcon i4=new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\javacasestudy\\home35.jpg");
		JLabel lb = new JLabel();
		lb.setIcon(i4);
		lb.setBounds(0,-500,1600,1600);
		
		
		
		
	    JLabel label1=new JLabel();
	    label1.setText("U S E R N A M E");
	    label1.setBounds(200,100,550,30);
	    label1.setForeground(Color.black);
	    JTextField t1=new JTextField();
	    t1.setBounds(350,100,150,30);
	    
	    JLabel label2=new JLabel("P A S S W O R D");
	    label2.setBounds(200,180,650,30);
	    label2.setForeground(Color.black);
	    JPasswordField t2=new JPasswordField();
	    t2.setBounds(350,180,150,30);
	    
	    
	    JButton b3=new JButton("Forgot Password?");
	    b3.setBounds(590,253,140,30);
	    
	    JButton b1=new JButton("S U B M I T");
	    b1.setBounds(365,250,100,30);
	    
	    JButton b2=new JButton("C R E A T E  A N  A C C O U N T ");
	    b2.setBounds(350,440,400,30);
	    
	    
	    ImageIcon i3=new ImageIcon("back2.png");
		JButton b13= new JButton(); 
 		b13.setIcon(i3);
 	    b13.setBackground(new Color(0x4faba0));
 		b13.setBounds(0, 5, 50,50);
 		b13.setFocusPainted(false);
 		b13.setBorderPainted(false);
 		b13.setFocusable(false);
 		
 		b13.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new border();
			}
 			
 		});
 		
 		
	    
	    b1.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { 
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mySql://localhost:3306/airline","root","Lalli@2003");
					String ins= "select username,psw from login where username=? and psw=?";
					PreparedStatement st = conn.prepareStatement(ins);
					
					st.setString(1,t1.getText());
					st.setString(2, t2.getText());
					ResultSet rs = st.executeQuery();

					if(rs.next()) {
				      if(rs.getString(1).equals(t1.getText())&&rs.getString(2).equals(t2.getText()))
						
							k=true;
						
					
					}
						if(k)
						{
						    
                           
					JOptionPane.showInternalMessageDialog(null,"login successfull", "message", JOptionPane.INFORMATION_MESSAGE);
					         new ways();
						}
					else
							JOptionPane.showInternalMessageDialog(null,"login unsuccessful", "error!", JOptionPane.ERROR_MESSAGE);
					
				}
				
					catch (SQLException e1) {
					
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
						
						e1.printStackTrace();
					}
			}
	
				
	    	
	    });
	    
	   b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					new casesignup();
				} catch (ClassNotFoundException | SQLException e1) {
					
					e1.printStackTrace();
				}
			}
	    	
	    });
	    


	    b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					new casestudy5();
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}
	    	
	    });
	    

	   
	    
	    
	    f.add(b13);
	    f.setLayout(null);
        f.getContentPane().setBackground(new Color(132,206,235));
	    f.add(label1);
	    f.add(t1);
	    f.add(label2);
	    f.add(t2);
        f.add(b1);
	    f.add(b2);
	    f.add( b3);
	    f.add(lb);
	    f.setTitle("Login");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setSize(1600,1600);
		

	    
	}

	

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		try
		{
		new caselogin();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

}