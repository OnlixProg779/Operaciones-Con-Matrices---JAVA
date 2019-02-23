package interfaz;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

import matrices.MatricesMetodos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class JpanelAdjunta extends JPanel {

	private JTextField textField;
	JpanelMatrizA panel_2;
	JpanelMatrizB Jpanel_3;
	JScrollPane scrollPane_2;
	JScrollPane scrollPane_3;
	double[][] matrizA;
	double[][] matrizB;
	double[][] matrizAdjunta;
	String[][] matrizResultante;
	int a;
	private JTextArea textArea;

	/**
	 * Create the panel.
	 */
	public JpanelAdjunta() {
		setBackground(SystemColor.inactiveCaptionBorder);
		setBorder(new LineBorder(SystemColor.activeCaption, 2));

		this.setSize(747, 669);

		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 11, 727, 252);

		add(panel);
		panel.setLayout(null);

		textField = new JTextField();
		textField.setBounds(47, 219, 61, 20);
		panel.add(textField);
		textField.setColumns(10);

		JButton btnCrear = new JButton("Redimensionar");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				a = Integer.parseInt(textField.getText());
				panel_2 = null;
				panel_2 = new JpanelMatrizA(a, a);
				scrollPane_2.setViewportView(panel_2);

				panel.setVisible(true);
			}
		});
		btnCrear.setBounds(118, 218, 121, 23);
		panel.add(btnCrear);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 33, 305, 175);
		panel.add(scrollPane_2);

		panel_2 = new JpanelMatrizA();
		panel_2.setBackground(SystemColor.text);

		scrollPane_2.setViewportView(panel_2);

		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(412, 33, 305, 175);
		panel.add(scrollPane_3);

		Jpanel_3 = new JpanelMatrizB();
		Jpanel_3.setBackground(SystemColor.text);
		scrollPane_3.setViewportView(Jpanel_3);

		JLabel lblResultadoAdjunta = new JLabel("Resultado Adjunta de Matriz");
		lblResultadoAdjunta.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultadoAdjunta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblResultadoAdjunta.setBounds(412, 222, 305, 14);
		panel.add(lblResultadoAdjunta);

		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(325, 107, 77, 23);
		panel.add(btnCalcular);

		JCheckBox chckbxFraccion = new JCheckBox("Fraccion");
		chckbxFraccion.setBounds(321, 77, 82, 23);
		panel.add(chckbxFraccion);
		
		JLabel lblCalculoDeMatriz = new JLabel("Calculo de Matriz Adjunta");
		lblCalculoDeMatriz.setHorizontalAlignment(SwingConstants.CENTER);
		lblCalculoDeMatriz.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblCalculoDeMatriz.setBounds(250, 0, 221, 36);
		panel.add(lblCalculoDeMatriz);
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				matrizA = MatricesMetodos.insertarEnMatriz(panel_2.textFieldMatriz,
						Integer.parseInt(textField.getText()), Integer.parseInt(textField.getText()));
				Jpanel_3 = null;
				Jpanel_3 = new JpanelMatrizB(a, a);
				scrollPane_3.setViewportView(Jpanel_3);

				boolean pase = false;
				if (chckbxFraccion.isSelected()) {
					pase = true;
				}
				//matrizResultante = devolverMatrizAdjunta(matrizA);
				
				matrizAdjunta = MatricesMetodos.AdjuntaMatriz(matrizA);

				matrizResultante = MatricesMetodos.TransponerMatriz(matrizAdjunta, pase);

				Jpanel_3.llenarMatriz(matrizResultante);

				textArea.setText("\t" + "Matriz A" + "\t\t\t");

				String a = MatricesMetodos.almacenarMatrizEnString3(matrizA, null, null, 'X');
				String b = MatricesMetodos.imprimirMatrizString(matrizResultante);

				String proceso = MatricesMetodos.procesoAdjuntaMatriz(matrizA, pase);
				String procesofinal = MatricesMetodos.TransponerMatrizProceso(matrizAdjunta, pase);

				textArea.setText(textArea.getText() + "\n" + a + "\n\n" + "Resutado Matriz Adjunta:" + "\n\n" + b
						+ "\n\n" + "Proceso Adjunta:" + "\n\n" + proceso + "\n\n" + "Trasponiendo:" + "\n\n"
						+ procesofinal);

			}
		});

		panel.setVisible(true);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 274, 725, 384);
		add(scrollPane);

		JPanel panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 705, 360);
		panel_1.add(scrollPane_1);

		textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);

		setVisible(false);

	}
	
	
}
