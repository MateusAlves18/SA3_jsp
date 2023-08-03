package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionMySQL;
import model.UserAdmin;

public class UserAdminDAO {
	
	public boolean existUser(UserAdmin user) {
		Connection connection = ConnectionMySQL.init_connection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = connection.prepareStatement("SELECT * FROM useradmin WHERE user = ? AND password = ?");
			stmt.setString(1, user.getUser());
            stmt.setString(2, user.getPassword());
			rs = stmt.executeQuery();
		
			if(rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			System.out.println();
			e.printStackTrace();
			
		} finally {
			ConnectionMySQL.stopConnection(connection, stmt, rs);
		}
		return false;
	}

}
