package business;
/*the code which about the connection with database is referenced from the book:Tomcat and Java Web, JDBC*/
import java.util.ArrayList;
import java.util.List;

import business.FaultManager;
import domain.Fault;
import database.DbConnector;

import java.sql.*;
public class FaultControl implements FaultManager {
	private DbConnector dbConn=new DbConnector();
	@Override
	public void add(String issueid, String issuetype, String summary,
			String detail, String expresult, String actresult,
			String projectname, String foundrelease, String state, String status, 
			String severity, String reproducibility, String reproterid,
			String reprotername, String assignstate) {
		// TODO Auto-generated method stub
		try {
			Connection conn = dbConn.getConn();
			Statement stmt = conn.createStatement();
			String sql = "insert into fault(issueid,issuetype,summary,detail,expectedresult,actualresult,projectname,foundinrelease,state,rationalstatus,severity,reproducibility,reporterid, reportername, assignstate) values('" + issueid + "','" + issuetype + "','" + summary + "','" + detail + "','" + expresult + "','" + actresult + "','" + projectname + "','" + foundrelease + "','" + state + "','" + status + "','" + severity + "','" + reproducibility + "','" + reproterid + "','" + reprotername + "','"+assignstate+"')";
			stmt.executeUpdate(sql);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void edit(String issueid, String issuetype, String summary,
			String detail, String expresult, String actresult,
			String projectname, String foundrelease, String state, String status, 
			String severity, String reproducibility, String reproterid,
			String reprotername) {
		// TODO Auto-generated method stub
		try{
			Connection connection=dbConn.getConn();
			Statement statement=connection.createStatement();
			String sql="update fault set issueid='"+ issueid +"',issuetype='"+issuetype+"',summary='"+summary+"',detail='"+detail+"',expectedresult='"+expresult+"',actualresult='"+actresult+"',projectname='"+projectname+"',foundinrelease='"+foundrelease+"',state='"+state+"',rationalstatus='"+status+"',severity='"+severity+"',reproducibility='"+reproducibility+"',reporterid='"+reproterid+"',reportername='"+reprotername+"' where issueid='"+issueid+"'";
			statement.execute(sql);
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Override
	public void editAssigndev(String issueid, String developerid,String administratorid, String assignstate)
	{
		try{
			Connection connection=dbConn.getConn();
			Statement statement=connection.createStatement();
			String sql="update fault set developerid='"+developerid+"',administratorid='"+administratorid+"',assignstate='"+assignstate+"' where issueid='"+issueid+"'";
			statement.execute(sql);
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void delete(String issueid) {
		// TODO Auto-generated method stub
		try {
			Connection conn = dbConn.getConn();
			Statement stmt = conn.createStatement();
			String sql = "delete from fault where issueid='"+ issueid +"'";
			stmt.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void deleteassign(String issueid){
		try {
			Connection conn = dbConn.getConn();
			Statement stmt = conn.createStatement();
			String sql ="update fault set developerid='',administratorid='',assignstate='No' where issueid='"+issueid+"'";
			stmt.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<Fault> list() {
		// TODO Auto-generated method stub
		List<Fault> list=new ArrayList<Fault>();
		try {
			Connection conn = dbConn.getConn();
			Statement stmt = conn.createStatement();
			String sql = "select * from fault";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Fault fault = new Fault();
				fault.setid(rs.getString("issueid"));
				fault.settype(rs.getString("issuetype"));
				fault.setsummary(rs.getString("summary"));
				fault.setdeatil(rs.getString("detail"));
				fault.setexpresult(rs.getString("expectedresult"));
				fault.setactresult(rs.getString("actualresult"));
				fault.setproname(rs.getString("projectname"));
				fault.setrelease(rs.getString("foundinrelease"));
				fault.setstate(rs.getString("state"));
				fault.setstatus(rs.getString("rationalstatus"));
				fault.setseverity(rs.getString("severity"));
				fault.setreproducty(rs.getString("reproducibility"));
				fault.setreporterid(rs.getInt("reporterid"));
				fault.setreportername(rs.getString("reportername"));
				list.add(fault);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Fault> listsim() {
		// TODO Auto-generated method stub
		List<Fault> listsim=new ArrayList<Fault>();
		try {
			Connection conn = dbConn.getConn();
			Statement stmt = conn.createStatement();
			String sql = "select * from fault";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Fault fault = new Fault();
				fault.setid(rs.getString("issueid"));
				fault.settype(rs.getString("issuetype"));
				fault.setsummary(rs.getString("summary"));
				fault.setstate(rs.getString("state"));
				fault.setstatus(rs.getString("rationalstatus"));
				fault.setseverity(rs.getString("severity"));
				listsim.add(fault);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listsim;
	}
	
	@Override
	public List<Fault> listsimassign() {
		// TODO Auto-generated method stub
		List<Fault> listsim=new ArrayList<Fault>();
		try {
			Connection conn = dbConn.getConn();
			Statement stmt = conn.createStatement();
			String sql = "select * from fault where assignstate='No'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Fault fault = new Fault();
				fault.setid(rs.getString("issueid"));
				fault.settype(rs.getString("issuetype"));
				fault.setsummary(rs.getString("summary"));
				fault.setstate(rs.getString("state"));
				fault.setstatus(rs.getString("rationalstatus"));
				fault.setseverity(rs.getString("severity"));
				listsim.add(fault);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listsim;
	}
	@Override
	public List<Fault> listassignInfo(){
		List<Fault> listsim=new ArrayList<Fault>();
		try {
			Connection conn = dbConn.getConn();
			Statement stmt = conn.createStatement();
			String sql = "select * from fault where assignstate='Yes'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Fault fault = new Fault();
				fault.setid(rs.getString("issueid"));
				fault.settype(rs.getString("issuetype"));
				fault.setsummary(rs.getString("summary"));
				fault.setstate(rs.getString("state"));
				fault.setdeveloperid(rs.getString("developerid"));
				fault.setadministrator(rs.getString("administratorid"));
				fault.setassignstate(rs.getString("assignstate"));
				listsim.add(fault);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listsim;
	}
	@Override//获取一个开发者账号下的所有issue
	public List<Fault> listassignissue(String assignerid){
		List<Fault> listassign= new ArrayList<Fault>();
		try {
			Connection conn = dbConn.getConn();
			Statement stmt = conn.createStatement();
			String sql = "select * from fault where assignstate='Yes' and developerid='"+assignerid+"'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Fault fault = new Fault();
				fault.setid(rs.getString("issueid"));
				fault.settype(rs.getString("issuetype"));
				fault.setsummary(rs.getString("summary"));
				fault.setstate(rs.getString("state"));
				fault.setdeveloperid(rs.getString("developerid"));
				fault.setadministrator(rs.getString("administratorid"));
				fault.setassignstate(rs.getString("assignstate"));
				listassign.add(fault);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listassign;
	}
	@Override//获取一个管理员分配的所有issue
	public List<Fault> listassigner(String assignerid){
		List<Fault> listassign= new ArrayList<Fault>();
		try {
			Connection conn = dbConn.getConn();
			Statement stmt = conn.createStatement();
			String sql = "select * from fault where assignstate='Yes' and administratorid='"+assignerid+"'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Fault fault = new Fault();
				fault.setid(rs.getString("issueid"));
				fault.settype(rs.getString("issuetype"));
				fault.setsummary(rs.getString("summary"));
				fault.setstate(rs.getString("state"));
				fault.setdeveloperid(rs.getString("developerid"));
				fault.setadministrator(rs.getString("administratorid"));
				fault.setassignstate(rs.getString("assignstate"));
				listassign.add(fault);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listassign;
	}
	@Override
	public Fault getFault(String id) {
		// TODO Auto-generated method stub
		Fault fault= new Fault();
		try {
			Connection conn = dbConn.getConn();
			Statement stmt = conn.createStatement();
			String sql = "select * from fault where issueid='" + id+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				fault.setid(rs.getString("issueid"));
				fault.settype(rs.getString("issuetype"));
				fault.setsummary(rs.getString("summary"));
				fault.setdeatil(rs.getString("detail"));
				fault.setexpresult(rs.getString("expectedresult"));
				fault.setactresult(rs.getString("actualresult"));
				fault.setproname(rs.getString("projectname"));
				fault.setrelease(rs.getString("foundinrelease"));
				fault.setstate(rs.getString("state"));
				fault.setstatus(rs.getString("rationalstatus"));
				fault.setseverity(rs.getString("severity"));
				fault.setreproducty(rs.getString("reproducibility"));
				fault.setreporterid(rs.getInt("reporterid"));
				fault.setreportername(rs.getString("reportername"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fault;
	}
	
	@Override
	public boolean checkfault(String id){
		boolean result=false;
		try {
			Connection conn = dbConn.getConn();
			Statement stmt = conn.createStatement();
			String sql = "select issueid from fault where issueid='" + id + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				result = true;
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public void issueAssignToDeve(String issueid, String developerid, String administratorid ,String assignstate){
		try{
			Connection connection=dbConn.getConn();
			Statement statement=connection.createStatement();
			String sql="update fault set developerid='"+developerid+"',administrator='"+administratorid+"',assignstate='"+assignstate+"' where issueid='"+issueid+"'";
			statement.execute(sql);
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
