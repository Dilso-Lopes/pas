import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Tabela extends JTable{
	Conexao con;
	Color Cor2 = new Color(147, 112, 219);
	
	public Tabela(){
		criarTabela();
	
	}

		private void criarTabela() {
			this.setModel(new DefaultTableModel(
				new Object[][]{
						{null,null,null,null,null,null,null}
				}, new String[]{"Finalidade","Data","Hora Inicial","Hora Final","Andar","Sala","Nome","Sobrenome","Setor","E-mail","Ramal"} 
				));
				this.setPreferredScrollableViewportSize(new Dimension(960,380));
				this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				this.setRowHeight(30);
				this.getColumnModel().getColumn(0).setPreferredWidth(130);
				this.getColumnModel().getColumn(1).setPreferredWidth(85);
				this.getColumnModel().getColumn(2).setPreferredWidth(80);
				this.getColumnModel().getColumn(3).setPreferredWidth(80);
				this.getColumnModel().getColumn(4).setPreferredWidth(50);
				this.getColumnModel().getColumn(5).setPreferredWidth(40);
				this.getColumnModel().getColumn(6).setPreferredWidth(110);
				this.getColumnModel().getColumn(7).setPreferredWidth(210);
				this.getColumnModel().getColumn(8).setPreferredWidth(140);
				this.getColumnModel().getColumn(9).setPreferredWidth(210);
				this.getColumnModel().getColumn(10).setPreferredWidth(50);
				this.setBorder(BorderFactory.createEtchedBorder(1));
	
		}
		
			public void preencherTabela() {
				DefaultTableModel modelo = (DefaultTableModel)this.getModel();
				modelo.setNumRows(0);
				con = new Conexao();
					try {
						con.abrirBanco();
						String query = "SELECT a.cod_reserva, a.finalidade_reserva, a.data_reserva, a.hora_inicial, a.hora_final, a.cod_andar, a.cod_funcionario, b.cod_andar, b.nome, c.cod_sala, c.nome_sala, d.cod_funcionario, d.nome, d.sobrenome, d.setor, d.email, d.ramal FROM reserva a, andar b, sala c, funcionario d WHERE a.cod_andar = b.cod_andar AND b.cod_andar = c.cod_sala And a.cod_funcionario = d.cod_funcionario";
						con.st = con.con.prepareStatement(query);
						con.rs = con.st.executeQuery();
							if(con.rs.next()){
								do{
									modelo.addRow(new Object[]{con.rs.getObject("a.finalidade_reserva"),con.rs.getObject("a.data_reserva"),con.rs.getObject("a.hora_inicial"),con.rs.getObject("a.hora_final"),con.rs.getObject("b.nome"),con.rs.getObject("c.nome_sala"),con.rs.getObject("d.nome"),con.rs.getObject("d.sobrenome"),con.rs.getObject("d.setor"),con.rs.getObject("d.email"),con.rs.getObject("d.ramal")});
								}while(con.rs.next());
							}else{
								JOptionPane.showMessageDialog(null, "Não há nenhum registro!");
							}
						con.fecharBanco();
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Erro!!"+e.getMessage());
						e.printStackTrace();
					}
					
			}
			
				public void preencherTabela1(int sala){
					DefaultTableModel modelo = (DefaultTableModel)this.getModel();
					modelo.setNumRows(0);
					con = new Conexao();
						try {
							con.abrirBanco();
							String query = "SELECT a.cod_reserva, a.finalidade_reserva, a.data_reserva, a.hora_inicial, a.hora_final, a.cod_andar, a.cod_funcionario, b.cod_andar, b.nome, c.cod_sala, c.nome_sala, d.cod_funcionario, d.nome, d.sobrenome, d.setor, d.email, d.ramal FROM reserva a, andar b, sala c, funcionario d WHERE a.cod_andar = b.cod_andar AND b.cod_andar = c.cod_sala And a.cod_funcionario = d.cod_funcionario AND c.nome_sala=?";
							con.st = con.con.prepareStatement(query);
							con.st.setInt(1, sala);
							con.rs = con.st.executeQuery();
								if(con.rs.next()){
									do{
										modelo.addRow(new Object[]{con.rs.getObject("a.finalidade_reserva"),con.rs.getObject("a.data_reserva"),con.rs.getObject("a.hora_inicial"),con.rs.getObject("a.hora_final"),con.rs.getObject("b.nome"),con.rs.getObject("c.nome_sala"),con.rs.getObject("d.nome"),con.rs.getObject("d.sobrenome"),con.rs.getObject("d.setor"),con.rs.getObject("d.email"),con.rs.getObject("d.ramal")});
									}while(con.rs.next());
								}else{
									JOptionPane.showMessageDialog(null, "Não há nenhum registro!");
								}
							con.fecharBanco();
						} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Erro!!"+e.getMessage());
						e.printStackTrace();
						}
				
				}
					public void preencherTabela2(String hora){
						DefaultTableModel modelo = (DefaultTableModel)this.getModel();
						modelo.setNumRows(0);
						con = new Conexao();
							try {
								con.abrirBanco();
								String query = "SELECT a.cod_reserva, a.finalidade_reserva, a.data_reserva, a.hora_inicial, a.hora_final, a.cod_andar, a.cod_funcionario, b.cod_andar, b.nome, c.cod_sala, c.nome_sala, d.cod_funcionario, d.nome, d.sobrenome, d.setor, d.email, d.ramal FROM reserva a, andar b, sala c, funcionario d WHERE a.cod_andar = b.cod_andar AND b.cod_andar = c.cod_sala And a.cod_funcionario = d.cod_funcionario AND a.hora_inicial=?";
								con.st = con.con.prepareStatement(query);
								con.st.setString(1, hora);
								con.rs = con.st.executeQuery();
									if(con.rs.next()){
										do{
											modelo.addRow(new Object[]{con.rs.getObject("a.finalidade_reserva"),con.rs.getObject("a.data_reserva"),con.rs.getObject("a.hora_inicial"),con.rs.getObject("a.hora_final"),con.rs.getObject("b.nome"),con.rs.getObject("c.nome_sala"),con.rs.getObject("d.nome"),con.rs.getObject("d.sobrenome"),con.rs.getObject("d.setor"),con.rs.getObject("d.email"),con.rs.getObject("d.ramal")});
										}while(con.rs.next());
									}else{
										JOptionPane.showMessageDialog(null, "Não há nenhum registro!");
									}
								con.fecharBanco();
						
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Erro!!"+e.getMessage());
								e.printStackTrace();
							}
				
					}
				
}
