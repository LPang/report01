package web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Fault;
//import domain.User;

import business.FaultControl;
import business.FaultManager;
//import business.UserControl;
//import business.UserManager;

/**
 * Servlet implementation class FaultListSimpleServlet
 */
public class FaultListSimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaultListSimpleServlet() {
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
		System.out.println("FaultListSimpleServlet.doPost()");
		FaultManager fm = new FaultControl();
		List<Fault> listsim = fm.listsim();
//		System.out.print(listsim);
		request.setAttribute("faultList", listsim);
		request.getRequestDispatcher("faultListsimple.jsp").forward(request, response);
	}

}
