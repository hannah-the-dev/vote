package votes.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import votes.dao.*;
import votes.domain.Candidate;
import votes.domain.Voters;
import votes.dto.*;

public class VoteDataServiceImpl implements VoteDataService {

	public List<VoteDataDTO> voteResult() throws ClassNotFoundException, SQLException {
		VoteDataDaoImpl voteData = new VoteDataDaoImpl();
		List<VoteDataDTO> voteResult = voteData.voteResult();
		return voteResult;
	}
	public List<IndiDataDTO> indiResult(Candidate candidate) throws ClassNotFoundException, SQLException {
		VoteDataDaoImpl voteData = new VoteDataDaoImpl();
		List<IndiDataDTO> voteResult = voteData.indiResult(candidate);
		return voteResult;
	}
}
