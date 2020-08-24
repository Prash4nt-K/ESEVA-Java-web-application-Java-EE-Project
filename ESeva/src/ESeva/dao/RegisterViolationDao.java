package ESeva.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ESeva.dbutil.DBConnection;
import ESeva.pojo.SargentPojo;
import ESeva.pojo.ViolatorPojo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class RegisterViolationDao {
	
	public static int register (ViolatorPojo vp) throws SQLException
	{
		int check=0,check1,check2;
		String cid,pid,date,time;
		
	    Statement stm = DBConnection.getConnection().createStatement();
	    ResultSet rs = stm.executeQuery("select max(CID) from violation");
	    rs.next();
	    cid = rs.getString("max(CID)").substring(1);  
	    int temp = Integer.parseInt(cid);
	    temp = temp+1;
	    cid= "C"+Integer.toString(temp);
	    
	    
	    SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd"); 
		SimpleDateFormat sdft = new SimpleDateFormat("HH:mm:ss");
		Date dt = new Date();
		date = sdfd.format(dt);
		time = sdft.format(dt);
	    
		
		PreparedStatement pstm = DBConnection.getConnection().prepareStatement("insert into violation values(?,?,?,?,?,?,?,?,?,?,?,?)");
	    
		pstm.setString(1,cid);
	    pstm.setString(2,vp.getViolatorName());
	    pstm.setString(3,vp.getLicenseNo());
	    pstm.setString(4,vp.getPlaceOfViolation());
	    pstm.setString(5,vp.getVehicleType());
	    pstm.setString(6,vp.getVehicleColor());
	    pstm.setString(7,vp.getVehicleNo());
	    pstm.setString(8,vp.getAmount());
	    pstm.setString(9,vp.getOffenceDes());
	    pstm.setString(10,vp.getRepeatedOff());
	    pstm.setString(11,date);
	    pstm.setString(12,time);
	    check1 = pstm.executeUpdate();
	    
	    
	    Statement st = DBConnection.getConnection().createStatement();
	    ResultSet rs1 = st.executeQuery("select max(PID) from payment");
	    rs1.next();
	    pid = rs1.getString("max(PID)").substring(1);  
	    int tem = Integer.parseInt(pid);
	    tem = tem+1;
	    pid= "P"+Integer.toString(tem);
	    
	    
	    PreparedStatement pst = DBConnection.getConnection().prepareStatement("insert into payment values(?,?,?,?)");
	    pst.setString(1,pid);
	    pst.setString(2,cid);
	    pst.setString(3,"No");
	    pst.setString(4,vp.getAmount());
	    check2 = pst.executeUpdate();
	    	    
	    if(check1 != 0 && check2 != 0)
	    {
	    	check = 1;
	    }
		return check;
	}

	
	public static int registerSos(SargentPojo sp) throws SQLException
	{
		int check=0;
		String date,time;
		
	    SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd"); 
		SimpleDateFormat sdft = new SimpleDateFormat("HH:mm:ss");
		Date dt = new Date();
		date = sdfd.format(dt);
		time = sdft.format(dt);
	    
		
		PreparedStatement pstm = DBConnection.getConnection().prepareStatement("insert into sos values(?,?,?,?,?)");
	    
		pstm.setString(1,sp.getSid());
	    pstm.setString(2,sp.getUsername());
	    pstm.setString(3,sp.getWorkLocation());
	    pstm.setString(4,date);
	    pstm.setString(5,time);
	    
	    check = pstm.executeUpdate();
	 
		return check;
	}
	
	
	
	public static ArrayList getDetailsOfViolators() throws SQLException
	{
		ArrayList <ViolatorPojo> arr = new ArrayList<>();
		
		Statement stm = DBConnection.getConnection().createStatement();
	    ResultSet rs1 = stm.executeQuery("select * from violation");
	    ViolatorPojo vpj;
	    
	    while(rs1.next()) 
	    {
		    vpj = new ViolatorPojo();
		    vpj.setCid(rs1.getNString("CID"));
		    vpj.setViolatorName(rs1.getString("VNAME"));
		    vpj.setVehicleNo(rs1.getString("VEHICLE_NO"));
		    vpj.setPlaceOfViolation(rs1.getString("PLACE"));
		    vpj.setOffenceDes(rs1.getString("OFFENCE_DESCRIPTION"));
		    vpj.setDate(rs1.getString("DATE"));
		    vpj.setTime(rs1.getString("TIME"));
		    vpj.setVehicleType(rs1.getString("VEHICLE_TYPE"));
		    vpj.setAmount(rs1.getNString("FINE_AMOUNT"));
		    
		    arr.add(vpj);
		    
	    }
	    return arr;
	}

	
	
}
