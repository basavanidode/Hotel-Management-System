package hotel.management.system;

import java.sql.*;

public class Conn {
	
	
	//step2 Creating the connection
	
	Connection c;
	
	//step3 Creating the Statement
	Statement s;
	
	
	
	
	
	Conn() throws SQLException{ //idk throws sqlexceptions POINTTTTTTTTTT
		//step 1first we have to to resiter the driver class of MySQL
		//we have added the mysql jar in libraries
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//connection string creation below
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem","root","basava@2002");
			//using mysql in localhost with portno 3306
			//create ststement 
			s = c.createStatement(); //by using this statement we can execute queress
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//this is the driver for mysql which we have inseryted in Class.forName()
		
		
	}
	
	

}
