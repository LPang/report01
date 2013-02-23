package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Fault;

import business.FaultControl;
import business.FaultManager;

/**
 * Servlet implementation class FaultDetailServlet
 */
public class FaultDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaultDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("FaultDetailServlet.doPost()");
		String typeString=request.getParameter("type");
		System.out.print(typeString);
		if(typeString.equals("Default")){
			request.getRequestDispatcher("blank.jsp").forward(request, response);
		}
		else{
		String issueidString=(String)request.getSession().getAttribute("issuedetailid");
		FaultManager faultman=new FaultControl();
		Fault fault= faultman.getFault(issueidString);
		request.setAttribute("faultinfo", fault);
		request.getRequestDispatcher("faultDetail.jsp").forward(request, response);
		}
	}

}
