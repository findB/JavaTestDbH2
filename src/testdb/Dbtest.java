package testdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dbtest {
	
	Connection cn;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;
	
	public Dbtest() {
		try {
			Class.forName("org.h2.Driver");
			cn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			st = cn.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	
	void prepareQuery() {
		try {
			rs = st.executeQuery("select id, name from testtable");
			while(rs.next()) {
				System.out.println("ID "+ rs.getInt("ID")+" name "+ rs.getString("name"));
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
	}

}
