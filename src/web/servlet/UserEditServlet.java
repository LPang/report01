package web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.UserControl;
import business.UserManager;
import domain.User;

/**
 * Servlet implementation class UserEditServlet
 */
public class UserEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("UserEditServlet.doGet()");
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("userid");
		String authorityString=(String)request.getSession().getAttribute("authority");
		
		UserManager um = new UserControl();
		if(authorityString.equals("Administrator")){
			User user = um.getUser(id);
			request.setAttribute("userinfo", user);
//			System.out.println("UserEditServlet.doPost()check");
			request.getRequestDispatcher("userEdit.jsp").forward(request, response);
		}
		else{
			request.setAttribute("errorCheck", "You have no authority to modify!");
			request.getRequestDispatcher("showalluser").forward(request, response);
			
		}
	}

}
