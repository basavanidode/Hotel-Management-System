package hotel.management.system;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.sql.*;
import net.proteanit.sql.*;

import java.awt.*;
import java.awt.event.*;
public class Pickup extends JFrame implements ActionListener{
	JTable table; // to create a table
	
	JButton back , submit;
	
	Choice typeofcar;
	
	JCheckBox available;
	
	Pickup(){
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		
		
		table = new JTable(); // putting data dynamically
		table.setBounds(0,200,1000,300);
		//two ways to add data in table 1.manully creating a 2D array and 2. Importing XML packed
		
		add(table);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from driver");//now put this data inside table
			table.setModel(DbUtils.resultSetToTableModel(rs));//it will add data to table dynamically by importing that packet
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Table headers are not importing directly so we can add them maually
		
		JLabel text = new JLabel("Pick-up Service");
		text.setFont(new Font("Tahoma" , Font.BOLD ,20));
		text.setBounds(430,30,200,30);
		add(text);
		
		JLabel lblbed = new JLabel("Type Of Car");
		lblbed.setBounds(50,100,100,20);
		add(lblbed);
		
		typeofcar = new Choice();
		typeofcar.setBounds(150,100,200,25);
		add(typeofcar);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from driver");
			while(rs.next()) {
				typeofcar.add(rs.getString("brand"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		JLabel l1 = new JLabel("Name");
		l1.setBounds(30,170,100,20);
		add(l1);
		
		JLabel l2 = new JLabel("Age");
		l2.setBounds(200,170,100,20);
		add(l2);
		
		JLabel l3 = new JLabel("Gender");
		l3.setBounds(330,170,100,20);
		add(l3);
		
		JLabel l4 = new JLabel("Company");
		l4.setBounds(460,170,100,20);
		add(l4);
		
		JLabel l5 = new JLabel("Brand");
		l5.setBounds(630,170,100,20);
		add(l5);
		
		JLabel l6 = new JLabel("Availability");
		l6.setBounds(740,170,100,20);
		add(l6);
		
		JLabel l7 = new JLabel("Location");
		l7.setBounds(890,170,100,20);
		add(l7);
		
		submit = new JButton("Submit");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.addActionListener(this);
		submit.setBounds(300,520,120,30);
		add(submit);
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		back.setBounds(500,520,120,30);
		add(back);
		
		
	
		
		setBounds(300,200,1000,600);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Pickup();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==submit) {
			
			try {
				String query = "select * from driver where brand='"+typeofcar.getSelectedItem()+"' ";//selecting data from dropdown singlebed or dobule bed
				
				Conn conn = new Conn();
				ResultSet rs;
				rs = conn.s.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(rs));
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		} else if(e.getSource()==back) {
			setVisible(false);
			new Reception();
		}
		
		
	}
}
