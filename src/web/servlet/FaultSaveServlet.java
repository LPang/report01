package web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.FaultControl;
import business.FaultManager;


/**
 * Servlet implementation class FaultSaveServlet
 */
public class FaultSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaultSaveServlet() {
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
		System.out.println("FaultSaveServlet.doPost()");
		String savetype=request.getParameter("Savetype");
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
		String reporterid=request.getParameter("reporterid");
		String developerid=request.getParameter("developerid");
		String reportername=request.getParameter("reportername");
		String administratorid=(String)request.getSession().getAttribute("user");
		System.out.print(issueid);
		FaultManager faultManager=new FaultControl();
		if(savetype.equals("Edit")){
			faultManager.edit(issueid, issuetype, summary, detail, expectedres, actualres, projectname, foundinrelease, state, status, severity, reproducibility, reporterid, reportername);
			request.getRequestDispatcher("showallfault").forward(request, response);
		}
		else if(savetype.equals("Assign")){
			String assignstate="Yes";
			faultManager.editAssigndev(issueid, developerid, administratorid,assignstate);
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}
//		faultManager.edit(issueid, issuetype, summary, detail, expectedres, actualres, projectname, foundinrelease, state, status, severity, reproducibility, reportid, reportername);
		
	}

}
