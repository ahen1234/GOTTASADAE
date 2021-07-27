package implementation.com.gottasadae.board;

import java.sql.*;

public class JDBC {
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String userId = "TH";
			String userPass = "tmakdlf1";
			
			conn = DriverManager.getConnection(jdbcUrl, userId, userPass);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
