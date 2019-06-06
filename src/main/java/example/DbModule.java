package example;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

public class DbModule extends AbstractModule {

	private static final ThreadLocal<EntityManager> ENTITY_MANAGER_CACHE
    = new ThreadLocal<EntityManager>();

	
	@Override
	protected void configure() {
		// TODO Auto-generated method stub

	}
	
	
	  @Provides @Singleton
	  public EntityManagerFactory provideEntityManagerFactory() {
	    Map<String, String> properties = new HashMap<String, String>();
	    properties.put("javax.persistence.jdbc.url", "jdbc:postgresql://localhost:5432/guice");
	    properties.put("javax.persistence.jdbc.user", "axelor");
	    properties.put("javax.persistence.jdbc.password", "axelor");
	    properties.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
	    properties.put("eclipselink.logging.level", "FINE");
	    properties.put("eclipselink.ddl-generation", "create-tables");
	    properties.put("hibernate.hbm2ddl.auto", "update");
	    return Persistence.createEntityManagerFactory("Guice_JPA", properties);
	  }
	  
	  @Provides
	  public EntityManager provideEntityManager(EntityManagerFactory entityManagerFactory) {
	    EntityManager entityManager = ENTITY_MANAGER_CACHE.get();
	    if (entityManager == null) {
	      ENTITY_MANAGER_CACHE.set(entityManager = entityManagerFactory.createEntityManager());
	    }
	    return entityManager;
	  }

}
