package paneles;

import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

import controladorAlg.Funcion;
import controladorAlg.MatricesMetodos;
import controladorAlg.Resultado;
import controladorAlg.RungeKutta;

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

public class JpanelRungeKutta extends JPanel {
	private JTextField txtXFinal;
	JScrollPane scrollPane_2;
	private JTextField txtXInicial;
	double[][] matrizA;

	private JTextArea textArea;
	private JPanel panel_2;
	private JTextField txtFx;
	private JTextField txtYInicial;
	private JLabel lblEspacioH;
	private JCheckBox chckbxUsarFracciones;
	private JTextField txtIteraciones;

	/**
	 * Create the panel.
	 */
	public void limpiar() {

		txtXFinal.setText("");

		txtXInicial.setText("");
		;
	}

	public JpanelRungeKutta() {
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
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if(caracter >= '0' && caracter <= '9' || caracter =='.'|| caracter =='-') {
					
				}else {
					e.consume();
				}
			}
		});
		txtXInicial.setBounds(136, 108, 50, 30);
		panel_2.add(txtXInicial);
		txtXInicial.setColumns(10);

		txtXFinal = new JTextField();
		txtXFinal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if(caracter >= '0' && caracter <= '9' || caracter =='.'|| caracter =='-') {
					
				}else {
					e.consume();
				}
			}
		});
		txtXFinal.setBounds(136, 151, 50, 30);
		panel_2.add(txtXFinal);
		txtXFinal.setColumns(10);

		JLabel lblFx = new JLabel("Funci\u00F3n:");
		lblFx.setBounds(10, 72, 111, 14);
		panel_2.add(lblFx);
		lblFx.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFx.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setIcon(new ImageIcon(JpanelRungeKutta.class.getResource("/wallpapers/Calculator_16xLG.png")));
		btnCalcular.setBounds(502, 95, 166, 52);
		panel_2.add(btnCalcular);

		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String funcionIng = txtFx.getText();
					double x0 = Double.parseDouble(txtXInicial.getText());
					double y0 = Double.parseDouble(txtYInicial.getText());
					double xn = Double.parseDouble(txtXFinal.getText());
					
					int n = Integer.parseInt(txtIteraciones.getText());
					
					final RungeKutta metodo = new RungeKutta();
					String mostrar = "";
					Funcion funcion = new Funcion(funcionIng);
					
					
					metodo.fraccion = chckbxUsarFracciones.isSelected();
					
					mostrar += ("\n");
					mostrar += ("Funcion: [" + funcion.toString() + "]\n");

					mostrar += ("x0: " + x0 + "\n");
					mostrar += ("y0: " + y0 + "\n");
					mostrar += ("xn: " + xn + "\n");
					mostrar += (" n: " + n + "\n");

					mostrar += (metodo.evaluar(funcion, x0, y0, xn, n));
					double h = (xn - x0) / n;
					lblEspacioH.setText(String.valueOf(h));

					textArea.setText(textArea.getText() + "\n\t\t\t" + "Metodo de Runge Kutta" + "\n\n\n"
							+ mostrar);
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

		JLabel lblSerieTaylor = new JLabel("Runge Kutta");
		lblSerieTaylor.setHorizontalAlignment(SwingConstants.CENTER);
		lblSerieTaylor.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblSerieTaylor.setBounds(236, 0, 263, 36);
		panel_2.add(lblSerieTaylor);

		JLabel lblXInicial = new JLabel("X Inicial:");
		lblXInicial.setHorizontalAlignment(SwingConstants.CENTER);
		lblXInicial.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblXInicial.setBounds(10, 116, 111, 14);
		panel_2.add(lblXInicial);

		JLabel lblXFinal = new JLabel("X Final:");
		lblXFinal.setHorizontalAlignment(SwingConstants.CENTER);
		lblXFinal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblXFinal.setBounds(10, 159, 111, 14);
		panel_2.add(lblXFinal);
		
		JLabel lblYFinal = new JLabel("Y Inicial:");
		lblYFinal.setHorizontalAlignment(SwingConstants.CENTER);
		lblYFinal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblYFinal.setBounds(196, 116, 68, 14);
		panel_2.add(lblYFinal);
		
		txtYInicial = new JTextField();
		txtYInicial.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if(caracter >= '0' && caracter <= '9' || caracter =='.'|| caracter =='-') {
					
				}else {
					e.consume();
				}
			}
		});
		txtYInicial.setColumns(10);
		txtYInicial.setBounds(279, 108, 50, 30);
		panel_2.add(txtYInicial);
		
		JLabel lblH = new JLabel("h = ");
		lblH.setHorizontalAlignment(SwingConstants.CENTER);
		lblH.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblH.setBounds(10, 233, 108, 14);
		panel_2.add(lblH);
		
		lblEspacioH = new JLabel("***");
		lblEspacioH.setBounds(146, 234, 46, 14);
		panel_2.add(lblEspacioH);
		
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
