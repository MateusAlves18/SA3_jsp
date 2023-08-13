package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionMySQL;
import model.UserClient;

public class UserClientDAO {

	public String existUser(UserClient user) {
		Connection connection = ConnectionMySQL.init_connection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = connection.prepareStatement("SELECT name FROM userclient WHERE email = ? AND password = ?");
			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getPassword());
			rs = stmt.executeQuery();

			if (rs.next()) {
				return rs.getString("name");
			}

		} catch (SQLException e) {
			System.out.println();
			e.printStackTrace();

		} finally {
			ConnectionMySQL.stopConnection(connection, stmt, rs);
		}
		return "";
	}
	public boolean registerUser(UserClient user) {
		
		Connection connection = ConnectionMySQL.init_connection();
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement("INSERT INTO `senai`.`userclient` (`email`, `isCNPJ`, `password`, `name`, `endereco`, `matricula`) VALUES (?, ?, ?, ?, ?, ?)");
			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getIsCNPJ());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, user.getName());
			stmt.setString(5, user.getEndereco());
			stmt.setString(6, user.getMatricula());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println();
			e.printStackTrace();

		} finally {
			ConnectionMySQL.stopConnection(connection, stmt);
		}
		return false;
	}
}
