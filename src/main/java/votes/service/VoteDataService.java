package votes.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import votes.dao.*;
import votes.dto.*;


public class VoteDataService {
	public List<VoteDataDTO> voteResult() throws ClassNotFoundException, SQLException {
		VoteDataDAO voteData = new VoteDataDAO();
		List<VoteDataDTO> voteResult = voteData.voteResult();
		return voteResult;
	}
	public List<IndiDataDTO> indiResult(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		VoteDataDAO voteData = new VoteDataDAO();
		int candiIdx = Integer.parseInt(request.getParameter("idx"));
		String candiName = request.getParameter("name");
		List<IndiDataDTO> voteResult = voteData.indiResult(candiIdx, candiName);
		return voteResult;
	}
	

}
