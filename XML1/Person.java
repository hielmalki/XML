import java.awt.Image;
import java.util.*;

import turban.utils.*;


public class Person implements IGuifiable
{
	private String _strId="";
	private String _strName="";
	private String _strEmail="";
	private HSPersonaltyp _personaltyp=null;
	
	public Person(String strId,String strName, HSPersonaltyp personelltype, String strEmail)
	{
		_strId=strId;
		_strName=strName;
		_strEmail=strEmail;
		_personaltyp=personelltype;
	}
	
	public String toGuiString()
	{
		return _personaltyp.toGuiString()+" "+ _strName;
	}
	
	public Image getGuiIcon()
	{
		return null;
	}
	
	public String getId()
	{
		return _strId;
	}
	
	public String getName()
	{
		return _strName;
	}
	
	public String getEmail()
	{
		return _strEmail;
	}
	
	public HSPersonaltyp getPersonellType()
	{
		return _personaltyp;
	}
	
}