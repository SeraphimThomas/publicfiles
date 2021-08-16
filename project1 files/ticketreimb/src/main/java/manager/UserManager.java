package manager;

import common.User;
import reDAO.ReDAO;

public class UserManager {
	ReDAO dao = new ReDAO();
	User user = new User();
	
	public UserManager() {}
	
//	public createUser() {
//		user = 
//	}
	
	public boolean login (int employeeId, String password) {
		if(dao.getUser(employeeId, password) != null) {
			return true;
		}
		return false;
	}
}
