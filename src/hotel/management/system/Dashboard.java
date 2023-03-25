package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Dashboard extends JFrame implements ActionListener{
	
	Dashboard(){
		
		setBounds(0, 0, 1550, 1000);
		
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1550,1000, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,1550,1000);
		add(image);
		
		
		JLabel text = new JLabel("THE TAJ GROUP WELCOMES YOU");
		text.setBounds(400,80,1000,50);
		text.setFont(new Font("Tahoma", Font.PLAIN,46));
		text.setForeground(Color.WHITE);
		image.add(text);
		
		
		
		JMenuBar mb = new JMenuBar();//this class is used to create MenuBar 
		mb.setBounds(0,0,1550,30);
		image.add(mb);
		
		JMenu hotel = new JMenu("HOTEL MANAGEMENT");//TO add the objects on menubar we use JMenu
		hotel.setForeground(Color.RED);
		mb.add(hotel);
		
		JMenuItem reception = new JMenuItem("RECEPTION");
		reception.addActionListener(this);
		hotel.add(reception);
		
		
		JMenu admin = new JMenu("ADMIN");
		admin.setForeground(Color.BLUE);
		mb.add(admin);
		
		JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
		addemployee.addActionListener(this);
		admin.add(addemployee);
		
		JMenuItem addrooms = new JMenuItem("ADD ROOMS");
		addrooms.addActionListener(this);
		admin.add(addrooms);
		
		JMenuItem adddrivers = new JMenuItem("ADD DRIVERS");
		adddrivers.addActionListener(this);
		admin.add(adddrivers);
		
		
		//menuitems add in menu menu add in menubar
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new Dashboard();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("ADD EMPLOYEE")) {
			new AddEmployee();
		} else if(e.getActionCommand().equals("ADD ROOMS")) {
			new AddRooms();
		} else if(e.getActionCommand().equals("ADD DRIVERS")) {
			new AddDriver();
		} else if(e.getActionCommand().equals("RECEPTION")) {
			new Reception();
		}
		
	}
}
