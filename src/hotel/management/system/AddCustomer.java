package hotel.management.system;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.*;


public class AddCustomer extends JFrame implements ActionListener{
	
	JComboBox comboid;
	
	JTextField tfnumber , tfname ,tfcountry ,tfdeposit;
	
	JRadioButton rmale,rfemale;
	
	Choice croom;  //same as combobox but we can add values using add
	
	JLabel checkintime; //non editable field that user cannot edit this
	
	JButton add , back ;
	
	AddCustomer(){
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel text = new JLabel("NEW CUSTOMER FORM");
		text.setBounds(100,20,300,30);
		text.setFont(new Font("Raieway",Font.BOLD ,20));
		add(text);
		
		JLabel lblid = new JLabel("ID");
		lblid.setBounds(35,80,100,20);
		lblid.setFont(new Font("Raieway",Font.PLAIN ,20));
		add(lblid);
		
		//id combobox
		
		String options[]= {"Aadhar Card" , "Passport","Driving License","Voter-id Card","Ration Card"};
		comboid = new JComboBox(options);
		comboid.setBounds(200,80,150,25);
		comboid.setBackground(Color.WHITE);
		add(comboid);
		
		JLabel lblnumber = new JLabel("Number");
		lblnumber.setBounds(35,120,100,20);
		lblnumber.setFont(new Font("Raieway",Font.PLAIN ,20));
		add(lblnumber);
		
		tfnumber = new JTextField();
		tfnumber.setBounds(200,120,150,25);
		add(tfnumber);
		
		JLabel lblname = new JLabel("Name");
		lblname.setBounds(35,160,100,20);
		lblname.setFont(new Font("Raieway",Font.PLAIN ,20));
		add(lblname);
		
		tfname = new JTextField();
		tfname.setBounds(200,160,150,25);
		add(tfname);
		
		//gender label and Radio buttons
		
		JLabel lbgender = new JLabel("Gender");
		lbgender.setBounds(35,200,100,20);
		lbgender.setFont(new Font("Raieway",Font.PLAIN ,20));
		add(lbgender);
		
		rmale = new JRadioButton("Male");
		rmale.setBackground(Color.WHITE);
		rmale.setBounds(200,200,60,25);
		add(rmale);
		
		rfemale = new JRadioButton("Female");
		rfemale.setBackground(Color.WHITE);
		rfemale.setBounds(270,200,100,25);
		add(rfemale);
		
		//to group
		ButtonGroup bg = new ButtonGroup();
		bg.add(rmale);
		bg.add(rfemale);
		
		JLabel lblcountry = new JLabel("Country");
		lblcountry.setBounds(35,240,100,20);
		lblcountry.setFont(new Font("Raieway",Font.PLAIN ,20));
		add(lblcountry);
		
		tfcountry = new JTextField();
		tfcountry.setBounds(200,240,150,25);
		add(tfcountry);
		
		//In below label we have to insert the allocated values dynamically
		
		JLabel lblroom = new JLabel("Room Number");
		lblroom.setBounds(35,280,150,20);
		lblroom.setFont(new Font("Raieway",Font.PLAIN ,20));
		add(lblroom);
		
		//Choise using insted of JComboBox and we are inserting values dynamically
		croom = new Choice();
		
		//we are making connection with database such that allocated room nos are not visible
		try {
			Conn conn = new Conn();
			String query = "select * from room where availability ='Available'";
			ResultSet rs =  conn.s.executeQuery(query);
			while(rs.next()) {
				//by using add() we can add any data dynamically in Choise
				
				croom.add(rs.getString("roomnumber"));//it will select ony roomnumber column from that table
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		croom.setBounds(200,280,150,25);
		add(croom);
		
		
		JLabel lbltime = new JLabel("Checkin Time");
		lbltime.setBounds(35,320,150,20);
		lbltime.setFont(new Font("Raieway",Font.PLAIN ,20));
		add(lbltime);
		
		//date class object
		Date date = new Date();
		//we cannot insert date directly in JLabel
		
		//Below field is noneditable field
		
		checkintime = new JLabel("" + date);
		checkintime.setBounds(200,320,150,25);
		checkintime.setFont(new Font("Raieway",Font.PLAIN ,15));
		add(checkintime);
		
		JLabel lbldeposit = new JLabel("Deposit");
		lbldeposit.setBounds(35,360,100,20);
		lbldeposit.setFont(new Font("Raieway",Font.PLAIN ,20));
		add(lbldeposit);
		
		tfdeposit = new JTextField();
		tfdeposit.setBounds(200,360,150,25);
		add(tfdeposit);
		
		add = new JButton("Add");
		add.setBackground(Color.BLACK);
		add.setForeground(Color.WHITE);
		add.setBounds(50,410,120,30);
		add.addActionListener(this);
		add(add);
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(200,410,120,30);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
		Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(400,50,300,400);
		add(image);
		
		
		setBounds(350,200,800,550);
		setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		new AddCustomer();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==add) {
			
			String id = (String) comboid.getSelectedItem();
			String number = tfnumber.getText();
			String name = tfname.getText();
			String gender = null;
			
			if (rmale.isSelected()) {
				gender ="Male";
			} else {
				gender = "Female";
			}
			
			String country = tfcountry.getText();
			String room = croom.getSelectedItem();
			String time = checkintime.getText();
			String deposit = tfdeposit.getText();
			
			try {
				String query = "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
				//one more query to remove the allocated rooms
				String query2 = "update room set availability = 'Occupied' where roomnumber = '"+room+"' ";
				
				Conn conn = new Conn();
				conn.s.executeUpdate(query);
				conn.s.executeUpdate(query2);
				
				JOptionPane.showMessageDialog(null, "New Customer Added Successfully");
				
				setVisible(false);
				new Reception();
				
				
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		} else if (e.getSource()==back) {
			setVisible(false);
			new Reception();
			
		}
		
	}
		
	
}
