package votes.service;

import java.sql.SQLException;
import java.util.List;

import votes.domain.Candidates;

public interface CurrentCandiService {
	List<Candidates> currentCandiList () throws ClassNotFoundException, SQLException;
}
