import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Pesquisa extends JInternalFrame{ 
	JPanel painel = new JPanel();
	JPanel painel1 = new JPanel();
	JPanel painel2 = new JPanel();
	JPanel painel3 = new JPanel();
	JPanel painel4 = new JPanel();
	JPanel painel5 = new JPanel();
	
	JLabel sala = new JLabel("Sala");
	JLabel andar = new JLabel("Andar");
	JLabel hora = new JLabel("Hora Início");
	
	JComboBox box = new JComboBox();
	JComboBox box1 = new JComboBox();
	JComboBox box2 = new JComboBox();
	
	TitledBorder titulo = new TitledBorder("Resultado da Consulta");
	
	JTextArea texto = new JTextArea(18,75);
	
	Color Cor1 = new Color(112,128,144);
	Color Cor2 = new Color(147,112,219);
	Color Cor3 = new Color(238,238,224);
	Color Cor4 = new Color(85,26,139);
	DadosBanco pesq;
	Tabela tb;
	String tempo;
	int sa;
	
	public Pesquisa(){
		
		ImageIcon img4 = new ImageIcon(getClass().getResource("Imagem/LOGO1.jpg"));
		this.setTitle("Consulta");
		this.setFrameIcon(img4);
		this.setSize(1020, 700);
		this.setLocation(210, 40);
		this.setClosable(true);
		this.setIconifiable(false);
		this.add(painel5,BorderLayout.SOUTH);
		this.add(painel4,BorderLayout.NORTH);
		this.add(painel,BorderLayout.WEST);
		this.add(painel2,BorderLayout.CENTER);
		this.add(painel3,BorderLayout.EAST);
		
		JButton ok = new JButton();   
        ImageIcon img = new ImageIcon(getClass().getResource("Imagem/OK1.png"));   
        ok.setIcon(img);   
        ok.setBackground(Cor3);
        ok.setPreferredSize(new Dimension(60,60));
		ok.setFocusPainted(false);
		ok.setBorderPainted(false);
		ok.setToolTipText("Confirmar Pesquisa");
		
		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
						if(box.getSelectedItem()==null && box1.getSelectedItem()==null && box2.getSelectedItem()==null){
							JOptionPane.showMessageDialog(null, "Nenhum item selecionado!");
						}else if(box.getSelectedIndex()>0 && box1.getSelectedIndex()<=0){
							JOptionPane.showMessageDialog(null, "Item do Campo Sala não selecionado!");
						}else if(box.getSelectedIndex()> 0 && box1.getSelectedIndex()> 0){
							if(box1.getSelectedItem()=="Salas"){
								tb.preencherTabela();
							}else if(box.getSelectedIndex()== 1 && box1.getSelectedIndex()==2){
								sa = 1;
								tb.preencherTabela1(sa);
							}else if(box.getSelectedIndex()== 1 && box1.getSelectedIndex()==3){
								sa = 2;
								tb.preencherTabela1(sa);
							}else if(box.getSelectedIndex()== 1 && box1.getSelectedIndex()==4){
								sa = 3;
								tb.preencherTabela1(sa);
							}else if(box.getSelectedIndex()== 1 && box1.getSelectedIndex()==5){
								sa = 4;
								tb.preencherTabela1(sa);
							}else if(box.getSelectedIndex()== 2 && box1.getSelectedIndex()==2){
								sa = 5;
								tb.preencherTabela1(sa);
							}else if(box.getSelectedIndex()== 2 && box1.getSelectedIndex()==3){
								sa = 6;
								tb.preencherTabela1(sa);
							}else if(box.getSelectedIndex()== 2 && box1.getSelectedIndex()==4){
								sa = 7;
								tb.preencherTabela1(sa);
							}else if(box.getSelectedIndex()== 3 && box1.getSelectedIndex()==2){
								sa = 8;
								tb.preencherTabela1(sa);
							}else if(box.getSelectedIndex()== 3 && box1.getSelectedIndex()==3){
								sa = 9;
								tb.preencherTabela1(sa);
							}else if(box.getSelectedIndex()== 4 && box1.getSelectedIndex()==2){
								sa = 10;
								tb.preencherTabela1(sa);
							}else if(box.getSelectedIndex()== 4 && box1.getSelectedIndex()==3){
								sa = 11;
								tb.preencherTabela1(sa);
							}else if(box.getSelectedIndex()== 5 && box1.getSelectedIndex()==2){
								sa = 12;
								tb.preencherTabela1(sa);
							}else if(box.getSelectedIndex()== 5 && box1.getSelectedIndex()==3){
								sa = 13;
								tb.preencherTabela1(sa);
							}else if(box.getSelectedIndex()== 6 && box1.getSelectedIndex()==2){
								sa = 14;
								tb.preencherTabela1(sa);
							}else if(box.getSelectedIndex()== 6 && box1.getSelectedIndex()==3){
								sa = 15;
								tb.preencherTabela1(sa);
							}
						}else if(box2.getSelectedIndex()> 0){
							tempo = (String) box2.getSelectedItem(); 
							tb.preencherTabela2(tempo);
						}

					

				
					
			}

			

		});
        
        JButton cancel = new JButton();   
        ImageIcon img1 = new ImageIcon(getClass().getResource("Imagem/sair5.png"));   
        cancel.setIcon(img1);   
        cancel.setBackground(Cor3);
        cancel.setPreferredSize(new Dimension(60,60));
		cancel.setFocusPainted(false);
		cancel.setBorderPainted(false);
		cancel.setToolTipText("Sair da Pesquisa");
		
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int s = JOptionPane.showConfirmDialog(null, "Deseja realmente sair da pesquisa?","Sair",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					if(s == JOptionPane.YES_OPTION){
						dispose();
					}
			}

			});
		
		JLabel figura = new JLabel();
		ImageIcon img2 = new ImageIcon(getClass().getResource("Imagem/pesquisa3.png"));
		figura.setIcon(img2);
		figura.setBorder(new BevelBorder(BevelBorder.LOWERED));
			
			box.addItem(null);
		for (int i = 4; i < 10; i++){
			box.addItem(i);
		}
			box2.addItem(null);
		for (int i = 6; i < 23; i++){
			box2.addItem(i+":00");
		}
		box.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == box){
				if(box.getSelectedItem()== null){
					box2.setEnabled(true);
				}else if(box.getSelectedIndex()> 0){
					box2.setEnabled(false);
				}
				if(box.getSelectedIndex() == 1){
					remover();
					box1.addItem(null);
					box1.addItem("Salas");
					for (int i = 1; i < 5; i++){
						box1.addItem(i);
					}
				}
				if(box.getSelectedIndex() == 2){
					remover();
					box1.addItem(null);
					box1.addItem("Salas");
					for (int i = 5; i < 8; i++){
						box1.addItem(i);
					}
				}
				if(box.getSelectedIndex() == 3){
					remover();
					box1.addItem(null);
					box1.addItem("Salas");
					for (int i = 8; i < 10; i++){
						box1.addItem(i);
					}
				}
				if(box.getSelectedIndex() == 4){
					remover();
					box1.addItem(null);
					box1.addItem("Salas");
					for (int i = 10; i < 12; i++){
						box1.addItem(i);
					}
				}
				if(box.getSelectedIndex() == 5){
					remover();
					box1.addItem(null);
					box1.addItem("Salas");
					for (int i = 12; i < 14; i++){
						box1.addItem(i);
					}
				}
				if(box.getSelectedIndex() == 6){
					remover();
					box1.addItem(null);
					box1.addItem("Salas");
					for (int i = 14; i < 16; i++){
						box1.addItem(i);
					}
				}
				}
	
			}

			
			

		});
		box2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
					if(box2.getSelectedItem()== null){
						box.setEnabled(true);
						box1.setEnabled(true);
					}else if(box2.getSelectedIndex()> 0){
						box.setEnabled(false);
						box1.setEnabled(false);
					}


			}

		});
		
		painel.setBackground(Cor3);
		painel.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0,Cor2));
		painel.setLayout(new FlowLayout(FlowLayout.LEADING));
		painel.setLayout(new GridLayout(2,0));
		
		tb = new Tabela();
		painel2.setBackground(Cor3);
		painel2.setPreferredSize(new Dimension(530,900));
		painel2.setBorder(titulo);
		painel2.add(new JScrollPane(tb));
		
		painel3.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 5,Cor2));
		painel3.setBackground(Cor3);
		
		painel4.add(figura);
		painel4.setBackground(Cor3);
		painel4.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		painel4.setBorder(BorderFactory.createMatteBorder(5, 5, 0, 5,Cor2));
		painel4.add(andar);
		painel4.add(box);
		painel4.add(sala);
		painel4.add(box1);
		painel4.add(hora);
		painel4.add(box2);
		painel4.add(ok);
		painel4.add(cancel);
		
		painel5.setBackground(Cor3);
		painel5.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
		painel5.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 5,Cor2));
		
		titulo.setTitleFont(new Font("tahoma", Font.BOLD, 14));
		titulo.setTitleColor(Cor4);
		titulo.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,Color.BLUE));
		
		sala.setForeground(Cor4);
		andar.setForeground(Cor4);
		hora.setForeground(Cor4);
		
	}
	
	public void setPosição(){
		Dimension d = this.getDesktopPane().getSize();
		this.setLocation((d.width - this.getSize().width)/2, (d.height - this.getSize().height)/2);
	}
	private void remover() {
		if(box1 != null)
		box1.removeAllItems();
	}
	private void remover1() {
		if(box != null && box1 != null)
		box.removeAllItems();
	}
	
	
}
