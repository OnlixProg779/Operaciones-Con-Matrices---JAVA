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

public class Teoria_Adjunta extends JPanel {
	private JLabel lblAdjunta;


	/**
	 * Create the panel.
	 */
	public Teoria_Adjunta() {
		
		setBorder(new LineBorder(SystemColor.activeCaption, 2));

		setBounds(175,11,747, 669);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 11, 727, 647);

		add(panel);
		panel.setLayout(null);
		
		lblAdjunta = new JLabel("MULTIPLICACION DE MATRICES");
		lblAdjunta.setBackground(new Color(255, 255, 255));
		lblAdjunta.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdjunta.setFont(new Font("Sylfaen", Font.BOLD, 21));
		lblAdjunta.setForeground(Color.BLUE);
		lblAdjunta.setBounds(10, 35, 707, 35);
		panel.add(lblAdjunta);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(20, 81, 686, 544);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JTextArea adj = new JTextArea();
		adj.setForeground(Color.BLACK);
		adj.setFont(new Font("Monospaced", Font.PLAIN, 14));
		adj.setText("Sea A una matriz de n x n y sea B la matriz de sus cofactores, es decir:\r\n" + 
				" "+ "\n\n\n\n" +
									"El elemento cij de la matriz producto se obtiene multiplicando cada elemento de la" + "\n" + "fila i de la matriz A por cada elemento de la columna j de la matriz B y sumándolos.");
		adj.setBounds(10, 11, 666, 522);
		panel_1.add(adj);
	}

}
