package com.topyfi.javabrains.HibernateTutorial;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.topyfi.javabrains.HibernateTutorial.dto.UserDetails;

public class Test {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		String minUserId = "5";
		String userName = "User 10";
		
		Criteria criteria = session.createCriteria(UserDetails.class);
		criteria.add(Restrictions.like("userName", "%User 1%"))
				.add(Restrictions.between("userId", 5, 50));
	
		List<UserDetails> users = (List<UserDetails>) criteria.list();
		session.getTransaction().commit();
		session.close();
		
		//System.out.println("Size of list result: " + users.size());
		
		for(UserDetails u : users){
			System.out.println(u.getUserName());
		}
		sessionFactory.close();
	}
}
