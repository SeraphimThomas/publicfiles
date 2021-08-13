package manager;

import common.User;
import reDAO.ReDAO;

public class UserManager {
	ReDAO dao = new ReDAO();
	
	public UserManager() {}
	
//	public void create(User user) {
//		dao.createUser(user);
//	}
	
	public boolean login (int employeeId, String password) {
		if(dao.getUser(employeeId, password) != null) {
			return true;
		}
		return false;
	}
}
