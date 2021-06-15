package votes.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisterDAOImpl implements RegisterDAO {

	@Override
	public int register(String candiIdx, String candiName) 
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection conn = DriverManager.getConnection  
				("jdbc:mysql://192.168.23.17:3306/kopoctc", "root", "kopoctc");
//					          address		port	DB		user	pw
		
		Statement stmt = conn.createStatement(); 
		String query = String.format(
				"Insert into candidates values( %s, '%s', true)", candiIdx, candiName);
		stmt.execute(query);
		int updateCount = stmt.getUpdateCount();
		stmt.close();
	    conn.close();
	    return updateCount;
	}

}
