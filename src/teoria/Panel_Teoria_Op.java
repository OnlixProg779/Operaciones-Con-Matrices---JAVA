package teoria;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import interfaz.WindPrincipal;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class Panel_Teoria_Op extends JPanel {
	public JLabel lblNewLabel;
	public JLabel lblResta;
	public JLabel lblMultiplicacin;
	public JLabel lblMultiplicacinPor;
	public JLabel lblMatrizAdjunta;
	public JLabel lblMatrizIdentidad;
	
	/**
	 * Create the panel.
	 */
	public Panel_Teoria_Op() {
		this.setBounds(16, 67, 124, 169);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setBounds(0, 0, 124, 216);
		add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel(" -- Suma");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				colorletra(lblNewLabel);
				colornormal(lblResta);
				colornormal(lblMultiplicacin);
				colornormal(lblMatrizAdjunta);
				colornormal(lblMultiplicacinPor);
				colornormal(lblMatrizIdentidad);
				margen(lblNewLabel);
				margennormal(lblResta);
				margennormal(lblMultiplicacin);
				margennormal(lblMatrizAdjunta);
				margennormal(lblMultiplicacinPor);
				margennormal(lblMatrizIdentidad);
				
				WindPrincipal.mostrarTeoria(WindPrincipal.ts);
				
			}
		});
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(0, 11, 124, 14);
		panel.add(lblNewLabel);
		
		lblResta = new JLabel(" -- Resta");
		lblResta.setForeground(Color.BLACK);
		lblResta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				colorletra(lblResta);
				colornormal(lblNewLabel);
				colornormal(lblMultiplicacin);
				colornormal(lblMatrizAdjunta);
				colornormal(lblMultiplicacinPor);
				colornormal(lblMatrizIdentidad);
				margen(lblResta);
				margennormal(lblNewLabel);
				margennormal(lblMultiplicacin);
				margennormal(lblMatrizAdjunta);
				margennormal(lblMultiplicacinPor);
				margennormal(lblMatrizIdentidad);
				WindPrincipal.mostrarTeoria(WindPrincipal.tr);
				
			}
		});
		lblResta.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblResta.setBounds(0, 36, 124, 14);
		panel.add(lblResta);
		
		lblMultiplicacinPor = new JLabel("<html> -- Multiplicaci\u00F3n  		por             Escalar<html>");
		lblMultiplicacinPor.setForeground(Color.BLACK);
		lblMultiplicacinPor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				colorletra(lblMultiplicacinPor);
				colornormal(lblNewLabel);
				colornormal(lblMultiplicacin);
				colornormal(lblMatrizAdjunta);
				colornormal(lblResta);
				colornormal(lblMatrizIdentidad);
				margen(lblMultiplicacinPor);
				margennormal(lblNewLabel);
				margennormal(lblMultiplicacin);
				margennormal(lblMatrizAdjunta);
				margennormal(lblResta);
				margennormal(lblMatrizIdentidad);
				WindPrincipal.mostrarTeoria(WindPrincipal.tr);
			}
		});
		lblMultiplicacinPor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMultiplicacinPor.setBounds(0, 86, 124, 28);
		panel.add(lblMultiplicacinPor);
		
		lblMultiplicacin = new JLabel(" -- Multiplicaci\u00F3n");
		lblMultiplicacin.setForeground(Color.BLACK);
		lblMultiplicacin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				colorletra(lblMultiplicacin);
				colornormal(lblNewLabel);
				colornormal(lblResta);
				colornormal(lblMatrizAdjunta);
				colornormal(lblMultiplicacinPor);
				colornormal(lblMatrizIdentidad);
				margen(lblMultiplicacin);
				margennormal(lblNewLabel);
				margennormal(lblResta);
				margennormal(lblMatrizAdjunta);
				margennormal(lblMultiplicacinPor);
				margennormal(lblMatrizIdentidad);
				
				//mostrar(te);
			}
		});
		lblMultiplicacin.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMultiplicacin.setBounds(0, 61, 124, 14);
		panel.add(lblMultiplicacin);
		
		lblMatrizIdentidad = new JLabel(" -- Matriz Identidad");
		lblMatrizIdentidad.setForeground(Color.BLACK);
		lblMatrizIdentidad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				colorletra(lblMatrizIdentidad);
				colornormal(lblNewLabel);
				colornormal(lblResta);
				colornormal(lblMultiplicacinPor);
				colornormal(lblMultiplicacin);
				colornormal(lblMatrizAdjunta);
				margen(lblMatrizIdentidad);
				margennormal(lblNewLabel);
				margennormal(lblResta);
				margennormal(lblMultiplicacinPor);
				margennormal(lblMultiplicacin);
				margennormal(lblMatrizAdjunta);
				WindPrincipal.mostrarTeoria(WindPrincipal.ti);
			}
		});
		lblMatrizIdentidad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMatrizIdentidad.setBounds(0, 150, 124, 14);
		panel.add(lblMatrizIdentidad);
		
		lblMatrizAdjunta = new JLabel(" -- Matriz Adjunta");
		lblMatrizAdjunta.setForeground(Color.BLACK);
		lblMatrizAdjunta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				colorletra(lblMatrizAdjunta);
				colornormal(lblNewLabel);
				colornormal(lblResta);
				colornormal(lblMultiplicacinPor);
				colornormal(lblMultiplicacin);
				colornormal(lblMatrizIdentidad);
				margen(lblMatrizAdjunta);
				margennormal(lblNewLabel);
				margennormal(lblResta);
				margennormal(lblMultiplicacinPor);
				margennormal(lblMultiplicacin);
				margennormal(lblMatrizIdentidad);
				WindPrincipal.mostrarTeoria(WindPrincipal.tad);

			}
		});
		lblMatrizAdjunta.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMatrizAdjunta.setBounds(0, 125, 124, 14);
		panel.add(lblMatrizAdjunta);
		
		setVisible(false);

		
		
		
	}
	
	
	
	
	
	/**
	void mostrar(JPanel mostrar) {
		
	ts.setVisible(false);
	tr.setVisible(false);
	tm.setVisible(false);
	te.setVisible(false);
	tsa.setVisible(false);
	tde.setVisible(false);
	tco.setVisible(false);
	tad.setVisible(false);
	ti.setVisible(false);
	mostrar.setVisible(true);
	}*/
	
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
