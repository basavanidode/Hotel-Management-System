package hotel.management.system;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.sql.*;
import net.proteanit.sql.*;

import java.awt.*;
import java.awt.event.*;
public class CustomerInfo extends JFrame implements ActionListener{
	JTable table; // to create a table
	
	JButton back;
	
	CustomerInfo(){
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		
		
		table = new JTable(); // putting data dynamically
		table.setBounds(0,40,1000,400);
		//two ways to add data in table 1.manully creating a 2D array and 2. Importing XML packed
		
		add(table);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from customer");//now put this data inside table
			table.setModel(DbUtils.resultSetToTableModel(rs));//it will add data to table dynamically by importing that packet
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Table headers are not importing directly so we can add them maually
		
		JLabel l1 = new JLabel("Document");
		l1.setBounds(30,10,100,20);
		add(l1);
		
		JLabel l2 = new JLabel("Number");
		l2.setBounds(160,10,100,20);
		add(l2);
		
		JLabel l3 = new JLabel("Name");
		l3.setBounds(290,10,100,20);
		add(l3);
		
		JLabel l8 = new JLabel("Gender");
		l8.setBounds(400,10,100,20);
		add(l8);
		
		JLabel l4 = new JLabel("Country");
		l4.setBounds(540,10,100,20);
		add(l4);
		
		JLabel l5 = new JLabel("Room Number");
		l5.setBounds(650,10,100,20);
		add(l5);
		
		JLabel l6 = new JLabel("Checkin Time");
		l6.setBounds(760,10,100,20);
		add(l6);
		
		JLabel l7 = new JLabel("Deposit");
		l7.setBounds(880,10,100,20);
		add(l7);
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		back.setBounds(420,500,120,30);
		add(back);
		
		
	
		
		setBounds(300,200,1000,600);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new CustomerInfo();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new Reception();
		
	}
}