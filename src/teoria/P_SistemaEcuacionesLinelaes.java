package teoria;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;

public class P_SistemaEcuacionesLinelaes extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JLabel lblMtodoMatriz;

	/**
	 * Create the panel.
	 */
	public P_SistemaEcuacionesLinelaes() {
		this.setBounds(26, 147, 124, 123);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setBounds(0, 0, 124, 122);
		add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("<html>-- M\u00E9todo Gauss Jordan<html>");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				colorletra(lblNewLabel);
				colornormal(lblMtodoMatriz);
				margen(lblNewLabel);
				margennormal(lblMtodoMatriz);
			}
		});
		lblNewLabel.setBounds(10, 27, 114, 35);
		panel.add(lblNewLabel);
		
		lblMtodoMatriz = new JLabel("<html> -- M\u00E9todo Matriz Identidad<html>");
		lblMtodoMatriz.setForeground(Color.BLACK);
		lblMtodoMatriz.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMtodoMatriz.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				colorletra(lblMtodoMatriz);
				colornormal(lblNewLabel);
				margen(lblMtodoMatriz);
				margennormal(lblNewLabel);
			}
		});
		lblMtodoMatriz.setBounds(10, 73, 114, 35);
		panel.add(lblMtodoMatriz);

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
