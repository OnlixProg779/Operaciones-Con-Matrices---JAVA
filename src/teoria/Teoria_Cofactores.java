package teoria;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

public class Teoria_Cofactores extends JPanel {

	private JLabel lblCofactores;

	/**
	 * Create the panel.
	 */
	public Teoria_Cofactores() {
		
		setBorder(new LineBorder(SystemColor.activeCaption, 2));

		setBounds(175,11,747, 669);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 11, 727, 647);

		add(panel);
		panel.setLayout(null);
		
		lblCofactores = new JLabel("DETERMINANTE POR EL METODO DE COFACTORES");
		lblCofactores.setBackground(new Color(255, 255, 255));
		lblCofactores.setHorizontalAlignment(SwingConstants.CENTER);
		lblCofactores.setFont(new Font("Sylfaen", Font.BOLD, 21));
		lblCofactores.setForeground(Color.BLUE);
		lblCofactores.setBounds(10, 35, 707, 35);
		panel.add(lblCofactores);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(20, 81, 686, 544);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		

	}

}
