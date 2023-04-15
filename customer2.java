package javacasestudy;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class customer2 extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private JTextField first;
	private JTextField last;
	private JTextField textPhone;
	private JTextField textEmail;

	public customer2() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\chiki\\Downloads\\paper-plane.png"));
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setForeground(Color.BLACK);
		setSize(800,1600);
		setVisible(true);
		
		
		
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		getContentPane().setLayout(null);
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(150, 42, 899, 629);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel heading = new JLabel("Customer Details");
		heading.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
		heading.setBackground(Color.cyan);
		heading.setForeground(Color.BLACK);
		heading.setBounds(21, 25, 225, 60);
		panel_1.add(heading);
		
		JRadioButton mr = new JRadioButton(".Mr");
		mr.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		mr.setForeground(Color.WHITE);
		mr.setBackground(Color.BLACK);
		mr.setBounds(27, 123, 109, 23);
		panel_1.add(mr);
		
		JRadioButton ms = new JRadioButton(".Ms");
		ms.setForeground(Color.WHITE);
		ms.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ms.setBackground(Color.BLACK);
		ms.setBounds(170, 124, 109, 23);
		panel_1.add(ms);
		
		JRadioButton Mrs = new JRadioButton(".Mrs");
		Mrs.setForeground(Color.WHITE);
		Mrs.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		Mrs.setBackground(Color.BLACK);
		Mrs.setBounds(355, 124, 109, 23);
		panel_1.add(Mrs);
		
		JLabel firstname = new JLabel("First Name :");
		firstname.setFont(new Font("Arial Black", Font.PLAIN, 14));
		firstname.setBackground(Color.BLACK);
		firstname.setForeground(Color.WHITE);
		firstname.setBounds(41, 184, 185, 23);
		panel_1.add(firstname);
		
		JLabel lastname = new JLabel("Last Name :");
		lastname.setForeground(Color.WHITE);
		lastname.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lastname.setBackground(Color.BLACK);
		lastname.setBounds(478, 184, 185, 23);
		panel_1.add(lastname);
		
		JLabel phone = new JLabel("Phone Number :");
		phone.setForeground(Color.WHITE);
		phone.setFont(new Font("Arial Black", Font.PLAIN, 14));
		phone.setBackground(Color.BLACK);
		phone.setBounds(41, 336, 185, 23);
		panel_1.add(phone);
		
		JLabel email = new JLabel("Email id :");
		email.setForeground(Color.WHITE);
		email.setFont(new Font("Arial Black", Font.PLAIN, 14));
		email.setBackground(Color.BLACK);
		email.setBounds(478, 336, 185, 23);
		panel_1.add(email);
		
		first = new JTextField();
		first.setBounds(41, 240, 238, 34);
		panel_1.add(first);
		first.setColumns(10);
		
		last = new JTextField();
		last.setColumns(10);
		last.setBounds(478, 247, 238, 34);
		panel_1.add(last);
		
		textPhone = new JTextField();
		textPhone.setColumns(10);
		textPhone.setBounds(41, 398, 238, 34);
		panel_1.add(textPhone);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(478, 398, 238, 34);
		panel_1.add(textEmail);
		
		JButton Submit = new JButton("Submit");
		Submit.setFont(new Font("Times New Roman", Font.BOLD, 14));
		Submit.setBackground(Color.BLACK);
		Submit.setForeground(Color.WHITE);
		Submit.setBounds(739, 547, 120, 44);
		panel_1.add(Submit);
		
		
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new customer2();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new customer2();
		
	}
}