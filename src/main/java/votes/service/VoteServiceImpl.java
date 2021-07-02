package votes.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import votes.dao.*;
import votes.domain.*;

public class VoteServiceImpl implements VoteService {
	VoteDAOImpl voteDao = new VoteDAOImpl();
	public VoteServiceImpl() throws ClassNotFoundException, SQLException {
	}
	@Override
	public int voting(String candidate, String ageInfo) throws ClassNotFoundException, SQLException {
		return voteDao.voting(candidate, ageInfo);
	}

	@Override
	public List<Candidate> voteFor() throws ClassNotFoundException, SQLException {
		VoteDAOImpl candiDao = new VoteDAOImpl();
		List<Candidate> candiList = candiDao.voteFor();
		return candiList;
	}

	@Override
	public List<AgeInfo> voterAge() throws ClassNotFoundException, SQLException {
		List<AgeInfo> ageList = voteDao.voterAge();
		return ageList;
	}
	
}
