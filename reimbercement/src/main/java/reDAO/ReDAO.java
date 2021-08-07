package reDAO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.*;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import common.*;

public class ReDAO implements Constants{
//	private static final Logger logger = LogManager.getLogger(ReDAO.class.getName());

	
	public void create(Ticket ticket) {
		Session session = DBUtil.getInstance().getSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.save(ticket);
			tx.commit();
		}catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
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
		return tickets;
	}
	

	public Ticket findById(int ticketId) {
		Session session = DBUtil.getInstance().getSession();
		Query query = session.createQuery("FROM common.Ticket where ticketID = :ticketID");
		query.setInteger("ticketID", ticketId);
		
		Ticket tickets = (Ticket) query.uniqueResult();
		
		session.close();
		
		return tickets;
	}
	
	public void delete(int ticketId) {
		Session session = DBUtil.getInstance().getSession();
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(session.get(Ticket.class, ticketId));
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e; //new RuntimeExpetion (e.getCause();
		}
		session.clear();
	}
}
