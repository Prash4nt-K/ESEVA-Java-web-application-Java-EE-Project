package ESeva.dbutil;
import java.sql.*;

public class DBConnection {
	
		public static Connection conn = null;
		static String path,username,password;
		
		static
		{
		try
		{
			path = "jdbc:mysql://localhost:3306/eseva";
			username = "root";
			password = "Pratt@26sql";
	
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(path,username,password);	
		}
		catch(ClassNotFoundException cnfe)
        {
           cnfe.printStackTrace();     
        }
		catch(SQLException sqlex)    
        {
			sqlex.printStackTrace();  
        }   
		}
		
		
		public static Connection getConnection()
	    {
	        return conn;
	    }
		
		
		public static void closeConnection()
	    {
	      try
	      {
	          if(conn!=null)
	          {
	              conn.close();
	          } 
	      }
	      catch(SQLException sqlex)    
	        {
	           sqlex.printStackTrace();
	        }  
	        
	    }
		
}
