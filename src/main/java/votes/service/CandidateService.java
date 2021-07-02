package votes.service;

import java.sql.SQLException;
import java.util.List;

import votes.domain.AgeInfo;
import votes.domain.Candidate;

public interface CandidateService {
	List<Candidate> currentCandiList() throws ClassNotFoundException, SQLException;
	int register(Candidate candidate) throws ClassNotFoundException, SQLException;
	int resign(Candidate candidate) throws ClassNotFoundException, SQLException;
}
