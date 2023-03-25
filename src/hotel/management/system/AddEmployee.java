package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddEmployee extends JFrame implements ActionListener{
	
	JTextField tfname , tfemail , tfphone ,tfage , tfsalary ,tfaadhar;
	
	JRadioButton rbmale ,rbfemale;
	
	JButton submit;
	
	JComboBox cbjob;
	
	AddEmployee(){
		setLayout(null);
		
		JLabel lblname = new JLabel("NAME");
		lblname.setBounds(60,30,120,30);
		lblname.setFont(new Font("Tahoma", Font.PLAIN ,17));
		add(lblname);
		
		tfname = new JTextField() ;
		tfname.setBounds(200,30,150,30);
		add(tfname);
		
		JLabel lblage = new JLabel("AGE");
		lblage.setBounds(60,80,120,30);
		lblage.setFont(new Font("Tahoma", Font.PLAIN ,17));
		add(lblage);
		
		tfage = new JTextField() ;
		tfage.setBounds(200,80,150,30);
		add(tfage);
		
		JLabel lblgender = new JLabel("GENDER"); //in Gender we are using radio buttons not textfields
		lblgender.setBounds(60,130,120,30);
		lblgender.setFont(new Font("Tahoma", Font.PLAIN ,17));
		add(lblgender);
		
		//to creat radio buuton
		
		rbmale = new JRadioButton("Male");
		rbmale.setFont(new Font("Tahoma",Font.PLAIN,14));
		rbmale.setBackground(Color.WHITE);
		rbmale.setBounds(200,130,70,30);
		add(rbmale);
		
		
		rbfemale = new JRadioButton("Female");
		rbfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
		rbfemale.setBackground(Color.WHITE);
		rbfemale.setBounds(280,130,70,30);
		add(rbfemale);
		
		//to group the two radio buttons such that only one will be selevcted ar=t a time
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbmale);
		bg.add(rbfemale);
		
		JLabel lbljob = new JLabel("JOB");
		lbljob.setBounds(60,180,120,30);
		lbljob.setFont(new Font("Tahoma", Font.PLAIN ,17));
		add(lbljob);
		
		//for dropdown we use JComboBox as Below
		
		String str[]= {"Front Desk Clerks" , "Porters" ,"Housekeeping" , "Kitchen Staff" ,"Room Service", "Chefs","Waiter/Waitress","Manager","Accountent"};
		cbjob = new JComboBox(str);
		cbjob.setBounds(200,180 ,150,30);
		cbjob.setBackground(Color.WHITE);
		add(cbjob);
		
		JLabel lblsalary = new JLabel("SALARY");
		lblsalary.setBounds(60,230,120,30);
		lblsalary.setFont(new Font("Tahoma", Font.PLAIN ,17));
		add(lblsalary);
		
		tfsalary = new JTextField() ;
		tfsalary.setBounds(200,230,150,30);
		add(tfsalary);
		
		JLabel lblphone = new JLabel("PHONE");
		lblphone.setBounds(60,280,120,30);
		lblphone.setFont(new Font("Tahoma", Font.PLAIN ,17));
		add(lblphone);
		
		tfphone = new JTextField() ;
		tfphone.setBounds(200,280,150,30);
		add(tfphone);
		
		JLabel lblemail = new JLabel("EMAIL");
		lblemail.setBounds(60,330,120,30);
		lblemail.setFont(new Font("Tahoma", Font.PLAIN ,17));
		add(lblemail);
		
		tfemail = new JTextField() ;
		tfemail.setBounds(200,330,150,30);
		add(tfemail);
		
		JLabel lblaadhar  = new JLabel("AADHAR");
		lblaadhar.setBounds(60,380,120,30);
		lblaadhar.setFont(new Font("Tahoma", Font.PLAIN ,17));
		add(lblaadhar);
		
		tfaadhar = new JTextField() ;
		tfaadhar.setBounds(200,380,150,30);
		add(tfaadhar);
		
		submit = new JButton("SUBMIT");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.setBounds(200,430,150,30);
		submit.addActionListener(this);
		add(submit);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
		Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(380,60,450,370);
		add(image);
		
		getContentPane().setBackground(Color.WHITE );
		setBounds(350,200,850,540);
		setVisible(true);
		
	}
	
	

	public static void main(String[] args) {
		
		new AddEmployee();
		
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		String name = tfname.getText();
		String age = tfage.getText();
		String salary = tfsalary.getText();
		String phone = tfphone.getText();
		String email = tfemail.getText();
		String aadhar = tfaadhar.getText();
		
		//Validation
		
		if (name.equals("")) {
			JOptionPane.showMessageDialog(null, "Name should not be empty");
			return;
		}
		
		if (email.equals("")) {
			JOptionPane.showMessageDialog(null, "Please enter a correct Email");// && ("@") && (".com") doubt
			return;
		}
		
		
		//to retreve the values from radio buttons
		String gender =null;
		
		if(rbmale.isSelected()) {
			gender = "Male";
		} else if(rbfemale.isSelected()) {
			gender="Female";	
		}
		
		//to retreve the value from combobox
		
		String job = (String) cbjob.getSelectedItem();
		
		try {
			
			Conn conn = new Conn();
			
			
			String query = "insert into employee values('"+name+"' , '"+age+"' , '"+gender+"' , '"+job+"' ,'"+salary+"' , '"+phone+"' , '"+email+"' , '"+aadhar+"')";
			
			//now for inserting data into database 
			
			conn.s.executeUpdate(query);
			
			JOptionPane.showMessageDialog(null, "Employee added Succesfully");//popup
			
			setVisible(false);
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		
	}



}
