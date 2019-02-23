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

public class Teoria_Resta extends JPanel {

	private JLabel lblRestaDeMatrices;

	/**
	 * Create the panel.
	 */
	public Teoria_Resta() {

		setBorder(new LineBorder(SystemColor.activeCaption, 2));

		setBounds(175,11,747, 669);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 11, 727, 647);

		add(panel);
		panel.setLayout(null);
		
		lblRestaDeMatrices = new JLabel("RESTA DE MATRICES");
		lblRestaDeMatrices.setBackground(new Color(255, 255, 255));
		lblRestaDeMatrices.setHorizontalAlignment(SwingConstants.CENTER);
		lblRestaDeMatrices.setFont(new Font("Sylfaen", Font.BOLD, 21));
		lblRestaDeMatrices.setForeground(Color.BLUE);
		lblRestaDeMatrices.setBounds(10, 35, 707, 35);
		panel.add(lblRestaDeMatrices);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(20, 81, 686, 544);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(169, 139, 375, 111);
		panel_1.add(label);
		label.setIcon(new ImageIcon(Teoria_Resta.class.getResource("/imagenes_teoria_resta/restadematrices1.jpg")));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Teoria_Resta.class.getResource("/imagenes_teoria_resta/restadematrices2.jpg")));
		lblNewLabel.setBounds(103, 290, 99, 89);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Teoria_Resta.class.getResource("/imagenes_teoria_resta/restadematrices3.jpg")));
		lblNewLabel_1.setBounds(252, 290, 123, 89);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(Teoria_Resta.class.getResource("/imagenes_teoria_resta/restadematrices4.jpg")));
		lblNewLabel_2.setBounds(429, 290, 115, 89);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Teoria_Resta.class.getResource("/imagenes_teoria_resta/restadematrices5.jpg")));
		lblNewLabel_3.setBounds(250, 438, 180, 84);
		panel_1.add(lblNewLabel_3);
		
		JTextArea pasosParaRestar = new JTextArea();
		pasosParaRestar.setForeground(Color.BLACK);
		pasosParaRestar.setFont(new Font("Monospaced", Font.PLAIN, 14));
		pasosParaRestar.setText("Para poder restar, se aplica el mismo método de suma de matrices, se deben restar" + "\n" + "entre sí aquellos componentes que se sitúan en la misma posición." + "\n\n" +
								"Por ejemplo: " + "\n\n" + "Tenemos las matrices A y B:"+ "\n\n\n\n\n\n\n" + "Estas dos matrices pueden restarse ya que tienen el mismo número de filas y columnas.\r\n" +
								"\r\n\n\n\n\n\n" + "Sólo queda ordenar los números para obtener el resultado de esta resta de matrices," + "\n" + "como se presenta a continuación:");
		pasosParaRestar.setBounds(10, 11, 666, 522);
		panel_1.add(pasosParaRestar);
	}

}
