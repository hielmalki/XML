import java.awt.Image;

import turban.utils.IGuifiable;


public class MyGuifiable implements IGuifiable{
	String _strGuiString;
	public MyGuifiable(String string) {
		// TODO Auto-generated constructor stub
		this._strGuiString=toGuiString();
	}
	@Override
	public Image getGuiIcon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toGuiString() {
		// TODO Auto-generated method stub
		return null;
	}

}
