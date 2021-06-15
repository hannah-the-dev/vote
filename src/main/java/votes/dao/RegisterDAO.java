package votes.dao;

import java.sql.SQLException;
import java.util.List;

import votes.domain.Candidates;

public interface RegisterDAO {
	int register(String candiIdx, String candiName) 
			throws ClassNotFoundException, SQLException;
}
