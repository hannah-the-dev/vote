package votes.dao;

import java.sql.SQLException;
import java.util.List;

import votes.domain.*;

public interface VoteDAO {
	int voting(String candiIdx, int ageGroup) throws ClassNotFoundException, SQLException;
	List<Candidates> voteFor() throws ClassNotFoundException, SQLException;
	List<AgeInfo> voterAge() throws ClassNotFoundException, SQLException;
}

