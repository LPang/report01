package web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import business.UserControl;
import business.UserManager;
import domain.User;


/**
 * Servlet implementation class UserListServlet
 */
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("UserListServlet.doPost()");
		String type=request.getParameter("type");
		UserManager um = new UserControl();
		if(type.equals("Reporter")){
			List<User> listreporter= um.listtype(type);
			request.setAttribute("userList", listreporter);
		}
		else if(type.equals("Developer")){
			List<User> listreporter= um.listtype(type);
			request.setAttribute("userList", listreporter);
		}
		else if(type.equals("All")){
			List<User> list = um.list();
			request.setAttribute("userList", list);
		}
		request.getRequestDispatcher("userList.jsp").forward(request, response);
	}

}
