package javacasestudy;
	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	public class payment extends JFrame  {
	
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private static JLabel success;
	private static JButton btnNewButton;

	public payment() {

	
	setSize(1600,1600);
	getContentPane().setLayout(null);
	JPanel p1 = new JPanel();
	p1.setBounds(0,0,1600,1600);
	p1.setBackground(Color.darkGray);
	

	
	
	success = new JLabel("Pay In next 5 Mins");
	success .setFont(new Font("Arial Black",Font.BOLD,20));
	success.setForeground(Color.CYAN);

	success.setHorizontalAlignment(SwingConstants.RIGHT);
	success.setBounds(451, 422, 583, 37);
	getContentPane().add(success);
	
	
	JLabel lblNewLabel = new JLabel("Enter Payment Reference Number: ");
	lblNewLabel .setFont(new Font("Arial Black",Font.BOLD,20));
	lblNewLabel.setForeground(Color.CYAN);
	lblNewLabel.setBounds(451, 113, 438, 75);
	getContentPane().add(lblNewLabel);

	textField = new JTextField();
	textField.setBounds(451, 188, 283, 37);
	getContentPane().add(textField);
	textField.setColumns(10);

	btnNewButton = new JButton("PAY");
	
	btnNewButton.setBackground(UIManager.getColor("Button.disabledShadow"));
	btnNewButton.setBounds(640, 307, 94, 50);
	getContentPane().add(btnNewButton);
	
	
	
	
	
	btnNewButton.addActionListener(new ActionListener() {
		

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			JOptionPane.showInternalMessageDialog(null,"payment successful", "message", JOptionPane.INFORMATION_MESSAGE);
	         new ways();
			new printing();
			
		}
	});
	
	
	
	
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
			new project();
		}
			
		});
		
		
	ImageIcon qrcode=new ImageIcon("C:\\Users\\HP\\OneDrive\\Documents\\QRCode.jpeg");
	JLabel payimage = new JLabel();
	payimage.setBounds(10, 107, 360, 301);
	payimage.setIcon(qrcode);
	payimage.setVisible(true);
	getContentPane().add(payimage);
	
	
	

	JLabel lblNewLabel_2 = new JLabel("QR CODE :");
	lblNewLabel_2 .setFont(new Font("Arial Black",Font.BOLD,20));
	lblNewLabel_2.setForeground(Color.CYAN);
	
	lblNewLabel_2.setBounds(20, 30, 187, 49);
	getContentPane().add(lblNewLabel_2);
	add(p1);
	setResizable(true);
	setVisible(true);
	
	
	
	
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			success.setText("Payment Successful");	
			
			
		}
	});

	}


	public static void main(String[] args) {
	new payment();
	}
	

	
}