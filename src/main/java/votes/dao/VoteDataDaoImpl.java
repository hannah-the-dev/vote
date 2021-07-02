package votes.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import votes.domain.Candidate;
import votes.domain.Voters;
import votes.dto.*;

public class VoteDataDaoImpl implements VoteDataDao {
	Connection conn = ConnectionPool.getConnection();
	Statement stmt = conn.createStatement();
	String query;
	public VoteDataDaoImpl() throws ClassNotFoundException, SQLException {
	}

	public List<VoteDataDTO> voteResult() throws SQLException, ClassNotFoundException {
		List<VoteDataDTO> voteResult = new ArrayList<VoteDataDTO>();
		query = "select " + "c.candi_idx, " // 후보자 기호 및 이름
				+ "c.candi_name, " + "count(d.candi_idx), " // 득표수
				+ "count(d.candi_idx)/(select count(d.candi_idx) from vote_data d, candidates c "
				+ "where c.valid=1 and c.candi_idx=d.candi_idx) " // 득표율
				+ "from vote_data d " // 투표데이터에서
				+ "right outer join candidates c " // 후보자데이터를 아우터 조인 조건으로
				+ "on d.candi_idx = c.candi_idx " + "where c.valid=1 " // 사퇴하지 않은 후보자들 중에서
				+ "group by c.candi_idx;"; // 후보자 기호로 조회

		ResultSet rset = stmt.executeQuery(query);
		while (rset.next()) {
			VoteDataDTO temp = new VoteDataDTO(rset.getInt(1), rset.getString(2));
			temp.setVoteCount(rset.getInt(3));
			temp.setVoteRate(rset.getDouble(4));
			temp.setCandidate(new Candidate(rset.getInt(1), rset.getString(2)));
			voteResult.add(temp);
		}
		rset.close();
		stmt.close();
		conn.close();
		return voteResult;
	}

	public List<IndiDataDTO> indiResult(Candidate candidate) throws SQLException, ClassNotFoundException {
		List<IndiDataDTO> voteResult = new ArrayList<IndiDataDTO>();
		query = String.format(
			      "select "
			                        //후보자 기호 및 이름
			      +   "a.age, "
			      +   "(select count(age) from vote_data where vote_data.age = a.age and vote_data.candi_idx=%s), " //득표수
			      +   "(select count(age) from vote_data where vote_data.age = a.age and vote_data.candi_idx=%s)"
			      + "/(select count(age) from vote_data where vote_data.candi_idx=%s) as rate " //득표율
			      + "from vote_data d "                     //투표데이터에서
			      + "right outer join age_info a "        //후보자데이터를 아우터 조인 조건으로
			      + "on d.candi_idx=%s "         
			  
			      + "group by a.age;"                //후보자 기호로 조회
			      , candidate.getCandiIdx(), candidate.getCandiIdx(), candidate.getCandiIdx(), candidate.getCandiIdx());
		  
		ResultSet rset = stmt.executeQuery(query);
		while (rset.next()) {
			IndiDataDTO temp = new IndiDataDTO(rset.getInt(1), rset.getInt(2), rset.getDouble(3));
			voteResult.add(temp);
		}
		rset.close();
		stmt.close();
		conn.close();
		return voteResult;
	}
}
