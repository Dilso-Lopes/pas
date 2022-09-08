import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;

public class JanelaPrincipal extends JFrame {
	JDesktopPane dk = new JDesktopPane();
	
		JMenuBar barra = new JMenuBar();
		JMenu acoes = new JMenu("Ações");
		JMenu opcoes = new JMenu("Opções");
		
			JMenuItem cad = new JMenuItem("Cadastro");
			JMenuItem login = new JMenuItem("Login");
			JMenuItem agen = new JMenuItem("Agendamento");
			JMenuItem atu = new JMenuItem("Atualizar Cadastro");
			JMenuItem sair = new JMenuItem("Sair");
			JMenuItem cons = new JMenuItem("Consultar Salas");
			JMenuItem man = new JMenuItem("Manual Usuário");
			JMenuItem off = new JMenuItem("Logoff");
						
				Color Cor1 = new Color(112, 128, 144);
				Color Cor2 = new Color(147, 112, 219);
				Color Cor3 = new Color(238, 238, 224);
				Color Cor4 = new Color(85, 26, 139);
			
					Cadastro cadastro;
					Login Log;
					Agendamento agend;
					Pesquisa pesq;
					Conexao con;
					Caracter carac;
					DadosBanco atualizar,fun,reserv,verificar,usuario;
					int codi,rama, integer;
					JLabel label = new JLabel("Versão 1.0");
									
						public JanelaPrincipal(){
							criarJanelaPrincipal();
								Log = new Login();
								dk.add(Log);
								Log.setVisible(true);
								Log.ok.addActionListener(new ActionListener(){
									public void actionPerformed(ActionEvent e){
										Log.dispose();
										Log.log = Log.texto.getText();
										String pass = "";
										char[] caracters = Log.password.getPassword();										
										for (int i = 0; i < caracters.length; i++) {
											pass += caracters[i];
										}										
										Log.senh = pass;
											validarUsuario(Log.log, Log.senh);
						
											}
											
											});
												Log.setPosição();
									}
									
