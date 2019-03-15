package ca.sheridancollege.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ca.sheridancollege.beans.Feedback;

public class DAO {

	SessionFactory sessionFactory = new Configuration().configure("ca/sheridancollege/config/hibernate.cfg.xml")
			.buildSessionFactory();

	public void populateFeedback() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		LocalDate date1 = LocalDate.parse("2018-04-14");
		Feedback tech1 = new Feedback(date1,"Technical Support","My Computer was fixed perfectly I really appreciate the help ");
		
		LocalDate date2 = LocalDate.parse("2018-04-17");
		Feedback tech2 = new Feedback(date2,"Technical Support","Everthing Ran Smoothley, it was a great experience ");
		
		LocalDate date3 = LocalDate.parse("2016-02-14");
		Feedback tech3 = new Feedback(date3,"Technical Support","I still need help fixing my laptop, I called 3 times with no aswer ");

		
		session.save(tech1);
		session.save(tech2);
		session.save(tech3);
		
		session.getTransaction().commit();
		session.close();
	}
	
	public void insertFeedback(Feedback feed){
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(feed);
		
		session.getTransaction().commit();
		session.close();
		
		
	}
	
	public List<Feedback> queryFeedbackbydate(LocalDate date ){
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.getNamedQuery("Feedback.byDate");
		query.setParameter("date", date);
		
		@SuppressWarnings("unchecked")
		List<Feedback> FeedbackList = query.getResultList();
		
		session.getTransaction().commit();
		session.close();
		

		return FeedbackList;
	}
	
}
