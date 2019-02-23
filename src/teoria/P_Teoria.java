package teoria;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Panel;
import java.awt.SystemColor;

import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class P_Teoria extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4465323865156813473L;
	public JLabel lblDeterminante;
	public JLabel lblSistemaDeEcuaciones;
	public JLabel lblOperacionesConMatrices;

	/**
	 * Create the panel.
	 */
	public P_Teoria() {
		this.setBounds(20,260,135,167);
		setLayout(null);
		add(ptop);
		add(ptd);
		add(ps);

		
		lblOperacionesConMatrices = new JLabel("<html> >>Operaciones con Matrices<html>");
		lblOperacionesConMatrices.setForeground(Color.BLACK);
		lblOperacionesConMatrices.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ptop.setVisible(true);
				ptd.setVisible(false);
				ps.setVisible(false);
				
				lblOperacionesConMatrices.setForeground(SystemColor.RED);
				lblDeterminante.setForeground(SystemColor.BLACK);
				lblSistemaDeEcuaciones.setForeground(SystemColor.BLACK);

				lblDeterminante.setBounds(10,268,139,14);
				lblSistemaDeEcuaciones.setBounds(10,290,139,53);
				
			}
		});
		lblOperacionesConMatrices.setBounds(10, 27, 139, 41);
		lblOperacionesConMatrices.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblOperacionesConMatrices);
		
		lblDeterminante = new JLabel(">>Determinante");
		lblDeterminante.setForeground(Color.BLACK);
		lblDeterminante.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblDeterminante.setBounds(10, 80, 139, 14);
				lblDeterminante.setForeground(SystemColor.RED);
				lblOperacionesConMatrices.setForeground(SystemColor.BLACK);
				lblSistemaDeEcuaciones.setForeground(SystemColor.BLACK);

				ptop.setVisible(false);
				ptd.setVisible(true);
				ps.setVisible(false);

				lblSistemaDeEcuaciones.setBounds(10,290,139,53);

			}
		});
		lblDeterminante.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDeterminante.setBounds(10, 80, 139, 14);
		add(lblDeterminante);
		
		lblSistemaDeEcuaciones = new JLabel("<html> >>Sistema de Ecuaciones Lineales<html>");
		lblSistemaDeEcuaciones.setForeground(Color.BLACK);
		lblSistemaDeEcuaciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblSistemaDeEcuaciones.setBounds(10, 80, 139, 14);
				lblSistemaDeEcuaciones.setForeground(SystemColor.RED);
				lblOperacionesConMatrices.setForeground(SystemColor.BLACK);
				lblDeterminante.setForeground(SystemColor.BLACK);

				ps.setVisible(true);

				ptop.setVisible(false);
				ptd.setVisible(false);
				lblSistemaDeEcuaciones.setBounds(10,105,139,53);
			}
		});
		lblSistemaDeEcuaciones.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSistemaDeEcuaciones.setBounds(10, 105, 139, 53);
		add(lblSistemaDeEcuaciones);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setBounds(0, 0, 135, 167);
		add(panel);
		
		setVisible(false);

	}
	
	
	P_OperacionesBasicas ptop= new P_OperacionesBasicas();
	P_Determinante ptd= new P_Determinante();
	P_SistemaEcuacionesLinelaes ps= new P_SistemaEcuacionesLinelaes();
}
