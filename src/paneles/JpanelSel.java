package paneles;

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

import controladorAlg.MatricesMetodos;
import controladorAlg.Resultado;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

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
	private JRadioButton rdbDescomp;

	/**
	 * Create the panel.
	 */
	public void limpiar() {
		textField.setText("");

		panel_2 = null;

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
		btnMultiplicar.setIcon(new ImageIcon(JpanelSel.class.getResource("/wallpapers/Calculator_16xLG.png")));
		btnMultiplicar.addActionListener(new ActionListener() {
			private Resultado matrizResultante;

			public void actionPerformed(ActionEvent arg0) {

				if (rdbtnGauss.isSelected()) {

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
				if (rdbtnPorMIdentidad.isSelected()) {
					matrizResultante = null;
					Resultado resul = new Resultado(null, "", null);
					int x = Integer.parseInt(textField.getText());
					matrizB = MatricesMetodos.insertarEnMatrizUni(panel_2.textFieldMatrizResultado, x);
					matrizA = MatricesMetodos.insertarEnMatriz(panel_2.textFieldMatriz, x, x);
					double[][] matrizIde = MatricesMetodos.formatoIdentidad(matrizA);
					matrizResultante = MatricesMetodos.InversaMatrizCofactores(matrizA);
					String a = MatricesMetodos.almacenarMatrizEnString3(matrizIde, null, null, '.');

					MatricesMetodos.inversaPorMatrizIdentidad(matrizIde, matrizIde.length, resul);

					String b = resul.getPasos() + "\n\n"
							+ "Multiplicamos la inversa por el vector de resultados y obtenemos el valor de las incognitas"
							+ "\n\n";

					double[][] inversaAMultiplicar = MatricesMetodos.InversaMatriz(matrizA, true);

					double[][] XinversaAMultiplicar = (inversaAMultiplicar);

					double[][] vectorResultante = MatricesMetodos.transformarVectorAarray(matrizB);

					String MatrizResultante[][] = MatricesMetodos.multiplicarDosMatrices(XinversaAMultiplicar,
							vectorResultante, false);

					textArea.setText("\t" + "Matriz A" + "\t\t\t" + "X" + "\t\t" + "Matriz B" + "\n");
					String ax = MatricesMetodos.almacenarMatrizEnString3(XinversaAMultiplicar, vectorResultante, null,
							'X');
					String bx = MatricesMetodos.almacenarMatrizEnString3(MatrizResultante, 'X');
					String rx = MatricesMetodos.pasosMultiplicar(XinversaAMultiplicar, vectorResultante, false);
					textArea.setText(textArea.getText() + "\n" + ax + "\n\n" + "Resutado:" + "\n\n" + bx + "\n\n"
							+ "Proceso:" + "\n\n" + rx);

					textArea.setText("\t" + "Matriz con su matriz identidad" + "\n" + a + "\n\n" + b);

					textArea.setText(textArea.getText() + "\n" + ax + "\n\n" + "Resutado:" + "\n\n" + bx + "\n\n"
							+ "Proceso:" + "\n\n" + rx);

				}
				if (rdbtnPorMInversa.isSelected()) {
					matrizResultante = null;
					int x = Integer.parseInt(textField.getText());
					matrizA = MatricesMetodos.insertarEnMatriz(panel_2.textFieldMatriz, x, x);
					matrizB = MatricesMetodos.insertarEnMatrizUni(panel_2.textFieldMatrizResultado, x);

					matrizResultante = MatricesMetodos.InversaMatrizCofactores(matrizA);

					String a = matrizResultante.getPasos() + "\n\n"
							+ "Ahora multiplicamos su inversa por el vector de resultados";

					double[][] inversaAMultiplicar = MatricesMetodos.InversaMatriz(matrizA, true);
					double[][] vectorResultante = MatricesMetodos.transformarVectorAarray(matrizB);
					String MatrizResultante[][] = MatricesMetodos.multiplicarDosMatrices(inversaAMultiplicar,
							vectorResultante, false);
					String b = ("\t" + "Matriz A" + "\t\t\t" + "X" + "\t\t" + "Matriz B" + "\n");
					String ax = MatricesMetodos.almacenarMatrizEnString3(inversaAMultiplicar, vectorResultante, null,
							'X');
					String bx = MatricesMetodos.almacenarMatrizEnString3(MatrizResultante, 'X');
					String rx = MatricesMetodos.pasosMultiplicar(inversaAMultiplicar, vectorResultante, false);
					String c = "\n" + ax + "\n\n" + "Resutado:" + "\n\n" + bx + "\n\n" + "Proceso:" + "\n\n" + rx;

					textArea.setText(a + b + c);
				}
				if (rdbDescomp.isSelected()) {
					
					int i, j, h, k, s;
			        double c, suma, valorDeK, valorDeHK;

			        

					
					matrizResultante = null;
					Resultado resul = new Resultado(null, "", null);
					int x = Integer.parseInt(textField.getText());
					matrizB = MatricesMetodos.insertarEnMatrizUni(panel_2.textFieldMatrizResultado, x);
					matrizA = MatricesMetodos.insertarEnMatriz(panel_2.textFieldMatriz, x, x);
					
					
					double aux[][] = new double[x][x];
					 double z[]  = new double[x]; 
					 double resutado[]  = new double[x];
					 
					 
					 for (i = 0; i <= x - 1; i++) {
		
				            for (j = 0; j <= x - 1; j++) {
				               
				                if (i == j) {
				                    aux[i][j] = 1;
				                } else {
				                    aux[i][j] = 0;
				                }
				            }
				        }
					 
					 textArea.setText(textArea.getText()+" CALCULANDO TRIANGULAR SUPERIOR\n");
					for (i = 0; i < x - 1; i++) {
			            for (j =i+1; j < x; j++) {
			                c = (matrizA[j][i] / matrizA[i][i]);
			                for (s = 0; s < x; s++) {
			                	matrizA[j][s]=matrizA[j][s]-c*matrizA[i][s];
			                }
			                aux[j][i]=c;
			                String a = MatricesMetodos.almacenarMatrizEnString3(matrizA, null, null, '.');
				            textArea.setText(textArea.getText()+"\n\n"+ a);  
			            }
			            String a = MatricesMetodos.almacenarMatrizEnString3(matrizA, null, null, '.');
			            textArea.setText(textArea.getText()+"\n\n "+ a);
			        }
					textArea.setText(textArea.getText()+"REALIZANDO SIGUIENTE PASO\n");
			        for(i=0;i<x;i++){
			            suma=matrizB[i];
			            for(j=i;j>=0;j--)
			            {
			                if(i==j){
			                    suma=suma/aux[i][j];
			                }else{
			                    suma=suma-((z[j]*aux[i][j])/aux[i][i]);
			                }
			                double[][] vectorResultante=null;
			                if(i==0) {
			                vectorResultante = MatricesMetodos.transformarVectorAarray(matrizB);
			                }
			                String a = MatricesMetodos.almacenarMatrizEnString3(vectorResultante, null, null, '.');
				            textArea.setText(textArea.getText()+"\n\n"+ a);  
			            }
			            

			            z[i]=suma;
			            double[][] vectorResultante = MatricesMetodos.transformarVectorAarray(z);
			            String a = MatricesMetodos.almacenarMatrizEnString3(vectorResultante, null, null, '.');
			            textArea.setText(textArea.getText()+"\n\n"+ a);  
			        }
			        
					textArea.setText(textArea.getText()+"REALIZANDO SIGUIENTE PASO EN RESULTADO\n");

			        for(i=x-1;i>=0;i--){
			            suma=z[i];
			            for(j=i;j<x;j++)
			            {
			                if(i==j){
			                    suma=suma/matrizA[i][j];
			                }else{
			                    suma=suma-((resutado[j]*matrizA[i][j])/matrizA[i][i]);
			                    
			                }
			                String a = MatricesMetodos.almacenarMatrizEnString3(matrizA, null, null, '.');
				            textArea.setText(textArea.getText()+"\n\n"+ a);  
			            }
			            resutado[i]=suma;
			            double[][] vectorResultante = MatricesMetodos.transformarVectorAarray(resutado);

			            String a = MatricesMetodos.almacenarMatrizEnString3(vectorResultante, null, null, '.');
			            textArea.setText(textArea.getText()+"\n\n"+ a);  
			        }
			        for(i=0;i<x;i++){
			            k=i+1;
			            System.out.println("El valor de la incognita x"+ k+" es: "+resutado[i]);
			        }
			    
		
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
		btnCrear.setIcon(new ImageIcon(JpanelSel.class.getResource("/wallpapers/Resize.png")));
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
		btnCrear.setBounds(64, 225, 133, 23);
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
		panel_3.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_3.setBounds(207, 212, 510, 34);
		panel.add(panel_3);
		panel_3.setLayout(null);

		rdbtnPorMIdentidad = new JRadioButton("Por M. Identidad");
		rdbtnPorMIdentidad.setBounds(6, 7, 136, 23);
		panel_3.add(rdbtnPorMIdentidad);

		rdbtnPorMInversa = new JRadioButton("Por M. Inversa");
		rdbtnPorMInversa.setBounds(144, 7, 127, 23);
		panel_3.add(rdbtnPorMInversa);

		rdbtnGauss = new JRadioButton("Gauss");
		rdbtnGauss.setBounds(279, 7, 84, 23);
		panel_3.add(rdbtnGauss);
		
		rdbDescomp = new JRadioButton("Descomposicion LU");
		rdbDescomp.setBounds(377, 7, 127, 23);
		panel_3.add(rdbDescomp);

		grupo1 = new ButtonGroup();
		grupo1.add(rdbtnPorMIdentidad);
		grupo1.add(rdbtnGauss);
		grupo1.add(rdbtnPorMInversa);
		grupo1.add(rdbDescomp);
		
		

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
