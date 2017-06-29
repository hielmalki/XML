
import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

@Root(strict = false)
public class HSBib extends DefaultHandler{
	
	
	@ElementList(name = "Personal", entry = "Person", inline = false, required = true, empty = false)
	List<Person> _lstPersonal = new ArrayList<Person>();
	
	@ElementList(name = "Books", entry = "Book", inline = false, required = true, empty = false)
	private List<Book> _lstBooks = new ArrayList<Book>();
	
	private boolean _blnPersonal = false;
	private boolean _blnPerson = false;
	
	
	@Attribute(name = "Email")
	String _strEmail = "";
	
	
	public void startElement(String uri, String localName, 
			String qName, Attributes atts) throws SAXException{
		if(qName.equals("Personal") == true){
			_blnPersonal = true;
		}
		if(qName.equals("Person") == true){
				if(_blnPersonal == false){
					//throw new SAXParseException("Element {Personal} not entered");
				}
				if(_blnPerson == true){
					//throw new SAXParseException("Element {Personal} already enterd", null);
					_blnPerson = true;
				}
				_strEmail = atts.getValue("Email").trim();
		}
		
		
	}
	public void endElement(String uri, String localName, 
			String qName, Attributes atts) throws SAXException{
		if(qName.equals("Personal") == true){
				if(_blnPerson == true)
					_blnPersonal = false;
		}
//		if(qName.equals("Person") == true){
//			_blnPerson = true;
//			_lstPersonal.add(_strEmail); // da sollte die DatenTyp von der Liste String sein!
//		}
	}
	
	
	
	public void addPerson(String strId,String strName,HSPersonaltyp personelltype, String strEmail)
	{
		Person person = new Person(strId,strName,personelltype,strEmail);
		_lstPersonal.add(person);
	}
	public List<Person> getListPerson()
	  {
		  return _lstPersonal;
	  }
	public void addBooks(String b, String c, String d, String e)
	{
		Book buch= new Book(b,c,d,e);
		_lstBooks.add(buch);
	}
	public List<Book> getListBook()
	  {
		  return _lstBooks;
	  }
}
