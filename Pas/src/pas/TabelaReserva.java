import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TabelaReserva extends JTable{
	Conexao con;
	Color Cor2 = new Color(147, 112, 219);
	DadosBanco apagar;
	
	public TabelaReserva(){
		criarTabela();
	
	}

	private void criarTabela() {
		this.setModel(new DefaultTableModel(
			new Object[][]{
					{null,null,null,null,null,null,null}
			}, new String[]{"Código Reserva","Finalidade","Data","Hora Inicial","Hora Final","Andar","Sala","Nome","Sobrenome","Setor","E-mail","Ramal"} 
			));
			this.setPreferredScrollableViewportSize(new Dimension(960,380));
			this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			this.setRowHeight(30);
			this.getColumnModel().getColumn(0).setPreferredWidth(50);
			this.getColumnModel().getColumn(1).setPreferredWidth(130);
			this.getColumnModel().getColumn(2).setPreferredWidth(85);
			this.getColumnModel().getColumn(3).setPreferredWidth(80);
			this.getColumnModel().getColumn(4).setPreferredWidth(80);
			this.getColumnModel().getColumn(5).setPreferredWidth(50);
			this.getColumnModel().getColumn(6).setPreferredWidth(40);
			this.getColumnModel().getColumn(7).setPreferredWidth(110);
			this.getColumnModel().getColumn(8).setPreferredWidth(210);
			this.getColumnModel().getColumn(9).setPreferredWidth(140);
			this.getColumnModel().getColumn(10).setPreferredWidth(210);
			this.getColumnModel().getColumn(11).setPreferredWidth(50);
			this.setBorder(BorderFactory.createEtchedBorder(1));

	}
	
		public void preencherTabela(String no) {
			DefaultTableModel modelo = (DefaultTableModel)this.getModel();
			modelo.setNumRows(0);
			con = new Conexao();
			
				try {
					
					con.abrirBanco();
					String query = "SELECT a.cod_reserva, a.finalidade_reserva, a.data_reserva, a.hora_inicial, a.hora_final, a.cod_andar, a.cod_funcionario, b.cod_andar, b.nome, c.cod_sala, c.nome_sala, d.cod_funcionario, d.nome, d.sobrenome, d.setor, d.email, d.ramal FROM reserva a, andar b, sala c, funcionario d WHERE a.cod_andar = b.cod_andar AND b.cod_andar = c.cod_sala AND a.cod_funcionario = d.cod_funcionario AND d.senha=?";
					con.st = con.con.prepareStatement(query);
					con.st.setString(1, no);
					con.rs = con.st.executeQuery();
					if(con.rs.next()){
						do{
							modelo.addRow(new Object[]{con.rs.getObject("a.cod_reserva"),con.rs.getObject("a.finalidade_reserva"),con.rs.getObject("a.data_reserva"),con.rs.getObject("a.hora_inicial"),con.rs.getObject("a.hora_final"),con.rs.getObject("b.nome"),con.rs.getObject("c.nome_sala"),con.rs.getObject("d.nome"),con.rs.getObject("d.sobrenome"),con.rs.getObject("d.setor"),con.rs.getObject("d.email"),con.rs.getObject("d.ramal")});
						}while(con.rs.next());
						JPanel pa = new JPanel();
						pa.add(new JScrollPane(this));
						int s = JOptionPane.showConfirmDialog(null,pa,"Cancelar Reserva",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
						if(s == JOptionPane.OK_OPTION){
							int cod = this.getSelectedRow();
							if(cod < 0){
								JOptionPane.showMessageDialog(null, "Registro não selecionado!");
							}else{
								 cod = (Integer) this.getValueAt(this.getSelectedRow(),0);
							apagar = new DadosBanco();
							apagar.apagarReserva(cod);
							JOptionPane.showMessageDialog(null, "Angendamento cancelado com sucesso!");
							}
						}
						
					}else{
						JOptionPane.showMessageDialog(null, "Não há registro para essa senha");
					}
						
					con.fecharBanco();
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro!!"+e.getMessage());
					e.printStackTrace();
				}
		}
					
				
				
}
