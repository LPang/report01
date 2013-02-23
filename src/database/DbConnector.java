package database;
/*reference from the book:Tomcat and java Web , about the JDBC*/
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DbConnector {
	
	public Connection getConn() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
//		String url = "jdbc:mysql://127.0.0.1:3306/faultreport";
		Connection conn = DriverManager.getConnection("jdbc:mysql://arlia.computing.dundee.ac.uk:3306/lugepang","LugePang","ac31004");
		return conn;
	}
}
