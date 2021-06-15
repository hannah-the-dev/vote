package votes.dao;

import java.sql.SQLException;
import java.util.List;

import votes.domain.Candidates;

public interface CurrentCandiDAO {
	List<Candidates> currentCandiList () throws ClassNotFoundException, SQLException;
}
