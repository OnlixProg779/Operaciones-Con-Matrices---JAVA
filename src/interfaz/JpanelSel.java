package interfaz;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
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
import matrices.Resultado;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;

public class JpanelSel extends JPanel {

	private JTextField textField;
	JpanelMatrizParaSEL panel_2;
	JScrollPane scrollPane_2;
	double[][] matrizA;
	double[] matrizB;
	double[][] matrizResultado;
	private JTextArea textArea;
	private JCheckBox chckbxFraccion;
	private JRadioButton rdbtnPorMIdentidad;
	private JRadioButton rdbtnPorMInversa;
	private JRadioButton rdbtnGauss;
	private ButtonGroup grupo1;
	/**
	 * Create the panel.
	 */
	public void limpiar() {
		textField.setText("");
		
		panel_2=null;
		
		
	}
	
	public JpanelSel() {
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
		
		JButton btnMultiplicar = new JButton("Calcular");
		btnMultiplicar.addActionListener(new ActionListener() {
			private Resultado matrizResultante;

			public void actionPerformed(ActionEvent arg0) {
				
				
				if(rdbtnGauss.isSelected()) {
					
					int x = Integer.parseInt(textField.getText());
					matrizA = MatricesMetodos.insertarEnMatriz(panel_2.textFieldMatriz, x, x);
					matrizB = MatricesMetodos.insertarEnMatrizUni(panel_2.textFieldMatrizResultado, x);

					matrizResultado = MatricesMetodos.combinarEnMatrices(matrizA, matrizB);

					textArea.setText("\t" + "Matriz de la Ecuacion Lineal");
					String a = MatricesMetodos.almacenarMatrizEnString3(matrizA, null, null, '.');

						boolean pase = false;
						if (chckbxFraccion.isSelected()) {
							pase = true;
						}
						textArea.setText(textArea.getText() + "\n" + a + "\n\n" + "Proceso:" + "\n\n"
								+ MatricesMetodos.GaussJordan(matrizResultado, (x), pase));
				}
				if(rdbtnPorMIdentidad.isSelected()) {
					matrizResultante =null;
					Resultado resul= new Resultado(null, "",null);
					int x = Integer.parseInt(textField.getText());
					matrizB = MatricesMetodos.insertarEnMatrizUni(panel_2.textFieldMatrizResultado, x);
					matrizA = MatricesMetodos.insertarEnMatriz(panel_2.textFieldMatriz, x, x);
					double[][] matrizIde=MatricesMetodos.formatoIdentidad(matrizA);
					matrizResultante = MatricesMetodos.InversaMatrizCofactores(matrizA);
					String a = MatricesMetodos.almacenarMatrizEnString3(matrizIde, null, null, '.');
					
					
					MatricesMetodos.inversaPorMatrizIdentidad(matrizIde,matrizIde.length,resul);
					
					String b = resul.getPasos()+"\n\n"+"Multiplicamos la inversa por el vector de resultados y obtenemos el valor de las incognitas"+"\n\n";
					
					double[][] inversaAMultiplicar = MatricesMetodos.InversaMatriz(matrizA, true);
					
					double[][] XinversaAMultiplicar = (inversaAMultiplicar);
					
					double[][] vectorResultante = MatricesMetodos.transformarVectorAarray(matrizB);
				
					String MatrizResultante[][] = MatricesMetodos.multiplicarDosMatrices(XinversaAMultiplicar, vectorResultante, false);
					
					
					textArea.setText("\t"+"Matriz A"+"\t\t\t"+"X"+"\t\t"+"Matriz B"+"\n");
					String ax=MatricesMetodos.almacenarMatrizEnString3(XinversaAMultiplicar,vectorResultante,null,'X');
					String bx=MatricesMetodos.almacenarMatrizEnString3(MatrizResultante,'X');
					String rx=MatricesMetodos.pasosMultiplicar(XinversaAMultiplicar, vectorResultante,false);
					textArea.setText(textArea.getText()+"\n"+ax+"\n\n"+"Resutado:"+"\n\n"+bx+"\n\n"+"Proceso:"+"\n\n"+rx);
					
					
					textArea.setText("\t" + "Matriz con su matriz identidad"+"\n"+a+"\n\n"+b);
					
					textArea.setText(textArea.getText()+"\n"+ax+"\n\n"+"Resutado:"+"\n\n"+bx+"\n\n"+"Proceso:"+"\n\n"+rx);
				
					
					
					
					
					
					
					
				}
				if(rdbtnPorMInversa.isSelected()) {
					matrizResultante=null;
					int x = Integer.parseInt(textField.getText());
					matrizA = MatricesMetodos.insertarEnMatriz(panel_2.textFieldMatriz, x, x);
					matrizB = MatricesMetodos.insertarEnMatrizUni(panel_2.textFieldMatrizResultado, x);
					
					matrizResultante=MatricesMetodos.InversaMatrizCofactores(matrizA);
					
					String a = matrizResultante.getPasos()+"\n\n"+"Ahora multiplicamos su inversa por el vector de resultados";
					
					double[][] inversaAMultiplicar = MatricesMetodos.InversaMatriz(matrizA, true);
					double[][] vectorResultante = MatricesMetodos.transformarVectorAarray(matrizB);
					String MatrizResultante[][] = MatricesMetodos.multiplicarDosMatrices(inversaAMultiplicar, vectorResultante, false);
					String b =("\t"+"Matriz A"+"\t\t\t"+"X"+"\t\t"+"Matriz B"+"\n");
					String ax=MatricesMetodos.almacenarMatrizEnString3(inversaAMultiplicar,vectorResultante,null,'X');
					String bx=MatricesMetodos.almacenarMatrizEnString3(MatrizResultante,'X');
					String rx=MatricesMetodos.pasosMultiplicar(inversaAMultiplicar, vectorResultante,false);
					String c = "\n"+ax+"\n\n"+"Resutado:"+"\n\n"+bx+"\n\n"+"Proceso:"+"\n\n"+rx;
					
					textArea.setText(a+b+c);
				}
				
				
				

				
			}
		});
		btnMultiplicar.setToolTipText("Multiplicar");
		btnMultiplicar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMultiplicar.setBounds(596, 143, 121, 58);
		panel.add(btnMultiplicar);

		textField = new JTextField();
		textField.setBounds(10, 226, 44, 20);
		panel.add(textField);
		textField.setColumns(10);

		JButton btnCrear = new JButton("Redimensionar");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a = Integer.parseInt(textField.getText());
				int b = a;
				panel_2 = null;
				panel_2 = new JpanelMatrizParaSEL(a, b);
				scrollPane_2.setViewportView(panel_2);

				panel.setVisible(true);
			}
		});
		btnCrear.setBounds(64, 225, 121, 23);
		panel.add(btnCrear);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 30, 576, 171);
		panel.add(scrollPane_2);

		panel_2 = new JpanelMatrizParaSEL();

		scrollPane_2.setViewportView(panel_2);
		
		chckbxFraccion = new JCheckBox("Fraccion");
		chckbxFraccion.setBounds(596, 113, 97, 23);
		panel.add(chckbxFraccion);
		
		JLabel lblSistemaDeEcuaciones = new JLabel("Sistema de Ecuaciones Lineales");
		lblSistemaDeEcuaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblSistemaDeEcuaciones.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblSistemaDeEcuaciones.setBounds(175, 0, 359, 34);
		panel.add(lblSistemaDeEcuaciones);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Metodos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(207, 212, 510, 34);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		rdbtnPorMIdentidad = new JRadioButton("Por M. Identidad");
		rdbtnPorMIdentidad.setBounds(71, 7, 136, 23);
		panel_3.add(rdbtnPorMIdentidad);
		
		rdbtnPorMInversa = new JRadioButton("Por M. Inversa");
		rdbtnPorMInversa.setBounds(224, 7, 127, 23);
		panel_3.add(rdbtnPorMInversa);
		
		rdbtnGauss = new JRadioButton("Gauss");
		rdbtnGauss.setBounds(374, 7, 84, 23);
		panel_3.add(rdbtnGauss);
		
		grupo1 = new ButtonGroup();
		grupo1.add(rdbtnPorMIdentidad);
		grupo1.add(rdbtnGauss);
		grupo1.add(rdbtnPorMInversa);

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
