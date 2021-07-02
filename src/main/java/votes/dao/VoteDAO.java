package votes.dao;

import java.sql.SQLException;
import java.util.List;

import votes.domain.*;

public interface VoteDAO {
	int voting(Candidate candidate, AgeInfo ageInfo) throws ClassNotFoundException, SQLException;
	List<Candidate> voteFor() throws ClassNotFoundException, SQLException;
	List<AgeInfo> voterAge() throws ClassNotFoundException, SQLException;
	int voting(String candidate, String ageInfo) throws ClassNotFoundException, SQLException;
}

