package javacasestudy;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.PreparedStatement;



import javax.swing.*;
public class casesignup {
	public casesignup()throws SQLException,ClassNotFoundException
	{
		
		
		JFrame f1 = new JFrame ();
		f1.setTitle("signup");
		f1.setSize(1600,1600);
		f1.setLayout(null);
		
		
		ImageIcon i4=new ImageIcon("C:\\Users\\HP\\Downloads\\New folder\\si.jpg");
		JLabel lb = new JLabel();
		lb.setIcon(i4);
		lb.setBounds(0,-300,1600,1600);
		

		final JLabel l6 = new JLabel("First Name");
		l6.setBounds(420,120,80,30);
		final JTextField t1=new JTextField();
		t1.setBounds(520,120,250,30);
		
		final JLabel l7 = new JLabel("LastName");
		l7.setBounds(420,190,60,30);
		final JTextField t2=new JTextField();
		t2.setBounds(520,190,250,30);
		final JLabel l8 = new JLabel("Email");
		l8.setBounds(420,260,160,30);
		final JTextField  t3=new JTextField();
		t3.setBounds(520,260,250,30);
		
		final JLabel l9 = new JLabel("Create Password");
		l9.setBounds(410,340,160,30);
		final JTextField t4=new JTextField();
		t4.setBounds(520,340,250,30);
		
		final JLabel l10 = new JLabel("Confirm Password");
		l10.setBounds(410,420,160,30);
		final JPasswordField t5=new JPasswordField();
		t5.setBounds(520,420,250,30);
		
		final JLabel l11 = new JLabel("UserName");
		l11.setBounds(420,510,60,30);
		final JTextField  t6=new JTextField();
		t6.setBounds(520,510,250,30);
		
		
		JButton  b1 = new JButton("S U B M I T");
		    b1.setFont(new Font("Classic",Font.BOLD,20));
		    b1.setBounds(500, 660, 250, 50);
		    b1.setFocusable(false);
		    
		    
		  
		   
    		
		    b1.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(t4.getText().equals(t5.getText())) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver"); 
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","Lalli@2003");
				    String ins="insert into signup2(f_name,l_name,email,creatpsw,confirmpsw,username)values(?,?,?,?,?,?)";
					PreparedStatement st = conn.prepareStatement(ins);

					st.setString(1,t1.getText());
					st.setString(2,t2.getText());
					st.setString(3,t3.getText());
					st.setString(4,t4.getText());
					st.setString(5,t5.getText());
					st.setString(6,t6.getText());
					st.executeUpdate();
					
					String ins1="insert into login values(?,?)";
					PreparedStatement st1=conn.prepareStatement(ins1);
					st1.setString(1,t6.getText());
					st1.setString(2,t5.getText());
					st1.executeUpdate();
					
					
					new caselogin();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 				
			}
	    	
		    else
		    {
		    	JOptionPane.showInternalMessageDialog(null,"Thapu thapu thapu? thapu ga rayadhu", "error!", JOptionPane.ERROR_MESSAGE);
		    }
			}
		    });
		    
		    
		    JButton  b2 = new JButton("B A C K");
		    b2.setFont(new Font("Classic",Font.BOLD,20));
		    b2.setBounds(110, 660, 200, 50);
		    b2.setFocusable(false);
		    
		    b2.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e)
		    	{
		    		try {
						new caselogin();
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    	}
		    });
		
		f1.add(l6);
		f1.add(t1);
		f1.add(l7);
		f1.add(t2);
		f1.add(l8);
		f1.add(t3);
		f1.add(l9);
		f1.add(t4);
		f1.add(l10);
		f1.add(t5);
		f1.add(l11);
		f1.add(t6);
		f1.add(b1);
		f1.add(b2);
		f1.add(lb);
		f1.setVisible(true);

	}
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		new casesignup();
		
	}
}


