package ESeva.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import ESeva.dbutil.DBConnection;
import ESeva.pojo.EmergencyPojo;
import ESeva.pojo.SargentPojo;

public class EmergencyDao {
	
	public static int registerEm(EmergencyPojo ep) throws SQLException
	{
		int check=0;
		String date,time;
		
	    SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd"); 
		SimpleDateFormat sdft = new SimpleDateFormat("HH:mm:ss");
		Date dt = new Date();
		date = sdfd.format(dt);
		time = sdft.format(dt);
	    
		
		PreparedStatement pstm = DBConnection.getConnection().prepareStatement("insert into emergency values(?,?,?,?,?,?)");
	    
		pstm.setString(1,ep.getLocation());
	    pstm.setString(2,ep.getAccedentType());
	    pstm.setString(3,ep.getNumberOfPeople());
	    pstm.setString(4,ep.getPriority());
	    pstm.setString(5,date);
	    pstm.setString(6,time);
	    
	    check = pstm.executeUpdate();
	 
		return check;
	}

	
	

	public static ArrayList getDetailsForEmergency() throws SQLException
	{
		ArrayList <EmergencyPojo> arr = new ArrayList<>();
		
		Statement stm = DBConnection.getConnection().createStatement();
	    ResultSet rs = stm.executeQuery("select * from emergency");
	    
	    EmergencyPojo ep;
	    
	    while(rs.next())
	    {
	    	ep = new EmergencyPojo();
	    	
	    	ep.setLocation(rs.getString("LOCATION"));
	    	ep.setAccedentType(rs.getString("ACCEDENT_TYPE"));
	    	ep.setNumberOfPeople(rs.getString("NUMBER_PEOPLE"));
	    	ep.setPriority(rs.getString("PRIORITY"));
	    	ep.setDate(rs.getString("DATE"));
	    	ep.setTime(rs.getString("TIME"));
		    
		    arr.add(ep);
		    
	    }
	    return arr;
	}
	
	
}
