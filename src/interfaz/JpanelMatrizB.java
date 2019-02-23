package interfaz;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DecimalFormat;

import javax.swing.border.MatteBorder;
import javax.swing.text.JTextComponent;

import matrices.MatricesMetodos;

public class JpanelMatrizB extends JPanel {
	public static JTextField[][] textFieldMatriz;
	public static JLabel lblNotificacionB;

	/**
	 * Create the panel.
	 */
	public JpanelMatrizB() {
		setBackground(SystemColor.text);
		setLayout(null);
		setPreferredSize(new Dimension(761, 492));
		inizialize(0, 0);

	}

	public JpanelMatrizB(int a, int b) {
		setLayout(null);
		setPreferredSize(new Dimension(761, 492));
		inizialize(b, a);
		setBackground(SystemColor.text);
	}

	void inizialize(int filas, int columnas) {
//setPreferredSize(new Dimension(filas, columnas));
		textFieldMatriz = new JTextField[filas][columnas];
		controladorB control=new controladorB();
		int tamañoXPanel = columnas * 55;
		int tamañoYPanel = filas * 27;
		int posh = 190;
        int posv =50;
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(0, 2, 0, 2, (Color) new Color(0, 0, 0)));
		panel.setBounds(10, 11, tamañoXPanel, tamañoYPanel);
		add(panel);
		panel.setBackground(SystemColor.text);
		
		lblNotificacionB = new JLabel("");
		lblNotificacionB.setForeground(Color.RED);
		lblNotificacionB.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblNotificacionB.setBounds(10, 0, 450, 11);
		add(lblNotificacionB);
		
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				textFieldMatriz[i][j] = new JTextField("", 4);
				textFieldMatriz[i][j].setBounds(posh, posv, 90, 30);
				panel.add(textFieldMatriz[i][j]);
				textFieldMatriz[i][j].addFocusListener(control);
				posh+=80;
			}
			posv+=30;
			posh=50;
		}
		
		
		this.repaint();

	}
	
	public void llenarMatrizB(double[][] matriz) {
		DecimalFormat df = new DecimalFormat("#0.00");
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[0].length; j++) {
					textFieldMatriz[i][j].setText((df.format(matriz[i][j])));;
				}
			}
		}
	
	public void llenarMatriz(String[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				textFieldMatriz[i][j].setText(((matriz[i][j])));;
			}
		}
	}
	
	

	private class controladorB implements FocusListener{
		@Override
		public void focusGained(FocusEvent arg0) {
			// TODO Auto-generated method stub
			String campo=((JTextComponent)arg0.getSource()).getText();
			if(!MatricesMetodos.esNumerico(campo)&& !campo.equals("")) 
				lblNotificacionB.setText("Error: solo puede ingresar numeros.(coloque un numero para avanzar)");
			else
				lblNotificacionB.setText("");
		}

		@Override
		public void focusLost(FocusEvent arg0) {
			// TODO Auto-generated method stub
			String campo=((JTextComponent)arg0.getSource()).getText();
			if(!MatricesMetodos.esNumerico(campo)&& !campo.equals("")) {
				lblNotificacionB.setText("Error: solo puede ingresar numeros.(coloque un numero para avanzar)");
				((JTextComponent)arg0.getSource()).requestFocus();
			}
		}
			
	}
	
	

	
}
