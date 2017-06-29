import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.helpers.DefaultHandler;

import turban.utils.ErrorHandler;
import turban.utils.UserMsgException;


public class EmailExtractor{

	
	private List<String> _lstEmails;
	
	public static void parseXMLwithSAX(String strFileName){
		//ErrorHandler.assert(strFileName != null, (new File(strFileName)).exists() == true, true, "Error: File {0} does not exist", strFileName);
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			DefaultHandler saxEvtsHandler = new DefaultHandler();
			saxParser.parse(new File("Personal.xml"), saxEvtsHandler);
		}
		catch (Exception ex){
			
		}
	}
	
	public List<String> getList(){
		return _lstEmails;
	}
	
	public static void main (String [] args){
		parseXMLwithSAX("Personal.xml");
	}
}
