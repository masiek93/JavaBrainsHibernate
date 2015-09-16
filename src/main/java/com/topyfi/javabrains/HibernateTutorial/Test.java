package com.topyfi.javabrains.HibernateTutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.topyfi.javabrains.HibernateTutorial.dto.FourWheeler;
import com.topyfi.javabrains.HibernateTutorial.dto.TwoWheeler;
import com.topyfi.javabrains.HibernateTutorial.dto.UserDetails;
import com.topyfi.javabrains.HibernateTutorial.dto.Vehicle;

public class Test {

	public static void main(String[] args) {
		//UserDetails user = new UserDetails();
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Audi");
		
		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("Kawasaki");
		bike.setSteeringHandle("NotWheel");
		
		FourWheeler car = new FourWheeler();
		car.setVehicleName("Mercedes");
		car.setSteeringWheel("Wheel");

		//user.setUserName("Marta");
		//vehicle2.setVehicleName("BMW");

		//user.getVehicle().add(vehicle);
		//user.getVehicle().add(vehicle2);

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		//session.persist(user);
		session.save(vehicle);
		session.save(bike);
		session.save(car);
		session.getTransaction().commit();

		session.close();
		sessionFactory.close();
	}
}
