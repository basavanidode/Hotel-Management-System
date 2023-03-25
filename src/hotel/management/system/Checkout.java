package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.util.Date;

public class Checkout extends JFrame implements ActionListener{
	
	JLabel lblroomnumber , lblcheckintime ,lblcheckouttime;
	
	Choice ccustomer;
	
	JButton checkout , back;

	Checkout(){
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel text = new JLabel("Checkout");
		text.setBounds(100,20,100,30);
		text.setForeground(Color.BLUE);
		text.setFont(new Font("Tahoma",Font.BOLD,20));
		add(text);
		
		JLabel lblid = new JLabel("Checkout");
		lblid.setBounds(30,80,100,30);
		add(lblid);
		
		ccustomer = new Choice();
		ccustomer.setBounds(150,80,150,25);
		add(ccustomer);
		
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
		Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(310,80,20,20);
		add(image);
		
		JLabel lbroom = new JLabel("Room Number");
		lbroom.setBounds(30,130,100,30);
		add(lbroom);
		
		lblroomnumber = new JLabel();
		lblroomnumber.setBounds(150,130,100,30);
		add(lblroomnumber);
		
		JLabel lblcheckin = new JLabel("Checkin Time");
		lblcheckin.setBounds(30,180,100,30);
		add(lblcheckin);
		
		lblcheckintime = new JLabel();
		lblcheckintime.setBounds(150,180,100,30);
		add(lblcheckintime);
		
		JLabel lblcheckout = new JLabel("Checkout Time");
		lblcheckout.setBounds(30,230,100,30);
		add(lblcheckout);
		
		
		//default date
		Date date = new Date();
		lblcheckouttime = new JLabel("" + date);
		lblcheckouttime.setBounds(150,230,150,30);
		add(lblcheckouttime);
		
		checkout = new JButton("Checkout");
		checkout.setBackground(Color.BLACK);
		checkout.setForeground(Color.WHITE);
		checkout.setBounds(30,280,120,30);
		checkout.addActionListener(this);
		add(checkout);
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(170,280,120,30);
		back.addActionListener(this);
		add(back);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from customer");
			while(rs.next()) {
				ccustomer.add(rs.getNString("number"));
				lblroomnumber.setText(rs.getString("room"));
				lblcheckintime.setText(rs.getString("checkintime"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
		Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		JLabel image2 = new JLabel(i6);
		image2.setBounds(350,50,400,250);
		add(image2);
		
		setBounds(300,200,800,400);
		setVisible(true);
		
	}
		
	
	public static void main(String[] args) {
		new Checkout();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==checkout) {
			String query1 = "delete from customer where number = '"+ccustomer.getSelectedItem()+"'";
			String query2 = "update room set availability = 'Available' where roomnumber = '"+lblroomnumber.getText()+"' ";
			
			try {
				Conn c=new Conn();
				c.s.executeUpdate(query1);
				c.s.executeUpdate(query2);
				
				
				
				JOptionPane.showMessageDialog(null, "Checkout Done");
				
				setVisible(false);
				new Reception();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		
		} else {
			setVisible(false);
			new Reception();
		}
		
	}
}
