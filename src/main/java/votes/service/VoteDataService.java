package votes.service;

import java.sql.SQLException;
import java.util.List;

import votes.domain.Candidate;
import votes.dto.*;

public interface VoteDataService {
	public List<VoteDataDTO> voteResult() throws ClassNotFoundException, SQLException;
	public List<IndiDataDTO> indiResult(Candidate candidate) throws ClassNotFoundException, SQLException;
}
