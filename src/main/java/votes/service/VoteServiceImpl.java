package votes.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import votes.dao.*;
import votes.domain.*;

public class VoteServiceImpl implements VoteService {
	VoteDAOImpl voteDao = new VoteDAOImpl();
	@Override
	public int voting(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String candiIdx = request.getParameter("idx");
		int ageGroup = Integer.parseInt(request.getParameter("age"));
		int updateCount = voteDao.voting(candiIdx, ageGroup);
		return updateCount;
	}

	@Override
	public List<Candidates> voteFor() throws ClassNotFoundException, SQLException {
		VoteDAOImpl candiDao = new VoteDAOImpl();
		List<Candidates> candiList = candiDao.voteFor();
		return candiList;
	}

	@Override
	public List<AgeInfo> voterAge() throws ClassNotFoundException, SQLException {
		List<AgeInfo> ageList = voteDao.voterAge();
		return ageList;
	}
	
}
