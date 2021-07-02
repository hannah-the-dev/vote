package votes.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public interface RegisterService {
	int register(HttpServletRequest request) 
			throws ClassNotFoundException, SQLException;
}
