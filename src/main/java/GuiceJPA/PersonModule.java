package GuiceJPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class PersonModule extends AbstractModule{

	@Override
	protected void configure() {
		// TODO Auto-generated method stub
		
	}
	
	@Provides
	public EntityManagerFactory provideEntityManagerFactory() {
		return Persistence.createEntityManagerFactory("Guice_JPA");
	}
	
	@Provides
	public EntityManager provideEntityManager(EntityManagerFactory entityManagerFactory) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
	    
	    return entityManager;
	}

}
