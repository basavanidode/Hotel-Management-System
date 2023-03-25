package hotel.management.system;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.*;
import java.sql.ResultSet;
public class Login extends JFrame implements ActionListener {
	
	JTextField username ;
	JPasswordField password;
	JButton login , cancel;  //we have diclared textfield and button globally inorder to match results from database
	
	Login() {
		getContentPane().setBackground(Color.WHITE);//to set the background color of full frame white we use getContentPane()
		
		setLayout(null);
		
		JLabel user = new JLabel("Username");
		user.setBounds(40, 20, 100, 10);
		add(user);
		
		username= new JTextField();//to create text field for user inputs
		username.setBounds(150,20,100,30);
		add(username);
		
		JLabel pass = new JLabel("Password");
		pass.setBounds(40, 65, 100, 10);
		add(pass);
		
		 password= new JPasswordField();//to create text field for user inputs
		password.setBounds(150,65,100,30);
		add(password);
		
		login =new JButton("Login");
		login.setBounds(40, 150, 120, 30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);//to check action happend on login button
		add(login);
		
		cancel =new JButton("Cancel");
		cancel.setBounds(180, 150, 120, 30);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);//to check action happend on Cancel button
		add(cancel);
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);//for scaling the image
		//we cannot place the Image class objects in JLable for that purpose we will create ImageIcon as below
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(350,10,200,200);
		add(image);
		
		
		
		
		setBounds(500,200,600,300);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//to check whether the login button is clicked or cancel buuton is clicked 
		if(e.getSource()==login) {
			
			String user = username.getText();//we can extract the values from Textfield
			String pass = password.getText();//to extact the password from Textfield
			
			
			//Hit the database and check weather the values are exsit in database or not
			//database is an extrnal entity so thet we need to craet the try and catch block as below
			
			try {
				Conn c =new Conn();//created the object of conn class
				//we are creating mysql query below
				String query = "select * from login where username= '"+ user + "' and password = '" + pass + "'";
				
				//to exicute this query we have an function call Execute query as below
				
				ResultSet rs = c.s.executeQuery(query);//it will return if data is avilable else it will return nullo so we are 
				//storing in resultset
				
				//to check the data present in rs we use next() as below
				
				if(rs.next()) {
					setVisible(false);//close the current frame and show the next frame i.e. Dashboard
					new Dashboard();
				} else {
					//to show popup window we use JOPtionPane
					JOptionPane.showMessageDialog(null, "Invalid username or password");
					setVisible(false);//to close the frame
				}
				
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} else if (e.getSource()==cancel) {
			setVisible(false);//when we clicked on cancel button the frame will be closed
			
		}
		
	}
	

	public static void main(String[] args) {
		new Login();
	}

	
}
