package javacasestudy;
import  javax.swing.*;
import  java.awt.*;
import  java.awt.event.ActionEvent;
import  java.awt.event.ActionListener;
import  java.sql.Connection;
import  java.sql.DriverManager;
import  java.sql.PreparedStatement;
import  java.sql.ResultSet;
import java.sql.SQLException;

public class  customer extends JFrame {
private static final long serialVersionUID = 1L;
private JFrame f;
private JPanel p1;
private JPanel p2;
private JLabel l1;
private JButton add;
private JButton search;

int count=0;


public customer(){
	
	
	
	
	
	
	
	
	
f=new JFrame("BOOKING");
f.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\chiki\\Downloads\\paper-plane.png"));
p1= new JPanel();
p2= new JPanel();
add= new JButton("+");
add.setOpaque(false);
add.setBackground(new Color(255, 255, 255));





JButton remove=new JButton("-");
remove.setBackground(new Color(255, 255, 255));
remove.setBounds(275, 475, 71, 21);
l1= new JLabel("Number of Adults:        0");
l1.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
l1.setBounds(91, 478, 154, 13);
String Date[]= {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
String Month[]= {"1","2","3","4","5","6","7","8","9","10","11","12"};
String Year[]= {"2022","2023","2024","2025","2026","2027","2028","2029","2030"};
String[] str1 = new String[10];
String[] str2 = new String[10];
try
{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection conn=DriverManager.getConnection("jdbc:mySql://localhost:3306/airline","root","8448");
PreparedStatement st = conn.prepareStatement("select *from flights");
ResultSet rs = st.executeQuery();
 int i=0;
 while(rs.next()){
 	str1[i] = rs.getString(2);
 	str2[i++] = rs.getString(3);
 }
}
catch(Exception e) {
}
JComboBox c1 = new JComboBox(str1);//from
JComboBox c2 = new JComboBox(str2);//to
 c1.setBounds(91, 212, 118, 39);
 c2.setBackground(new Color(255, 255, 255));
 c2.setSelectedIndex(2);
 c2.setBackground(new Color(255, 255, 255));
 c2.setBounds(294, 212, 118, 39);

 
p1.setLayout(null);
search = new JButton("SEARCH");
search.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 15));
search.setBackground(new Color(255, 255, 255));
search.setBounds(403, 598, 150, 54);
p1.add(search);
p1.add(l1);
p1.add(c1);
p1.add(remove);
p1.add(add);

f.setResizable(true);
add.setBounds(371,475,80,21);
p1.setBounds(20, 56, 600, 700);

p1.setBackground(new Color(255, 255, 255));
p2.setBackground(Color.cyan);

remove.addActionListener( new ActionListener() {
public void actionPerformed(ActionEvent e) {
count--;
l1.setText("Number of Adults: "+ count );
}
});
add.addActionListener( new ActionListener() {
public void actionPerformed(ActionEvent e) {
count++;
l1.setText("Number of Adults: "+ count );
}
});
f.getContentPane().add(p1);

JRadioButton rdbtnNewRadioButton = new JRadioButton("One Way");
rdbtnNewRadioButton.setBackground(new Color(255, 255, 255));
rdbtnNewRadioButton.setSelected(true);
rdbtnNewRadioButton.setBounds(91, 87, 91, 21);
p1.add(rdbtnNewRadioButton);

JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Round Trip");
rdbtnNewRadioButton_1.setBackground(new Color(255, 255, 255));
rdbtnNewRadioButton_1.setBounds(199, 87, 91, 21);
p1.add(rdbtnNewRadioButton_1);

ButtonGroup g=new ButtonGroup();
g.add(rdbtnNewRadioButton_1);
g.add(rdbtnNewRadioButton);

rdbtnNewRadioButton.setSelected(true);



p1.add(c2);

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

JComboBox comboBox_1 = new JComboBox(Date);
comboBox_1.setSelectedIndex(19);
comboBox_1.setBounds(91, 390, 46, 22);
p1.add(comboBox_1);

JComboBox comboBox_1_1 = new JComboBox(Month);
comboBox_1_1.setSelectedIndex(6);
comboBox_1_1.setBounds(142, 390, 51, 22);
p1.add(comboBox_1_1);

JComboBox comboBox_1_2 = new JComboBox(Year);
comboBox_1_2.setBounds(199, 390, 58, 22);
p1.add(comboBox_1_2);

JPanel Return = new JPanel();
Return.setBorder(null);
Return.setBackground(new Color(255, 255, 255));
Return.setBounds(279, 303, 240, 122);
p1.add(Return);
Return.setLayout(null);

JLabel lblNewLabel_2_1 = new JLabel("Return Date");
lblNewLabel_2_1.setBounds(0, 11, 84, 17);
lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 14));
Return.add(lblNewLabel_2_1);

JLabel lblNewLabel_3_1 = new JLabel("Date");
lblNewLabel_3_1.setBounds(0, 48, 30, 14);
Return.add(lblNewLabel_3_1);

JLabel lblNewLabel_4_1 = new JLabel("Month");
lblNewLabel_4_1.setBounds(69, 48, 48, 14);
Return.add(lblNewLabel_4_1);

JLabel lblNewLabel_5_1 = new JLabel("Year");
lblNewLabel_5_1.setBounds(145, 48, 40, 14);
Return.add(lblNewLabel_5_1);

JComboBox comboBox_1_3 = new JComboBox(Date);
comboBox_1_3.setBounds(0, 89, 48, 22);
comboBox_1_3.setSelectedIndex(23);
Return.add(comboBox_1_3);

JComboBox comboBox_1_4 = new JComboBox(Month);
comboBox_1_4.setBounds(69, 89, 48, 22);
comboBox_1_4.setSelectedIndex(8);
Return.add(comboBox_1_4);

JComboBox comboBox_1_2_1 = new JComboBox(Year);
comboBox_1_2_1.setBounds(145, 89, 57, 22);
Return.add(comboBox_1_2_1);

f.getContentPane().add(p2);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

f.setVisible(true);
f.setSize(1000,1600);
f.getContentPane().setLayout(null);
ImageIcon img=new ImageIcon("C:\\Users\\chiki\\OneDrive\\Desktop\\mark100.jpg");
JLabel image= new JLabel();
image.setIcon(img);
image.setVisible(true);
image.setBounds(0,0,1080,720);
f.getContentPane().add(image);



}
public static void main(String[] args) {
new customer();
}
}