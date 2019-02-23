package interfaz;


import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

import matrices.MatricesMetodos;
import matrices.Resultado;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

public class JpanelDeterminante extends JPanel {
	private JTextField textField_1;
	JScrollPane scrollPane_2;
	private JTextField textField_2;
	double[][] matrizA;
	
	
	private JTextArea textArea;
	private JPanel panel_2;
	private JTextField textFieldResutado;
	private JpanelMatrizA Jpanel_1;
	private JCheckBox chckbxPorSarrus;
	
	/**
	 * Create the panel.
	 */
	public void limpiar() {
		
		textField_1.setText("");
		Jpanel_1=null;
		textField_2.setText("");;
	}
	
	public JpanelDeterminante() {
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
		
				textField_2 = new JTextField();
				textField_2.setBounds(69, 227, 44, 20);
				panel_2.add(textField_2);
				textField_2.setColumns(10);
				
				textField_1 = new JTextField();
				textField_1.setVisible(false);
				textField_1.setBounds(20, 227, 44, 20);
				panel_2.add(textField_1);
				textField_1.setColumns(10);
				
						JButton btnCrear = new JButton("Redimensionar");
						btnCrear.setBounds(123, 226, 118, 23);
						panel_2.add(btnCrear);
						
						JLabel lblDeterminante = new JLabel("Determinante");
						lblDeterminante.setBounds(495, 96, 111, 14);
						panel_2.add(lblDeterminante);
						lblDeterminante.setFont(new Font("Tahoma", Font.BOLD, 11));
						lblDeterminante.setHorizontalAlignment(SwingConstants.CENTER);
						
								JButton btnMult_Escalar = new JButton("=");
								btnMult_Escalar.setBounds(383, 117, 52, 52);
								panel_2.add(btnMult_Escalar);
								
								btnMult_Escalar.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
										try {
										Resultado resul= new Resultado(null, "",null);
										matrizA = null;
										matrizA = MatricesMetodos.insertarEnMatriz(Jpanel_1.textFieldMatriz, Integer.parseInt(textField_1.getText()), Integer.parseInt(textField_1.getText()));
										MatricesMetodos.DeterminanteConPasos(0, matrizA, "", resul);
										

										textArea.setText("Proceso \n" + resul.getPasos());
										double result = MatricesMetodos.Determinante(0, matrizA, "");
										textFieldResutado.setText(String.valueOf(result));
										if(chckbxPorSarrus.isSelected()&&textField_2.getText().equals("3")) {

										textArea.setText(	textArea.getText()+"\n\n\n\n\n\n\n"+"Determinante por Sarrus"+"\n\n\n\n"+MatricesMetodos.calcularDeterminantePorSarrus(matrizA, 3));
										}
										}
										catch(java.lang.NumberFormatException e) {
											JOptionPane.showMessageDialog(null, "Un caracter no es numerico", "AVISO", JOptionPane.INFORMATION_MESSAGE);
										}
									}
								});
								btnMult_Escalar.setToolTipText("Determinante");
								btnMult_Escalar.setFont(new Font("Tahoma", Font.BOLD, 14));
								
								textFieldResutado = new JTextField();
								textFieldResutado.setBounds(495, 132, 111, 23);
								panel_2.add(textFieldResutado);
								textFieldResutado.setColumns(10);
								
								JScrollPane scrollPane_3 = new JScrollPane();
								scrollPane_3.setBounds(10, 40, 305, 175);
								panel_2.add(scrollPane_3);
								
								Jpanel_1 = new JpanelMatrizA();
								scrollPane_3.setViewportView(Jpanel_1);
								
								JLabel lblDeterminanteDeUna = new JLabel("Determinante de una Matriz");
								lblDeterminanteDeUna.setHorizontalAlignment(SwingConstants.CENTER);
								lblDeterminanteDeUna.setFont(new Font("Sitka Text", Font.BOLD, 16));
								lblDeterminanteDeUna.setBounds(212, 0, 263, 36);
								panel_2.add(lblDeterminanteDeUna);
								
								chckbxPorSarrus = new JCheckBox("Por Sarrus");
								chckbxPorSarrus.setBounds(446, 46, 97, 23);
								panel_2.add(chckbxPorSarrus);
								btnCrear.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
										int a = Integer.parseInt(textField_2.getText());
										int b = a;
										textField_1.setText(String.valueOf(a));
										Jpanel_1 = null;
										Jpanel_1 = new JpanelMatrizA(a, b);
										scrollPane_3.setViewportView(Jpanel_1);
										
										panel_2.setVisible(true);
									}
								});
		
		
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
