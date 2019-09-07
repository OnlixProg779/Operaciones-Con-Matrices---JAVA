package paneles;

import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

import org.lsmp.djep.xjep.function.Simpson;

import controladorAlg.Funcion;
import controladorAlg.MatricesMetodos;
import controladorAlg.Resultado;
import controladorAlg.RungeKutta;
import controladorAlg.Simpson_;
import controladorAlg.Trapecio;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JpanelNewtonCotes extends JPanel {
	private JTextField txtMax;
	JScrollPane scrollPane_2;
	private JTextField txtMinimo;
	double[][] matrizA;

	private JTextArea textArea;
	private JPanel panel_2;
	private JTextField txtFx;
	private JCheckBox chckbxUsarFracciones;
	private JTextField txtIteraciones;

	/**
	 * Create the panel.
	 */
	public void limpiar() {

		txtMax.setText("");

		txtMinimo.setText("");
		;
	}

	public JpanelNewtonCotes() {
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

		txtMinimo = new JTextField();
		txtMinimo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if(caracter >= '0' && caracter <= '9' || caracter =='.'|| caracter =='-') {
					
				}else {
					e.consume();
				}
			}
		});
		txtMinimo.setBounds(136, 108, 50, 30);
		panel_2.add(txtMinimo);
		txtMinimo.setColumns(10);

		txtMax = new JTextField();
		txtMax.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if(caracter >= '0' && caracter <= '9' || caracter =='.'|| caracter =='-') {
					
				}else {
					e.consume();
				}
			}
		});
		txtMax.setBounds(136, 151, 50, 30);
		panel_2.add(txtMax);
		txtMax.setColumns(10);

		JLabel lblFx = new JLabel("Funci\u00F3n:");
		lblFx.setBounds(10, 72, 111, 14);
		panel_2.add(lblFx);
		lblFx.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFx.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setIcon(new ImageIcon(JpanelNewtonCotes.class.getResource("/wallpapers/Calculator_16xLG.png")));
		btnCalcular.setBounds(502, 95, 166, 52);
		panel_2.add(btnCalcular);

		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("");
				
				try {
					String funcionIng = txtFx.getText();
					double x0 = Double.parseDouble(txtMinimo.getText());
					double xn = Double.parseDouble(txtMax.getText());
					
					int n = Integer.parseInt(txtIteraciones.getText());
					
					final Trapecio metodoTrapecio = new Trapecio();
					final Simpson_ metodoSimpson = new Simpson_();
					String mostrar = "";
					Funcion funcion = new Funcion(funcionIng);
					
					
					mostrar += "\n\t\t\t" + "Metodo de Newton-Cotes";
					
					
					metodoTrapecio.fraccion = chckbxUsarFracciones.isSelected();
					
					mostrar += ("\n");
					mostrar += ("Funcion: [" + funcion.toString() + "]\n");

					mostrar += ("x0: " + x0 + "\n");
					mostrar += ("xn: " + xn + "\n");
					mostrar += (" n: " + n + "\n");

					mostrar += (metodoTrapecio.evaluar(funcion, x0, xn, n));
					double h = (xn - x0) / n;
					

					mostrar += "\n\t\t\t" + "Metodo de Simpson";
					metodoSimpson.fraccion = chckbxUsarFracciones.isSelected();
					
					
					
					mostrar += ("\n");
					mostrar += ("Funcion: [" + funcion.toString() + "]\n");

					mostrar += ("x0: " + x0 + "\n");
					mostrar += ("xn: " + xn + "\n");
					mostrar += (" n: " + n + "\n");

					mostrar += (metodoSimpson.evaluar(funcion, x0, xn, n));
					 h = (xn - x0) / n;
					

					textArea.setText(textArea.getText() 	+ mostrar);
				}

				catch (java.lang.NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Un caracter no es numerico", "AVISO",
							JOptionPane.INFORMATION_MESSAGE);
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

		JLabel lblSerieTaylor = new JLabel("Newton-Cotes");
		lblSerieTaylor.setHorizontalAlignment(SwingConstants.CENTER);
		lblSerieTaylor.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblSerieTaylor.setBounds(236, 0, 263, 36);
		panel_2.add(lblSerieTaylor);

		JLabel lblXInicial = new JLabel("Valor Minimo:");
		lblXInicial.setHorizontalAlignment(SwingConstants.CENTER);
		lblXInicial.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblXInicial.setBounds(10, 116, 111, 14);
		panel_2.add(lblXInicial);

		JLabel lblXFinal = new JLabel("Valor Maximo:");
		lblXFinal.setHorizontalAlignment(SwingConstants.CENTER);
		lblXFinal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblXFinal.setBounds(10, 159, 111, 14);
		panel_2.add(lblXFinal);
		
		chckbxUsarFracciones = new JCheckBox("Usar Fracciones");
		chckbxUsarFracciones.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxUsarFracciones.setBounds(206, 155, 121, 23);
		panel_2.add(chckbxUsarFracciones);
		
		txtIteraciones = new JTextField();
		txtIteraciones.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if(caracter >= '0' && caracter <= '9' || caracter =='.'|| caracter =='-') {
					
				}else {
					e.consume();
				}
			}
		});
		txtIteraciones.setColumns(10);
		txtIteraciones.setBounds(136, 192, 50, 30);
		panel_2.add(txtIteraciones);
		
		JLabel lblN = new JLabel("n Iteraciones:");
		lblN.setHorizontalAlignment(SwingConstants.CENTER);
		lblN.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblN.setBounds(10, 200, 111, 14);
		panel_2.add(lblN);

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
	}
}
