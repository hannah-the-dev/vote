package votes.service;

import java.sql.SQLException;
import java.util.List;

import votes.dao.CandidateDaoImpl;
import votes.domain.Candidate;

public class CandidateServiceImpl implements CandidateService {

	@Override
	public List<Candidate> currentCandiList() throws ClassNotFoundException, SQLException {
		return new CandidateDaoImpl().currentCandiList();
	}

	@Override
	public int register(Candidate candidate) throws ClassNotFoundException, SQLException {
		return new CandidateDaoImpl().register(candidate);
	}

	@Override
	public int resign(Candidate candidate) throws ClassNotFoundException, SQLException {
		return new CandidateDaoImpl().resign(candidate);
	}

}
