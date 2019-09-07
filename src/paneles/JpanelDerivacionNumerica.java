package paneles;

import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

import controladorAlg.Adelantadas;
import controladorAlg.Centradas;
import controladorAlg.Retrasadas;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JpanelDerivacionNumerica extends JPanel {
	JScrollPane scrollPane_2;
	private JTextField txtXInicial;
	double[][] matrizA;

	private JTextArea textArea;
	private JPanel panel_2;
	private JTextField txtFx;
	private JTextField txth;
	private ButtonGroup grupo;
	private JRadioButton rdbtnFormulaProgresiva;
	private JRadioButton rdbtnFormulaRegresiva;
	private JRadioButton rdbtnFormulaCentral;

	/**
	 * Create the panel.
	 */
	public void limpiar() {

txtFx.setText("");
txth.setText("");
		txtXInicial.setText("");
		;
	}

	public JpanelDerivacionNumerica() {
		setBackground(SystemColor.inactiveCaptionBorder);
		setBorder(new LineBorder(SystemColor.activeCaption, 2));

		this.setSize(747, 669);

		setLayout(null);

		panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 727, 259);
		add(panel_2);
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBackground(SystemColor.inactiveCaption);
		panel_2.setLayout(null);

		txtXInicial = new JTextField();
		txtXInicial.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				char caracter = arg0.getKeyChar();
				if(caracter >= '0' && caracter <= '9' || caracter =='.'|| caracter =='-') {
					
				}else {
					arg0.consume();
				}
			
			}
		});
		txtXInicial.setBounds(136, 108, 50, 30);
		panel_2.add(txtXInicial);
		txtXInicial.setColumns(10);

		JLabel lblFx = new JLabel("Funci\u00F3n:");
		lblFx.setBounds(10, 72, 111, 14);
		panel_2.add(lblFx);
		lblFx.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFx.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setIcon(new ImageIcon(JpanelDerivacionNumerica.class.getResource("/wallpapers/Calculator_16xLG.png")));
		btnCalcular.setBounds(502, 95, 166, 52);
		panel_2.add(btnCalcular);

		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			if(rdbtnFormulaRegresiva.isSelected()) {
				textArea.setText("FORMULAS REGRESIVAS");
				formulasRetrasadas();
			}else if(rdbtnFormulaProgresiva.isSelected()) {
				textArea.setText("FORMULAS PROGRESIVAS");
				formulasProgresivas();
			}else if(rdbtnFormulaCentral.isSelected()){
				textArea.setText("FORMULAS CENTRADAS");
				formulasCentradas();
			}else {
				JOptionPane.showMessageDialog(null, "Ingrese el tipo de formulas a utilizar");
			}
			
			}
		});
		btnCalcular.setToolTipText("Calcular Runge Kutta");
		btnCalcular.setFont(new Font("Tahoma", Font.BOLD, 14));

		txtFx = new JTextField();
		txtFx.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if(caracter >= '0' && caracter <= '9' || caracter =='.'|| caracter =='-'||caracter =='x'||caracter =='('||caracter ==')'||caracter =='^'||caracter =='*'||caracter =='/'
						||caracter =='s'||caracter =='i'||caracter =='n'||caracter =='l'||caracter =='o'||caracter =='g'
						||caracter =='c'||caracter =='t'||caracter =='a'||caracter =='n'||caracter =='g'||caracter =='r'||caracter =='q'
						) {
					
				}else {
					e.consume();
				}
			}
		});
		txtFx.setBounds(136, 61, 191, 36);
		panel_2.add(txtFx);
		txtFx.setColumns(10);

		JLabel lblSerieTaylor = new JLabel("Derivacion Numerica");
		lblSerieTaylor.setHorizontalAlignment(SwingConstants.CENTER);
		lblSerieTaylor.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblSerieTaylor.setBounds(236, 0, 263, 36);
		panel_2.add(lblSerieTaylor);

		JLabel lblXInicial = new JLabel("X Inicial:");
		lblXInicial.setHorizontalAlignment(SwingConstants.CENTER);
		lblXInicial.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblXInicial.setBounds(10, 116, 111, 14);
		panel_2.add(lblXInicial);
		
		JLabel lblh = new JLabel("h:");
		lblh.setHorizontalAlignment(SwingConstants.CENTER);
		lblh.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblh.setBounds(10, 157, 111, 14);
		panel_2.add(lblh);
		
		txth = new JTextField();
		txth.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char caracter = arg0.getKeyChar();
				if(caracter >= '0' && caracter <= '9' || caracter =='.'|| caracter =='-') {
					
				}else {
					arg0.consume();
				}
			}
		});
		txth.setColumns(10);
		txth.setBounds(136, 149, 50, 30);
		panel_2.add(txth);
		
		rdbtnFormulaProgresiva = new JRadioButton("Formula Progresiva");
		rdbtnFormulaProgresiva.setBounds(98, 215, 140, 23);
		panel_2.add(rdbtnFormulaProgresiva);
		
		rdbtnFormulaRegresiva = new JRadioButton("Formula Regresiva");
		rdbtnFormulaRegresiva.setBounds(295, 215, 140, 23);
		panel_2.add(rdbtnFormulaRegresiva);
		
		rdbtnFormulaCentral = new JRadioButton("Formula Central");
		rdbtnFormulaCentral.setBounds(496, 215, 140, 23);
		panel_2.add(rdbtnFormulaCentral);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 281, 727, 377);
		add(scrollPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 705, 353);
		panel_1.add(scrollPane_1);

		textArea = new JTextArea();

		scrollPane_1.setViewportView(textArea);

		setVisible(false);
		grupo = new ButtonGroup();
		grupo.add(rdbtnFormulaCentral);
		grupo.add(rdbtnFormulaRegresiva);
		grupo.add(rdbtnFormulaProgresiva);
	}
	
	private void formulasProgresivas() {
		String funcionIng = txtFx.getText();
		double x0 = Double.parseDouble(txtXInicial.getText());
		double h = Double.parseDouble(txth.getText());
		
		final Adelantadas metodo = new Adelantadas();
	
		Adelantadas.cadena=   "********************** FUNCIÓN **********************\n";
          
		Adelantadas.cadena = Adelantadas.cadena + "f :  "+funcionIng + "\n\t Puntos:     ( x=" + x0 + "\t h=" + h + " )\n";
          
		Adelantadas.cadena = Adelantadas.cadena +   "********************** Primera Derivada **********************\n";
          
            metodo.primeraDerivada(funcionIng, x0, h);
                    		
            Adelantadas.cadena = Adelantadas.cadena +   "********************** Segunda Derivada **********************\n";
                    metodo.segundaDerivada(funcionIng, x0, h);
                    
                    Adelantadas.cadena = Adelantadas.cadena +   "********************** Tercera Derivada **********************\n";
                    metodo.terceraDerivada(funcionIng, x0, h);

		textArea.setText(textArea.getText() + "\n\t\t\t" + "Metodo Formulas Progresivas" + "\n\n\n"
				+ Adelantadas.cadena);
	}
	
	private void formulasCentradas() {
		String funcionIng = txtFx.getText();
		double x0 = Double.parseDouble(txtXInicial.getText());
		double h = Double.parseDouble(txth.getText());
		
		final Centradas metodo = new Centradas();
		
		String mostrar = metodo.mostar(funcionIng, x0, h);
		
		textArea.setText(textArea.getText() + "\n\t\t\t" + "Metodo Formulas Centradas" + "\n\n\n"
				+ mostrar);
		
	}
	
	private void formulasRetrasadas() {
		try {
			String funcionIng = txtFx.getText();
			double x0 = Double.parseDouble(txtXInicial.getText());
			double h = Double.parseDouble(txth.getText());
			
			final Retrasadas metodo = new Retrasadas();
		
			 Retrasadas.cadena=   "********************** FUNCIÓN **********************\n";
	          
	            Retrasadas.cadena = Retrasadas.cadena + "f :  "+funcionIng + "\n\t Puntos:     ( x=" + x0 + "\t h=" + h + " )\n";
	          
	            Retrasadas.cadena = Retrasadas.cadena +   "********************** Primera Derivada **********************\n";
	          
	            metodo.primeraDerivada(funcionIng, x0, h);
	                    		
	                    Retrasadas.cadena = Retrasadas.cadena +   "********************** Segunda Derivada **********************\n";
	                    metodo.segundaDerivada(funcionIng, x0, h);
	                    
	                    Retrasadas.cadena = Retrasadas.cadena +   "********************** Tercera Derivada **********************\n";
	                    metodo.terceraDerivada(funcionIng, x0, h);

			textArea.setText(textArea.getText() + "\n\t\t\t" + "Metodo Formulas Regresivas" + "\n\n\n"
					+ Retrasadas.cadena);
		}

		catch (java.lang.NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Un caracter no es numerico", "AVISO",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
