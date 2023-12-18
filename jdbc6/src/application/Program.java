package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class Program {
	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		try {
			conn = DB.getConnection();
			
			conn.setAutoCommit(false);
			
			
			
			st = conn.createStatement();
			
			int rows1 = st.executeUpdate("UPDATE seller SET BaseSAlary = 2090 WHERE DepartmentId = 1");
			
			int x=1;
			if(x<2) {
				throw new SQLException("fake error");
			}
			
			int rows2 = st.executeUpdate("UPDATE seller SET BaseSAlary = 3090 WHERE DepartmentId = 2");

			
			conn.commit();
			
		System.out.println("rows1 "+rows1);
		System.out.println("rows2 "+rows2);

			
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
						throw new DbException("transation rolled back"+e.getMessage());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				throw new DbException("deu merda");
			}
			
		}
		finally{
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}