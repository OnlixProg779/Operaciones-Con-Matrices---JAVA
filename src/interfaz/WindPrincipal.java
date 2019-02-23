package interfaz;

import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import java.awt.Component;
import javax.swing.Box;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import teoria.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JLabel;

public class WindPrincipal {
	JPanel panelSuma, panelResta, panelMultiplicacion, panelEscalar, panelDeterminante, panelAdjunta,
			panelInversa, panelSel;
	private JFrame frame;

	
	
	
	public static JPanel ts;
	public static JPanel tr;
	public static JPanel tm;
	public static JPanel te;
	public static JPanel tsa;
	public static JPanel tde;
	public static JPanel tco;
	public static JPanel tad;
	public static JPanel ti;
	public static JPanel ptop;
	public static JPanel ptd;
	public static JPanel ps;
	
	
	
	
	
	
	
	
	 JPanel teoria;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JPanel panel_1;
	/**
	 * Launch the application.
	 */

	private void mostrar(JPanel mostrar) {
		panelSuma.setVisible(false);
		panelResta.setVisible(false);
		panelMultiplicacion.setVisible(false);
		panelEscalar.setVisible(false);
		panelDeterminante.setVisible(false);
		panelAdjunta.setVisible(false);
		panelInversa.setVisible(false);
		panelSel.setVisible(false);
		panel_1.setVisible(false);
		mostrar.setVisible(true);
	}
	
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindPrincipal window = new WindPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WindPrincipal() {
		initialize();
		frame.setTitle("PROYECTO DE ALGEBRA - MATRICES");
		frame.setLocationRelativeTo(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 938, 726);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		panelSuma = new JpaneSumar();
		panelSuma.setBounds(-10008, -10030, 747, 669);
		frame.getContentPane().add(panelSuma);
		panelResta = new JpaneResta();
		panelResta.setBounds(-10008, -10030, 747, 669);
		frame.getContentPane().add(panelResta);
		panelMultiplicacion = new JpaneMultiplicar();
		panelMultiplicacion.setBounds(-10008, -10030, 747, 669);
		frame.getContentPane().add(panelMultiplicacion);
		
		
		
			
		
		
		
		
		panelEscalar = new JpanelEscalar();
		panelEscalar.setBounds(-10008, -10030, 747, 669);
		frame.getContentPane().add(panelEscalar);
		panelDeterminante = new JpanelDeterminante();
		panelDeterminante.setBounds(-10008, -10030, 747, 669);
		frame.getContentPane().add(panelDeterminante);
		panelAdjunta = new JpanelAdjunta();
		panelAdjunta.setBounds(-10008, -10030, 747, 669);
		frame.getContentPane().add(panelAdjunta);
		
		panelInversa = new JpanelInversa();
		panelInversa.setBounds(-10008, -10030, 747, 669);
		frame.getContentPane().add(panelInversa);
		panelSel = new JpanelSel();
		panelSel.setBounds(-10008, -10030, 747, 669);
		frame.getContentPane().add(panelSel);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 152, 658);
		frame.getContentPane().add(scrollPane);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		
		panel.setBorder(new LineBorder(new Color(244, 247, 252), 8));
		scrollPane.setViewportView(panel);
		panel.setLayout(null);

