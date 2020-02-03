 package bookshop;

import java.sql.*;
import java.util.Scanner;

public class Sql {
	public static void main(String [] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please choose from the following options:"
				+ "\n      Press 1 :to insert data"
				+ "\n      Press 2 :to delete data"
				+ "\n      Press 3 :to Search for data"
				+ "\n      Press 4 :to update data"
				+ "\n      Press 0 :to exit"
				+ "\n"
				+ "\nPlease enter your number below: ");
		int num = input.nextInt();
		
		try
	    { 
	 
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore","root","Greatjoy@23");
			Statement stmt = conn.createStatement();
			
			switch(num) {
			
			case 1 :
				/* Inserting data in database
	            String q1 = "insert into books values (3001, 'J C Waters','Mhirimo printworks',99)";
	            int x = stmt.executeUpdate(q1); 
	            if (x > 0)             
	                System.out.println("Successfully Inserted");             
	            else            
	                System.out.println("Insert Failed"); 
				break;*/
				System.out.println("Enter the id: ");
				int id = input.nextInt();

				System.out.println("Enter the title: ");
				String Title = input.nextLine();

				System.out.println("Enter the Author: ");
				String Author = input.nextLine();

				System.out.println("Enter the Qty of the product: ")
				int Qty = input.nextInt();

				String q1 = "insert into books " + " (id, Title, Author, Qty) "+ " values (?,?,?,?)";
				stmt = myconn.prepareStatement(q1);
				
				//set param values
				stmt.setInt(1, id);
				stmt.setString(2, Title);
				stmt.setString(3, Author);
				stmt.setInt(4, Qty);

				int x = stmt.executeUpdate(q1); 
	            if (x > 0)             
	                System.out.println("Successfully Inserted");             
	            else            
	                System.out.println("Insert Failed"); 
				break;

			case 2 :
				 /* Deleting from database Title
	            String  q2 = "DELETE from books  WHERE id = 3007";
	                   
	            int y= stmt.executeUpdate(q2); 
	              
	            if (y> 0)             
	                System.out.println("One book Successfully Deleted");             
	            else
	                System.out.println("ERROR OCCURED ");
	            break;*/
				int n = input.nextInt();
				String q2 = "DELETE from books WHERE id = ?";
				stmt = myconn.prepareStatement(q2);

				 stmt.setInt(1,n);

				 int y= stmt.executeUpdate(q2); 
	              
	            if (y> 0)             
	                System.out.println("One book Successfully Deleted");             
	            else
	                System.out.println("ERROR OCCURED ");
	            break;

			case 3 :
				  SELECT query
				 String q3 = "select * from books WHERE  id = ?";
				 stmt = myconn.prepareStatement(q3);
		            
					int p = input.nextInt();
					ResultSet rs = stmt.executeQuery(q3); 
					stmt.setInt(p);

		            if (rs.next()) 
		            {	
						int id = rs.getInt(p); 
		                System.out.println("title : " + rs.getString(1)); 
		                System.out.println("author :" + rs.getString(2)); 
		                System.out.println("publisher :" + rs.getString(3));
		                System.out.println(" Qty :" + rs.getString(4));
		            }
		            else
		             
		                System.out.println("No such user id is already registered"); 
		            break;
		            
				
			case 4 :
				// Updating database 
	            String q4 =  "UPDATE Books set Qty = ? WHERE id = ?";
	            
				int Qty = input.nextInt();
				int id  = input.nextInt();
	           
	              stmt = myconn.prepareStatement(q4);

				  stmt.setInt(1,Qty);
				  stmt.setInt(2,id);

				int z = stmt.executeUpdate( q4); 
	            if (z > 0)             
	                System.out.println("Qty Successfully Updated");             
	            else            
	                System.out.println("ERROR OCCURED");
	            break;
				
				
			case 0 :
				System.out.println("Existing, Thank you.");
				break;
			
			default:
				System.out.println("Your input is not applicable, please try one of the following options." 
						+ "\n      Press 1 :to insert data"
						+ "\n      Press 2 :to delete data"
						+ "\n      Press 3 :to Search for data"
						+ "\n      Press 4 :to update data"
						+ "\n      Press 0 :to exit");
				break;
				
	          
			}
           
            conn.close();
	    } 
	    catch(Exception e) 
	    { 
	        System.out.println(e); 
	    } 
		
	}

}
