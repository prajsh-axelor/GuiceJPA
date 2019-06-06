package example;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class MainDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Injector injector = Guice.createInjector(new DbModule());
	    ExamplePersistedClassDao examplePersistedClassDao = injector.getInstance(ExamplePersistedClassDao.class);   

	    ExamplePersistedClass example = new ExamplePersistedClass();
	    example.setOtherField("hello world");
	    examplePersistedClassDao .saveInNewTransaction(example);

	    ExamplePersistedClass retrieved = examplePersistedClassDao.getByOtherField("hello world");

	}

}
