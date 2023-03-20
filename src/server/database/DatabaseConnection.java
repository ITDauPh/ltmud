package server.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
	private Connection con = null;

	public DatabaseConnection() {
		if (con == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				this.con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ltmud", "root", "");

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
			}
		}
	}

	public boolean dangNhap(String username, String password) {
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"select * from account where username='" + username + "' and password='" + password + "'");
			if (rs.getFetchSize() != 0)
				return false;
//			while(rs.next()) {
//				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
//			}
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public void close() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
