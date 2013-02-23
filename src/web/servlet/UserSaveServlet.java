package web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.UserControl;
import business.UserManager;
/**
 * Servlet implementation class UserSaveServlet
 */
public class UserSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("UserSaveServlet.doGet()");
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userid = request.getParameter("userid");
		System.out.print(userid);
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		String identity=request.getParameter("identity");
		String email=request.getParameter("email");
		String authority="0";
		if(identity.equals("Administrator")){
			authority="1";
		}
		if(identity.equals("Reporter")){
			authority="2";
		}
		if(identity.equals("Developer")){
			authority="3";
		}
		if(identity.equals("Guest")){
			authority="4";
		}
		UserManager um = new UserControl();
		um.edit(userid, name, password, email, identity, authority);
		request.getRequestDispatcher("showalluser?type=All").forward(request, response);
	}

}
