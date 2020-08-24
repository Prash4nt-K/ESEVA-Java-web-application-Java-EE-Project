package ESeva.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ESeva.dao.PaymentDao;
import ESeva.dao.RegisterViolationDao;
import ESeva.pojo.ViolatorPojo;

/**
 * Servlet implementation class SubmitPaymentData
 */
@WebServlet("/SubmitPaymentData")
public class SubmitPaymentData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitPaymentData() {
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
		
	
		
		
		HttpSession ses = request.getSession();

		String challanID = (String)ses.getAttribute("challanID");
		int answer=0;
		
		try
		{
		answer = PaymentDao.acceptPayment(challanID);
		}
		catch(Exception ex)
		{
		System.out.print(ex);
		}
	
		if(answer != 0)
		{
			response.sendRedirect("AfterPayment.html");
		}
	}

}
