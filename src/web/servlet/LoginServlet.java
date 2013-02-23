package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import business.UserControl;
import business.UserManager;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String account = request.getParameter("username");
		String password = request.getParameter("password");
		String identityString = request.getParameter("identity");
		
		UserManager um = new UserControl();
		boolean login = um.login(account,password,identityString);
		if(login){
			request.getSession().setAttribute("user", account);
			request.getSession().setAttribute("authority", identityString);
//			request.setAttribute("user", name);
//			System.out.print("login success");
			request.getRequestDispatcher("main.jsp").forward(request, response);
//			request.getRequestDispatcher("UserListServlet").forward(request, response);
		}else {
			request.setAttribute("errorMessage", "Your account, password or type is incorrect:");
			System.out.print("login failed");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
