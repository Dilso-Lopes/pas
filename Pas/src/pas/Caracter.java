import javax.swing.text.*;

public class Caracter extends PlainDocument {
	private int tamMax;
	 
		
	public Caracter(int tam) {
		tamMax = tam;
	}

	public void insertString(int offs, String str, AttributeSet a)
			throws BadLocationException {
		if ((getLength() + str.length()) <= tamMax)
			super.insertString(offs, str, a);
	
	}
	
	
}
