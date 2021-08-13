package servelets;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import common.Constants;
import common.HttpUtil;
import common.User;
import reDAO.ReDAO;
import manager.UserManager;

@SuppressWarnings("serial")
@WebServlet("/login")

public class UserServlet extends HttpServlet{

	private UserManager manager = new UserManager();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		try {
			//get JSON data
			ObjectMapper mapper = new ObjectMapper();
			User user = mapper.readValue(HttpUtil.getJSONData(req), User.class);
			//persist data to back-end
			boolean success = manager.login(user.getEmployeeid(),user.getPassword());
			//send success response
			
			resp.getWriter().print( "{\"status\":"+ (success ? "\"success\"" : "\"failure\"")+"}");
		}catch (Exception e) {
			resp.getWriter().print(HttpUtil.getErrorMessage(e.getMessage()));
			resp.setStatus(Constants.HTTP_ERROR);
		}
		
	}
}
