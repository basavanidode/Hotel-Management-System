package hotel.management.system;

import java.awt.Color;//color property is present in awt packet
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;  //as we are using Swing it is present in javax so we need to import javax

public class HotelManagementSystem extends JFrame implements ActionListener {

	
	
      private static final long serialVersionUID = 1L;// i don't know why i'am using this
	
	
	HotelManagementSystem(){
		setSize(1366,565);//By using setSize(length,breadth) function we can set the size of the Frame
		setLocation(100,100);//The origin of opening of the Frame is from top left We can Change that position 
		//also using setLocation(top,left);
		
		//or else we can use setBounds(100,100,1366,565); insted of writing setSize And setLocation
		setLayout(null);//it will disable the by default layout and we need to creat our own layout 
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
		//to access the frame from our icons location we use above code taht we use ImageIcon in that
		//ClassLoader.getSystemResource
		
		JLabel image = new JLabel(i1);//we will know JLable latter
		image.setBounds(0,0,1366,565);//locationx ,locationy,width , height
		//and it is the combination of location and layout and location is with respect to the frame not to the window
		add(image);
	
		
		JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");//JLable is used to add text on the frame
		text.setBounds(20,430,1000,90);
		text.setForeground(Color.WHITE);//we can change the color of text using setForeground();
		text.setFont(new Font("serif",Font.PLAIN,50));//to set the font size we use this method
		//(font Family,style,size)
		image.add(text);//text component is now on the image
		
		
		JButton next =new JButton("Next");//using JButton we can create button 
		next. setBounds (1150, 450, 150, 50);
		next.setBackground(Color.WHITE);//we can change the backgroung color using setBackground();
		next.addActionListener(this);//to add action when we click on it
		next.setFont(new Font("serif",Font.BOLD,25));
		image.add (next);

		
		
		setVisible(true);//by default the visibility of the frame is hidden so using this we can able to see the frame
		
		
		//For differ Functionality we using an infinte loop in that all these stuff if ur getting any doubt plz google it 
	    //here we are differing the text "HOTEL MANAGEMENT SYSTEM"
		while(true) {
			text.setVisible(false);
			try {
				Thread.sleep(500);
			} catch(Exception e) {
				e.printStackTrace();
			}
			text.setVisible(true);
			try {
				Thread.sleep(500);
			} catch(Exception e) {
				e.printStackTrace();
			}
			text.setVisible(true);
		}
		
		
		
		
	}
	
	public void actionPerformed (ActionEvent ae) {
		//ovveridn to implements that ActionListioner interface
		
		//what we have to do after clicking on taht button this will diclared in this Method
		
		setVisible(false);
		new Login();
		//we have done 3 steps here+
		
	}
	

	public static void main(String[] args)  {
		new HotelManagementSystem(); //to access a Class we need to create the object for that

	}

}
