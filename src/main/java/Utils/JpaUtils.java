package Utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {

	public static EntityManagerFactory getFactory() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Assigment_SOF3011");
		return factory;
	}
	
	public static EntityManager getEntityManager() {
		EntityManager em = JpaUtils.getFactory().createEntityManager();
		return em;
	}
	
}
