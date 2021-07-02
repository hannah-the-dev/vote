package votes.dao;

import java.sql.SQLException;
import java.util.List;

import votes.domain.*;
import votes.dto.*;

public interface VoteDataDao {
	List<VoteDataDTO> voteResult() throws SQLException, ClassNotFoundException;
	List<IndiDataDTO> indiResult(Candidate candidate) throws SQLException, ClassNotFoundException;
}
