package servelets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import common.Ticket;
import reDAO.ReDAO;

@SuppressWarnings("serial")
@WebServlet("/home")

public class IntroServlet extends HttpServlet{
	ReDAO data = new ReDAO();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		resp.setContentType("application/json");
		
		
		
		ObjectMapper mapper = new ObjectMapper();
		//String jsonInString = mapper.writeValueAsString(new Greeting("Hello API"));
		
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

		String jsonstr = jsonStrBuffer.toString();
		ObjectMapper mapper = new ObjectMapper();
		Ticket ticket = mapper.readValue(jsonstr, Ticket.class);
//		int employeeID = Integer.parseInt(request.getParameter("employeeID"));
//		String reason = request.getParameter("reason");
//		double ticketVal = Double.parseDouble(request.getParameter("ticketamount"));
//		String comment = request.getParameter("comment");
//		int ticketNum = Integer.parseInt(request.getParameter("ticketnumber"));
		
//		Ticket ticket = new Ticket (employeeID, reason, /*ticketNum,*/ ticketVal, comment);
		
		data.create(ticket);
		
		doGet(request,response);
		
	}
	
}

class Greeting{
	private String message;
	
	public Greeting() {
		super();
	}
	public Greeting(String message) {
		super();
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
