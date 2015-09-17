package com.topyfi.javabrains.HibernateTutorial;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.topyfi.javabrains.HibernateTutorial.dto.UserDetails;

public class Test {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("select userName from UserDetails");
		query.setFirstResult(5);
		query.setMaxResults(4);
		
		List<String> users = (List<String>) query.list();
		session.getTransaction().commit();
		session.close();
		
		//System.out.println("Size of list result: " + users.size());
		
		for(String u : users){
			System.out.println(u);
		}
		sessionFactory.close();
	}
}
