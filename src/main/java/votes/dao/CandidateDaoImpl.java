package votes.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import votes.domain.Candidate;

public class CandidateDaoImpl implements CandidateDao {
	Connection conn = ConnectionPool.getConnection();
	Statement stmt = conn.createStatement();
	String query;
	public CandidateDaoImpl() throws ClassNotFoundException, SQLException {
	}

	@Override
	public List<Candidate> currentCandiList() throws ClassNotFoundException, SQLException {
		query = "SELECT * FROM candidates;";
		ResultSet rset = stmt.executeQuery(query);
		List<Candidate> currentCandiList = new ArrayList<Candidate>();
		while (rset.next()) {
			Candidate thisCandi = 
					new Candidate(rset.getInt(1), rset.getString(2), rset.getBoolean(3));
			currentCandiList.add(thisCandi);
		}
		rset.close();
		stmt.close();
		conn.close();
		return currentCandiList;
	}

	@Override
	public int register(Candidate candidate) throws ClassNotFoundException, SQLException {
		query = String.format(
				"Insert into candidates values( %s, '%s', true)", 
				candidate.getCandiIdx(), candidate.getCandiName());
		int succeed = stmt.executeUpdate(query);
		stmt.close();
	    conn.close();
	    return succeed;
	}

	@Override
	public int resign(Candidate candidate) throws ClassNotFoundException, SQLException {
		query = String.format(
				"update candidates set valid=0 where candi_idx='%s';", 
				candidate.getCandiIdx());
		int succeed = stmt.executeUpdate(query);
        stmt.close();
	    conn.close();
		return succeed;
	}
}
