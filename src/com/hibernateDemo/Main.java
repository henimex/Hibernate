package com.hibernateDemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		System.out.println("hibernate test");
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(City.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			
			//CRUD Operation
			SelectOperation(session);
			InsertOperation(session);
			UpdateOperation(session);
			DeleteOperation(session);
			
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}
	
	public static void SelectOperation(Session session) {
		String queryOne = "FROM City c WHERE c.countryCode='TUR' AND c.district='Istanbul'";
		String queryTwo = "FROM City c WHERE c.name LIKE '%kar%'";

		List<City> cities = session.createQuery(queryTwo).getResultList();
		for (City city : cities) {
			System.out.println(city.getName());
		}
	}
	
	public static void InsertOperation(Session session) {
		City city = new City();
		city.setName("Sivrihisar1");
		city.setCountryCode("TUR");
		city.setDistrict("Anadolu");
		city.setPopulation(1000);
		
		session.save(city);
		System.out.println("City Added");
	}
	
	public static void UpdateOperation(Session session) {
		City takeCity = session.get(City.class, 4086);
		System.out.println(takeCity.getName());
		
		takeCity.setName("Sivrihisar2");
		takeCity.setCountryCode("TUR");
		takeCity.setDistrict("Anadolu");
		takeCity.setPopulation(20000);
		
		session.save(takeCity);
		System.out.println("City Updated as " + takeCity.getName());
	}
	
	public static void DeleteOperation(Session session) {
		City deleteCity = session.get(City.class, 4086);
		session.delete(deleteCity);
	}

}
