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

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

public class JpanelEscalar extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	JpanelMatrizA Jpanel_1;
	JScrollPane scrollPane_2;
	JScrollPane scrollPane_3;
	private JTextField textField_2;
	double[][] matrizA;
	String[][] matrizResultante;
	double escalar;
	private JTextArea textArea;
	private JCheckBox checkboxFraccion;
	
	/**
	 * Create the panel.
	 */
	public void limpiar() {
		textField.setText("");
		textField_1.setText("");
		Jpanel_1=null;
		textField_2.setText("");;
	}
	
	public JpanelEscalar() {
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
		
		textField = new JTextField();
		textField.setBounds(94, 118, 72, 33);
		panel.add(textField);
		textField.setColumns(10);

		JButton btnMult_Escalar = new JButton("X");
		
		btnMult_Escalar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				matrizA = MatricesMetodos.insertarEnMatriz(Jpanel_1.textFieldMatriz, Integer.parseInt(textField_1.getText()), Integer.parseInt(textField_2.getText()));
				escalar= Double.parseDouble(textField.getText());		
				
				boolean pase = false;
				if (checkboxFraccion.isSelected()) {
					pase = true;
				}
				matrizResultante = MatricesMetodos.matrizPorEscalar(matrizA, escalar, pase);
				textArea.setText("Matriz A" + "\n");
				String a=MatricesMetodos.almacenarMatrizEnString3(matrizA,null,null,'+');
				String b=MatricesMetodos.almacenarMatrizEnString3(matrizResultante,' ');
				String r=MatricesMetodos.ProcesoMultiplicacionEscalar(matrizA, escalar,pase);
				textArea.setText(textArea.getText() + "\n"+a+"\n\n"+"Por Escalar:     " + escalar +"\n\n"+ "Resutado:" + "\n\n" +b+ "\n\n" + "Proceso:" + "\n\n" + r);
			
			}
		});
		btnMult_Escalar.setToolTipText("Multiplicar");
		btnMult_Escalar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMult_Escalar.setBounds(276, 111, 52, 52);
		panel.add(btnMult_Escalar);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(545, 228, 44, 20);
		panel.add(textField_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(491, 228, 44, 20);
		panel.add(textField_1);

		panel.setVisible(true);

		JButton btnCrear = new JButton("Redimensionar");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a = Integer.parseInt(textField_2.getText());
				int b = Integer.parseInt(textField_1.getText());
				Jpanel_1 = null;
				Jpanel_1 = new JpanelMatrizA(a, b);
				scrollPane_3.setViewportView(Jpanel_1);
				panel.setVisible(true);
			}
		});
		btnCrear.setBounds(599, 225, 118, 23);
		panel.add(btnCrear);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(412, 42, 305, 175);
		panel.add(scrollPane_3);
		
		Jpanel_1 = new JpanelMatrizA();
		scrollPane_3.setViewportView(Jpanel_1);
		
		JLabel lblEscalar = new JLabel("Escalar");
		lblEscalar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEscalar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEscalar.setBounds(94, 77, 72, 14);
		panel.add(lblEscalar);
		
		checkboxFraccion = new JCheckBox("Fraccion");
		checkboxFraccion.setBounds(264, 81, 77, 23);
		panel.add(checkboxFraccion);
		
		JLabel lblMultiplicacionDeUna = new JLabel("Multiplicaci\u00F3n de una Matriz por un Escalar");
		lblMultiplicacionDeUna.setHorizontalAlignment(SwingConstants.CENTER);
		lblMultiplicacionDeUna.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblMultiplicacionDeUna.setBounds(163, 0, 388, 36);
		panel.add(lblMultiplicacionDeUna);
		
		
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
