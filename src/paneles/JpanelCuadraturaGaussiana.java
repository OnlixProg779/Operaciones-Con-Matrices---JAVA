package paneles;

import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

import org.nfunk.jep.ParseException;


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

public class JpanelCuadraturaGaussiana extends JPanel {
	private JTextField txtLimInf;
	JScrollPane scrollPane_2;
	private JTextField txtLimSup;
	double[][] matrizA;

	private JTextArea textArea;
	private JPanel panel_2;
	private JTextField txtFuncion;
	private JTextField txtNpuntos;
	private String proceso = "";

	/**
	 * Create the panel.
	 */
	public void limpiar() {

		txtLimInf.setText("");

		txtLimSup.setText("");
		;
	}

	public JpanelCuadraturaGaussiana() {
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

		txtLimSup = new JTextField();
		txtLimSup.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if(caracter >= '0' && caracter <= '9' || caracter =='.'|| caracter =='-') {
					
				}else {
					e.consume();
				}
			}
		});
		txtLimSup.setBounds(136, 108, 50, 30);
		panel_2.add(txtLimSup);
		txtLimSup.setColumns(10);

		txtLimInf = new JTextField();
		txtLimInf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if(caracter >= '0' && caracter <= '9' || caracter =='.'|| caracter =='-') {
					
				}else {
					e.consume();
				}
			}
		});
		txtLimInf.setBounds(136, 151, 50, 30);
		panel_2.add(txtLimInf);
		txtLimInf.setColumns(10);

		JLabel lblFx = new JLabel("Funci\u00F3n:");
		lblFx.setBounds(10, 72, 111, 14);
		panel_2.add(lblFx);
		lblFx.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFx.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setIcon(new ImageIcon(JpanelCuadraturaGaussiana.class.getResource("/wallpapers/Calculator_16xLG.png")));
		btnCalcular.setBounds(502, 95, 166, 52);
		panel_2.add(btnCalcular);

		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					textArea.setText("");
					  boolean correcto = true;
				        String msg = "";
				        proceso = "";
				        double sum = 0;
				        f = new double[Integer.parseInt(txtNpuntos.getText()) + 1];
				        double h = (Double.parseDouble(txtLimSup.getText()) - Double.parseDouble(txtLimInf.getText())) / Double.parseDouble(txtNpuntos.getText());
				        fun = new Funcion_2(txtFuncion.getText());
				      //  int num = jOpcionIntegracion.getSelectedIndex() + 2;
				        try {
				            dividir(fun.Redondear(h));
				        } catch (ParseException ex) {
				            JOptionPane.showMessageDialog(null, "Funcion ingresada incorrecta");
				            correcto = false;
				        }


				        
				      
				        
				        fun.setF(cambio(txtFuncion.getText(), Integer.parseInt(txtLimInf.getText()), Integer.parseInt(txtLimSup.getText())));
				        proceso += cambio(txtFuncion.getText(), Integer.parseInt(txtLimInf.getText()), Integer.parseInt(txtLimSup.getText())) + "\n";
				        switch (txtNpuntos.getText()) {
				            case "2":
				                try {
				                    sum = fun.EvaluarZ(-(Math.sqrt(3) / 3)) + fun.EvaluarZ(Math.sqrt(3) / 3);
				                    proceso += "Proceso: \n" + fun.EvaluarZ(-(Math.sqrt(3) / 3)) + "+" + fun.EvaluarZ(Math.sqrt(3) / 3) + "\n";
				                    proceso += "Resultado sin redondear: " + sum + "\n";
				                } catch (ParseException ex) {
				                    JOptionPane.showMessageDialog(null, "Funcion ingresada incorrecta");
				                    correcto = false;
				                }
				                break;
				            case "3":
				                try {
				                    sum = (0.555555556 * fun.EvaluarZ(0.7745966692)) + (0.888888889 * fun.EvaluarZ(0)) + (0.555555556 * fun.EvaluarZ(-0.7745966692));
				                    proceso += "Proceso: \n" + (0.555555556 + "*" + fun.EvaluarZ(0.7745966692)) + "+" + (0.888888889 + "*" + fun.EvaluarZ(0)) + "+" + (0.555555556 + "*" + fun.EvaluarZ(-0.7745966692)) + "\n";
				                    proceso += "Resultado sin redondear: " + sum + "\n";
				                } catch (ParseException ex) {
				                    JOptionPane.showMessageDialog(null, "Funcion ingresada incorrecta");
				                    correcto = false;
				                }
				                break;
				            case "4":
				                try {
				                    sum = (0.3478548451 * fun.EvaluarZ(0.8611363116)) + (0.6521451549 * fun.EvaluarZ(0.3399810436)) + (0.6521451549 * fun.EvaluarZ(0.3399810436)) + (0.3478548451 * fun.EvaluarZ(-0.8611363116));
				                    proceso += "Proceso: \n" + (0.3478548451 + "*" + fun.EvaluarZ(0.8611363116)) + "+" + (0.6521451549 + "*" + fun.EvaluarZ(0.3399810436)) + "+" + (0.6521451549 + "*" + fun.EvaluarZ(0.3399810436)) + "+" + (0.3478548451 + "*" + fun.EvaluarZ(-0.8611363116)) + "\n";
				                    proceso += (0.3478548451 * fun.EvaluarZ(0.8611363116)) + "+" + (0.6521451549 * fun.EvaluarZ(0.3399810436)) + "+" + (0.6521451549 * fun.EvaluarZ(0.3399810436)) + "+" + (0.3478548451 * fun.EvaluarZ(-0.8611363116)) + "\n";
				                    proceso += (0.3478548451 * fun.EvaluarZ(0.8611363116)) + (0.6521451549 * fun.EvaluarZ(0.3399810436)) + "+" + (0.6521451549 * fun.EvaluarZ(0.3399810436)) + (0.3478548451 * fun.EvaluarZ(-0.8611363116)) + "\n";
				                    proceso += "Resultado sin redondear: " + sum + "\n";
				                } catch (ParseException ex) {
				                    JOptionPane.showMessageDialog(null, "Funcion ingresada incorrecta");
				                    correcto = false;
				                }
				                break;
				            case "5":
				                try {
				                    sum = (0.236926885 * fun.EvaluarZ(0.9061798459)) + (0.4786286705 * fun.EvaluarZ(0.5384693101)) + (0.5688888889 * fun.EvaluarZ(0)) + (0.4786286705 * fun.EvaluarZ(-0.5384693101)) + (0.236926885 * fun.EvaluarZ(-0.9061798459));
				                    proceso += "Proceso: \n" + (0.236926885 + "*" + fun.EvaluarZ(0.9061798459)) + "+" + (0.4786286705 + "*" + fun.EvaluarZ(0.5384693101)) + "+" + (0.5688888889 + "*" + fun.EvaluarZ(0)) + "+" + (0.4786286705 + "*" + fun.EvaluarZ(-0.5384693101)) + "+" + (0.236926885 + "*" + fun.EvaluarZ(-0.9061798459)) + "\n";
				                    proceso += "Resultado sin redondear: " + sum + "\n";
				                } catch (ParseException ex) {
				                    JOptionPane.showMessageDialog(null, "Funcion ingresada incorrecta");
				                    correcto = false;
				                }
				                break;
				            case "6":
				                try {
				                    sum = (0.1713245 * fun.EvaluarZ(0.932469514)) + (0.3607616 * fun.EvaluarZ(0.661209386)) + (0.4679139 * fun.EvaluarZ(0.238619186)) + (0.4679139 * fun.EvaluarZ(-0.238619186)) + (0.3607616 * fun.EvaluarZ(-0.661209386)) + (0.1713245 * fun.EvaluarZ(-0.932469514));
				                    proceso += (0.1713245 + "*" + fun.EvaluarZ(0.932469514)) + "+" + (0.3607616 + "*" + fun.EvaluarZ(0.661209386)) + "+" + (0.4679139 + "*" + fun.EvaluarZ(0.238619186)) + "+" + (0.4679139 + "*" + fun.EvaluarZ(-0.238619186)) + "+" + (0.3607616 + "*" + fun.EvaluarZ(-0.661209386)) + "+" + (0.1713245 + "*" + fun.EvaluarZ(-0.932469514));
				                    proceso += "Resultado sin redondear: " + sum + "\n";
				                } catch (ParseException ex) {
				                    JOptionPane.showMessageDialog(null, "Funcion ingresada incorrecta");
				                    correcto = false;
				                }
				                break;

				            default:
				                JOptionPane.showMessageDialog(null, "Puede seleccionar de 2 a 6 puntos");
				                correcto = false;

				        }
				        if (correcto) {
				            String re = "";
				            
				                re = String.format("∫(%s)dx ≈\n∫(%s)dz ≈\n Valor redondeado %s", txtFuncion.getText(), fun.getF(), Double.toString(fun.Redondear(sum)));
				            
				            
				            textArea.setText("\t\tCuadratura Gaussiana \n Funcion:"+txtFuncion.getText()+"\n\nResultado :\n"+proceso + "\n" );
				        } else {
				            JOptionPane.showMessageDialog(null, msg, "ERROR", 0);
				        }
				        txtFuncion.requestFocus();
				}

				catch (java.lang.NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Un caracter no es numerico", "AVISO",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnCalcular.setToolTipText("Calcular cuadratura Gaussiana");
		btnCalcular.setFont(new Font("Tahoma", Font.BOLD, 14));

		txtFuncion = new JTextField();
		txtFuncion.addKeyListener(new KeyAdapter() {
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
		txtFuncion.setBounds(136, 61, 191, 36);
		panel_2.add(txtFuncion);
		txtFuncion.setColumns(10);

		JLabel lblSerieTaylor = new JLabel("Cuadratura Gaussiana");
		lblSerieTaylor.setHorizontalAlignment(SwingConstants.CENTER);
		lblSerieTaylor.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblSerieTaylor.setBounds(236, 0, 263, 36);
		panel_2.add(lblSerieTaylor);

		JLabel lblXInicial = new JLabel("Lim Sup:");
		lblXInicial.setHorizontalAlignment(SwingConstants.CENTER);
		lblXInicial.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblXInicial.setBounds(10, 116, 111, 14);
		panel_2.add(lblXInicial);

		JLabel lblXFinal = new JLabel("Lim Inf:");
		lblXFinal.setHorizontalAlignment(SwingConstants.CENTER);
		lblXFinal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblXFinal.setBounds(10, 159, 111, 14);
		panel_2.add(lblXFinal);
		
		JLabel lblYFinal = new JLabel("N\u00B0 Puntos:");
		lblYFinal.setHorizontalAlignment(SwingConstants.CENTER);
		lblYFinal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblYFinal.setBounds(10, 200, 111, 14);
		panel_2.add(lblYFinal);
		
		txtNpuntos = new JTextField();
		txtNpuntos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if(caracter >= '0' && caracter <= '9' || caracter =='.'|| caracter =='-') {
					
				}else {
					e.consume();
				}
			}
		});
		txtNpuntos.setColumns(10);
		txtNpuntos.setBounds(136, 192, 50, 30);
		panel_2.add(txtNpuntos);
		
		JLabel label = new JLabel("(2-6)");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(10, 220, 111, 14);
		panel_2.add(label);

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
	
	
	 private double[] f;
	    private Funcion_2 fun;
	    
	    public double sumatoria() {
	        double ret = 0;
	        for (int i = 1; i < f.length - 1; i++) {
	            ret += f[i] * 2;
	        }
	        ret += f[0] + f[f.length - 1];
	        return ret;
	    }

	    public double sumatoriaSimpson() {
	        double ret = 0;
	        for (int i = 1; i <= (f.length - 1) / 2; i++) {
	            ret += f[(2 * i) - 1] * 4;
	            proceso += "\t"+(String.format("i = %d\nf(%d) = %f", i, 2*i -1, f[(2*i)-1]));
	        }
	        for (int i = 1; i <= (f.length - 3) / 2; i++) {
	            ret += f[2 * i] * 2;
	            proceso +="\t"+ (String.format("i = %d\nf(%d) = %f", i, 2*i, f[(2*i)]));
	        }
	        ret += f[0] + f[f.length - 1];
	        return ret;
	    }

	    public void dividir(double h) throws ParseException {
	        int x = Integer.parseInt(txtNpuntos.getText());
	        double a = Integer.parseInt(txtLimInf.getText());
	        for (int i = 0; i <= x; i++) {
	            f[i] = fun.Evaluar(a);
	            proceso +="\t"+ (String.format("n = %d\nXn = %f\nF(Xn) = %f\n", i, a, f[i]));
	            a += h;
	        }
	    }

	    public String cambio(String fun, int a, int b) {
	        String ret = fun;
	        int co = b - a;
	        int op = b + a;
	        while (ret.indexOf("x") != -1) {
	            ret = ret.replace("x", ("((" + co + "z" + (op >= 0 ? "+" : "-") + Math.abs(op) + ")" + "(" + (co / 2) + ")" + "/2)")).toString();
	        }
	        //ret.replaceAll("x", ("("+co+"z"+(op>=0 ? "+" : "-")+Math.abs(op)+")"+"("+(co/2)+ ")"+"/2")).toString();
	        //ret.replaceAll("x", String.format("(%sz%s%s)(%s)/2", Integer.toString(co), (op>=0 ? "+" : "-"), Integer.toString(Math.abs(op)), Double.toString(co/2)));
	        return ret;
	    }
}
