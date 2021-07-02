package votes.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import votes.domain.*;

public interface VoteService {
	public int voting(String candidate, String ageInfo) throws ClassNotFoundException, SQLException;
	public List<Candidate> voteFor() throws ClassNotFoundException, SQLException;
	public List<AgeInfo> voterAge() throws ClassNotFoundException, SQLException;
}