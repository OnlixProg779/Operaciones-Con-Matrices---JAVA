package teoria;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Panel_Teoria_Det extends JPanel {
	public JLabel label_3;
	public JLabel label_1;
	public JLabel label_2;

	/**
	 * Create the panel.
	 */
	public Panel_Teoria_Det() {
		this.setBounds(26, 97, 124, 169);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 124, 170);
		add(panel);
		
		label_3 = new JLabel("<html> -- Determinante 2x2<html>");
		label_3.setForeground(Color.BLACK);
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				colorletra(label_3);
				colornormal(label_1);
				colornormal(label_2);
				
				margen(label_3);
				margennormal(label_1);
				margennormal(label_2);
				
			}
		});
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(0, 11, 124, 38);
		panel.add(label_3);
		
		label_1 = new JLabel("<html> -- Determinante por Sarrus<html>");
		label_1.setForeground(Color.BLACK);
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				colorletra(label_1);
				colornormal(label_3);
				colornormal(label_2);
				
				margen(label_1);
				margennormal(label_3);
				margennormal(label_2);
			}
		});
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(0, 67, 124, 28);
		panel.add(label_1);
		
		label_2 = new JLabel("<html> -- Determinante por Cofactores<html>");
		label_2.setForeground(Color.BLACK);
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				colorletra(label_2);
				colornormal(label_3);
				colornormal(label_1);
				
				margen(label_2);
				margennormal(label_3);
				margennormal(label_1);
			}
		});
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(0, 120, 124, 28);
		panel.add(label_2);
		
		setVisible(false);
		
	}

	void colorletra(JLabel label) {
		label.setForeground(SystemColor.MAGENTA);
	}
	
	void margen(JLabel label) {
		label.setBorder(LineBorder.createGrayLineBorder());
	}
	
	void colornormal(JLabel label) {
		label.setForeground(SystemColor.BLACK);
	}

	void margennormal(JLabel label) {
		label.setBorder(null);
	}
}
