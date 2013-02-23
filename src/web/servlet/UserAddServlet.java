package web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.UserManager;
import business.UserControl;
/**
 * Servlet implementation class UserAddServlet
 */
public class UserAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("UserAddServlet.doGet()");
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("UserAddServlet.doPost()");
		String type=request.getParameter("type");
		String id=request.getParameter("account");
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
		if(um.checkuser(id)){
			request.setAttribute("errorCheck", "The account has existed");
			System.out.println("UserAddServlet.doPost()check");
		}
		else{
			um.add(id,name, password, identity, email, authority);
		}
		
		if(type.equals("Register")){
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else if(type.equals("Add")){
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}
	}

}