							private void criarJanelaPrincipal(){
								ImageIcon img3 = new ImageIcon(getClass().getResource("Imagem/LOGO1.jpg"));
								this.setIconImage(img3.getImage());
								this.setTitle("PAS - Programa para Agendamento de Sala de Reunião");
								this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								this.setResizable(false);
								this.setVisible(true);
								this.setExtendedState(JFrame.MAXIMIZED_BOTH);
								this.add(barra, BorderLayout.NORTH);
								this.add(dk);
									
									barra.add(acoes);
									barra.add(opcoes);
							
										acoes.add(agen);
										agen.setEnabled(false);
										acoes.add(atu);
										atu.setEnabled(false);
										acoes.add(cad);
										acoes.add(login);
										acoes.add(off);
										off.setEnabled(false);
										acoes.addSeparator();
										acoes.add(sair);
										acoes.setToolTipText("Ações");
							
											opcoes.add(cons);
											cons.setEnabled(false);
											opcoes.addSeparator();
											opcoes.add(man);
											opcoes.setToolTipText("Opções");
								
												cad.addActionListener(new ActionListener(){
													public void actionPerformed(ActionEvent e){
														if(e.getSource() == cad){
															usuario = new DadosBanco();
															verificarTelas();
															cadastro = new Cadastro();
															dk.add(cadastro);
															cadastro.setVisible(true);
															cadastro.setPosição();
															cadastro.ok.addActionListener(new ActionListener(){
																public void actionPerformed(ActionEvent e){
																	cadastro.n = cadastro.texto.getText();
																	cadastro.sob = cadastro.texto1.getText();
																	cadastro.se = cadastro.texto2.getText();
																	cadastro.em = cadastro.texto3.getText();
																	cadastro.lo = cadastro.texto5.getText();
																	String pass = "";
																	char[] caracters = cadastro.pass.getPassword();										
																	for (int i = 0; i < caracters.length; i++) {
																		pass += caracters[i];
																	}										
																	cadastro.senh = pass;
																	String passw = "";
																	char[] caracteres = cadastro.pass1.getPassword();										
																	for (int i = 0; i < caracteres.length; i++) {
																		passw += caracteres[i];
																	}										
																	cadastro.sen = passw;
																		if(cadastro.n.equals("")){
																			JOptionPane.showMessageDialog(null,"Campo Nome não preenchido!");
																		}else if(cadastro.sob.equals("")){
																			JOptionPane.showMessageDialog(null,"Campo Sobrenome não preenchido!");
																		}else if(cadastro.se.equals("")){
																			JOptionPane.showMessageDialog(null,"Campo Setor não preenchido!");
																		}else if(cadastro.em.equals("")){
																			JOptionPane.showMessageDialog(null,"Campo e-mail não preenchido!");
																		}else if(cadastro.texto4.getText().equals("")){
																			JOptionPane.showMessageDialog(null,"Campo Ramal não preenchido!");
																		}else if(cadastro.lo.equals("")){
																			JOptionPane.showMessageDialog(null,"Campo Login não preenchido!");
																		}else if(cadastro.senh.equals("")){
																			JOptionPane.showMessageDialog(null,"Campo Senha não preenchido!");
																		}else if(cadastro.sen.equals("")){
																			JOptionPane.showMessageDialog(null,"Campo Confirma senha não preenchido!");
																		}else if(usuario.verificaLogin(cadastro.lo)){
																		}else if(usuario.verificaSenha(cadastro.sen)){	
																		}else if(validarInteiro(cadastro.texto4.getText())){
																			if(cadastro.senh.equals(cadastro.sen)){
																				cadastro.ra = Integer.parseInt(cadastro.texto4.getText());
																				fun = new DadosBanco();
																				
																					try {
																						fun.Inserirdados(cadastro.n, cadastro.sob, cadastro.se, cadastro.em, cadastro.ra, cadastro.lo, cadastro.sen);
																						cadastro.dispose();
																						JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso!");
																					} catch (Exception e1) {
																						JOptionPane.showMessageDialog(null,"Erro! "+e1.getMessage());
																						e1.printStackTrace();
																					}
																					
																			}else{
																			JOptionPane.showMessageDialog(null,"Confirmação de senha incorreta!");
																			
																			}
																		
																		}
																		
																}

																	public boolean validarInteiro(String oi) {
																		boolean valido = true;
																	for(int i = 0; i < cadastro.texto4.getText().length();i++){
																		Character ca = cadastro.texto4.getText().charAt(i);
																		if(Character.isDigit(ca)){
																			valido = false;
																			break;
																		}
																		
																	}
																	
																	if(valido)
																		JOptionPane.showMessageDialog(null,"Campo Ramal não preenchido com numero inteiro");
																	return true;
																	
																}
																	
																	});
														}
														
													}

												});
												
													login.addActionListener(new ActionListener(){
														public void actionPerformed(ActionEvent e){
															if(e.getSource() == login){
																	verificarTelas();
																	Log = new Login();
																	dk.add(Log);
																	Log.setVisible(true);
																	Log.ok.addActionListener(new ActionListener(){
																		public void actionPerformed(ActionEvent e){
																			Log.dispose();
																			Log.log = Log.texto.getText();
																			String pass = "";
																			char[] caracters = Log.password.getPassword();										
																			for (int i = 0; i < caracters.length; i++) {
																				pass += caracters[i];
																			}										
																			Log.senh = pass;
																				validarUsuario(Log.log, Log.senh);
																				
																				}
																				
																		});
																			Log.setPosição();	
																
															}
											
														}

													});
													
														agen.addActionListener(new ActionListener(){
															public void actionPerformed(ActionEvent e){
																if(e.getSource() == agen){
																		verificarTelas();
																		agend = new Agendamento();
																		dk.add(agend);
																		agend.setVisible(true);
																		agend.setPosição();
																		agend.ok.addActionListener(new ActionListener(){
																			public void actionPerformed(ActionEvent e){
																				if(agend.texto.getText().equals("")){
																					JOptionPane.showMessageDialog(null,"Finalidade não preenchido!");
																				}else if(agend.box6.getSelectedItem()== null){
																					JOptionPane.showMessageDialog(null,"Item Andar não selecionado!");
																				}else if(agend.box.getSelectedItem()== null){
																					JOptionPane.showMessageDialog(null,"Item Sala não selecionado!");
																				}else if(agend.box4.getSelectedItem()== null){
																					JOptionPane.showMessageDialog(null, "Item Ano não selecionado!");
																				}else if(agend.box2.getSelectedItem()== null){
																					JOptionPane.showMessageDialog(null, "Item Mês não selecionado!");
																				}else if(agend.box1.getSelectedItem()== null){
																					JOptionPane.showMessageDialog(null, "Item Dia não selecionado!");
																				}else if(agend.box3.getSelectedItem()== null){
																					JOptionPane.showMessageDialog(null, "Item Hora Início não selecionado!");
																				}else if(agend.box5.getSelectedItem()== null){
																					JOptionPane.showMessageDialog(null, "Item Hora Término não selecionado!");
																				}else{
																					if(agend.box6.getSelectedIndex() == 1 && agend.box.getSelectedIndex() == 1){
																						agend.and = 1;
																					}else if( agend.box6.getSelectedIndex() == 1 && agend.box.getSelectedIndex() == 2){
																						agend.and = 2;
																						
																					}else if( agend.box6.getSelectedIndex() == 1 && agend.box.getSelectedIndex() == 3){
																						agend.and = 3;
																						
																					}else if( agend.box6.getSelectedIndex() == 1 && agend.box.getSelectedIndex() == 4){
																						agend.and = 4;
																						
																					}else if( agend.box6.getSelectedIndex() == 2 && agend.box.getSelectedIndex() == 1){
																						agend.and = 5;
																						
																					}else if( agend.box6.getSelectedIndex() == 2 && agend.box.getSelectedIndex() == 2){
																						agend.and = 6;
																						
																					}else if( agend.box6.getSelectedIndex() == 2 && agend.box.getSelectedIndex() == 3){
																						agend.and = 7;
																						
																					}else if( agend.box6.getSelectedIndex() == 3 && agend.box.getSelectedIndex() == 1){
																						agend.and = 8;
																						
																					}else if( agend.box6.getSelectedIndex() == 3 && agend.box.getSelectedIndex() == 2){
																						agend.and = 9;
																						
																					}else if( agend.box6.getSelectedIndex() == 4 && agend.box.getSelectedIndex() == 1){
																						agend.and = 10;
																						
																					}else if( agend.box6.getSelectedIndex() == 4 && agend.box.getSelectedIndex() == 2){
																						agend.and = 11;
																						
																					}else if( agend.box6.getSelectedIndex() == 5 && agend.box.getSelectedIndex() == 1){
																						agend.and = 12;
																						
																					}else if( agend.box6.getSelectedIndex() == 5 && agend.box.getSelectedIndex() == 2){
																						agend.and = 13;
																						
																					}else if( agend.box6.getSelectedIndex() == 6 && agend.box.getSelectedIndex() == 1){
																						agend.and = 14;
																						
																					}else if( agend.box6.getSelectedIndex() == 6 && agend.box.getSelectedIndex() == 2){
																						agend.and = 15;
																						
																					}
																					int sal = 9;
																					if(agend.box1.getSelectedIndex()<10){
																						agend.da = "0"+String.valueOf(agend.box1.getSelectedItem());
																					}else{
																						agend.da = String.valueOf(agend.box1.getSelectedItem());
																					}
																					agend.anual = agend.box4.getSelectedItem()+"-"+agend.meses+"-"+agend.da;
																					agend.fi = agend.texto.getText();
																					agend.date = agend.anual;
																					agend.time1 = (String) agend.box3.getSelectedItem();
																					String tim = "0"+agend.time1+":00";
																					agend.time2 = (String) agend.box5.getSelectedItem();
																					agend.func = codi;
																						verificar = new DadosBanco();
																						if(verificar.verificaReserva(agend.and,agend.date,tim)){
																						
																						}else{
																							reserv = new DadosBanco();
																							try {
																								reserv.Reserva(agend.fi, agend.date, agend.time1, agend.time2, agend.and, agend.func);
																								agend.dispose();
																								JOptionPane.showMessageDialog(null,"Agendamento realizado com sucesso!");
																							} catch (Exception e1) {
															
																								e1.printStackTrace();
																						}
																						
																						}
																						
																				
																				}
													
																			}
												
																		});
																	
																}
											
															}
									
														});
														
															cons.addActionListener(new ActionListener(){
																public void actionPerformed(ActionEvent e){
																	if(e.getSource() == cons){
																		
																			verificarTelas();
																			pesq = new Pesquisa();
																			dk.add(pesq);
																			pesq.setVisible(true);
																			pesq.setPosição();
																		
											
																	}
											
																}
									
															});
															
																sair.addActionListener(new ActionListener(){
																	public void actionPerformed(ActionEvent e){
																		if(e.getSource() == sair){
																			System.exit(0);
											
																		}
												
																	}
									
																});
																
																man.addActionListener(new ActionListener(){
																	public void actionPerformed(ActionEvent e){
																		
																			try {
																				VerPDF ver = new VerPDF();
																				ver.print();
																			} catch (Throwable e1) {
																				// TODO Auto-generated catch block
																				e1.printStackTrace();
																			}
																		
				
																		 /*try {   
																			 
																	            Runtime.getRuntime().exec("C:\\Program Files (x86)\\Adobe\\Reader 9.0\\Reader\\AcroRd32.exe");    
																	        } catch (IOException e1) {   
																	            e1.printStackTrace();   
																	        }*/   

																		
																			
																		
																	}
									
																});
																
																off.addActionListener(new ActionListener(){
																	public void actionPerformed(ActionEvent e){
																		if(e.getSource() == off){
																			verificarTelas();
																			JOptionPane.showMessageDialog(null, "Logoff realizado com sucesso!");
																			agen.setEnabled(false);
																			atu.setEnabled(false);
																			cons.setEnabled(false);
																			off.setEnabled(false);
																			cad.setEnabled(true);
																			login.setEnabled(true);
											
																		}
												
																	}
									
																});
																
																	atu.addActionListener(new ActionListener(){
																		public void actionPerformed(ActionEvent e){
																			if(e.getSource() == atu){
																					verificarTelas();
																					String nom,se;
																					JLabel lbl = new JLabel("Digite seu login:");
																					JTextField jt = new JTextField();
																					JLabel lb = new JLabel("Digite sua senha:");
																					JPasswordField jp = new JPasswordField();
																					int q = JOptionPane.showConfirmDialog(null,new Object[]{lbl,jt,lb,jp},"Login",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
																						if(q == JOptionPane.OK_OPTION){
																						cadastro = new Cadastro();
																						nom = new String(jt.getText());
																						se = new String(jp.getPassword());
																						atualizar(nom, se);
																						
																						cadastro.ok.addActionListener(new ActionListener(){
																							public void actionPerformed(ActionEvent e){
																								String pass = "";
																								char[] caracters = cadastro.pass.getPassword();										
																								for (int i = 0; i < caracters.length; i++) {
																									pass += caracters[i];
																								}										
																								cadastro.senh = pass;
																								String passw = "";
																								char[] caracteres = cadastro.pass1.getPassword();										
																								for (int i = 0; i < caracteres.length; i++) {
																									passw += caracteres[i];
																								}										
																								cadastro.sen = passw;
																																															
																									if(cadastro.texto.getText().equals("")||cadastro.texto1.getText().equals("")||cadastro.texto2.getText().equals("")||cadastro.texto3.getText().equals("")||cadastro.texto4.getText().equals("")||cadastro.texto5.getText().equals("")||cadastro.senh.equals("")|| cadastro.sen.equals("")){
																										JOptionPane.showMessageDialog(null, "Preencha os campos em branco!");
																									}else if(cadastro.senh.equals(cadastro.sen)){
																										cadastro.ra = Integer.parseInt(cadastro.texto4.getText());
																										atualizar = new DadosBanco();
																										atualizar.atualizarCadastro(codi, cadastro.texto.getText(), cadastro.texto1.getText(), cadastro.texto2.getText(), cadastro.texto3.getText(), cadastro.ra, cadastro.texto5.getText(), cadastro.sen);
																										cadastro.dispose();
																										JOptionPane.showMessageDialog(null,"Atualização realizada com sucesso!");
																									}else{
																											JOptionPane.showMessageDialog(null,"Confirmação de senha incorreta!");
																									}
																									
																								
																								
																							}
																
														
																						});
																				
																			}
																						
																			}
																		}
									
																	});
							}
				
																		private void verificarTelas(){
																			if (Log != null && Log.isVisible()){
																				Log.dispose();
																			}
																			if (cadastro != null && cadastro.isVisible()){
																				cadastro.setVisible(false);
																			}
																			if (agend != null && agend.isVisible()){
																				agend.setVisible(false);
																			}
																			if (pesq != null && pesq.isVisible()){
																				pesq.setVisible(false);
																			}
					
																		}
																		
																				public void validarUsuario(String logi, String senh){
																					String us,sn;
																					con = new Conexao();
																				
																						try {
																						
																							con.abrirBanco();
																								String query = "SELECT * FROM funcionario WHERE login=? AND senha=?";
																								con.st = con.con.prepareStatement(query);
																								con.st.setString(1, logi);
																								con.st.setString(2, senh);
																								con.rs = con.st.executeQuery();
																									if(con.rs.next()){
																										codi = con.rs.getInt("cod_funcionario");
																										us = con.rs.getString("login");
																										sn = con.rs.getString("senha");
																										if(us.equals(logi) && sn.equals(senh) ){
																											JOptionPane.showMessageDialog(null,"Login realizado com sucesso!");
																											agen.setEnabled(true);
																											atu.setEnabled(true);
																											cons.setEnabled(true);
																											off.setEnabled(true);
																											cad.setEnabled(false);
																											login.setEnabled(false);
																										}
																					
																									}else{
																										JOptionPane.showMessageDialog(null,"Usuário não cadastrado ou senha inválida!");
																										
																									}

																							con.fecharBanco();
																								
																						} catch (Exception e) {
																						// TODO Auto-generated catch block
																						e.printStackTrace();
																						}
																		
																				}
																				
																					private void atualizar(String logi, String senh){
																						String us,sn,nom,sobr,set,em,ra;
																						int ram;
																						con = new Conexao();
																						
																						try {
																							con.abrirBanco();
																							String query = "SELECT * FROM funcionario WHERE login=? AND senha=?";
																							con.st = con.con.prepareStatement(query);
																							con.st.setString(1, logi);
																							con.st.setString(2, senh);
																							con.rs = con.st.executeQuery();
																							if(con.rs.next()){
																								codi = con.rs.getInt("cod_funcionario");
																								us = con.rs.getString("login");
																								sn = con.rs.getString("senha");
																									if(us.equals(logi) && sn.equals(senh) ){
																										codi = con.rs.getInt("cod_funcionario");
																										nom = con.rs.getString("nome");
																										sobr = con.rs.getString("sobrenome");
																										set = con.rs.getString("setor");
																										em = con.rs.getString("email");
																										ram = con.rs.getInt("ramal");
																										ra = Integer.toString(ram);
																										
																											cadastro = new Cadastro();
																											dk.add(cadastro);
																											cadastro.setTitle("Atualizar Cadastro");
																											cadastro.texto.setText(nom);
																											cadastro.texto1.setText(sobr);
																											cadastro.texto2.setText(set);
																											cadastro.texto3.setText(em);
																											cadastro.texto4.setText(ra);
																											cadastro.texto5.setText(us);
																											cadastro.setVisible(true);
																											cadastro.setPosição();
																									}
																		
																							}else{
																							
																							JOptionPane.showMessageDialog(null, "Login e senha incorreto!");
																							
																							}
																							con.fecharBanco();
																						} catch (Exception e) {
																						// TODO Auto-generated catch block
																						e.printStackTrace();
																						}
																						
																					}															
	
	public static void main(String[] args) {
		
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (UnsupportedLookAndFeelException exc) {

		} catch (ClassNotFoundException exc) {

		} catch (InstantiationException exc) {

		} catch (IllegalAccessException exc) {

		}

					new JanelaPrincipal();

	}

}
