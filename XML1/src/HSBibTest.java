import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import turban.utils.UserMsgException;


public class HSBibTest {

	SimpleFrameworkDeAndSerializer _SFDS;

	@Test
	public void XMLtoObj() {
		try {
			HSBib hsbib = _SFDS.deserialize(HSBib.class, "Personal.xml");
			List<Person> test = new ArrayList<Person>();
			Person p1 = new Person( "002" , "Bernhard Turban", HSPersonaltyp.Profesor, "bt@hs-rm.de");
			test= hsbib.getListPerson();
			assertEquals(1,test.size());
		} catch (UserMsgException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		

	}

}
