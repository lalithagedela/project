package javacasestudy;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class  ways extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private JFrame f;
	private JPanel p1;
	private JPanel p2;
	private JLabel l1;
	private JButton add;
	private JButton search;
	
	int count=0;
	
	
	@SuppressWarnings("unchecked")
	public ways() {
		
	f=new JFrame("BOOKING");
	p1= new JPanel();
	p2= new JPanel();
	p1.setBackground(new Color(0x2d3c50));
	add= new JButton("+");
    add.setOpaque(false);
	add.setBackground(new Color(0x2d3c50));
	
	

	
	
	
	JButton remove=new JButton("-");
	
	remove.setBounds(275, 475, 71, 21);
	l1= new JLabel("Number of Adults:        0");
	l1.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
	l1.setBounds(91, 478, 154, 13);

	String city[]= {"vizag","bengaluru","chennai"};
	String Date[]= {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	String Month[]= {"1","2","3","4","5","6","7","8","9","10","11","12"};
	String Year[]= {"2022","2023","2024","2025","2026","2027","2028","2029","2030"};
	
	
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
			new border();
		}
			
		});
		
		ImageIcon i2=new ImageIcon("bag1.jpg");
		JLabel label2 = new JLabel(); 
 		label2.setIcon(i2);
// 		label2.setBackground( new Color(0x2d3c50));
 		label2.setBounds(0, 0, 1570,860);
