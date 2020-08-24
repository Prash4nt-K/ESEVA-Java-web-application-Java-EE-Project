package ESeva.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ESeva.dao.EmergencyDao;
import ESeva.pojo.EmergencyPojo;

/**
 * Servlet implementation class RegisterEmergency
 */
@WebServlet("/RegisterEmergency")
public class RegisterEmergency extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterEmergency() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String location = request.getParameter("loc");
		String accedentType = request.getParameter("acty");
		String numberOfPeople = request.getParameter("nopa");
		String priority = request.getParameter("pri");
		
		EmergencyPojo ep = new EmergencyPojo();
		ep.setLocation(location);
		ep.setAccedentType(accedentType);
		ep.setNumberOfPeople(numberOfPeople);
		ep.setPriority(priority);
		
		int answer=0;
		
		try 
		{
		answer = EmergencyDao.registerEm(ep);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		if(answer != 0)
		{
			response.sendRedirect("AfterEmergency.html");
		}
		
		
	}

}
