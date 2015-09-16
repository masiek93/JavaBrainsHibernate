package com.topyfi.javabrains.HibernateTutorial;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.topyfi.javabrains.HibernateTutorial.dto.Address;
import com.topyfi.javabrains.HibernateTutorial.dto.UserDetails;

public class Test {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		
		Address address = new Address();
		address.setStreet("Na Uboczu");
		address.setCity("Warsaw");
		address.setState("Mazowieckie");
		address.setZipCode("33444");
		
		Address address2 = new Address();
		address2.setStreet("Żytnia");
		address2.setCity("Wrocław");
		address2.setState("Dolnyśląsk");
		address2.setZipCode("53506");
		
		user.getListOfAddresses().add(address);
		user.getListOfAddresses().add(address2);
		
		/*user.setHomeAddress(address);
		
		address.setStreet("Żytnia");
		address.setCity("Wrocław");
		address.setState("Dolnyśląsk");
		address.setZipCode("53506");*/
		
		
		user.setUserName("Marta");
//		user.setOfficeAddress(address);
		user.setJoinedDate(new Date());
		user.setDescription("Decription... anything");
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		user = null;
		
		session = sessionFactory.openSession();
		//session.beginTransaction();
		user = (UserDetails) session.get(UserDetails.class, 1);
		//System.out.println("User Name : " + user.getUserName());
		session.close();
		System.out.println("Size address list : " + user.getListOfAddresses().size());
		sessionFactory.close();
	}
}
