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

public class Teoria_Det2x2 extends JPanel {
	private JLabel lblDet;


	/**
	 * Create the panel.
	 */
	public Teoria_Det2x2() {
		
		setBorder(new LineBorder(SystemColor.activeCaption, 2));

		setBounds(175,11,747, 669);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 11, 727, 647);

		add(panel);
		panel.setLayout(null);
		
		lblDet = new JLabel("DETERMINANTE DE 2X2");
		lblDet.setBackground(new Color(255, 255, 255));
		lblDet.setHorizontalAlignment(SwingConstants.CENTER);
		lblDet.setFont(new Font("Sylfaen", Font.BOLD, 21));
		lblDet.setForeground(Color.BLUE);
		lblDet.setBounds(10, 35, 707, 35);
		panel.add(lblDet);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(20, 81, 686, 544);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel((String) null);
		lblNewLabel.setIcon(new ImageIcon(Teoria_Det2x2.class.getResource("/imagenes_teoria_det2x2/i1.PNG")));
		lblNewLabel.setBounds(204, 30, 152, 41);
		panel_1.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Teoria_Det2x2.class.getResource("/imagenes_teoria_det2x2/i2.PNG")));
		label.setBounds(188, 106, 231, 33);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Teoria_Det2x2.class.getResource("/imagenes_teoria_det2x2/i3.PNG")));
		label_1.setBounds(198, 205, 231, 60);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Teoria_Det2x2.class.getResource("/imagenes_teoria_det2x2/i4.PNG")));
		label_2.setBounds(158, 288, 340, 94);
		panel_1.add(label_2);

		JTextArea det = new JTextArea();
		det.setForeground(Color.BLACK);
		det.setFont(new Font("Monospaced", Font.PLAIN, 14));
		det.setText("Sea A una matriz 2 × 2:\r\n\n\n" + 
				"El determinante A se define como: " + "\n\n\n\n" + "Ejemplo: "+ "\n" + "Calcule el determinante de: "+"\n\n\n\n" +
				"Solucion: " + "\n\n\n\n\n\n\n" + "Una forma de memorizar el calculo del determinante de una matriz de 2×2 es la"+ "\n" +"siguiente: escribir los elementos de la matriz y hacer los productos en diagonal de" +"\n"+
				"manera que los que van de izquierda-arriba a derecha-abajo iran multiplicados por" + "\n"+"1 mientras que los productos de izquierda-abajo a derecha-arriba iran multiplicados\r\n" + 
						"por −1");
						det.setBounds(10, 11, 666, 522);
		panel_1.add(det);

	}
}
