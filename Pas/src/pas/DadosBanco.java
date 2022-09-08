import java.awt.Component;
import java.awt.Dimension;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class DadosBanco extends Conexao {
	Tabela tb;

	public void Inserirdados(String nome,String sob,String setor,String email,int ramal,String login, String senha) throws Exception{
		abrirBanco();
			String query = "INSERT INTO Funcionario(nome,sobrenome,setor,email,ramal,login,senha) VALUES(?,?,?,?,?,?,?)";
			st = con.prepareStatement(query);
			st.setString(1, nome);
			st.setString(2, sob);
			st.setString(3, setor);
			st.setString(4, email);
			st.setInt(5, ramal);
			st.setString(6, login);
			st.setString(7, senha);
			st.execute();
		fecharBanco();
	}
	
		public void Reserva(String finalidade,String data,String hora1,String hora2, int andar, int func) throws Exception{
			abrirBanco();
				String query = "INSERT INTO Reserva(finalidade_reserva,data_reserva,hora_inicial,hora_final,cod_andar,cod_funcionario) VALUES(?,?,?,?,?,?)";
				st = con.prepareStatement(query);
				st.setString(1, finalidade);
				st.setString(2, data);
				st.setString(3, hora1);
				st.setString(4, hora2);
				st.setInt(5, andar);
				st.setInt(6, func);
				st.execute();
			fecharBanco();
		
		}
			public void atualizarCadastro(int cod, String nome, String sobrenome, String setor, String email, int ramal, String login, String senha){
				try {
					abrirBanco();
						String query = "UPDATE funcionario SET nome = ?, sobrenome = ?, setor = ?, email = ?, ramal = ?, login = ?, senha = ? WHERE cod_funcionario = ?";
						st = con.prepareStatement(query);
						st.setString(1, nome);
						st.setString(2, sobrenome);
						st.setString(3, setor);
						st.setString(4, email);
						st.setInt(5, ramal);
						st.setString(6, login);
						st.setString(7, senha);
						st.setInt(8, cod);
						st.executeUpdate();
					fecharBanco();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro "+e.getMessage());
					e.printStackTrace();
				}
			}
				public void bucasReserva(String nome){
					tb = new Tabela();
					DefaultTableModel modelo = (DefaultTableModel)tb.getModel();
					modelo.setNumRows(0);
					try {
						abrirBanco();
							String query = "SELECT a.cod_reserva, a.finalidade_reserva, a.data_reserva, a.hora_inicial, a.hora_final, b.cod_andar, b.nome, c.cod_sala, c.nome_sala, d.cod_funcionario, d.nome, d.sobrenome, d.setor, d.email, d.ramal FROM reserva a, andar b, sala c, funcionario d WHERE a.cod_reserva = b.cod_andar AND b.cod_andar = c.cod_sala AND a.cod_reserva = d.cod_funcionario";
							st = con.prepareStatement(query);
							rs = st.executeQuery();
								while(rs.next()){
									modelo.addRow(new Object[]{rs.getObject("a.finalidade_reserva"),rs.getObject("a.data_reserva"),rs.getObject("a.hora_inicial"),rs.getObject("a.hora_final"),rs.getObject("b.nome"),rs.getObject("c.nome_sala"),rs.getObject("d.nome"),rs.getObject("d.sobrenome"),rs.getObject("d.setor"),rs.getObject("d.email"),rs.getObject("d.ramal")});
								}
						fecharBanco();
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
						e.printStackTrace();
					}
					
				}
					public void apagarReserva(int c){
						try {
							abrirBanco();
								String query = "DELETE FROM reserva WHERE cod_reserva=?";
								st = con.prepareStatement(query);
								st.setInt(1, c);
								st.execute();
							fecharBanco();
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null,"Não há registros a serem deletados");
							e.printStackTrace();
							JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
						}
					}
					public boolean verificaReserva(int sal,String dat,String hor){
						boolean reserva = false;
						String dt,ho;
						int sa;
					
							try {
							
								abrirBanco();
									String query = "SELECT * FROM reserva a, sala b WHERE b.nome_sala=? AND data_reserva=? AND hora_inicial=?";
									st = con.prepareStatement(query);
									st.setInt(1, sal);
									st.setString(2, dat);
									st.setString(3, hor);
									rs = st.executeQuery();
										if(rs.next()){
											dt = rs.getString("a.data_reserva");
											sa = rs.getInt("b.nome_sala");
											ho = rs.getString("a.hora_inicial");
											if(sal == sa && dat.equals(dt) && hor.equals(ho))
												reserva = true;
												JOptionPane.showMessageDialog(null, "Sala reservada nesse horário, escolha outro");
										}

								fecharBanco();
									
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
							e.printStackTrace();
							}
							
							return reserva;
					}
					
					
					public boolean verificaLogin(String logi){
						boolean usuario = false;
						String us;
					
							try {
							
								abrirBanco();
									String query = "SELECT * FROM funcionario WHERE login=?";
									st = con.prepareStatement(query);
									st.setString(1, logi);
									rs = st.executeQuery();
										if(rs.next()){
											
											us = rs.getString("login");
											
											if(us.equals(logi)){
												usuario = true;
												JOptionPane.showMessageDialog(null,"Login já cadastro!");
												
											}
						
										}

								fecharBanco();
									
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
							e.printStackTrace();
							}
							return usuario;
							
					}
					
					public boolean verificaSenha(String senh){
						boolean password = false;
						String sn;
						
					
							try {
							
								abrirBanco();
									String query = "SELECT * FROM funcionario WHERE senha=?";
									st = con.prepareStatement(query);
									st.setString(1, senh);
									rs = st.executeQuery();
										if(rs.next()){
											sn = rs.getString("senha");
											if(sn.equals(senh) ){
												password = true;
												JOptionPane.showMessageDialog(null,"Senha já cadastrada!");
												
											}
						
										}

								fecharBanco();
									
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
							e.printStackTrace();
							}
							return password;
							
					}

	
}
