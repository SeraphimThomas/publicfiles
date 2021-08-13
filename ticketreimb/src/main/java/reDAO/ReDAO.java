package reDAO;


import java.util.List;
import org.hibernate.Session;
import org.hibernate.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import common.*;

public class ReDAO implements Constants{
private static final Logger logger = LogManager.getLogger(ReDAO.class.getName());

	
	public void create(Ticket ticket) {
		Session session = DBUtil.getInstance().getSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.save(ticket);
//			session.setInt(1, ticket.getEmployeeID())
			tx.commit();
			logger.info("Ticket Created with " + ticket.getEmployeeID());
		}catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
				logger.warn("Error in database");
			}
			throw e;
		}
		session.close();
	}
	@SuppressWarnings("unchecked")
	public List<Ticket> getAll(){
		Session session = DBUtil.getInstance().getSession();
		Query query = session.createQuery("FROM common.Ticket");
		List<Ticket> tickets = query.list();
		session.close();
		logger.info("Ticket pulled from the database");
		return tickets;
	}
	

	public Ticket findById(int empId) {
		Session session = DBUtil.getInstance().getSession();
		Query query = session.createQuery("FROM common.Ticket where employeeid = :employeeid");
		query.setInteger("employeeid", empId);
		
		Ticket tickets = (Ticket) query.uniqueResult();
		
		session.close();
		
		logger.info("Returning tickets for user ID " + empId);
		return tickets;
	}
	
	public void delete(int ticketId) {
		Session session = DBUtil.getInstance().getSession();
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(session.get(Ticket.class, ticketId));
			logger.info("Ticket deleted.  Ticket number: "+ ticketId);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			logger.warn("Error in deleting ticket "+ ticketId);
			throw e; //new RuntimeExpetion (e.getCause();
		}
		session.clear();
	}
//	public void createUser(User user) {
//		Session session = DBUtil.getInstance().getSession();
//		
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			session.save(user);
//			tx.commit();
//		}catch (HibernateException e) {
//			if(tx != null) {
//				tx.rollback();
//			}
//			throw e;
//		}
//		session.close();
//	}
	
	public User getUser(int employeeId, String password) {
		Session session = DBUtil.getInstance().getSession();
		
		Query query = session.createQuery("FROM common.User where employeeId = :empId and password = :pass");
		query.setInteger("empId", employeeId);
		query.setString("pass", password);
		
		User user = (User) query.uniqueResult();
		
		session.close();
		
		return user;
	}
}