// 		label2.setBorderPainted(false);
 		
	
	JComboBox from= new JComboBox(city);
	from.setBounds(91, 212, 118, 39);
	from.setBackground(new Color(255, 255, 255));
	p1.setLayout(null);
	
	

	JComboBox to = new JComboBox(city);
	to.setSelectedIndex(2);
	to.setBackground(new Color(255, 255, 255));
	to.setBounds(294, 212, 118, 39);
	p1.add(to);
	
	
	JComboBox comboBox_1 = new JComboBox(Date);
	comboBox_1.setSelectedIndex(25);
	comboBox_1.setBounds(91, 390, 46, 22);
	p1.add(comboBox_1);
	
	
	JComboBox comboBox_1_1 = new JComboBox(Month);
	comboBox_1_1.setSelectedIndex(6);
	comboBox_1_1.setBounds(142, 390, 51, 22);
	p1.add(comboBox_1_1);
	
	
	JComboBox comboBox_1_2 = new JComboBox(Year);
	comboBox_1_2.setBounds(199, 390, 58, 22);
	p1.add(comboBox_1_2);
	
	
	search = new JButton("SEARCH");
	search.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {	
		    Connection conn=DriverManager.getConnection("jdbc:mySql://localhost:3306/airline","root","Lalli@2003");
		    String ins="insert into way2(from_states,To_states) values(?,?)";
		    PreparedStatement st = conn.prepareStatement(ins);
		    String s=(String) from.getSelectedItem();//from
		    st.setString(1,s);
		    String s1=(String)to.getSelectedItem();//to
		    st.setString(2,s1);
		    st.executeUpdate();	
		}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
			new searchflight();
			
		}
	});
	search.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 15));
	search.setBackground(new Color(255, 255, 255));
	search.setBounds(403, 598, 150, 54);
	p1.add(search);
	p1.add(l1);
	p1.add(from);
	p1.add(remove);
	p1.add(add);
	
	
	f.setBackground(Color.red);
	
	
	f.setResizable(true);
	add.setBounds(371,475,80,21);
	p1.setBounds(20, 56, 600, 700);
	
	p1.setBackground(new Color(255, 255, 255));
	p2.setBackground(Color.RED);
	remove.setVisible(false);
	remove.addActionListener( new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			count--;
			l1.setText("Number of Adults: "+ count );
			if(count<=0) {
				remove.setVisible(false);
				
			}
			
		}
	});
	add.addActionListener( new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			count++;
			l1.setText("Number of Adults: "+ count );
			if(count>0) {
				remove.setVisible(true);
			}
		}
	});
	f.getContentPane().add(p1);
	
	JRadioButton oneway = new JRadioButton("One Way");
	
	oneway.setBackground(new Color(255, 255, 255));
	oneway.setSelected(true);
	oneway.setBounds(91, 87, 91, 21);
	p1.add(oneway);
	
	JRadioButton roundway = new JRadioButton("Round Trip");
	
	roundway.setBackground(new Color(255, 255, 255));
	roundway.setBounds(199, 87, 91, 21);
	p1.add(roundway);
	
	ButtonGroup g=new ButtonGroup();
	g.add(roundway);
	g.add(oneway);
	
	oneway.setSelected(true);
	
	JLabel lblNewLabel = new JLabel("From");
	lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
	lblNewLabel.setBounds(91, 143, 91, 27);
	p1.add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("To");
	lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
	lblNewLabel_1.setBounds(294, 142, 80, 27);
	p1.add(lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel("Departure Date");
	lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
	lblNewLabel_2.setBounds(91, 317, 118, 14);
	p1.add(lblNewLabel_2);
	
	JLabel lblNewLabel_3 = new JLabel("Date");
	lblNewLabel_3.setBounds(91, 354, 46, 14);
	p1.add(lblNewLabel_3);
	
	JLabel lblNewLabel_4 = new JLabel("Month");
	lblNewLabel_4.setBounds(142, 354, 46, 14);
	p1.add(lblNewLabel_4);
	
	JLabel lblNewLabel_5 = new JLabel("Year");
	lblNewLabel_5.setBounds(199, 354, 46, 14);
	p1.add(lblNewLabel_5);
	
	
	
	
	
	
	
	JPanel round = new JPanel();
	round.setBorder(null);
	round.setBackground(new Color(255, 255, 255));
	round.setBounds(279, 303, 240, 122);
	p1.add(round);
	round.setLayout(null);
	
	JLabel lblNewLabel_2_1 = new JLabel("Return Date");
	lblNewLabel_2_1.setBounds(0, 11, 84, 17);
	lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 14));
	round.add(lblNewLabel_2_1);
	
	JLabel lblNewLabel_3_1 = new JLabel("Date");
	lblNewLabel_3_1.setBounds(0, 48, 30, 14);
	round.add(lblNewLabel_3_1);
	
	JLabel lblNewLabel_4_1 = new JLabel("Month");
	lblNewLabel_4_1.setBounds(69, 48, 48, 14);
	round.add(lblNewLabel_4_1);
	
	JLabel lblNewLabel_5_1 = new JLabel("Year");
	lblNewLabel_5_1.setBounds(145, 48, 40, 14);
	round.add(lblNewLabel_5_1);
	
	JComboBox comboBox_1_3 = new JComboBox(Date);
	comboBox_1_3.setBounds(0, 89, 48, 22);
	comboBox_1_3.setSelectedIndex(23);
	round.add(comboBox_1_3);
	
	JComboBox comboBox_1_4 = new JComboBox(Month);
	comboBox_1_4.setBounds(69, 89, 48, 22);
	comboBox_1_4.setSelectedIndex(8);
	round.add(comboBox_1_4);
	
	JComboBox comboBox_1_2_1 = new JComboBox(Year);
	comboBox_1_2_1.setBounds(145, 89, 57, 22);
	round.add(comboBox_1_2_1);
	f.add(label2);
	f.getContentPane().add(p2);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	f.setVisible(true);
	f.setSize(1575,860);
	f.getContentPane().setLayout(null);
	ImageIcon img=new ImageIcon("C:\\Users\\chiki\\OneDrive\\Desktop\\v.jpg");
	JLabel image= new JLabel();
	image.setIcon(img);
	image.setVisible(true);
	image.setBounds(0,0,1575,860);
	f.getContentPane().add(image);
	round.setVisible(false);
	oneway.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			round.setVisible(false);
		}
	});
	
	roundway.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			round.setVisible(true);
		}
	});
	
	
	
	}
	public static void main(String[] args) {
		new ways();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
