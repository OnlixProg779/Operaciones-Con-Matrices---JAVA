package interfaz;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.border.SoftBevelBorder;

import matrices.MatricesMetodos;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class JpaneMultiplicar extends JPanel {
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
	private JCheckBox checkBoxFraccion;
	private JLabel lblMultiplicacinDeMatrices;
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
	
	public JpaneMultiplicar() {
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

		JButton btnMultiplicar = new JButton("X");
		btnMultiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				
				matrizA = MatricesMetodos.insertarEnMatriz(panel_2.textFieldMatriz, Integer.parseInt(textField_1.getText()), Integer.parseInt(textField.getText()));
				
				matrizB = MatricesMetodos.insertarEnMatriz(Jpanel_3.textFieldMatriz, Integer.parseInt(textField_3.getText()), Integer.parseInt(textField_2.getText()));
				boolean pase = false;
				if (checkBoxFraccion.isSelected()) {
					pase = true;
				}
				matrizResultante = MatricesMetodos.multiplicarDosMatrices(matrizA, matrizB, pase);
				textArea.setText("\t"+"Matriz A"+"\t\t\t"+"X"+"\t\t"+"Matriz B"+"\n");
				String a=MatricesMetodos.almacenarMatrizEnString3(matrizA,matrizB,null,'X');
				String b=MatricesMetodos.almacenarMatrizEnString3(matrizResultante,'X');
				String r=MatricesMetodos.pasosMultiplicar(matrizA, matrizB,pase);
				textArea.setText(textArea.getText()+"\n"+a+"\n\n"+"Resutado:"+"\n\n"+b+"\n\n"+"Proceso:"+"\n\n"+r);
				
				
				
			}
		});
		btnMultiplicar.setToolTipText("Multiplicar");
		btnMultiplicar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMultiplicar.setBounds(339, 102, 50, 47);
		panel.add(btnMultiplicar);

		textField = new JTextField();
		textField.setBounds(64, 226, 44, 20);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(10, 226, 44, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JButton btnCrear = new JButton("Redimensionar");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a = Integer.parseInt(textField.getText());
				int b = Integer.parseInt(textField_1.getText());
				textField_3.setText(String.valueOf(a));
				panel_2 = null;
				panel_2 = new JpanelMatrizA(a, b);
				scrollPane_2.setViewportView(panel_2);

				panel.setVisible(true);
			}
		});
		btnCrear.setBounds(118, 225, 121, 23);
		panel.add(btnCrear);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 40, 305, 175);
		panel.add(scrollPane_2);

		panel_2 = new JpanelMatrizA();

		scrollPane_2.setViewportView(panel_2);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(412, 40, 305, 175);
		panel.add(scrollPane_3);
		
		Jpanel_3 = new JpanelMatrizB();
		scrollPane_3.setViewportView(Jpanel_3);
		
		JButton button = new JButton("Redimensionar");
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
		button.setBounds(599, 223, 118, 23);
		panel.add(button);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(545, 226, 44, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_3.setEnabled(false);
		textField_3.setColumns(10);
		textField_3.setBounds(491, 226, 44, 20);
		panel.add(textField_3);
		
		checkBoxFraccion = new JCheckBox("Fraccion");
		checkBoxFraccion.setBounds(324, 72, 82, 23);
		panel.add(checkBoxFraccion);
		
		lblMultiplicacinDeMatrices = new JLabel("Multiplicaci\u00F3n de Matrices");
		lblMultiplicacinDeMatrices.setHorizontalAlignment(SwingConstants.CENTER);
		lblMultiplicacinDeMatrices.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblMultiplicacinDeMatrices.setBounds(232, 0, 249, 36);
		panel.add(lblMultiplicacinDeMatrices);

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
