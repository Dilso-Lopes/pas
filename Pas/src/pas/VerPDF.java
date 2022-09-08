import java.awt.Desktop;
import java.io.File;
import java.io.IOException;



import javax.swing.JDialog;
   


public class VerPDF extends JDialog{

	// Object[] meupdf;
	public VerPDF() throws Throwable {
		//
		//
		// meupdf = new Object[]{""};
		// this.setSize(900,700);
		// this.setVisible(true);
		// this.setLocationRelativeTo(null);
		// SimpleViewer viewer = new SimpleViewer(this, null);
		// viewer.setupViewer();
		// viewer.executeCommand(Commands.OPENFILE,meupdf);

	}
	
	public void print() throws IOException {
		File file = new File("C:\\Users\\Everaldo\\Documents\\Documentos Office\\Manual.pdf");
		Desktop desktop = Desktop.getDesktop();
		desktop.open(file);
		
		
	}


}
