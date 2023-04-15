package javacasestudy;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class project extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField first;
	private JTextField last;
	private JTextField textPhone;
	private JTextField textEmail;

	public project(){
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\chiki\\Downloads\\paper-plane.png"));
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setForeground(Color.BLACK);
		setSize(1600,1600);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		getContentPane().setLayout(null);
		
		
		
		
		JPanel innerPanel = new JPanel();
		innerPanel.setForeground(Color.WHITE);
		innerPanel.setBackground(Color.BLACK);
		innerPanel.setBounds(150, 42, 899, 629);
		getContentPane().add(innerPanel);
		innerPanel.setLayout(null);
		
		JLabel heading = new JLabel("Passenger Details");
		heading.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
		heading.setBackground(Color.BLACK);
		heading.setForeground(Color.WHITE);
		heading.setBounds(23, 25, 325, 100);
		innerPanel.add(heading);
		
		JRadioButton mr = new JRadioButton(".Mr");
		mr.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		mr.setForeground(Color.WHITE);
		mr.setBackground(Color.BLACK);
		mr.setBounds(27, 123, 109, 23);
		innerPanel.add(mr);
		
		JRadioButton ms = new JRadioButton(".Ms");
		ms.setForeground(Color.WHITE);
		ms.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ms.setBackground(Color.BLACK);
		ms.setBounds(170, 124, 109, 23);
		innerPanel.add(ms);
		
		JRadioButton Mrs = new JRadioButton(".Mrs");
		Mrs.setForeground(Color.WHITE);
		Mrs.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		Mrs.setBackground(Color.BLACK);
		Mrs.setBounds(355, 124, 109, 23);
		innerPanel.add(Mrs);
		
		JLabel firstname = new JLabel("First Name :");
		firstname.setFont(new Font("Arial Black", Font.PLAIN, 14));
		firstname.setBackground(Color.BLACK);
		firstname.setForeground(Color.WHITE);
		firstname.setBounds(41, 184, 185, 23);
		innerPanel.add(firstname);
		
		JLabel lastname = new JLabel("Last Name :");
		lastname.setForeground(Color.WHITE);
		lastname.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lastname.setBackground(Color.BLACK);
		lastname.setBounds(478, 184, 185, 23);
		innerPanel.add(lastname);
		
		JLabel phone = new JLabel("Phone Number :");
		phone.setForeground(Color.WHITE);
		phone.setFont(new Font("Arial Black", Font.PLAIN, 14));
		phone.setBackground(Color.BLACK);
		phone.setBounds(41, 336, 185, 23);
		innerPanel.add(phone);
		
		JLabel email = new JLabel("Email id :");
		email.setForeground(Color.WHITE);
		email.setFont(new Font("Arial Black", Font.PLAIN, 14));
		email.setBackground(Color.BLACK);
		email.setBounds(478, 336, 185, 23);
		innerPanel.add(email);
		
		

		ImageIcon i3=new ImageIcon("back2.png");
		JButton b13= new JButton(); 
			b13.setIcon(i3);
		    b13.setBackground(new Color(0x4faba0));
			b13.setBounds(0, 5, 50,50);
			b13.setFocusPainted(false);
			b13.setBorderPainted(false);
			b13.setFocusable(false);
			add(b13);
			
			b13.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new searchflight();
				}
					
				});
		
		first = new JTextField();
		first.setBounds(41, 240, 238, 34);
		innerPanel.add(first);
		first.setColumns(20);
		
		last = new JTextField();
		last.setColumns(10);
		last.setBounds(478, 247, 238, 34);
		innerPanel.add(last);
		
		textPhone = new JTextField();
		textPhone.setColumns(10);
		textPhone.setBounds(41, 398, 238, 34);
		innerPanel.add(textPhone);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(478, 398, 238, 34);
		innerPanel.add(textEmail);
		
		JButton Submit = new JButton("Submit");
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					
					Class.forName("com.mysql.cj.jdbc.Driver"); 
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","Lalli@2003");
				    String ins="insert into customer2(f_name,l_name,phn,email)values(?,?,?,?)";
					PreparedStatement st = conn.prepareStatement(ins);
					st.setString(1,first.getText());
					st.setString(2,last.getText());
					st.setString(3,textPhone.getText());
					st.setString(4,textEmail.getText());
					st.executeUpdate();
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
		
				new payment();
			}

			}
		);
		Submit.setFont(new Font("Times New Roman", Font.BOLD, 14));
		Submit.setBackground(Color.BLACK);
		Submit.setForeground(Color.WHITE);
		Submit.setBounds(739, 547, 120, 44);
		innerPanel.add(Submit);
		
		JButton addCustomer = new JButton("+ Passenger");
		addCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new project();
			}
		});
		addCustomer.setForeground(Color.WHITE);
		addCustomer.setFont(new Font("Times New Roman", Font.BOLD, 14));
		addCustomer.setBackground(Color.BLACK);
		addCustomer.setBounds(41, 547, 171, 44);
		innerPanel.add(addCustomer);
		
		setVisible(true);
		
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new project();
	}
}