package javacasestudy;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class casestudy5{
	
      boolean k=false;
      boolean n=false;
      
	public casestudy5()throws ClassNotFoundException,SQLException {
	
	    
		JFrame f =new JFrame();
 	    f.setTitle("forgot password frame");
		f.setResizable(true);
		f.setSize(1600,1600);
		f.setLayout(null);
		
		
	    ImageIcon i4=new ImageIcon("C:\\Users\\HP\\Downloads\\New folder\\logo34.jpg");
		JLabel lb = new JLabel(i4);
		lb.setBounds(0,-500,1600,1600);
		f.add(lb);
		
	    JLabel l1=new JLabel("Username:");
	    l1.setBounds(1000,150,200,30);
	    final JTextField t1=new JTextField();
	    t1.setBounds(1200,150,200,30);
	    l1.setFont(new Font("Arial Black",Font.BOLD,20));
	    
	    
		JLabel l2=new JLabel("Create Password:");
		l2.setBounds(950,250,250,30);
		final JTextField t2=new JTextField();
		t2.setBounds(1200,250,200,30);
		l2.setFont(new Font("Arial Black",Font.BOLD,20));
		JButton backbutton = new JButton("Previous Login page");
		backbutton.setBounds(800, 500, 220, 44);
		f.add(backbutton);
		
		
		backbutton.setForeground(Color.WHITE);
		backbutton.setFont(new Font("Arial Black", Font.PLAIN, 14));
		backbutton.setBackground(Color.BLACK);
		backbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new caselogin();
				} catch (ClassNotFoundException | SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		

		JLabel l3=new JLabel("Confirm Password:");
		l3.setBounds(950,350,250,30);
		final JPasswordField t3=new JPasswordField();
		t3.setBounds(1200,350,200, 30);
		l3.setFont(new Font("Arial Black",Font.BOLD,20));
		JButton b1=new JButton("RESET");
		b1.setBounds(1200,500,220,44);
	
		
		
		
	    b1.addActionListener(new ActionListener() {

			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					

					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mySql://localhost:3306/airline","root","Lalli@2003");
					
					String ins="select psw from login where username=? ";
				    PreparedStatement st = conn.prepareStatement(ins);
					 
					st.setString(1,t1.getText());
					ResultSet rs = st.executeQuery();
					if(rs.next())
				{
					if(rs.getString(1).equals(t1.getText())){
							k=true;
  			    	}
					}
					if ((t2.getText()).equals(t3.getText())) {
						n=true;
					}
					if (k ==true&& n==true ) {
						
						String ins1="update login set psw=? where username=?";
						 PreparedStatement st1 = conn.prepareStatement(ins1);
						
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
					
					e1.printStackTrace();
				}
			}
	    	
	    });
	    
	    
    	
		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(t1);
		f.add(t2);
		f.add(t3);
		f.add(b1);
		f.add(lb);
		f.setVisible(true);	
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) throws Exception {
		new casestudy5();
	
	}

}