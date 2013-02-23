package web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Fault;
import domain.User;

import business.FaultControl;
import business.FaultManager;
import business.UserControl;
import business.UserManager;

/**
 * Servlet implementation class FaultAssignSaveServlet
 */
public class FaultAssignSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaultAssignSaveServlet() {
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
		String id = request.getParameter("issueid");
		String authorityString=(String)request.getSession().getAttribute("authority");
		System.out.print(authorityString);
		if(authorityString.equals("Administrator")){
		FaultManager faultManager= new FaultControl();
		Fault fault= faultManager.getFault(id);//get the assigned issue's id
		
		UserManager userManager=new UserControl();
		List<User> listtype= userManager.listtype("Developer");//get all developer
		
		request.setAttribute("usertype", listtype);
		request.setAttribute("faultinfo", fault);
		request.getRequestDispatcher("faultAssignEdit.jsp").forward(request, response);
		}
		else{
		request.setAttribute("errorCheck", "You have no authority to Assign!");
		request.getRequestDispatcher("assignissue").forward(request, response);
		//FaultAssignServlet
		}
	}

}
