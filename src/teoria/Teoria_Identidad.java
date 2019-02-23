package teoria;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

public class Teoria_Identidad extends JPanel {

	/**
	 * Create the panel.
	 */
	public Teoria_Identidad() {
		
		setBackground(SystemColor.inactiveCaptionBorder);
		setBorder(new LineBorder(SystemColor.activeCaption, 2));

		this.setSize(747, 669);

		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 11, 727, 647);

		add(panel);
		panel.setLayout(null);
		
		JLabel lblSumaDeMatrices = new JLabel("MATRIZ IDENTIDAD");
		lblSumaDeMatrices.setHorizontalAlignment(SwingConstants.CENTER);
		lblSumaDeMatrices.setFont(new Font("Sylfaen", Font.BOLD, 21));
		lblSumaDeMatrices.setForeground(SystemColor.window);
		lblSumaDeMatrices.setBounds(10, 35, 707, 35);
		panel.add(lblSumaDeMatrices);

	}

}
