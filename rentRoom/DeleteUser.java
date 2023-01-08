package rentRoom;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import rentRoom.entity.Location;
import rentRoom.entity.myUser;

public class DeleteUser {
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(myUser.class)
								.addAnnotatedClass(Location.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();

			// get instructor by primary key / id
			int theId = 1;
			myUser tempUser = 
					session.get(myUser.class, theId);
			
	
			
			// delete the instructors
			if (tempUser != null) {
			
				System.out.println("Deleting: " + tempUser);
				
				// Note: will ALSO delete associated "details" object
				// because of CascadeType.ALL
				//
				session.delete(tempUser);				
			}
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}
}
