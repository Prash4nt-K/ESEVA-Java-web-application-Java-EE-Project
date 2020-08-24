package ESeva.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import ESeva.dao.SargentDao;
import ESeva.dbutil.DBConnection;

import java.sql.*;
import ESeva.pojo.SargentPojo;;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String uname = request.getParameter("uname");
    	String password = request.getParameter("psw");
    	boolean answer = false;
    	
    	SargentPojo spj = new SargentPojo();
    	spj.setUsername(uname);
    	spj.setPassword(password);
    	
    	try
    	{
    		spj = SargentDao.getIdAndPassword(spj);
    	}
    	catch(Exception ex)
    	{
    		System.out.print(ex);
    	}
    	
    	if(SargentDao.check == true)
    	{
    		HttpSession ses = request.getSession();
    		ses.setAttribute("name",spj.getUsername());
    		ses.setAttribute("passwd",spj.getPassword());
    		ses.setAttribute("workLoc",spj.getWorkLocation());
    		ses.setAttribute("sid",spj.getSid());
    		
    		response.sendRedirect("TrafficInspector.html");
    	}
    	else
    	{
    		response.sendRedirect("LoginError.html");
    	}
	}

}
