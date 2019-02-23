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

public class Teoria_Escalar extends JPanel {

	private JLabel lblEscalar;

	/**
	 * Create the panel.
	 */
	public Teoria_Escalar() {

		setBorder(new LineBorder(SystemColor.activeCaption, 2));

		setBounds(175,11,747, 669);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 11, 727, 647);

		add(panel);
		panel.setLayout(null);
		
		lblEscalar = new JLabel("MULTIPLICACION DE MATRIZ POR UN ESCALAR");
		lblEscalar.setBackground(new Color(255, 255, 255));
		lblEscalar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEscalar.setFont(new Font("Sylfaen", Font.BOLD, 21));
		lblEscalar.setForeground(Color.BLUE);
		lblEscalar.setBounds(10, 35, 707, 35);
		panel.add(lblEscalar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(20, 81, 686, 544);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Teoria_Escalar.class.getResource("/imagenes_teoria_escalar/mult_esc.PNG")));
		lblNewLabel.setBounds(215, 165, 232, 71);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel((String) null);
		lblNewLabel_1.setIcon(new ImageIcon(Teoria_Escalar.class.getResource("/imagenes_teoria_escalar/mult_esc1.png")));
		lblNewLabel_1.setBounds(105, 264, 473, 126);
		panel_1.add(lblNewLabel_1);
		
		JTextArea pasosParaMultiplicar = new JTextArea();
		pasosParaMultiplicar.setForeground(Color.BLACK);
		pasosParaMultiplicar.setFont(new Font("Monospaced", Font.PLAIN, 14));
		pasosParaMultiplicar.setText("\n\n\n"+"El producto escalar de un número real, r , y una matriz A es la matriz rA. Cada " + "\n" + "elemento de la matriz rA es r veces su elemento correspondiente en A . "+ "\n\n" +
									"Dado el escalar r y la matriz " + "\n\n\n\n" + "Ejemplo: ");
		pasosParaMultiplicar.setBounds(10, 11, 666, 522);
		panel_1.add(pasosParaMultiplicar);
	}

}
