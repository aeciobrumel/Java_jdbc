package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	private static ResultSet rs;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement st = null;
		rs = null;
		try {
			conn = 	DB.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select * from department");
			
			while(rs.next()) {
				System.out.println(rs.getInt("Id")+", "+rs.getString("Name"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace(); 
			
		}

			finally {
				DB.closeStatement(st);
				DB.closeConnection();
				DB.closeResultSet(rs);
			}
		
	}

}
