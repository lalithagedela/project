package javacasestudy;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.*;
import javax.swing.*;
public class printing implements ActionListener{
	JFrame f;
	JTextArea t;
	JButton b;
	public printing() {
	
		f = new JFrame();
		f.getContentPane().setBackground(Color.cyan);
		f.setLayout(null);
		t = new JTextArea();
		b = new JButton("Print");
		t.setFont(new Font("MU Boli",Font.BOLD,20));
		//t.setBackground(Color.darkGray);
		b.setFont(new Font("MU Boli",Font.BOLD,20));
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline?CharacterEncoding=latin1","root","Lalli@2003");
			PreparedStatement st = con.prepareStatement("select * from search where To_flight=?");
			st.setString(1,"Hyderabad");
			ResultSet rs = st.executeQuery();
			

			
			ImageIcon i3=new ImageIcon("back2.png");
			JButton b13= new JButton(); 
				b13.setIcon(i3);
			    b13.setBackground(new Color(0x4faba0));
				b13.setBounds(0, 5, 50,50);
				b13.setFocusPainted(false);
				b13.setBorderPainted(false);
				b13.setFocusable(false);
				f.add(b13);
				b13.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new payment();
				}
					
				});
			while(rs.next()) {
				t.append("\n\n\n\tAirline Tickets Details\n\n\n\n"+
			"\tFrom_flight.\t\t"+rs.getString(1)+
			"\n\n\tTo_flight.\t\t"+rs.getString(2)+"\n\n\tPrice.\t\t"+rs.getString(3)+"\n\n\tTime.\t\t"+rs.getString(4));
				t.setBounds(0,0,1550,600);	
				t.setEditable(false);
			}
			f.add(t);
			b.setBounds(700,700,100,50);
			f.add(b);
			b.addActionListener(this);
			f.setExtendedState(JFrame.MAXIMIZED_BOTH);
			
			
			printing1();
		}catch(Exception e) {}
	}
	
	public void printing1()
	{
	
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline?CharacterEncoding=latin1","root","Lalli@2003");
			PreparedStatement st = con.prepareStatement("select * from customer2 where f_name=?");
			st.setString(1,"lalitha");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
			
			t.append("\n\n\tFirst Name.\t\t"+rs.getString(1)+
			"\n\n\tLast Name.\t\t"+rs.getString(2)+"\n\n\tPhone no.\t\t"+rs.getString(3)+"\n\n\tEmail.\t\t"+rs.getString(4));
				
			}
			f.setVisible(true);
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
	}
	


	
	
	
	
	public static void main(String args[]){
		new printing();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == b) {
			try {
				t.print();
			} catch (PrinterException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		
		
		
		
		
	}
	
	
}