import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Text;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;


public class Books {
	private boolean _blnBooks;
	private boolean _blnBook;
	private boolean _blnHSBib;
	
	
	
	@Attribute(name = "ID")
	private String _strId;
	@Attribute(name = "Author")
	private String _strAuthor;
	@Attribute(name = "LentBy")
	private String _strLentBy;
	@Attribute(name = "ReturnDate")
	private String _strReturnDate;
	@Text
	private String _strName ;
	
	public Books(){
		
	}
	
	public Books(String strId, String strAuthor, String strLentBy, String strReturnDate, String strName){
		this._strId = strId;
		this._strAuthor = strAuthor;
		this._strLentBy = strLentBy;
		this._strReturnDate = strReturnDate;
		this._strName = strName;
	}
	
	public void startElement(String uri, String localName, 
			String qName, Attributes atts) throws SAXException{
		if(qName.equals("HSBIb") == true){
			_blnHSBib = true;
		}
		if(qName.equals("Books") == true){
				if(_blnHSBib == false){
					//throw new SAXParseException("Element {Personal} not entered");
				}
				if(_blnBooks == true){
					//throw new SAXParseException("Element {Personal} already enterd", null);
					_blnBooks = true;
				}
		}
		
		if(qName.equals("Book") == true){
			if(_blnHSBib == false){
				//throw new SAXParseException("Element {Personal} not entered");
			}
			if(_blnBooks == false){
				//throw new SAXParseException("Element {Personal} not entered");
			}
			if(_blnBook == true){
				//throw new SAXParseException("Element {Personal} already enterd", null);
				_blnBook = true;
				_strId = atts.getValue("ID").trim();
				_strAuthor = atts.getValue("Author");
				_strLentBy = atts.getValue("LentBy");
				_strReturnDate = atts.getValue("ReturnDate");
			}
		}
		
		
		
	}
	
	public void characters (char [] ch, int start, int length) throws SAXException{
		if(_blnBook == true){
			_strName = new String (ch, start, length).trim();
		}
	}
	
	public void endElement(String uri, String localName, 
			String qName, Attributes atts) throws SAXException{
		if(qName.equals("HSBib") == true){
			if(_blnBooks == true || _blnBook == true){
				_blnBooks = false;
			}
		}
		if(qName.equals("Books") == true){
			if(_blnBook == true){
				// throw new 
				_blnBooks = false;
			}
		}
		if(qName.equals("Book") == true){
			_blnBook = false;
			if(_strId == null || _strId.trim().length() == 0){
				//throw 
			}
			if(_strAuthor == null || _strAuthor.trim().length() == 0){
				//throw 
			}
			if(_strLentBy == null || _strLentBy.trim().length() == 0){
				//throw 
			}
			if(_strReturnDate == null || _strReturnDate.trim().length() == 0){
				//throw 
			}
			if(_strName == null || _strName.trim().length() == 0){
				//throw 
			}
			
		}
		
		// End with this Class
	
	}
}
