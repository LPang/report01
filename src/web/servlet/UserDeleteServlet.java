package web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.UserManager;
import business.UserControl;
/**
 * Servlet implementation class UserDeleteServlet
 */
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("UserDeleteServlet.doGet()");
		this.doPost(request, response);
	}

	/*
	 *
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 *
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("userid");
		String authorityString=(String)request.getSession().getAttribute("authority");
		String typeString=request.getParameter("type");
		UserManager um = new UserControl();
		if(authorityString.equals("Administrator")){
		um.delete(id);
		}
		else{
			request.setAttribute("errorCheck", "You have no authority");
		}
		request.setAttribute("type",typeString);
		request.getRequestDispatcher("showalluser").forward(request, response);
	}

}
