package web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Fault;

import business.FaultControl;
import business.FaultManager;

/**
 * Servlet implementation class FaultAssignServlet
 */
public class FaultAssignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaultAssignServlet() {
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
//		System.out.println("FaultAssignServlet.doPost()");
		String authority=(String)request.getSession().getAttribute("authority");
		FaultManager fmFaultManager=new FaultControl();
		if(authority.equals("Administrator")){
			List<Fault> list=fmFaultManager.listsimassign();//back the unassigned bug
			request.setAttribute("faultinfo", list);
			request.getRequestDispatcher("faultAssign.jsp").forward(request, response);
		}
		else{
			request.setAttribute("errorCheck", "You have no authority to assign!");
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}
	}

}
