package web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.FaultManager;
import business.FaultControl;
/**
 * Servlet implementation class FaultAddServlet
 */
public class FaultAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaultAddServlet() {
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
		String authority=(String)request.getSession().getAttribute("authority");
		if(authority.equals("Administrator")||authority.equals("Reporter")){
		String issueid=request.getParameter("issueid");
		String issuetype=request.getParameter("issuetype");
		String summary=request.getParameter("summary");
		String detail=request.getParameter("detail");
		String expectedres=request.getParameter("expectedres");
		String actualres=request.getParameter("actualres");
		String projectname=request.getParameter("projectname");
		String foundinrelease=request.getParameter("foundinrelease");
		String state=request.getParameter("state");
		String status=request.getParameter("status");
		String severity=request.getParameter("severity");
		String reproducibility=request.getParameter("reproducibility");
		String reporterid=(String)request.getParameter("reporterid");
		String reportername=(String)request.getSession().getAttribute("user");
		String assignstate="No";
		FaultManager fau= new FaultControl();
		if(!fau.checkfault(issueid)){
		fau.add(issueid, issuetype, summary, detail, expectedres, actualres, projectname, foundinrelease, state, status, severity, reproducibility, reporterid, reportername,assignstate);
		}
		else{
			request.setAttribute("errorCheck", "The issue id has existed!");
		}
		}
		
		else{
			request.setAttribute("errorCheck", "You have no authority to report!");
		}
		request.getRequestDispatcher("main.jsp").forward(request, response);
		
	}

}
