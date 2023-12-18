package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement(
					"DELETE FROM seller "
					+"WHERE "
					+"Id = ?");
					st.setInt(1, 12);
			
			int rowsAffected= st.executeUpdate();
			
			System.out.println("done!!!Rows afeected: "+rowsAffected);
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			
		}
		finally{
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
