package teoria;
import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class Teoria_Suma extends JPanel {
	private JLabel lblSumaDeMatrices;
	

	/**
	 * Create the panel.
	 */
	public Teoria_Suma() {

		setBorder(new LineBorder(SystemColor.activeCaption, 2));

		setBounds(175,11,747, 669);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 11, 727, 647);

		add(panel);
		panel.setLayout(null);
		
		lblSumaDeMatrices = new JLabel("SUMA DE MATRICES");
		lblSumaDeMatrices.setBackground(new Color(255, 255, 255));
		lblSumaDeMatrices.setHorizontalAlignment(SwingConstants.CENTER);
		lblSumaDeMatrices.setFont(new Font("Sylfaen", Font.BOLD, 21));
		lblSumaDeMatrices.setForeground(Color.BLUE);
		lblSumaDeMatrices.setBounds(10, 35, 707, 35);
		panel.add(lblSumaDeMatrices);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(20, 81, 686, 544);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Teoria_Suma.class.getResource("/imagenes_teoria_suma/operaciones-con-matrices-1.png")));
		lblNewLabel.setBounds(196, 161, 305, 67);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Teoria_Suma.class.getResource("/imagenes_teoria_suma/operaciones-con-matrices-2.png")));
		lblNewLabel_1.setBounds(220, 319, 270, 74);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Teoria_Suma.class.getResource("/imagenes_teoria_suma/operaciones-con-matrices-3.png")));
		lblNewLabel_2.setBounds(289, 442, 142, 57);
		panel_1.add(lblNewLabel_2);
		
		JTextArea txtrparaPoderSumar = new JTextArea();
		txtrparaPoderSumar.setForeground(Color.BLACK);
		txtrparaPoderSumar.setFont(new Font("Monospaced", Font.PLAIN, 14));
		txtrparaPoderSumar.setText("\r\nPara poder sumar o restar matrices, las matrices deben ser del mismo orden, es" + "\n" +
									"decir, deben tener el mismo n\u00FAmero de filas y de columnas." + "\n\n" + 
									"Por ejemplo: "  + "\n\n" + "Tenemos las matrices A y B:"+ "\n\n\n\n\n" +"Estas dos matrices pueden sumarse ya que tienen el mismo número de filas y columnas.\r\n" + 
											"\r\n" + "Vamos sumando los elemento que ocupen el mismo lugar en cada matriz. Para que quede " + "\n" +
									"más claro, cada uno de ellos está de un color distinto:" + "\n\n\n\n\n\n" + "Finalmente, operamos en cada elemento de la matriz:");											
		txtrparaPoderSumar.setBounds(10, 11, 666, 522);
		panel_1.add(txtrparaPoderSumar);
		
		


	}
}
