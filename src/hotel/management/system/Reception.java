package hotel.management.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Reception extends JFrame implements ActionListener {
	
	JButton newCustomer,logout,checkout ,rooms ,deparment ,allEmployee ,managerInfo ,customers ,searchRoom,update , roomStatus,pickup;

	Reception(){
		
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		
		newCustomer = new JButton("New Customer Form");
		newCustomer.setBounds(10,30,200,30);
		newCustomer.setBackground(Color.BLACK);
		newCustomer.setForeground(Color.WHITE);
		newCustomer.addActionListener(this);
		add(newCustomer);
		

		rooms = new JButton("Rooms");
		rooms.setBounds(10,70,200,30);
		rooms.setBackground(Color.BLACK);
		rooms.setForeground(Color.WHITE);
		rooms.addActionListener(this);
		add(rooms);
		
		deparment = new JButton("Deparment");
		deparment.setBounds(10,110,200,30);
		deparment.setBackground(Color.BLACK);
		deparment.setForeground(Color.WHITE);
		deparment.addActionListener(this);
		add(deparment);
		
		allEmployee = new JButton("All Employees");
		allEmployee.setBounds(10,150,200,30);
		allEmployee.setBackground(Color.BLACK);
		allEmployee.setForeground(Color.WHITE);
		allEmployee.addActionListener(this);
		add(allEmployee);
		
		customers = new JButton("Customer Info");
		customers.setBounds(10,190,200,30);
		customers.setBackground(Color.BLACK);
		customers.setForeground(Color.WHITE);
		customers.addActionListener(this);
		add(customers);
		
		managerInfo = new JButton("Manager Info");
		managerInfo.setBounds(10,230,200,30);
		managerInfo.setBackground(Color.BLACK);
		managerInfo.setForeground(Color.WHITE);
		managerInfo.addActionListener(this);
		add(managerInfo);
		
		checkout = new JButton("Checkout");
		checkout.setBounds(10,270,200,30);
		checkout.setBackground(Color.BLACK);
		checkout.setForeground(Color.WHITE);
		checkout.addActionListener(this);
		add(checkout);
		
		update = new JButton("Update Status");
		update.setBounds(10,310,200,30);
		update.setBackground(Color.BLACK);
		update.setForeground(Color.WHITE);
		update.addActionListener(this);
		add(update);
		
		roomStatus = new JButton("Update Room Status");
		roomStatus.setBounds(10,350,200,30);
		roomStatus.setBackground(Color.BLACK);
		roomStatus.setForeground(Color.WHITE);
		roomStatus.addActionListener(this);
		add(roomStatus);
		
		pickup = new JButton("Pickup Service");
		pickup.setBounds(10,390,200,30);
		pickup.setBackground(Color.BLACK);
		pickup.setForeground(Color.WHITE);
		pickup.addActionListener(this);
		add(pickup);
		
		searchRoom = new JButton("Search Room");
		searchRoom.setBounds(10,430,200,30);
		searchRoom.setBackground(Color.BLACK);
		searchRoom.setForeground(Color.WHITE);
		searchRoom.addActionListener(this);
		add(searchRoom);
		
		logout = new JButton("Logout");
		logout.setBounds(10,470,200,30);
		logout.setBackground(Color.BLACK);
		logout.setForeground(Color.WHITE);
		logout.addActionListener(this);
		add(logout);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
		JLabel image = new JLabel(i1);
		image.setBounds(250,30,500,470);
		add(image);
		

		
		
		
		
		setBounds(350,200,800,570);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Reception();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==newCustomer) {
			setVisible(false);
			new AddCustomer();
		} else if(e.getSource()==rooms) {
			setVisible(false);
			new Room();
		} else if(e.getSource()==deparment) {
			setVisible(false);
			new Department();
		} else if(e.getSource()==allEmployee) {
			setVisible(false);
			new EmployeeInfo();
		} else if(e.getSource()==managerInfo) {
			setVisible(false);
			new ManagerInfo();
		} else if (e.getSource()==customers) {
			setVisible(false);
			new CustomerInfo();
		} else if(e.getSource()==searchRoom) {
			setVisible(false);
			new SearchRoom();
		} else if(e.getSource()==update) {
			setVisible(false);
			new UpdateCheck();
		} else if(e.getSource()==roomStatus) {
			setVisible(false);
			new UpdateRoom();
		} else if(e.getSource()==pickup) {
			setVisible(false);
			new Pickup();
		} else if(e.getSource()==checkout) {
			setVisible(false);
			new Checkout();
		} else if(e.getSource()==logout) {
			setVisible(false);
			System.exit(0);
			
		}
		
	}
	
}
