package ESeva.dao;
import java.sql.*;
import java.util.ArrayList;

import ESeva.dbutil.DBConnection;
import java.sql.*;
import ESeva.pojo.SargentPojo;
import ESeva.pojo.ViolatorPojo;

public class SargentDao {
	
	public static boolean check;
	
	public static SargentPojo getIdAndPassword (SargentPojo sp) throws SQLException
	{
		check = false;
		
		PreparedStatement pstm = DBConnection.getConnection().prepareStatement("select * from sargent where USERNAME=? AND PASSWORD=?");
	    pstm.setString(1,sp.getUsername());
	    pstm.setString(2,sp.getPassword());
	    ResultSet rs = pstm.executeQuery();
	    
	    if(rs.next())
	    {
	    	sp.setWorkLocation(rs.getString("WORK_LOCATION"));
	    	sp.setSid(rs.getString("SID"));
	    	if(sp.getUsername().equals(rs.getString("USERNAME")))
	    	{
	    		if(sp.getPassword().equals(rs.getString("PASSWORD")))
	    		{
	    			check = true;
	    		}
	    	}
		}
	   
		 return sp;
	}
	
	
	

	public static ArrayList getDetailsForSos() throws SQLException
	{
		String cid;
		ArrayList <SargentPojo> arr = new ArrayList<>();
		
		Statement stm = DBConnection.getConnection().createStatement();
	    ResultSet rs = stm.executeQuery("select * from sos");
	    
	    SargentPojo sp;
	    
	    while(rs.next())
	    {
	    	sp = new SargentPojo();
	    	
	    	sp.setSid(rs.getString("SID"));
	    	sp.setUsername(rs.getString("NAME"));
	    	sp.setWorkLocation(rs.getString("LOCATION"));
	    	sp.setDate(rs.getString("DATE"));
	    	sp.setTime(rs.getString("TIME"));
		    
		    arr.add(sp);
		    
	    }
	    return arr;
	}

}
