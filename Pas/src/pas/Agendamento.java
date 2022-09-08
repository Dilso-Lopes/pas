import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Agendamento extends JInternalFrame {
	
	String[] j ={null,"Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
	int co,di,and,func;
	String fi,date,time1,time2,d,anual,meses,da;
	
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
	JPanel painel13 = new JPanel();
		
		JLabel andar = new JLabel("Andar");
		JLabel sala = new JLabel("Sala");
		JLabel dia = new JLabel("Dia");
		JLabel mes = new JLabel("Mês");
		JLabel ano = new JLabel("Ano");
		JLabel hora = new JLabel("Hora Início");
		JLabel hora1 = new JLabel("Hora Término");
		JLabel figura = new JLabel();
		JLabel ren = new JLabel("Finalidade");
		JLabel cap = new JLabel("Capacidade:");
		JLabel ass = new JLabel("Acessórios:");
		JLabel cap1 = new JLabel();
		JLabel ass1 = new JLabel();
		JLabel figura1 = new JLabel();
		
			JComboBox box = new JComboBox();
			JComboBox box1 = new JComboBox();
			JComboBox box2 = new JComboBox(j);
			JComboBox box3 = new JComboBox();
			JComboBox box4 = new JComboBox();
			JComboBox box5 = new JComboBox();
			JComboBox box6 = new JComboBox();
			JComboBox box7 = new JComboBox();
			
				Color Cor1 = new Color(112,128,144);
				Color Cor2 = new Color(147,112,219);
				Color Cor3 = new Color(238,238,224);
				Color Cor4 = new Color(85,26,139);
					
					TitledBorder titulo = new TitledBorder("Informações sobre as Salas");	
								
						JTextField texto = new JTextField(20);
						JTextField texto1 = new JTextField(2);
						JTextField texto2 = new JTextField(25);
									
							DadosBanco reserv,apagar;
							TabelaReserva tb;
							String nom , x = "";
							JButton ok = new JButton(); 
							Caracter carac;
									
								public Agendamento(){
		
									ImageIcon img4 = new ImageIcon(getClass().getResource("Imagem/LOGO1.jpg"));
									this.setFrameIcon(img4);
									this.setTitle("Agendamento");
									this.setSize(1020,700);
									this.setLocation(140, 35);
									this.setClosable(true);
									this.setIconifiable(false);
									this.add(painel10,BorderLayout.SOUTH);
									this.add(painel8,BorderLayout.NORTH);
									this.add(painel,BorderLayout.WEST);
									this.add(painel2,BorderLayout.CENTER);
									this.add(painel6,BorderLayout.EAST);
										
											box6.addItem(null);
										for (int i = 4; i < 10; i++){
											box6.addItem(i);
										}
											box3.addItem(null);
										for (int i = 6; i < 23; i++){
											box3.addItem(i+":00");
										}
										
		
											Calendar data = new GregorianCalendar(); 
											SimpleDateFormat formato = new SimpleDateFormat("yyyy");
											d = (formato.format(data.getTime()));
											di = Integer.parseInt(d);
											box4.addItem(null);
											box4.addItem(di);
		
												box2.addActionListener(new ActionListener(){
													public void actionPerformed(ActionEvent e){
															if(box2.getSelectedItem()== null){
																box1.addItem(null);
															}else if(box2.getSelectedItem()== "Janeiro" || box2.getSelectedItem()== "Março" || box2.getSelectedItem()== "Maio" || box2.getSelectedItem()== "Julho" || box2.getSelectedItem()== "Agosto" || box2.getSelectedItem()== "Outubro" || box2.getSelectedItem()== "Dezembro"){
																removerItem();
																box1.addItem(null);
																dia31();
															}else if(box2.getSelectedItem()== "Abril" || box2.getSelectedItem()== "Junho" || box2.getSelectedItem()== "Setembro" || box2.getSelectedItem()== "Novembro"){
																removerItem();
																box1.addItem(null);
																dia30();
															}else if(box2.getSelectedItem()== "Fevereiro" && di % 4 == 0 && di % 100 != 0 || di % 400 == 0){
																removerItem();
																dia29();
				
															}else{
																removerItem();
																box1.addItem(null);
																dia28();
				
															}
				
																
																if(box2.getSelectedIndex()<10){
																	meses = "0"+(box2.getSelectedIndex());
																}else{
																	meses = String.valueOf(box2.getSelectedIndex());
																}
																
	
													}
		
												});
        
													box6.addActionListener(new ActionListener(){
														public void actionPerformed(ActionEvent e){
															
																if(box6.getSelectedIndex() == 1){
																	remover();
																	box.addItem(null);
																	for (int i = 1; i < 5; i++){
																		box.addItem(i);
																	}
																}
																if(box6.getSelectedIndex() == 2){
																	remover();
																	box.addItem(null);
																	for (int i = 5; i < 8; i++){
																		box.addItem(i);
																	}
																}
																if(box6.getSelectedIndex() == 3){
																	remover();
																	box.addItem(null);
																	for (int i = 8; i < 10; i++){
																		box.addItem(i);
																	}
																}
																if(box6.getSelectedIndex() == 4){
																	remover();
																	box.addItem(null);
																	for (int i = 10; i < 12; i++){
																		box.addItem(i);
																	}
																}
																if(box6.getSelectedIndex() == 5){
																	remover();
																	box.addItem(null);
																	for (int i = 12; i < 14; i++){
																		box.addItem(i);
																	}
																}
																if(box6.getSelectedIndex() == 6){
																	remover();
																	box.addItem(null);
																	for (int i = 14; i < 16; i++){
																		box.addItem(i);
																	}
																}
															
	
														}

														private void remover() {
															if(box != null)
																box.removeAllItems();
														}

													});
													
													box3.addActionListener(new ActionListener(){
														public void actionPerformed(ActionEvent e){
															if(box3.getSelectedIndex()==1){
																removerItem2();
																box5.addItem(null);
																for (int i = 7; i < 23; i++){
																	box5.addItem(i+":00");
																}
															}else if(box3.getSelectedIndex()==2){
																removerItem2();
																box5.addItem(null);
																for (int i = 8; i < 23; i++){
																	box5.addItem(i+":00");
																}
															}else if(box3.getSelectedIndex()==3){
																removerItem2();
																box5.addItem(null);
																for (int i = 9; i < 23; i++){
																	box5.addItem(i+":00");
																}
															}else if(box3.getSelectedIndex()==4){
																removerItem2();
																box5.addItem(null);
																for (int i = 10; i < 23; i++){
																	box5.addItem(i+":00");
																}
															}else if(box3.getSelectedIndex()==5){
																removerItem2();
																box5.addItem(null);
																for (int i = 11; i < 23; i++){
																	box5.addItem(i+":00");
																}
															}else if(box3.getSelectedIndex()==6){
																removerItem2();
																box5.addItem(null);
																for (int i = 12; i < 23; i++){
																	box5.addItem(i+":00");
																}
															}else if(box3.getSelectedIndex()==7){
																removerItem2();
																box5.addItem(null);
																for (int i = 13; i < 23; i++){
																	box5.addItem(i+":00");
																}
															}else if(box3.getSelectedIndex()==8){
																removerItem2();
																box5.addItem(null);
																for (int i = 14; i < 23; i++){
																	box5.addItem(i+":00");
																}
															}else if(box3.getSelectedIndex()==9){
																removerItem2();
																box5.addItem(null);
																for (int i = 15; i < 23; i++){
																	box5.addItem(i+":00");
																}
															}else if(box3.getSelectedIndex()==10){
																removerItem2();
																box5.addItem(null);
																for (int i = 16; i < 23; i++){
																	box5.addItem(i+":00");
																}
															}else if(box3.getSelectedIndex()==11){
																removerItem2();
																box5.addItem(null);
																for (int i = 17; i < 23; i++){
																	box5.addItem(i+":00");
																}
															}else if(box3.getSelectedIndex()==12){
																removerItem2();
																box5.addItem(null);
																for (int i = 18; i < 23; i++){
																	box5.addItem(i+":00");
																}
															}else if(box3.getSelectedIndex()==13){
																removerItem2();
																box5.addItem(null);
																for (int i = 19; i < 23; i++){
																	box5.addItem(i+":00");
																}
															}else if(box3.getSelectedIndex()==14){
																removerItem2();
																box5.addItem(null);
																for (int i = 20; i < 23; i++){
																	box5.addItem(i+":00");
																}
															}else if(box3.getSelectedIndex()==15){
																removerItem2();
																box5.addItem(null);
																for (int i = 21; i < 23; i++){
																	box5.addItem(i+":00");
																}
															}else if(box3.getSelectedIndex()==16){
																removerItem2();
																box5.addItem(null);
																for (int i = 22; i < 23; i++){
																	box5.addItem(i+":00");
																}
															}
														}
													});
        
														Box boxes[] = new Box[1];
														boxes[0] = Box.createHorizontalBox();
														boxes[0].add(Box.createHorizontalStrut(10));
														boxes[0].add(painel12);
														boxes[0].add(painel13);
										
															Box boxes1[] = new Box[1];
															boxes1[0] = Box.createVerticalBox();
															boxes1[0].add(Box.createVerticalStrut(10));
															boxes1[0].add(painel7);
															boxes1[0].add(painel11);
															boxes1[0].add(painel4);
															boxes1[0].add(painel5);
															boxes1[0].add(painel9);
										
																  
																ImageIcon img = new ImageIcon(getClass().getResource("Imagem/OK1.png"));   
																ok.setIcon(img);   
																ok.setBackground(Cor3);
																ok.setPreferredSize(new Dimension(60,60));
																ok.setFocusPainted(false);
																ok.setBorderPainted(false);
																ok.setToolTipText("Confirmar Agendamento");
										
								        
																		JButton cancel = new JButton();   
																		ImageIcon img1 = new ImageIcon(getClass().getResource("Imagem/Cancelar1.jpg"));   
																		cancel.setIcon(img1);   
																		cancel.setBackground(Cor3);
																		cancel.setPreferredSize(new Dimension(60,60));
																		cancel.setFocusPainted(false);
																		cancel.setBorderPainted(false);
																		cancel.setToolTipText("Cancelar Agendamento");
																			
																			cancel.addActionListener(new ActionListener(){
																				public void actionPerformed(ActionEvent e){
																					String usu;
																					JLabel lbl = new JLabel("Digite sua senha:");
																					JPasswordField jt = new JPasswordField();
																					int q = JOptionPane.showConfirmDialog(null,new Object[]{lbl,jt},"Cancelar Agendamento",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
																					if(q == JOptionPane.OK_OPTION){
																					
																					tb = new TabelaReserva();
																					String pass = "";
																					char[] caracters = jt.getPassword();										
																					for (int i = 0; i < caracters.length; i++) {
																						pass += caracters[i];
																					}										
																					usu = pass;
																					tb.preencherTabela(usu);
																					
																					
																					}
																			
																				}
																				
																			});
										
																			JButton sair = new JButton();   
																			ImageIcon img3 = new ImageIcon(getClass().getResource("Imagem/sair5.png"));   
																			sair.setIcon(img3);   
																			sair.setBackground(Cor3);
																			sair.setPreferredSize(new Dimension(60,60));
																			sair.setFocusPainted(false);
																			sair.setBorderPainted(false);
																			sair.setToolTipText("Sair");
										
																				sair.addActionListener(new ActionListener(){
																					public void actionPerformed(ActionEvent e){
																						int s = JOptionPane.showConfirmDialog(null, "Deseja realmente sair ?","Sair",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
																						if(s == JOptionPane.YES_OPTION){
																							dispose();
																						}
																					}

																				});
										
																					ImageIcon img2 = new ImageIcon(getClass().getResource("Imagem/sala1.png"));
																					figura.setIcon(img2);
																					figura.setBorder(new BevelBorder(BevelBorder.LOWERED));
																					figura.setLayout(new FlowLayout(FlowLayout.LEFT,30,20));
													
																						painel.add(boxes1[0]);
																						painel.setBackground(Cor3);
																						painel.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
																						painel.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0,Cor2));
																						painel1.setBorder(new BevelBorder(BevelBorder.LOWERED));
																						painel1.setPreferredSize(new Dimension(570,500));
																						ImageIcon img5 = new ImageIcon(getClass().getResource("Imagem/reuniao.jpg"));
																						figura1.setIcon(img5);
																						painel1.add(figura1);
																						
																							painel2.setBackground(Cor3);
																							painel2.setPreferredSize(new Dimension(530,900));
																							painel2.setBorder(titulo);
																							painel2.add(painel3);
																							painel2.add(painel1);
													
																								painel3.add(boxes[0]);
																								painel3.setBackground(Cor3);
																								painel3.setLocation(50, 50);
													
																									painel4.setLayout(new FlowLayout(FlowLayout.LEFT,5,20));
																									painel4.setBackground(Cor3);
																									painel4.add(andar);
																									painel4.add(box6);
																									painel4.add(sala);
																									painel4.add(box);
																									painel4.add(ano);
																									painel4.add(box4);
																									painel4.add(mes);
																									painel4.add(box2);
													
																										painel5.setLayout(new FlowLayout(FlowLayout.LEFT,5,10));
																										painel5.setBackground(Cor3);
																										painel5.add(dia);
																										painel5.add(box1);
																										painel5.add(hora);
																										painel5.add(box3);
																										painel5.add(hora1);
																										painel5.add(box5);
													
																											titulo.setTitleFont(new Font("tahoma", Font.BOLD, 14));
																											titulo.setTitleColor(Cor4);
																											titulo.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,Color.BLUE));
													
																												painel6.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 5,Cor2));
																												painel6.setBackground(Cor3);
													
																													painel7.add(figura);
																													painel7.setBackground(Cor3);
																													painel7.setLayout(new FlowLayout(FlowLayout.LEFT,5,10));
													
																														painel8.setBackground(Cor3);
																														painel8.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
																														painel8.setBorder(BorderFactory.createMatteBorder(5, 5, 0, 5,Cor2));
													
																															painel9.add(ok);
																															painel9.add(cancel);
																															painel9.add(sair);
																															painel9.setBackground(Cor3);
																															painel9.setLayout(new FlowLayout(FlowLayout.CENTER,5,130));
													
																																painel10.setBackground(Cor3);
																																painel10.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
																																painel10.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 5,Cor2));
													
																																	painel11.add(ren);
																																	painel11.add(texto);
																																	painel11.setBackground(Cor3);
																																	painel11.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
													
																																		painel12.add(cap);
																																		painel12.add(texto1);
																																		painel12.setBackground(Cor3);
																																		painel12.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
													
																																			painel13.add(ass);
																																			painel13.add(texto2);
																																			painel13.setBackground(Cor3);
																																			painel13.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
													
																																				sala.setForeground(Cor4);
																																				dia.setForeground(Cor4);
																																				mes.setForeground(Cor4);
																																				ano.setForeground(Cor4);
																																				hora.setForeground(Cor4);
																																				hora1.setForeground(Cor4);
																																				andar.setForeground(Cor4);
																																				ren.setForeground(Cor4);
																																				cap.setForeground(Cor4);
																																				ass.setForeground(Cor4);
																																				
																																				box.addActionListener(new ActionListener(){
																																					public void actionPerformed(ActionEvent e){
																																				if(box6.getSelectedIndex() == 1 && box.getSelectedIndex() == 1){
																																					
																																					texto1.setText("50");
																																					texto2.setText("Projetor, Telão e Caixa de Som");
																																				}else if( box6.getSelectedIndex() == 1 && box.getSelectedIndex() == 2){
																																					
																																					texto1.setText("20");
																																					texto2.setText("Telão e Caixa de Som");
																																				}else if( box6.getSelectedIndex() == 1 && box.getSelectedIndex() == 3){
																																					and = 3;
																																					texto1.setText("50");
																																					texto2.setText("Sem Acessórios");
																																				}else if( box6.getSelectedIndex() == 1 && box.getSelectedIndex() == 4){
																																					
																																					texto1.setText("20");
																																					texto2.setText("Caixa de Som");
																																				}else if( box6.getSelectedIndex() == 2 && box.getSelectedIndex() == 1){
																																					
																																					texto1.setText("50");
																																					texto2.setText("Sem Acessórios");
																																				}else if( box6.getSelectedIndex() == 2 && box.getSelectedIndex() == 2){
																																					
																																					texto1.setText("20");
																																					texto2.setText("Sem Acessórios");
																																				}else if( box6.getSelectedIndex() == 2 && box.getSelectedIndex() == 3){
																																					
																																					texto1.setText("50");
																																					texto2.setText("Projetor");
																																				}else if( box6.getSelectedIndex() == 3 && box.getSelectedIndex() == 1){
																																					and = 8;
																																					texto1.setText("30");
																																					texto2.setText("Projetor");
																																				}else if( box6.getSelectedIndex() == 3 && box.getSelectedIndex() == 2){
																																					and = 9;
																																					texto1.setText("20");
																																					texto2.setText("Projetor");
																																				}else if( box6.getSelectedIndex() == 4 && box.getSelectedIndex() == 1){
																																					
																																					texto1.setText("50");
																																					texto2.setText("Projetor");
																																				}else if( box6.getSelectedIndex() == 4 && box.getSelectedIndex() == 2){
																																					and = 11;
																																					texto1.setText("40");
																																					texto2.setText("Sem Acessórios");
																																				}else if( box6.getSelectedIndex() == 5 && box.getSelectedIndex() == 1){
																																					
																																					texto1.setText("50");
																																					texto2.setText("Caixa de Som");
																																				}else if( box6.getSelectedIndex() == 5 && box.getSelectedIndex() == 2){
																																					
																																					texto1.setText("20");
																																					texto2.setText("Telão e Caixa de Som");
																																				}else if( box6.getSelectedIndex() == 6 && box.getSelectedIndex() == 1){
																																					
																																					texto1.setText("50");
																																					texto2.setText("Projetor");
																																				}else if( box6.getSelectedIndex() == 6 && box.getSelectedIndex() == 2){
																																			
																																					texto1.setText("20");
																																					texto2.setText("Sem Acessórios");
																																				}
																																					}
																																				});
																																				texto.setDocument(new Caracter(40));
																																				texto1.setEditable(false);
																																				texto2.setEditable(false);
													
												
								}
																																					private void dia28() {
																																						for(int i = 1; i < 29; i++){
																																							box1.addItem(i);
																																						}
		
																																					}

																																						private void dia29() {
																																							for(int i = 1; i < 30; i++){
																																							box1.addItem(i);
																																							}
		
																																						}

																																							private void dia30() {
																																								for(int i = 1; i < 31; i++){
																																								box1.addItem(i);
																																								}
		
																																							}

																																								private void removerItem() {
																																									if(box1 != null)
																																										box1.removeAllItems();
																																									
																																								}
																																								private void removerItem2(){
																																									if(box5!=null)
																																										box5.removeAllItems();
																																								}
	
																																									private void dia31(){
																																										for(int i = 1; i < 32; i++){
																																											box1.addItem(i);
																																										}
		
																																									}
																																									
																																									
																																									public void setPosição(){
																																										Dimension d = this.getDesktopPane().getSize();
																																										this.setLocation((d.width - this.getSize().width)/2, (d.height - this.getSize().height)/2);
																																									}
																																									
																																										
																																									
																																									

}

