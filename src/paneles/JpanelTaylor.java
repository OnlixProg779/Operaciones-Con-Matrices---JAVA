package paneles;

import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

import controladorAlg.MatricesMetodos;
import controladorAlg.Resultado;

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

public class JpanelTaylor extends JPanel {
	private JTextField txtValorA;
	JScrollPane scrollPane_2;
	private JTextField txtIteraciones;
	double[][] matrizA;

	private JTextArea textArea;
	private JPanel panel_2;
	private JTextField txtFx;

	/**
	 * Create the panel.
	 */
	public void limpiar() {

		txtValorA.setText("");

		txtIteraciones.setText("");
		;
	}

	public JpanelTaylor() {
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
		txtIteraciones.setBounds(103, 108, 50, 30);
		panel_2.add(txtIteraciones);
		txtIteraciones.setColumns(10);

		txtValorA = new JTextField();
		txtValorA.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if(caracter >= '0' && caracter <= '9' || caracter =='.'|| caracter =='-') {
					
				}else {
					e.consume();
				}
			}
		});
		txtValorA.setBounds(103, 151, 50, 30);
		panel_2.add(txtValorA);
		txtValorA.setColumns(10);

		JLabel lblFx = new JLabel("F(x):");
		lblFx.setBounds(20, 72, 68, 14);
		panel_2.add(lblFx);
		lblFx.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFx.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnMult_Escalar = new JButton("Calcular");
		btnMult_Escalar.setIcon(new ImageIcon(JpanelTaylor.class.getResource("/wallpapers/Calculator_16xLG.png")));
		btnMult_Escalar.setBounds(502, 95, 166, 52);
		panel_2.add(btnMult_Escalar);

		btnMult_Escalar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String funcion = txtFx.getText();
					int iteracions = Integer.parseInt(txtIteraciones.getText());
					int a = Integer.parseInt(txtValorA.getText());

					textArea.setText(textArea.getText() + "\n\t\t\t" + "Serie De Taylor" + "\n\n\n"
							+ controladorAlg.AlgoritmosTaylor.taylor(funcion, iteracions, a));
				}

				catch (java.lang.NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Un caracter no es numerico", "AVISO",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnMult_Escalar.setToolTipText("Determinante");
		btnMult_Escalar.setFont(new Font("Tahoma", Font.BOLD, 14));

		txtFx = new JTextField();
		txtFx.setBounds(103, 61, 139, 36);
		panel_2.add(txtFx);
		txtFx.setColumns(10);

		JLabel lblSerieTaylor = new JLabel("Serie De Taylor");
		lblSerieTaylor.setHorizontalAlignment(SwingConstants.CENTER);
		lblSerieTaylor.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblSerieTaylor.setBounds(212, 0, 263, 36);
		panel_2.add(lblSerieTaylor);

		JLabel lbliteraciones = new JLabel("Iteraciones:");
		lbliteraciones.setHorizontalAlignment(SwingConstants.CENTER);
		lbliteraciones.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbliteraciones.setBounds(20, 116, 68, 14);
		panel_2.add(lbliteraciones);

		JLabel lblvalorA = new JLabel("Valor 'a':");
		lblvalorA.setHorizontalAlignment(SwingConstants.CENTER);
		lblvalorA.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblvalorA.setBounds(20, 159, 68, 14);
		panel_2.add(lblvalorA);

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
