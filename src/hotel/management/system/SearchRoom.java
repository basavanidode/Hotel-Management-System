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
public class SearchRoom extends JFrame implements ActionListener{
	JTable table; // to create a table
	
	JButton back , submit;
	
	JComboBox bedType;
	
	JCheckBox available;
	
	SearchRoom(){
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		
		
		table = new JTable(); // putting data dynamically
		table.setBounds(0,200,1000,300);
		//two ways to add data in table 1.manully creating a 2D array and 2. Importing XML packed
		
		add(table);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from room");//now put this data inside table
			table.setModel(DbUtils.resultSetToTableModel(rs));//it will add data to table dynamically by importing that packet
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Table headers are not importing directly so we can add them maually
		
		JLabel text = new JLabel("Search For Room");
		text.setFont(new Font("Tahoma" , Font.BOLD ,20));
		text.setBounds(430,30,200,30);
		add(text);
		
		JLabel lblbed = new JLabel("Bed Type");
		lblbed.setBounds(50,100,100,20);
		add(lblbed);
		
		bedType = new JComboBox(new String[]{"Single Bed" , "Double Bed"});
		bedType.setBounds(150,100,150,25);
		bedType.setBackground(Color.WHITE);
		add(bedType);
		
		available = new JCheckBox("Only Display Available");
		available.setBounds(650,100,150,25);
		available.setBackground(Color.WHITE);
		add(available);
		
		
		JLabel l1 = new JLabel("Room Number");
		l1.setBounds(50,170,100,20);
		add(l1);
		
		JLabel l2 = new JLabel("Availbility");
		l2.setBounds(270,170,100,20);
		add(l2);
		
		JLabel l3 = new JLabel("Status");
		l3.setBounds(450,170,100,20);
		add(l3);
		
		JLabel l4 = new JLabel("Price");
		l4.setBounds(670,170,100,20);
		add(l4);
		
		JLabel l5 = new JLabel("Bed Type");
		l5.setBounds(870,170,100,20);
		add(l5);
		
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
		new SearchRoom();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==submit) {
			
			try {
				String query1 = "select * from room where bed_type='"+bedType.getSelectedItem()+"' ";//selecting data from dropdown singlebed or dobule bed
				String query2 = "select * from room where availability= 'Available'AND bed_type='"+bedType.getSelectedItem()+"'";
				
				Conn conn = new Conn();
				ResultSet rs;
				if(available.isSelected()) {
					rs = conn.s.executeQuery(query2);
				} else {
					rs = conn.s.executeQuery(query1);
				}
				table.setModel(DbUtils.resultSetToTableModel(rs));//we can simply search the room
				
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		} else if(e.getSource()==back) {
			setVisible(false);
			new Reception();
		}
		
		
	}
}