package web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Fault;

import business.FaultControl;
import business.FaultManager;

/**
 * Servlet implementation class FaultAssignerServlet
 */
public class FaultAssignerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaultAssignerServlet() {
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
		String reporterid=request.getParameter("assignerid");
		String typeString=request.getParameter("type");
		FaultManager fManager= new FaultControl();
		if(typeString.equals("Developer")){
			//获取一个开发者的所有issue
			List<Fault> listassigner= new ArrayList<Fault>();
			listassigner=fManager.listassignissue(reporterid);
			request.setAttribute("listassign",listassigner);
			request.getRequestDispatcher("showFaultAssign2.jsp").forward(request, response);
		}
		else if(typeString.equals("Administrator")){
			//获取一个管理员分配的所有issue
			List<Fault> listassign= new ArrayList<Fault>();
			listassign=fManager.listassigner(reporterid);
			request.setAttribute("listassign", listassign);
			request.getRequestDispatcher("showFaultAssign.jsp").forward(request, response);
		}
		
	}

}
