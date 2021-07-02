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
	Connection conn = ConnectionPool.getConnection();
	Statement stmt = conn.createStatement();
	String query;
	public VoteDAOImpl() throws ClassNotFoundException, SQLException {
	}
	@Override
//	public int voting(Candidate candidate, AgeInfo ageInfo) throws ClassNotFoundException, SQLException {
//		query = String.format(
//				"Insert into vote_data values(null, %s, %s, null)", candidate.getCandiIdx(), ageInfo.getAge());
	public int voting(String candidate, String ageInfo) throws ClassNotFoundException, SQLException {
		query = String.format(
				"Insert into vote_data values(null, %s, %s, null)", candidate, ageInfo);
//		"Insert into vote_data values(null, %s, %s, null)", candidate.getCandiIdx(), ageInfo.getAge());

		int succeed = stmt.executeUpdate(query);
		stmt.close();
	    conn.close();
	    return succeed;
	}

	@Override
	public List<Candidate> voteFor() throws ClassNotFoundException, SQLException {
		query = "SELECT * FROM candidates WHERE valid = 1;";
		ResultSet rset = stmt.executeQuery(query);
		List<Candidate> currentCandiList = new ArrayList<Candidate>();
		while (rset.next()) {
			Candidate tempCandi = new Candidate(rset.getInt(1), rset.getString(2));
			currentCandiList.add(tempCandi);
		}
		return currentCandiList;
	}

	@Override
	public List<AgeInfo> voterAge() throws ClassNotFoundException, SQLException {
		query = "SELECT * FROM age_info;";
		ResultSet rset = stmt.executeQuery(query);
		List<AgeInfo> ageList = new ArrayList<AgeInfo>();
		while (rset.next()) {
			AgeInfo tempAge = new AgeInfo(rset.getInt(1), rset.getString(2));
			ageList.add(tempAge);
		}
		return ageList;
	}
	@Override
	public int voting(Candidate candidate, AgeInfo ageInfo) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
