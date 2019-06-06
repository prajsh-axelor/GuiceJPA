package GuiceJPA;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class PersonMain {
	public static void main(String [] args) {
		
		Injector injector = Guice.createInjector(new PersonModule());
		PersonDao pDao = injector.getInstance(PersonDao.class);
		
		Person person = new Person("Prajjwal");
		pDao.saveInNewTransaction(person);		
		
		
	}

}
