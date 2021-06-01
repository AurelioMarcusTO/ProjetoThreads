package cursojava.thread2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaTimeThread extends JDialog {
	

	private JPanel jpanel = new JPanel(new GridBagLayout());/* Painel de componentes */

	private JLabel descricaoHora = new JLabel("Coloque o Nome");
	private JTextField mostraTempo = new JTextField();
	
	private JLabel descricaoHora2 = new JLabel("Coloque o E-mail");
	private JTextField mostraTempo2 = new JTextField();
	
	private JButton jbutton = new JButton("Add Lista");
	private JButton jbutton2 = new JButton("Stop");
	
	private ImplementacaoFilaThread fila = new ImplementacaoFilaThread();
	
	
	public TelaTimeThread() {/* Executa o que tiver dentro no momento da abertura ou execucao */
		setTitle("Minha tela de time com Thread");
		setSize(new Dimension(240, 240));
		setLocationRelativeTo(null);
		setResizable(false);
		/* Primeira parte concluida */

		GridBagConstraints gridBagConstraints = new GridBagConstraints();/*Controlador de posicionamento de componentes*/
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.insets = new Insets(5, 10, 5, 5);
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		
		descricaoHora.setPreferredSize(new Dimension(200, 25));
		jpanel.add(descricaoHora, gridBagConstraints);
		
		mostraTempo.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy ++;
		jpanel.add(mostraTempo, gridBagConstraints);
		
		descricaoHora2.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy ++;
		jpanel.add(descricaoHora2, gridBagConstraints);
		
		mostraTempo2.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy ++;
		jpanel.add(mostraTempo2, gridBagConstraints);
		
		gridBagConstraints.gridwidth = 1;
		
		jbutton.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridy ++;
		jpanel.add(jbutton, gridBagConstraints);
		
		jbutton2.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridx ++;
		jpanel.add(jbutton2, gridBagConstraints);
		
		jbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) { /*Executa o clique no botão*/
				
				if (fila == null) {
					
					fila = new ImplementacaoFilaThread();
					fila.start();
					
				}
				
				ObjetoFilaThread filaThread = new ObjetoFilaThread();
				filaThread.setNome(mostraTempo.getText());
				filaThread.setEmail(mostraTempo2.getText());
				
				fila.add(filaThread);
								
			}
		});
		
		jbutton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				fila.stop();
				fila = null;
				
			}
		});
		
				
		fila.start();
		add(jpanel, BorderLayout.WEST);
		/* Sempre sera o ultimo comando */
		setVisible(true);/* Torna a tela visivel para o usuario */

	}

}
