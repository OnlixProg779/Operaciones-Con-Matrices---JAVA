package teoria;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.ImageIcon;

public class Teoria_SARRUS extends JPanel {

	private JLabel lblSarrus;

	/**
	 * Create the panel.
	 */
	public Teoria_SARRUS() {
		
		setBorder(new LineBorder(SystemColor.activeCaption, 2));

		setBounds(175,11,747, 669);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 11, 727, 647);

		add(panel);
		panel.setLayout(null);
		
		lblSarrus = new JLabel("DETERMINANTE POR EL METODO DE SARRUS");
		lblSarrus.setBackground(new Color(255, 255, 255));
		lblSarrus.setHorizontalAlignment(SwingConstants.CENTER);
		lblSarrus.setFont(new Font("Sylfaen", Font.BOLD, 21));
		lblSarrus.setForeground(Color.BLUE);
		lblSarrus.setBounds(10, 35, 707, 35);
		panel.add(lblSarrus);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(20, 81, 686, 544);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Teoria_SARRUS.class.getResource("/imagenes_teoria_sarrus/0_1.gif")));
		lblNewLabel.setBounds(250, 112, 170, 93);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Teoria_SARRUS.class.getResource("/imagenes_teoria_sarrus/0_2.gif")));
		lblNewLabel_1.setBounds(250, 265, 170, 83);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Teoria_SARRUS.class.getResource("/imagenes_teoria_sarrus/160_1.gif")));
		lblNewLabel_2.setBounds(90, 359, 570, 171);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("A=");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(46, 400, 34, 32);
		panel_1.add(lblNewLabel_3);
		
		JTextArea pasosParaMultiplicar = new JTextArea();
		pasosParaMultiplicar.setForeground(Color.BLACK);
		pasosParaMultiplicar.setFont(new Font("Monospaced", Font.PLAIN, 14));
		pasosParaMultiplicar.setText("La regla de Sarrus se usa para calcular el resultado de determinantes de 3x3. Estos " + "\n" + "se emplean para resolver ecuaciones lineales y saber si son compatibles."+ "\n\n" +"Los terminos con signo + estan formados por los elementos de la diagonal principal " + "\n" + "y los de las diagonales paralelas con su correspondiente vertice opuesto. "+ "\n\n\n\n\n\n" +
									"Los terminos con signo - estan formados por los elementos de la diagonal " + "\n" + "secundaria y los de las diagonales paralelas con su correspondiente vertice opuesto. " + "\n\n\n\n\n" + "Ejemplo: ");
		pasosParaMultiplicar.setBounds(10, 11, 666, 522);
		panel_1.add(pasosParaMultiplicar);

	}
}
