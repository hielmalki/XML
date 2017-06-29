
import org.simpleframework.xml.Element;
import org.simpleframework.xml.core.Validate;
import org.simpleframework.xml.*;

import turban.utils.ErrorHandler;

@SuppressWarnings({ "unused" })
@Root(name = "Book", strict = false)
public class Book {
	
	
	@Attribute(name = "ID")
	private String _strId;
	@Attribute(name = "Author")
	private String _strAuthor;
	@Attribute(name = "LentBy")
	private String _strLentBy;
	@Attribute(name = "ReturnDate")
	private String _strReturnDate;
	@Text
	private String _strName;
	
	
	
	public Book(){
		
	}
	
	public Book(String strId, String strAuthor, String strLentBy, String strReturnDate){
		this._strId = strId;
		this._strAuthor = strAuthor;
		this._strLentBy = strLentBy;
		this._strReturnDate = strReturnDate;
	}
	
	@Validate
	public void validate(){
		ErrorHandler.Assert(_strId != null && _strId.trim().length()> 0, true, Book.class, "No valide ID provided [{0}] ", _strId);
		ErrorHandler.Assert(_strName != null && _strName.trim().length()> 0, true, Book.class, "No valide Name provided [{0}] ", _strName);
	}
	
	// Set methods
	public void setAuthor(String author){
		_strAuthor = author;
	}
	public void setLentBy(String lentBy){
		_strLentBy = lentBy;
	}
	public void setReturnDate(String ReturnDate){
		_strReturnDate = ReturnDate;
	}
	
	
}