		JButton btn_Sumar = new JButton("Sumar");
		btn_Sumar.setBackground(Color.WHITE);
		btn_Sumar.setBorder(null);
		btn_Sumar.setBorderPainted(false);
		btn_Sumar.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 11));
		btn_Sumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrar(panelSuma);
				panelSuma.setBounds(165, 11, 747, 669);
			}
		});
		btn_Sumar.setHorizontalAlignment(SwingConstants.LEFT);
		btn_Sumar.setBounds(11, 80, 129, 23);
		panel.add(btn_Sumar);

		JButton btn_Restar = new JButton("Restar");
		btn_Restar.setBackground(Color.WHITE);
		btn_Restar.setBorder(null);
		btn_Restar.setBorderPainted(false);
		btn_Restar.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 11));
		btn_Restar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrar(panelResta);
				panelResta.setBounds(165, 11, 747, 669);
			}
		});
		btn_Restar.setHorizontalAlignment(SwingConstants.LEFT);
		btn_Restar.setBounds(10, 113, 130, 23);
		panel.add(btn_Restar);

		JButton btn_Multiplicar = new JButton("Multiplicar");
		btn_Multiplicar.setBackground(Color.WHITE);
		btn_Multiplicar.setBorder(null);
		btn_Multiplicar.setBorderPainted(false);
		btn_Multiplicar.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 11));
		btn_Multiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrar(panelMultiplicacion);
				panelMultiplicacion.setBounds(165, 11, 747, 669);
			}
		});
		btn_Multiplicar.setHorizontalAlignment(SwingConstants.LEFT);
		btn_Multiplicar.setBounds(10, 147, 130, 23);
		panel.add(btn_Multiplicar);

		JButton btnPorUnEscalar = new JButton("Por un Escalar");
		btnPorUnEscalar.setBackground(Color.WHITE);
		btnPorUnEscalar.setBorder(null);
		btnPorUnEscalar.setBorderPainted(false);
		btnPorUnEscalar.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 11));
		btnPorUnEscalar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrar(panelEscalar);
				panelEscalar.setBounds(165, 11, 747, 669);
			}
		});
		btnPorUnEscalar.setHorizontalAlignment(SwingConstants.LEFT);
		btnPorUnEscalar.setBounds(11, 181, 129, 23);
		panel.add(btnPorUnEscalar);

		JButton btnDeterminante = new JButton("Determinante");
		btnDeterminante.setBackground(Color.WHITE);
		btnDeterminante.setBorder(null);
		btnDeterminante.setBorderPainted(false);
		btnDeterminante.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 11));
		btnDeterminante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrar(panelDeterminante);
				panelDeterminante.setBounds(165, 11, 747, 669);
			}
		});
		btnDeterminante.setHorizontalAlignment(SwingConstants.LEFT);
		btnDeterminante.setBounds(11, 215, 129, 23);
		panel.add(btnDeterminante);

		JButton btnMatrizAdjunta = new JButton("Matriz Adjunta");
		btnMatrizAdjunta.setBackground(Color.WHITE);
		btnMatrizAdjunta.setBorder(null);
		btnMatrizAdjunta.setBorderPainted(false);
		btnMatrizAdjunta.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 11));
		btnMatrizAdjunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrar(panelAdjunta);
				panelAdjunta.setBounds(165, 11, 747, 669);
			}
		});
		btnMatrizAdjunta.setHorizontalAlignment(SwingConstants.LEFT);
		btnMatrizAdjunta.setBounds(11, 249, 129, 23);
		panel.add(btnMatrizAdjunta);

		JButton btnMatrizInversa = new JButton("Matriz Inversa");
		btnMatrizInversa.setBackground(Color.WHITE);
		btnMatrizInversa.setBorder(null);
		btnMatrizInversa.setBorderPainted(false);
		btnMatrizInversa.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 11));
		btnMatrizInversa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrar(panelInversa);
				panelInversa.setBounds(165, 11, 747, 669);
			}
		});
		btnMatrizInversa.setHorizontalAlignment(SwingConstants.LEFT);
		btnMatrizInversa.setBounds(11, 283, 129, 23);
		panel.add(btnMatrizInversa);

		JButton btnsistemasDeEcuaciones = new JButton("<html>Sistemas De Ecuaciones Lineales<html>");
		btnsistemasDeEcuaciones.setBackground(Color.WHITE);
		btnsistemasDeEcuaciones.setBorder(null);
		btnsistemasDeEcuaciones.setBorderPainted(false);
		btnsistemasDeEcuaciones.setHorizontalAlignment(SwingConstants.LEFT);
		btnsistemasDeEcuaciones.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 11));
		btnsistemasDeEcuaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrar(panelSel);
				panelSel.setBounds(165, 11, 747, 669);

			}
		});
		btnsistemasDeEcuaciones.setVerticalAlignment(SwingConstants.TOP);
		btnsistemasDeEcuaciones.setBounds(11, 317, 129, 51);
		panel.add(btnsistemasDeEcuaciones);
		
		JLabel lblMenDeOpciones = new JLabel("Men\u00FA de Opciones");
		lblMenDeOpciones.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMenDeOpciones.setBounds(11, 11, 129, 23);
		panel.add(lblMenDeOpciones);
		
		JButton btnInicio = new JButton("Inicio");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				mostrar(panel_1);
				panel_1.setBounds(165, 11, 747, 669);
				
			}
		});
		btnInicio.setHorizontalAlignment(SwingConstants.LEFT);
		btnInicio.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 11));
		btnInicio.setBorderPainted(false);
		btnInicio.setBorder(null);
		btnInicio.setBackground(Color.WHITE);
		btnInicio.setBounds(11, 45, 129, 23);
		panel.add(btnInicio);
		
		
		panel_1 = new JpanelFondo("/imagenes_menu/imagennn.png");
		panel_1.setBounds(172, 11, 740, 658);
		frame.getContentPane().add(panel_1);
		
		
		
		
		
		
	}
	
	
	public static void mostrarTeoria(JPanel mostrar) {
		
		ts.setVisible(false);
		tr.setVisible(false);
		tm.setVisible(false);
		te.setVisible(false);
		tsa.setVisible(false);
		tde.setVisible(false);
		tco.setVisible(false);
		tad.setVisible(false);
		ti.setVisible(false);
		mostrar.setBounds(165, 11, 747, 669);
		mostrar.setVisible(true);
		}
}
