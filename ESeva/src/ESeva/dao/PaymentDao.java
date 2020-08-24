package ESeva.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import ESeva.dbutil.DBConnection;
import ESeva.pojo.ViolatorPojo;

public class PaymentDao {
	
	public static boolean check1;
	public static boolean check2;
	
	public static ArrayList getDetails () throws SQLException
	{
		String cid;
		ArrayList <ViolatorPojo> arr = new ArrayList<>();
		
		Statement stm = DBConnection.getConnection().createStatement();
	    ResultSet rs = stm.executeQuery("select CID from payment where TICKET_ISSUED='No'");
	    
	    while(rs.next())
	    {
	    	cid = rs.getNString("CID");
	    	
	    	PreparedStatement pstm = DBConnection.getConnection().prepareStatement("select VNAME,VEHICLE_NO,VEHICLE_TYPE,PLACE,OFFENCE_DESCRIPTION,DATE,FINE_AMOUNT,TIME from violation where CID=?");
		    pstm.setString(1,cid);
		    ResultSet rs1 = pstm.executeQuery();
		    rs1.next();
		    ViolatorPojo vpj = new ViolatorPojo();
		    vpj.setCid(cid);
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

	
	
	
	public static void issueTicket(String cid) throws SQLException
	{
	    PreparedStatement pstm = DBConnection.getConnection().prepareStatement("update payment set TICKET_ISSUED = 'Yes' where CID=?");
	    pstm.setString(1,cid);
	    pstm.executeUpdate();	   
	}

	
	
	public static ViolatorPojo getDetailsOfChallan(String cid) throws SQLException
	{   	
	    	PreparedStatement pstm = DBConnection.getConnection().prepareStatement("select VNAME,VEHICLE_NO,VEHICLE_TYPE,PLACE,OFFENCE_DESCRIPTION,DATE,FINE_AMOUNT,TIME from violation where CID=?");
		    pstm.setString(1,cid);
		    ResultSet rs1 = pstm.executeQuery();
		    ViolatorPojo vpj = new ViolatorPojo();
		    
		    if(rs1.next())
		    {
		    vpj.setCid(cid);
		    vpj.setViolatorName(rs1.getString("VNAME"));
		    vpj.setVehicleNo(rs1.getString("VEHICLE_NO"));
		    vpj.setPlaceOfViolation(rs1.getString("PLACE"));
		    vpj.setOffenceDes(rs1.getString("OFFENCE_DESCRIPTION"));
		    vpj.setDate(rs1.getString("DATE"));
		    vpj.setTime(rs1.getString("TIME"));
		    vpj.setVehicleType(rs1.getString("VEHICLE_TYPE"));
		    vpj.setAmount(rs1.getNString("FINE_AMOUNT"));
		    
		    issueTicket(cid);
		    
		    check1 =  true;
		    }
		    else
		    {
		    	check1 = false;
		    }
		    
	    return vpj;
	}
	
	
	public static ArrayList getDetailsForPayment() throws SQLException
	{
		String cid;
		ArrayList <ViolatorPojo> arr = new ArrayList<>();
		
		Statement stm = DBConnection.getConnection().createStatement();
	    ResultSet rs = stm.executeQuery("select CID from payment where TICKET_ISSUED='Yes' and AMOUNT_TO_PAY <> '0'");
	    
	    while(rs.next())
	    {
	    	cid = rs.getNString("CID");
	    	
	    	PreparedStatement pstm = DBConnection.getConnection().prepareStatement("select VNAME,VEHICLE_NO,VEHICLE_TYPE,PLACE,OFFENCE_DESCRIPTION,DATE,FINE_AMOUNT,TIME from violation where CID=?");
		    pstm.setString(1,cid);
		    ResultSet rs1 = pstm.executeQuery();
		    rs1.next();
		    ViolatorPojo vpj = new ViolatorPojo();
		    vpj.setCid(cid);
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
	
	
	public static ViolatorPojo getDetailsOfPayment(String cid) throws SQLException
	{   	
	    	PreparedStatement pstm = DBConnection.getConnection().prepareStatement("select VNAME,VEHICLE_NO,VEHICLE_TYPE,PLACE,OFFENCE_DESCRIPTION,DATE,FINE_AMOUNT,TIME from violation where CID=?");
		    pstm.setString(1,cid);
		    ResultSet rs1 = pstm.executeQuery();
		    ViolatorPojo vpj = new ViolatorPojo();
		    
		    if(rs1.next())
		    {
		    vpj.setCid(cid);
		    vpj.setViolatorName(rs1.getString("VNAME"));
		    vpj.setVehicleNo(rs1.getString("VEHICLE_NO"));
		    vpj.setPlaceOfViolation(rs1.getString("PLACE"));
		    vpj.setOffenceDes(rs1.getString("OFFENCE_DESCRIPTION"));
		    vpj.setDate(rs1.getString("DATE"));
		    vpj.setTime(rs1.getString("TIME"));
		    vpj.setVehicleType(rs1.getString("VEHICLE_TYPE"));
		    vpj.setAmount(rs1.getNString("FINE_AMOUNT"));
		    
		    issueTicket(cid);
		    
		    check2 =  true;
		    }
		    else
		    {
		    	check2 = false;
		    }
		    
	    return vpj;
	}
	
	
	public static int acceptPayment(String cid) throws SQLException
	{   	
			String date,time,amountToPay="0";
			int check1,check2,check=0;
			
			SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd"); 
			SimpleDateFormat sdft = new SimpleDateFormat("HH:mm:ss");
			Date dt = new Date();
			date = sdfd.format(dt);
			time = sdft.format(dt);
		    
		    PreparedStatement pstm = DBConnection.getConnection().prepareStatement("update payment set AMOUNT_TO_PAY=?,P_DATE=?,P_TIME=? where CID=?");
		    pstm.setString(1,amountToPay);
		    pstm.setString(2,date);
		    pstm.setString(3,time);
		    pstm.setString(4,cid);
		    check = pstm.executeUpdate();	
		    
		    
		    return check;
	}

	
	
	public static ArrayList getFineCollectedDetails() throws SQLException
	{
		ArrayList <ViolatorPojo> arr = new ArrayList<>();
		String cid;
		
		Statement stm = DBConnection.getConnection().createStatement();
	    ResultSet rs = stm.executeQuery("select CID,P_DATE,P_TIME from payment where AMOUNT_TO_PAY='0'");
	    
	    ViolatorPojo vpj;
	    
	    while(rs.next())
	    {
	    	cid = rs.getString("CID");
	    	
	    	PreparedStatement pstm = DBConnection.getConnection().prepareStatement("select VNAME,FINE_AMOUNT,OFFENCE_DESCRIPTION from violation where CID=?");
		    pstm.setString(1,cid);
		    ResultSet rs1 = pstm.executeQuery();
		    rs1.next();
		    
		    vpj = new ViolatorPojo();
		    
		    vpj.setCid(cid);
		    vpj.setViolatorName(rs1.getString("VNAME"));
		    vpj.setAmount(rs1.getString("FINE_AMOUNT"));
		    vpj.setOffenceDes(rs1.getString("OFFENCE_DESCRIPTION"));
		    vpj.setDate(rs.getString("P_DATE"));
		    vpj.setTime(rs.getString("P_TIME"));
		    
		    arr.add(vpj);
		    
	    }
	    return arr;
	}



}
