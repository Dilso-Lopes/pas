import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cadastro extends JInternalFrame {
	JPanel painel = new JPanel();
	JPanel painel1 = new JPanel();
	JPanel painel2 = new JPanel();
	JPanel painel3 = new JPanel();
	JPanel painel4 = new JPanel();
	JPanel painel5 = new JPanel();
	JPanel painel6 = new JPanel();
	JPanel painel7 = new JPanel();
	JPanel painel8 = new JPanel();
	JPanel painel9 = new JPanel();
	JPanel painel10 = new JPanel();
	JPanel painel11 = new JPanel();
	JPanel painel12 = new JPanel();
	
		JPasswordField pass = new JPasswordField(10);
		JPasswordField pass1 = new JPasswordField(10);
	
			JTextField texto = new JTextField(10);
			JTextField texto1 = new JTextField(20);
			JTextField texto2 = new JTextField(20);
			JTextField texto3 = new JTextField(20);
			JTextField texto4 = new JTextField(5);
			JTextField texto5 = new JTextField(10);
	
				JButton ok = new JButton();
				JButton cancel = new JButton();
	
					String numer;
					String n,sob,se,em,lo,senh,sen;
					int co, ra;
					DadosBanco fun;
						
						Color Cor1 = new Color(112,128,144);
						Color Cor2 = new Color(147,112,219);
						Color Cor3 = new Color(238,238,224);
						Color Cor4 = new Color(85,26,139);
						
							JLabel nome = new JLabel("Nome");
							JLabel nome2 = new JLabel("Sobrenome");
							JLabel set = new JLabel("Setor");
							JLabel email = new JLabel("e-mail");
							JLabel ram = new JLabel("Ramal");
							JLabel login = new JLabel("Login");
							JLabel senha = new JLabel("Senha");
							JLabel conf = new JLabel("Confirmar senha");
	
	public Cadastro(){   
		ImageIcon img4 = new ImageIcon(getClass().getResource("Imagem/LOGO1.jpg"));
		this.setFrameIcon(img4);
		this.setTitle("Cadastro");	
		this.setSize(550,700);
		this.setLocation(345, 30);
		this.setClosable(true);
		this.setIconifiable(false);
		this.add(painel);
		this.add(painel9,BorderLayout.NORTH);
		this.add(painel10,BorderLayout.SOUTH);
		this.add(painel11,BorderLayout.WEST);
		this.add(painel12,BorderLayout.EAST);
		
			TitledBorder titulo = new TitledBorder("Dados do Usuário");
		   
				ImageIcon img = new ImageIcon(getClass().getResource("Imagem/OK1.png"));   
				ok.setIcon(img);   
				ok.setBackground(Cor3);
				ok.setPreferredSize(new Dimension(60,60));
				ok.setFocusPainted(false);
				ok.setBorderPainted(false);
				ok.setToolTipText("Confirmar Cadastro");
        
					ImageIcon img1 = new ImageIcon(getClass().getResource("Imagem/sair5.png"));   
					cancel.setIcon(img1);   
					cancel.setBackground(Cor3);
					cancel.setPreferredSize(new Dimension(60,60));
					cancel.setFocusPainted(false);
					cancel.setBorderPainted(false);
					cancel.setToolTipText("Sair do Cadastro");
		
						cancel.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
								int s = JOptionPane.showConfirmDialog(null, "Deseja realmente sair do Cadastro?","Sair",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
								if(s == JOptionPane.YES_OPTION){
									dispose();
								}
							}

						});
		
							JLabel figura = new JLabel();
							ImageIcon img2 = new ImageIcon(getClass().getResource("Imagem/usuario.png"));
							figura.setIcon(img2);
		
								Box boxes[] = new Box[1];
								boxes[0] = Box.createVerticalBox();
								boxes[0].add(Box.createVerticalStrut(5));
								boxes[0].add(painel1);
								boxes[0].add(painel2);
								boxes[0].add(painel3);
								boxes[0].add(painel4);
								boxes[0].add(painel5);
								boxes[0].add(painel6);
								boxes[0].add(painel7);
								boxes[0].add(painel8);
		
									nome.setForeground(Cor4); 
									nome2.setForeground(Cor4);
									set.setForeground(Cor4); 
									email.setForeground(Cor4); 
									ram.setForeground(Cor4); 
									login.setForeground(Cor4); 
									senha.setForeground(Cor4); 
									conf.setForeground(Cor4);
		
										titulo.setTitleFont(new Font("tahoma", Font.BOLD, 14));
										titulo.setTitleColor(Cor4);
										titulo.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,Color.BLUE));
	
											painel.add(boxes[0]);
											painel.setBackground(Cor3);
											painel.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 5,Cor2));
											painel.setLayout(new FlowLayout(FlowLayout.LEFT,100,5));
											painel.setBorder(titulo);
		
												painel1.add(nome);
												painel1.add(texto);
												painel1.setBackground(Cor3);
												painel1.setLayout(new FlowLayout(FlowLayout.LEFT,32,10));
		
													painel2.add(nome2);
													painel2.add(texto1);
													painel2.setBackground(Cor3);
													painel2.setLayout(new FlowLayout(FlowLayout.LEFT,16,10));
		
														painel3.add(set);
														painel3.add(texto2);
														painel3.setBackground(Cor3);
														painel3.setLayout(new FlowLayout(FlowLayout.LEFT,34,10));
		
															painel4.add(email);
															painel4.add(texto3);
															painel4.setBackground(Cor3);
															painel4.setLayout(new FlowLayout(FlowLayout.LEFT,31,10));
	
																painel5.add(ram);
																painel5.add(texto4);
																painel5.setBackground(Cor3);
																painel5.setLayout(new FlowLayout(FlowLayout.LEFT,30,10));
	
																	painel6.add(login);
																	painel6.add(texto5);
																	painel6.setBackground(Cor3);
																	painel6.setLayout(new FlowLayout(FlowLayout.LEFT,33,10));
		
																		texto.setDocument(new Caracter(20));
																		texto1.setDocument(new Caracter(60));
																		texto2.setDocument(new Caracter(60));  
																		texto3.setDocument(new Caracter(80));  
																		texto4.setDocument(new Caracter(5));
																		texto4.setToolTipText("Digite apenas numeros inteiros");
																		texto5.setDocument(new Caracter(20)); 
																		pass.setDocument(new Caracter(10));
																		pass1.setDocument(new Caracter(10));
		
																			painel7.add(senha);
																			painel7.add(pass);
																			painel7.setBackground(Cor3);
																			painel7.setLayout(new FlowLayout(FlowLayout.LEFT,31,10));
		
																				painel8.add(conf);
																				painel8.add(pass1);
																				painel8.setBackground(Cor3);
																				painel8.setLayout(new FlowLayout(FlowLayout.LEFT,2,10));
		
																					painel9.add(figura);
																					painel9.setBackground(Cor3);
																					painel9.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
																					painel9.setBorder(BorderFactory.createMatteBorder(5, 5, 0, 5,Cor2));
		
																						painel10.add(ok);
																						painel10.add(cancel);
																						painel10.setBackground(Cor3);
																						painel10.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
																						painel10.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 5,Cor2));
		
																							painel11.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0,Cor2));
																							painel11.setBackground(Cor3);
		
																								painel12.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 5,Cor2));
																								painel12.setBackground(Cor3);
		
																									/*numer = texto4.getText();
																									texto.setText(numer);*/ 
	}
	
																										public void setPosição(){
																											Dimension d = this.getDesktopPane().getSize();
																											this.setLocation((d.width - this.getSize().width)/2, (d.height - this.getSize().height)/2);
																										}
	
}
