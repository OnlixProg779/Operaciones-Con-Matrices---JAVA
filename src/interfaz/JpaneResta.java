package interfaz;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

import matrices.MatricesMetodos;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class JpaneResta extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	JpanelMatrizA panel_2;
	JpanelMatrizB Jpanel_3;
	JScrollPane scrollPane_2;
	JScrollPane scrollPane_3;
	private JTextField textField_2;
	private JTextField textField_3;
	double[][] matrizA;
	double[][] matrizB;
	String[][] matrizResultante;
	private JTextArea textArea;
	private JCheckBox CheckBoxFraccion;
	/**
	 * Create the panel.
	 */
	
	public void limpiar() {
		textField.setText("");
		textField_1.setText("");
		panel_2=null;
		Jpanel_3=null;
		textField_2.setText("");;
		textField_3.setText("");;
	}
	
	public JpaneResta() {
		setBackground(SystemColor.inactiveCaptionBorder);
		setBorder(new LineBorder(SystemColor.activeCaption, 2));

		this.setSize(747, 669);

		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 11, 727, 259);

		add(panel);
		panel.setLayout(null);

		JButton btnSumar = new JButton("-");
		
		btnSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				matrizA = MatricesMetodos.insertarEnMatriz(panel_2.textFieldMatriz, Integer.parseInt(textField_1.getText()), Integer.parseInt(textField.getText()));
				
				matrizB = MatricesMetodos.insertarEnMatriz(Jpanel_3.textFieldMatriz, Integer.parseInt(textField_3.getText()), Integer.parseInt(textField_2.getText()));
				boolean pase = false;
				if (CheckBoxFraccion.isSelected()) {
					pase = true;
				}
				matrizResultante = MatricesMetodos.restarDosMatrices(matrizA, matrizB,pase);
				textArea.setText("\t"+"Matriz A"+"\t\t\t"+"-"+"\t\t"+"Matriz B"+"\n");
				String a=MatricesMetodos.almacenarMatrizEnString3(matrizA,matrizB,null,'-');
				String b=MatricesMetodos.imprimirMatrizString(matrizResultante);
				String r=MatricesMetodos.PasosSumaResta(matrizA, matrizB, '-',pase);
				textArea.setText(textArea.getText()+"\n"+a+"\n\n"+"Resutado:"+"\n\n"+b+"\n\n"+"Proceso:"+"\n\n" + r);
			}
			catch(java.lang.NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Un caracter no es numerico", "AVISO", JOptionPane.INFORMATION_MESSAGE);
			}
			}
		});
		
		btnSumar.setToolTipText("Sumar");
		btnSumar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSumar.setBounds(337, 126, 53, 48);
		panel.add(btnSumar);

		textField = new JTextField();
		textField.setBounds(306, 226, 44, 20);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(252, 226, 44, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JButton btnCrear = new JButton("Redimensionar");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a = Integer.parseInt(textField.getText());
				int b = Integer.parseInt(textField_1.getText());
				panel_2 = null;
				panel_2 = new JpanelMatrizA(a, b);
				scrollPane_2.setViewportView(panel_2);
				textField_2.setText(String.valueOf(a));
				textField_3.setText(String.valueOf(b));
				Jpanel_3 = null;
				Jpanel_3 = new JpanelMatrizB(a, b);
				scrollPane_3.setViewportView(Jpanel_3);
				panel.setVisible(true);
			}
		});
		btnCrear.setBounds(360, 225, 121, 23);
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
		
		JButton button = new JButton("Redimensionar");
		button.setVisible(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a = Integer.parseInt(textField_2.getText());
				int b = Integer.parseInt(textField_3.getText());
				Jpanel_3 = null;
				Jpanel_3 = new JpanelMatrizB(a, b);
				scrollPane_3.setViewportView(Jpanel_3);
				panel.setVisible(true);
			}
		});
		button.setBounds(599, 222, 118, 23);
		panel.add(button);
		
		textField_2 = new JTextField();
		textField_2.setVisible(false);
		textField_2.setColumns(10);
		textField_2.setBounds(545, 225, 44, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setVisible(false);
		textField_3.setColumns(10);
		textField_3.setBounds(491, 225, 44, 20);
		panel.add(textField_3);
		
		CheckBoxFraccion = new JCheckBox("Fraccion");
		CheckBoxFraccion.setBounds(323, 96, 83, 23);
		panel.add(CheckBoxFraccion);
		
		JLabel lblRestaDeMatrices = new JLabel("Resta de Matrices");
		lblRestaDeMatrices.setHorizontalAlignment(SwingConstants.CENTER);
		lblRestaDeMatrices.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblRestaDeMatrices.setBounds(281, 0, 167, 36);
		panel.add(lblRestaDeMatrices);

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
