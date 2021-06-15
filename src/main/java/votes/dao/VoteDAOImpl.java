package votes.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import votes.domain.*;

public class VoteDAOImpl implements VoteDAO {
	
	@Override
	public int voting(String candiIdx, int ageGroup) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");  // com.mysql.cj.jdbc.Driver 클래스 사용
		Connection conn = DriverManager.getConnection  // 드라이버매니저로 연결
				("jdbc:mysql://192.168.23.17:3306/kopoctc", "root", "kopoctc");
//					          address		port	DB		user	pw
		Statement stmt = conn.createStatement(); // 연결된 객체에 쿼리 작업 실행을 하기 위한 객체
		String query = String.format(
				"Insert into vote_data values(null, %s, %s, null)", candiIdx, ageGroup);

		stmt.execute(query);
		int updateCount = stmt.getUpdateCount();
		stmt.close();
		conn.close();

		return updateCount;
	}

	@Override
	public List<Candidates> voteFor() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection conn = DriverManager.getConnection 
				("jdbc:mysql://192.168.23.17:3306/kopoctc", "root", "kopoctc");
		Statement stmt = conn.createStatement(); 
		String query = "SELECT * FROM candidates WHERE valid = 1;";
		ResultSet rset = stmt.executeQuery(query);
		List<Candidates> currentCandiList = new ArrayList<Candidates>();
		while (rset.next()) {
			Candidates tempCandi = new Candidates(rset.getInt(1), rset.getString(2));
			currentCandiList.add(tempCandi);
		}
		return currentCandiList;
	}

	@Override
	public List<AgeInfo> voterAge() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection conn = DriverManager.getConnection 
				("jdbc:mysql://192.168.23.17:3306/kopoctc", "root", "kopoctc");
		Statement stmt = conn.createStatement(); 
		String query = "SELECT * FROM age_info;";
		ResultSet rset = stmt.executeQuery(query);
		List<AgeInfo> ageList = new ArrayList<AgeInfo>();
		while (rset.next()) {
			AgeInfo tempAge = new AgeInfo(rset.getInt(1), rset.getString(2));
			ageList.add(tempAge);
		}
		return ageList;
	}

}
