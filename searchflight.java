package javacasestudy;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


@SuppressWarnings("serial")
public  class searchflight extends JFrame implements MouseListener
{
	Container c = getContentPane();
	
	JPanel PFlightTypes = new JPanel(null);
	JPanel PFlightDetails = new JPanel(null);
	public boolean bCheck=true;
	JLabel LDomesticFlight = new JLabel("DOMESTIC");
	JLabel LUserName, LPassword;
	JLabel LDomesticFlight1 = new JLabel("xxxxx");
	final Object[] col1 ={ "From", "To", "Price", "Time" };
	final Object[][] row1 = { { "Trivandrum", "Bangalore", "3125", "16:30" }, { "Trivandrum", "Chennai ", "3225", "19:00" }, { "Trivandrum", "Delhi", "1425 ", "08:30" }, { "Trivandrum", "Goa", "1025 ", "09:50" }, { "Trivandrum", "Hyderabad", "1525", "11:00" }, { "Banglore", "Trivandrum", "3825 ", "05:30" }, { "Trivandrum", "Lucknow", "3025 ", "05:30" }, { "Trivandrum", "Mumbai", "1725", "12:00" }, { "Trivandrum", "Vishakapatnam", "3725", "19:00" } };
	JTable TDomesticFlight = new JTable(row1, col1);
	JScrollPane JSP1 = new JScrollPane(TDomesticFlight, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	JLabel LEconomic = new JLabel("Economic", SwingConstants.LEFT);
	public searchflight()
	{
		setPreferredSize(new Dimension(1600,1600));
		PFlightTypes.setBackground(Color.darkGray);
		PFlightTypes .setFont(new Font("Arial Black",Font.BOLD,60));
		PFlightTypes.setForeground(Color.CYAN);

		PFlightDetails.setBackground(new Color(0x01a3a0));
		JSP1.setBounds(0, 340, 790, 200);
		PFlightTypes.setBounds(0,0,500, 340);
		PFlightDetails.setBounds(0,340,790,200);
		LDomesticFlight1.setBounds(60, 60, 138, 20);
		PFlightDetails.add(JSP1);
		JSP1.setVisible(true);
		LEconomic.setBounds(0, 170, 250, 125);
		PFlightTypes.add(LEconomic);
		LEconomic.setVisible(true);
		LDomesticFlight.setBounds(60, 60, 100, 25);
		
		
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
				
					new ways();
				}
	 			
	 		});
		c.add(PFlightTypes);
		c.add(PFlightDetails);
		PFlightTypes.add(LDomesticFlight);
		pack();
		setVisible(true);
		
		TDomesticFlight.setBackground(Color.BLACK);
		TDomesticFlight.setForeground(new Color(255, 255, 51));
		
		
		
		JButton Book = new JButton("BOOK");
		Book.setBackground(SystemColor.windowText);
		Book.setForeground(SystemColor.window);
		Book.setFont(new Font("Calibri", Font.BOLD, 18));
		Book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new project();
			}
		});
		Book.setBounds(824, 439, 104, 45);
		PFlightDetails.add(Book);
		
		
		
		
		TDomesticFlight.addMouseListener(new MouseListener() {
	        @Override
	        public void mouseReleased(MouseEvent e) {
	        }
	        @Override
	        public void mousePressed(MouseEvent e) {
	        	int row = TDomesticFlight.getSelectedRow();//1st row means it returns 0
	        	String from = (String) TDomesticFlight.getValueAt(row,0);//gives FROM from table TDomesticFlight
	        	String to = (String) TDomesticFlight.getValueAt(row,1);//gives TO from table TDomesticFlight
	        	String price = (String) TDomesticFlight.getValueAt(row,2);//gives PRICE from table TDomesticFlight
	        	String time = (String) TDomesticFlight.getValueAt(row,3);//gives TIME from table TDomesticFlight
	        	System.out.println(from +" "+to+" "+price+" "+time);	        	
	        }
	        @Override
	        public void mouseExited(MouseEvent e) {
	        }
	        @Override
	        public void mouseEntered(MouseEvent e) {
	        }
	        @Override
	        public void mouseClicked(MouseEvent e) {
	        }
	    });
		
		
		
	 		
	}
	public static void main(String args[])
	{
		new searchflight();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}



























