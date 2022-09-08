import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JInternalFrame {
	JPanel painel = new JPanel();
	JPanel painel1 = new JPanel();
	JPanel painel2 = new JPanel();
	JPanel painel3 = new JPanel();
	
		JLabel nome = new JLabel("Login ");
		JLabel senha = new JLabel("Senha");

		JPasswordField password = new JPasswordField(10);
		JTextField texto = new JTextField(10);
		
			Color Cor1 = new Color(112, 128, 144);
			Color Cor2 = new Color(147, 112, 219);
			Color Cor3 = new Color(238, 238, 224);
			Color Cor4 = new Color(85, 26, 139);
			
			String log,senh;
			DadosBanco validar;
			Caracter carac;
			JanelaPrincipal prin;
			JButton ok = new JButton(); 
			
	public Login(){
		ImageIcon img4 = new ImageIcon(getClass().getResource("Imagem/LOGO1.jpg"));
		this.setTitle("Login");
		this.setFrameIcon(img4);
		this.setSize(600, 400);
		this.setLocation(345, 190);
		this.setClosable(true);
		this.setIconifiable(false);
		this.add(painel);
		
		Box boxes[] = new Box[1];
		boxes[0] = Box.createVerticalBox();

		boxes[0].add(Box.createVerticalStrut(5));
		boxes[0].add(painel1);
		boxes[0].add(painel2);
		boxes[0].add(painel3);
		
		  
        ImageIcon img = new ImageIcon(getClass().getResource("Imagem/OK1.png"));   
        ok.setIcon(img);   
        ok.setBackground(Cor3);
        ok.setPreferredSize(new Dimension(60,60));
		ok.setFocusPainted(false);
		ok.setBorderPainted(false);
		ok.setToolTipText("Confirmar Login");
		
        JButton cancel = new JButton();   
        ImageIcon img1 = new ImageIcon(getClass().getResource("Imagem/Cancelar1.jpg"));   
        cancel.setIcon(img1);   
        cancel.setBackground(Cor3);
        cancel.setPreferredSize(new Dimension(60,60));
		cancel.setFocusPainted(false);
		cancel.setBorderPainted(false);
		cancel.setToolTipText("Cancelar Login");
		
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int s = JOptionPane.showConfirmDialog(null, "Deseja realmente cancelar esta operação ?","Sair",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					if(s == JOptionPane.YES_OPTION){
						dispose();
					}
			}

			});
		
		JLabel figura = new JLabel();
		ImageIcon img2 = new ImageIcon(getClass().getResource("Imagem/Login2.jpg"));
		figura.setIcon(img2);
		
		painel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Cor2));
		painel.add(figura, BorderLayout.WEST);
		painel.add(boxes[0], BorderLayout.EAST);
		painel.setBackground(Cor3);
		painel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 40));

		painel1.add(nome);
		painel1.add(texto);
		painel1.setBackground(Cor3);
		
		texto.setDocument(new Caracter(20));
		password.setDocument(new Caracter(10));

		painel2.add(senha);
		painel2.add(password);
		painel2.setBackground(Cor3);

		painel3.add(ok);
		painel3.add(cancel);
		painel3.setBackground(Cor3);
		painel3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 30));

		nome.setForeground(Cor4);
		senha.setForeground(Cor4);
			
	}
	public void setPosição(){
		Dimension d = this.getDesktopPane().getSize();
		this.setLocation((d.width - this.getSize().width)/2, (d.height - this.getSize().height)/2);
	}
	
}
