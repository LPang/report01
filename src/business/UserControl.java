package business;

import business.UserManager;
import domain.User;
import database.DbConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserControl implements UserManager {
	private DbConnector dbConn= new DbConnector();
	@Override
	public void add(String id, String name, String password, String type, String email, String authority) {
		try {
			Connection conn = dbConn.getConn();
			Statement stmt = conn.createStatement();
			String sql = "insert into user(id,userName,password,type,email,authority) values('"+id+"','" + name + "','" + password + "','" + type + "','" + email + "','" + authority + "')";
			stmt.executeUpdate(sql);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see onest.dev.business.UserManager#delete(java.lang.String)
	 */
	@Override
	public void delete(String id) {
		try {
			Connection conn = dbConn.getConn();
			Statement stmt = conn.createStatement();
			String sql = "delete from user where id='"+id+"'";
			stmt.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see onest.dev.business.UserManager#edit(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void edit(String id, String name, String password, String email, String type, String authority) {
		try {
			Connection conn = dbConn.getConn();
			Statement stmt = conn.createStatement();
			String sql = "update user set userName='" + name + "',password='" + password + "',type='" + type + "',email='"+email+"',authority='" + authority + "' where id='"+id+"'";
			stmt.executeUpdate(sql);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see onest.dev.business.UserManager#list()
	 */
	@Override
	public List<User> list() {
		List<User> list = new ArrayList<User>();
		try {
			Connection conn = dbConn.getConn();
			Statement stmt = conn.createStatement();
			String sql = "select * from user";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.settype(rs.getString("type"));
				user.setemail(rs.getString("email"));
				user.setAuthority(rs.getString("authority"));
				list.add(user);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see onest.dev.business.UserManager#list()
	 */
	@Override
	public List<User> listone(String id) {
		List<User> listone = new ArrayList<User>();
		try {
			Connection conn = dbConn.getConn();
			Statement stmt = conn.createStatement();
			String sql = "select * from user where id='"+id+"'";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.settype(rs.getString("type"));
				user.setemail(rs.getString("email"));
				user.setAuthority(rs.getString("authority"));
				listone.add(user);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listone;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see onest.dev.business.UserManager#list()
	 */
	@Override
	public List<User> listtype(String type) {
		List<User> list = new ArrayList<User>();
		try {
			Connection conn = dbConn.getConn();
			Statement stmt = conn.createStatement();
			String sql = "select * from user where type='"+type+"'";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.settype(rs.getString("type"));
				user.setemail(rs.getString("email"));
				user.setAuthority(rs.getString("authority"));
				list.add(user);
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
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see onest.dev.business.UserManager#login(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean login(String id, String password, String type) {
		boolean result = false;

		try {
			Connection conn = dbConn.getConn();
			System.out.println("Database connect success");
			Statement stmt = conn.createStatement();
			String sql = "select id from user where id='" + id + "' and password='" + password + "' and type='" + type + "'";
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
	public boolean checkuser(String id){
		boolean result=false;
		try {
			Connection conn = dbConn.getConn();
			Statement stmt = conn.createStatement();
			String sql = "select id from user where id='" + id + "'";
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
	public User getUser(String id) {
		User user = new User();
		try {
			Connection conn = dbConn.getConn();
			Statement stmt = conn.createStatement();
			String sql = "select * from user where id='"+id+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.settype(rs.getString("type"));
				user.setemail(rs.getString("email"));
				user.setAuthority(rs.getString("authority"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
