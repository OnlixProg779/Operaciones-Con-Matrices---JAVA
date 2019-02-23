package teoria;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class P_OperacionesBasicas extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4098724945706540713L;
	public JLabel lblNewLabel;
	public JLabel lblResta;
	public JLabel lblMultiplicacin;
	public JLabel lblMultiplicacinPor;
	public JLabel lblMatrizAdjunta;
	public JLabel lblMatrizIdentidad;

	/**
	 * Create the panel.
	 */
	public P_OperacionesBasicas() {
		this.setBounds(16, 67, 124, 169);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setBounds(0, 0, 124, 170);
		add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel(" -- Suma");
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
				mostrar(ts);
			}
		});
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(0, 11, 124, 14);
		panel.add(lblNewLabel);
		
		lblResta = new JLabel(" -- Resta");
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
				mostrar(tr);
				
			}
		});
		lblResta.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblResta.setBounds(0, 36, 124, 14);
		panel.add(lblResta);
		
		lblMultiplicacinPor = new JLabel("<html> -- Multiplicaci\u00F3n  		por             Escalar<html>");
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
				mostrar(tr);
			}
		});
		lblMultiplicacinPor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMultiplicacinPor.setBounds(0, 86, 124, 28);
		panel.add(lblMultiplicacinPor);
		
		lblMultiplicacin = new JLabel(" -- Multiplicaci\u00F3n");
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
				mostrar(ti);
			}
		});
		lblMatrizIdentidad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMatrizIdentidad.setBounds(0, 150, 124, 14);
		panel.add(lblMatrizIdentidad);
		
		lblMatrizAdjunta = new JLabel(" -- Matriz Adjunta");
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
				mostrar(tad);
			}
		});
		lblMatrizAdjunta.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMatrizAdjunta.setBounds(0, 125, 124, 14);
		panel.add(lblMatrizAdjunta);
		
		setVisible(false);

	}
	
	JPanel ts = new Teoria_Suma();
	JPanel tr = new Teoria_Resta();
	JPanel tm= new Teoria_Multiplicacion();
	JPanel te = new Teoria_Escalar();
	JPanel tsa = new Teoria_SARRUS();
	JPanel tde= new Teoria_Det2x2();
	JPanel tco = new Teoria_Cofactores();
	JPanel tad = new Teoria_Adjunta();
	JPanel ti = new Teoria_Identidad();
	
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
