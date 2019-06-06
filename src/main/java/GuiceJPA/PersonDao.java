package GuiceJPA;

import javax.persistence.EntityManager;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

public class PersonDao {
	
	protected EntityManager em;
	
	@Inject
	public PersonDao(EntityManager em) {
		this.em = em;
	}
	
	public void saveInNewTransaction(Person person) {
		em.getTransaction().begin();
		save(person);
		em.getTransaction().commit();
	}
	
	@Transactional
	public void save(Person person) {
		em.persist(person);
	}

	
}
