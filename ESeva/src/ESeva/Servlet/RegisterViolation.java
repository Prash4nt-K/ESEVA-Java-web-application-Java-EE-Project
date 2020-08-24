package ESeva.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ESeva.dao.RegisterViolationDao;
import ESeva.pojo.ViolatorPojo;

/**
 * Servlet implementation class RegisterViolation
 */
@WebServlet("/RegisterViolation")
public class RegisterViolation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterViolation() {
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
		
		String vname = request.getParameter("vname");
		String dlNo = request.getParameter("dlno");
		String place = request.getParameter("pov");
		String vtype = request.getParameter("vt");
		String vcolor = request.getParameter("vc");
		String vNo = request.getParameter("vn");
		String amount = request.getParameter("fa");
		String offDec = request.getParameter("od");
		String RepOff = request.getParameter("ro");
		
		ViolatorPojo vp = new ViolatorPojo();
		vp.setViolatorName(vname);
		vp.setLicenseNo(dlNo);
		vp.setPlaceOfViolation(place);
		vp.setVehicleType(vtype);
		vp.setVehicleColor(vcolor);
		vp.setVehicleNo(vNo);
		vp.setAmount(amount);
		vp.setOffenceDes(offDec);
		vp.setRepeatedOff(RepOff);
		
		int answer=0;
		
		try
		{
		answer = RegisterViolationDao.register(vp);
		}
		catch(Exception ex)
		{
		System.out.print(ex);
		}
	
		if(answer != 0)
		{
			response.sendRedirect("TrafficInspectorHome.html");
		}
	}

}
