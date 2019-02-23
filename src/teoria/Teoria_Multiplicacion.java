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

public class Teoria_Multiplicacion extends JPanel {

	private JLabel lblMultiplicacionDeMatrices;

	/**
	 * Create the panel.
	 */
	public Teoria_Multiplicacion() {
		
		setBorder(new LineBorder(SystemColor.activeCaption, 2));

		setBounds(175,11,747, 669);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 11, 727, 647);

		add(panel);
		panel.setLayout(null);
		
		lblMultiplicacionDeMatrices = new JLabel("MULTIPLICACION DE MATRICES");
		lblMultiplicacionDeMatrices.setBackground(new Color(255, 255, 255));
		lblMultiplicacionDeMatrices.setHorizontalAlignment(SwingConstants.CENTER);
		lblMultiplicacionDeMatrices.setFont(new Font("Sylfaen", Font.BOLD, 21));
		lblMultiplicacionDeMatrices.setForeground(Color.BLUE);
		lblMultiplicacionDeMatrices.setBounds(10, 35, 707, 35);
		panel.add(lblMultiplicacionDeMatrices);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(20, 81, 686, 544);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Teoria_Multiplicacion.class.getResource("/imagenes_teoria_multiplicacion/multiplicacion-matrices0.gif")));
		lblNewLabel.setBounds(174, 66, 294, 30);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Teoria_Multiplicacion.class.getResource("/imagenes_teoria_multiplicacion/multiplicacion-matrices.gif")));
		lblNewLabel_1.setBounds(115, 168, 469, 337);
		panel_1.add(lblNewLabel_1);
		
		JTextArea pasosParaMultiplicar = new JTextArea();
		pasosParaMultiplicar.setForeground(Color.BLACK);
		pasosParaMultiplicar.setFont(new Font("Monospaced", Font.PLAIN, 14));
		pasosParaMultiplicar.setText("Dos matrices A y B son multiplicables si el número de columnas de A coincide con el" + "\n" +"número de filas de B. "+ "\n\n\n\n" +
									"El elemento cij de la matriz producto se obtiene multiplicando cada elemento de la" + "\n" + "fila i de la matriz A por cada elemento de la columna j de la matriz B y sumándolos.");
		pasosParaMultiplicar.setBounds(10, 11, 666, 522);
		panel_1.add(pasosParaMultiplicar);

	}

}
