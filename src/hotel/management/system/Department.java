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
public class Department extends JFrame implements ActionListener{
	JTable table; // to create a table
	
	JButton back;
	
	Department(){
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		

		
		table = new JTable(); // putting data dynamically
		table.setBounds(0,50,700,350);
		//two ways to add data in table 1.manully creating a 2D array and 2. Importing XML packed
		
		add(table);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from department");//now put this data inside table
			table.setModel(DbUtils.resultSetToTableModel(rs));//it will add data to table dynamically by importing that packet
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Table headers are not importing directly so we can add them maually
		
		JLabel l1 = new JLabel("Department");
		l1.setBounds(110,10,100,20);
		add(l1);
		
		JLabel l2 = new JLabel("Budget");
		l2.setBounds(460,10,100,20);
		add(l2);
		
		
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		back.setBounds(280,400,120,30);
		add(back);
		
		
	
		
		setBounds(400,200,700,480);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Department();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new Reception();
		
	}
}

