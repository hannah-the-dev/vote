package votes.dao;

import java.sql.SQLException;
import java.util.List;

import votes.domain.Candidate;

public interface CandidateDao {
	List<Candidate> currentCandiList () throws ClassNotFoundException, SQLException;
	int register(Candidate candidate) throws ClassNotFoundException, SQLException;
	int resign(Candidate candidate) throws ClassNotFoundException, SQLException;
}
