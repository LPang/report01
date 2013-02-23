package web.servlet;

import java.io.IOException;
//import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import business.FaultControl;
//import business.FaultManager;
//import business.UserControl;
//import business.UserManager;
//import domain.Fault;
//import domain.User;

/**
 * Servlet implementation class FaultListServlet
 */
public class FaultListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaultListServlet() {
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
		System.out.println("FaultListServlet.doPost()");
		String tyString=request.getParameter("type");
		request.setAttribute("type",tyString);
		
		String issueid=request.getParameter("issueid");
//		System.out.print(issueid);
		request.getSession().setAttribute("issuedetailid", issueid);
		request.getRequestDispatcher("faultList.jsp").forward(request, response);
	
	}

}
