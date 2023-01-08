package rentRoom;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import rentRoom.entity.myUser;

public class ReadUser {


	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(myUser.class)
							.buildSessionFactory();
		
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating new user object");
			myUser tempUser = new myUser("password", "Adam", "Grey", "admin",
					"832142143", "klaudek1207@wp.pl");
			
			session.beginTransaction();
			
			System.out.println("Saving user");
			System.out.println(tempUser);
			
			session.save(tempUser);
			
			session.getTransaction().commit();
			
			System.out.println("Saved user. Generated id: " + tempUser.getId());
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("\nGetting student with id: " + tempUser.getId());
			
			myUser user1 = session.get(myUser.class, tempUser.getId());
			System.out.println("Get complete: " + user1);
			
			session.getTransaction().commit();
			System.out.println("Done");
			
		}
		finally {
			factory.close();
		}
	
	}

}
