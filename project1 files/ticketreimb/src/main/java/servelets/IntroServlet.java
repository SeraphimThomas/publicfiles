package servelets;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import common.Ticket;
import common.User;
import reDAO.ReDAO;

@SuppressWarnings("serial")
@WebServlet("/home")

public class IntroServlet extends HttpServlet{
	private static final Logger logger = LogManager.getLogger(ReDAO.class.getName());
	ReDAO data = new ReDAO();
	User user = new User();
	UserServlet userve = new UserServlet();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		resp.setContentType("application/json");
		
		logger.info("Performing get request");
		
		ObjectMapper mapper = new ObjectMapper();

		String jsonInString = mapper.writeValueAsString(data.getAll());
		
		resp.getWriter().print(jsonInString);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		StringBuffer jsonStrBuffer = new StringBuffer();
		String line = null;

		BufferedReader reader = request.getReader();
		while ((line = reader.readLine()) != null)
			jsonStrBuffer.append(line);
		
		//get Tickets based on whether the user is a manager or a base employee

		String jsonstr = jsonStrBuffer.toString();
		ObjectMapper mapper = new ObjectMapper();
		Ticket ticket = mapper.readValue(jsonstr, Ticket.class);
		data.create(ticket);
		logger.info("Posting request sent");
		
		doGet(request,response);
		
	}
	
}

