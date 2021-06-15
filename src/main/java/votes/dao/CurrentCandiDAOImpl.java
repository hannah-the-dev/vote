package votes.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import votes.domain.Candidates;

public class CurrentCandiDAOImpl implements CurrentCandiDAO {

	@Override
	public List<Candidates> currentCandiList() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver"); // com.mysql.cj.jdbc.Driver 클래스 사용
		Connection conn = DriverManager.getConnection // 드라이버매니저로 연결
		("jdbc:mysql://192.168.23.17:3306/kopoctc", "root", "kopoctc");
//					          address		port	DB		user	pw

		Statement stmt = conn.createStatement();
		String query = "SELECT * FROM candidates;";
		ResultSet rset = stmt.executeQuery(query);
		List<Candidates> currentCandiList = new ArrayList<Candidates>();
		while (rset.next()) {
			Candidates thisCandi = new Candidates(rset.getInt(1), rset.getString(2), rset.getBoolean(3));
			currentCandiList.add(thisCandi);
		}
		rset.close();
		stmt.close();
		conn.close();
		return currentCandiList;
	}

}
