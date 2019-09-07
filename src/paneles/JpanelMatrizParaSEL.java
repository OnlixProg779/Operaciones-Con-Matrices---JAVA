package paneles;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.SystemColor;

import javax.swing.border.MatteBorder;

public class JpanelMatrizParaSEL extends JPanel {
	public static JTextField[][] textFieldMatriz;
	public static JLabel[][] labelMatriz; 
	public static JTextField[] textFieldMatrizResultado;
	/**
	 * Create the panel.
	 */
	public JpanelMatrizParaSEL() {
		setBackground(SystemColor.text);
		setLayout(null);
		setPreferredSize(new Dimension(761, 492));
		inizialize(0, 0);
	}

	public JpanelMatrizParaSEL(int a, int b) {
		setLayout(null);
		setPreferredSize(new Dimension(761, 492));
		inizialize(b, a);
		setBackground(SystemColor.text);
	}

	void inizialize(int filas, int columnas) {

		textFieldMatriz = new JTextField[filas][columnas];
		labelMatriz = new JLabel[filas][columnas];
		textFieldMatrizResultado = new JTextField[columnas];
		
		int tamañoXPanel = (columnas+1) * 78;
		int tamañoYPanel = filas * 27;
		int posh = 190;
        int posv =50;
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(0, 2, 0, 2, (Color) new Color(0, 0, 0)));
		panel.setBounds(10, 11, tamañoXPanel, tamañoYPanel);
		add(panel);
		panel.setBackground(SystemColor.text);
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				textFieldMatriz[i][j] = new JTextField("", 4);
				textFieldMatriz[i][j].setHorizontalAlignment(SwingConstants.RIGHT);
				//textFieldMatriz[i][j].setBounds(posh, posv, 66, 27);
				panel.add(textFieldMatriz[i][j]);
				if(j!= columnas-1) {
				labelMatriz[i][j] = new JLabel("X"+j+" ");
				}else {
					labelMatriz[i][j] = new JLabel("X"+j+"  = ");
				}
				panel.add(labelMatriz[i][j]);
			
			}
			textFieldMatrizResultado[i] = new JTextField("", 4);
			textFieldMatrizResultado[i].setBounds(posh, posv, 90, 30);
			panel.add(textFieldMatrizResultado[i]);
			
			
		}
	//	this.setPreferredSize(new Dimension(filas, columnas));
		this.repaint();
	}
	
	

}
