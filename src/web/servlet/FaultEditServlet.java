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
 * Servlet implementation class FaultEditServlet
 */
public class FaultEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaultEditServlet() {
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
		System.out.println("FaultEditServlet.doPost()");
		String id = request.getParameter("issueid");
		String authorityString=(String)request.getSession().getAttribute("authority");
		System.out.print(authorityString);
		if(authorityString.equals("Administrator")){
		FaultManager faultManager= new FaultControl();
		Fault fault= faultManager.getFault(id);
		request.setAttribute("faultinfo", fault);
		request.getRequestDispatcher("faultEdit.jsp").forward(request, response);
		}
		else{
		request.setAttribute("errorCheck", "You have no authority to Modify!");
		request.getRequestDispatcher("showallfault").forward(request, response);
		}
	}

}
