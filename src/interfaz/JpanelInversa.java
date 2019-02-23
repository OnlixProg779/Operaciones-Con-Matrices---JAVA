package interfaz;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import matrices.MatricesMetodos;
import matrices.Resultado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

public class JpanelInversa extends JPanel {
	private JTextField textField;
	JpanelMatrizA panel_2;
	static JpanelMatrizB Jpanel_3;
	JScrollPane scrollPane_2;
	JScrollPane scrollPane_3;
	double[][] matrizA;
	Resultado matrizResultante;
	private static JTextArea textArea;
	JRadioButton rdbtnAdjunta;
	JRadioButton rdbtnIdentidad;

	private JLabel lblMetodo;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblCalculoDeMatriz;
	private JCheckBox checkBox;

	/**
	 * Create the panel.
	 */
	public void limpiar() {}
	
	public JpanelInversa() {
		setBackground(SystemColor.inactiveCaptionBorder);
		setBorder(new LineBorder(SystemColor.activeCaption, 2));

		this.setSize(747, 669);

		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 11, 727, 259);
		
		checkBox = new JCheckBox("Fraccion");
		checkBox.setBounds(321, 69, 83, 23);
		panel.add(checkBox);

		add(panel);
		panel.setLayout(null);
		JButton btnMultiplicar = new JButton("=");
		btnMultiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				try {
					int n=Integer.parseInt(textField.getText()); 
					matrizA = MatricesMetodos.insertarEnMatriz(panel_2.textFieldMatriz,n,n);
					Jpanel_3 = null;
					Jpanel_3 = new JpanelMatrizB(n,n);
					matrizResultante=MatricesMetodos.InversaMatrizCofactores(matrizA);
					
					if(rdbtnAdjunta.isSelected()) {
						if(checkBox.isSelected()) {
												
							matrizResultante.setResulFraccion(matrizResultante.ResultadoFracionM(matrizResultante));
							matrizResultante.masPasos("\nEn Fraccion:\n"+MatricesMetodos.imprimirMatrizString(matrizResultante.getResulFraccion()));	
							Jpanel_3.llenarMatriz(matrizResultante.getResulFraccion());//llena la matriz B
						}
						else {
							Jpanel_3.llenarMatrizB(matrizResultante.getResul());
						}
						textArea.setText(matrizResultante.getPasos());

					}
					else {
						Resultado resul= new Resultado(null, "",null);
						double[][] matrizIde=MatricesMetodos.formatoIdentidad(matrizA);
						MatricesMetodos.inversaPorMatrizIdentidad(matrizIde,matrizIde.length,resul);
						if(checkBox.isSelected()) {
							matrizResultante.setResulFraccion(matrizResultante.ResultadoFracionM(matrizResultante));
							resul.masPasos("\nEn Fraccion:\n"+MatricesMetodos.imprimirMatrizString(matrizResultante.getResulFraccion()));				
							Jpanel_3.llenarMatriz(matrizResultante.getResulFraccion());
						}
						else {
							Jpanel_3.llenarMatrizB(matrizResultante.getResul());
						}
						textArea.setText(resul.getPasos());
					}
					
					scrollPane_3.setViewportView(Jpanel_3);
					panel.setVisible(true);
					}
				catch(java.lang.NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Un caracter no es numerico", "AVISO", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnMultiplicar.setToolTipText("Matriz Inverza");
		btnMultiplicar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMultiplicar.setBounds(339, 99, 50, 47);
		panel.add(btnMultiplicar);
		
		lblMetodo = new JLabel("Metodo :");
		lblMetodo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblMetodo.setForeground(new Color(51, 0, 255));
		lblMetodo.setBackground(new Color(51, 0, 153));
		lblMetodo.setBounds(329, 157, 64, 22);
		panel.add(lblMetodo);
		
		rdbtnAdjunta = new JRadioButton("Adjunta");
		rdbtnAdjunta.setBackground(SystemColor.inactiveCaption);
		buttonGroup.add(rdbtnAdjunta);
		rdbtnAdjunta.setBounds(321, 186, 71, 23);
		panel.add(rdbtnAdjunta);
		rdbtnAdjunta.setSelected(true);
		
		rdbtnIdentidad = new JRadioButton("Identidad");
		rdbtnIdentidad.setBackground(SystemColor.inactiveCaption);
		buttonGroup.add(rdbtnIdentidad);
		rdbtnIdentidad.setBounds(321, 212, 90, 23);
		panel.add(rdbtnIdentidad);
		
		textField = new JTextField();
		textField.setBounds(20, 226, 81, 20);
		panel.add(textField);
		textField.setColumns(10);


		JButton btnCrear = new JButton("Redimensionar");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a = Integer.parseInt(textField.getText());
				panel_2 = null;
				panel_2 = new JpanelMatrizA(a, a);
				scrollPane_2.setViewportView(panel_2);

				panel.setVisible(true);
			}
		});
		btnCrear.setBounds(111, 225, 121, 23);
		panel.add(btnCrear);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 34, 305, 175);
		panel.add(scrollPane_2);

		panel_2 = new JpanelMatrizA();

		scrollPane_2.setViewportView(panel_2);
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(412, 34, 305, 175);
		panel.add(scrollPane_3);
		
		Jpanel_3 = new JpanelMatrizB();
		scrollPane_3.setViewportView(Jpanel_3);
		
		lblCalculoDeMatriz = new JLabel("Calculo de Matriz Inversa");
		lblCalculoDeMatriz.setHorizontalAlignment(SwingConstants.CENTER);
		lblCalculoDeMatriz.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblCalculoDeMatriz.setBounds(227, 0, 261, 36);
		panel.add(lblCalculoDeMatriz);
		
		
		
		panel.setVisible(true);

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

