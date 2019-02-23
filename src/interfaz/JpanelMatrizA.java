package interfaz;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.border.MatteBorder;
import javax.swing.text.JTextComponent;

import matrices.MatricesMetodos;

import javax.swing.JLabel;
import java.awt.Font;

public class JpanelMatrizA extends JPanel {
	public static JTextField[][] textFieldMatriz;
	private static JLabel lblNotificacionA;
	/**
	 * Create the panel.
	 */
	public JpanelMatrizA() {
		setBackground(SystemColor.text);
		setLayout(null);
		setPreferredSize(new Dimension(761, 492));
		inizialize(0, 0);
	}

	public JpanelMatrizA(int a, int b) {
		setLayout(null);
		setPreferredSize(new Dimension(761, 492));
		inizialize(b, a);
		setBackground(SystemColor.text);

	}

	void inizialize(int filas, int columnas) {

		textFieldMatriz = new JTextField[filas][columnas];
		controladorA control=new controladorA();
		int tamañoXPanel = columnas * 55;
		int tamañoYPanel = filas * 27;
		int posh = 190;
        int posv =50;
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(0, 2, 0, 2, (Color) new Color(0, 0, 0)));
		panel.setBounds(10, 11, tamañoXPanel, tamañoYPanel);
		add(panel);
		panel.setBackground(SystemColor.text);
		
		lblNotificacionA = new JLabel("");
		lblNotificacionA.setForeground(Color.RED);
		lblNotificacionA.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblNotificacionA.setBounds(10, 0, 450, 11);
		add(lblNotificacionA);
		
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
	
	private class controladorA implements FocusListener{
		@Override
		public void focusGained(FocusEvent arg0) {
			// TODO Auto-generated method stub
			String campo=((JTextComponent)arg0.getSource()).getText();
			if(!MatricesMetodos.esNumerico(campo)&& !campo.equals("")) 
				lblNotificacionA.setText("Error: solo puede ingresar numeros.(coloque un numero para avanzar)");
			else
				lblNotificacionA.setText("");
		}

		@Override
		public void focusLost(FocusEvent arg0) {
			// TODO Auto-generated method stub
			String campo=((JTextComponent)arg0.getSource()).getText();
			if(!MatricesMetodos.esNumerico(campo)&& !campo.equals("")) {
				lblNotificacionA.setText("Error: solo puede ingresar numeros.(coloque un numero para avanzar)");
				((JTextComponent)arg0.getSource()).requestFocus();
			}
		}
		
		
			
	}
}
