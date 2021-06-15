package votes.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import votes.dao.RegisterDAOImpl;

public class RegisterServiceImpl implements RegisterService {
	@Override
	public int register(HttpServletRequest request) 
			throws ClassNotFoundException, SQLException {
		
		String candiIdx = request.getParameter("idx");
		String candiName = request.getParameter("name");
		RegisterDAOImpl registerDAO = new RegisterDAOImpl();
		int updateCount = registerDAO.register(candiIdx, candiName);
		return updateCount;
	}
	
	
}
