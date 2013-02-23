package web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.FaultControl;
import business.FaultManager;

/**
 * Servlet implementation class FaultAssignDeleteServlet
 */
public class FaultAssignDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaultAssignDeleteServlet() {
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
		String id=request.getParameter("issueid");
		String authorityString=(String)request.getSession().getAttribute("authority");
		
		FaultManager fManager=new FaultControl();
		if(authorityString.equals("Administrator")){
			fManager.deleteassign(id);
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}
		else {
			request.setAttribute("errorCheck", "You have no authority to delete!");
		}
	}

}
