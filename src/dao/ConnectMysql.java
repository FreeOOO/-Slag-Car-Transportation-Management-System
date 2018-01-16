package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectMysql {
	public static Connection connectMysql() throws ClassNotFoundException, SQLException{
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mypro?characterEncoding=utf8";
		String user = "root";
		String pwd = "1qaz2wsx,";
		Class.forName(driver);
		return DriverManager.getConnection(url, user, pwd);
	}
	public static void closeConn(Connection conn) throws SQLException{
		if(conn != null)
			conn.close();
	}
	public static void closeRs(ResultSet rs) throws SQLException{
		if(rs != null)
			rs.close();
	}
	public static void closeSta(Statement ps) throws SQLException{
		if(ps != null)
			ps.close();
	}
}
