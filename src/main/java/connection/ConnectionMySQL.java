package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConnectionMySQL {


	private static String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:3306/senai"; // insert your database
	private static String USER = "root"; // insert your user
	private static String PASS = "2408"; // insert your password

	public static Connection init_connection() {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException("Error in connection" + e);
		}
	}

	public static void stopConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException error) {
				error.printStackTrace();
			}
		}
	}

	public static void stopConnection(Connection connection, PreparedStatement stmt) {
		try {
			stopConnection(connection);
			stmt.close();
		} catch (SQLException erro) {
			erro.printStackTrace();
		}
	}

	public static void stopConnection(Connection connection, PreparedStatement stmt, ResultSet rs) {
		stopConnection(connection, stmt);
		try {
			rs.close();
		} catch (SQLException erro) {
			erro.printStackTrace();

		}
	}
}


