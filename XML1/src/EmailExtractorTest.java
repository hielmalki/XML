import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class EmailExtractorTest {

	@Test
	public void testParseXMLwithSAX() {
		EmailExtractor test = new EmailExtractor();
		EmailExtractor.parseXMLwithSAX("Personal.xml");
		List<String> email = new ArrayList<String>();
		String email1 = "bt@hs-rm.de";
		String email2 = "bt@hs-rm.de";
		String email3 = "bt@hs-rm.de";
		email.add(email1);
		email.add(email2);
		email.add(2, email3);
		assertEquals(true, email.contains(email1));
		assertEquals(false, email.isEmpty());
		
		
	}

}
