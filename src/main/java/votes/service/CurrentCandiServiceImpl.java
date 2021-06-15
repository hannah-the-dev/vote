package votes.service;

import java.sql.SQLException;
import java.util.List;

import votes.dao.CurrentCandiDAOImpl;
import votes.domain.Candidates;

public class CurrentCandiServiceImpl implements CurrentCandiService {

	@Override
	public List<Candidates> currentCandiList() throws ClassNotFoundException, SQLException {
		CurrentCandiDAOImpl current = new CurrentCandiDAOImpl();
		List<Candidates> currentCandiList = current.currentCandiList();
		return currentCandiList;
	}

}
