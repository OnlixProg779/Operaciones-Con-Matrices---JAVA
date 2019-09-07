package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import paneles.JpanelCuadraturaGaussiana;
import paneles.JpanelDerivacionNumerica;
import paneles.JpanelFondo;
import paneles.JpanelNewtonCotes;
import paneles.JpanelRungeKutta;
import paneles.JpanelSel;
import paneles.JpanelTaylor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class WindPrincipal {

	JPanel panelSel, panelTaylor, panelRungeKutta, panelNewtonCotes, panelCuadraturaGaussiana, panelDerivacionNumerica;

	public JFrame frmProyectoMtodos;

	private JPanel panel;
	private JScrollPane scrollPane;
	private JPanel panel_1;
	private JButton btnrungeKutta;
	private JButton btnderivacinNumerica;
	private JButton btnnewtoncotes;
	private JButton btncuadraturaGaussiana;

	private void mostrar(JPanel mostrar) {

		panelSel.setVisible(false);
		panelTaylor.setVisible(false);
		panel_1.setVisible(false);
		panelRungeKutta.setVisible(false);
		panelDerivacionNumerica.setVisible(false);
		panelCuadraturaGaussiana.setVisible(false);
		panelNewtonCotes.setVisible(false);

		mostrar.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public WindPrincipal() {
		initialize();
		frmProyectoMtodos.setTitle("Proyecto - M\u00E9todos Num\u00E9ricos");
		frmProyectoMtodos.setLocationRelativeTo(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProyectoMtodos = new JFrame();
		frmProyectoMtodos.setResizable(false);
		frmProyectoMtodos.setBackground(new Color(0, 0, 0));
		frmProyectoMtodos.getContentPane().setBackground(UIManager.getColor("Button.focus"));
		frmProyectoMtodos.setBounds(100, 100, 938, 725);
		frmProyectoMtodos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProyectoMtodos.getContentPane().setLayout(null);

		panelSel = new JpanelSel();
		panelSel.setBounds(-10008, -10031, 747, 669);
		frmProyectoMtodos.getContentPane().add(panelSel);

		panelTaylor = new JpanelTaylor();
		panelTaylor.setBounds(-10008, -10031, 747, 669);
		frmProyectoMtodos.getContentPane().add(panelTaylor);

		panelRungeKutta = new JpanelRungeKutta();
		panelRungeKutta.setBounds(-10008, -10031, 747, 669);
		frmProyectoMtodos.getContentPane().add(panelRungeKutta);

		panelNewtonCotes = new JpanelNewtonCotes();
		panelNewtonCotes.setBounds(-10008, -10031, 747, 669);
		frmProyectoMtodos.getContentPane().add(panelNewtonCotes);

		panelCuadraturaGaussiana = new JpanelCuadraturaGaussiana();
		panelCuadraturaGaussiana.setBounds(-10008, -10031, 747, 669);
		frmProyectoMtodos.getContentPane().add(panelCuadraturaGaussiana);

		panelDerivacionNumerica = new JpanelDerivacionNumerica();
		panelDerivacionNumerica.setBounds(-10008, -10031, 747, 669);
		frmProyectoMtodos.getContentPane().add(panelDerivacionNumerica);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 169, 700);
		frmProyectoMtodos.getContentPane().add(scrollPane);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);

		panel.setBorder(new LineBorder(new Color(244, 247, 252), 8));
		scrollPane.setViewportView(panel);

		JButton btnsistemasDeEcuaciones = new JButton("<html>Resoluci\u00F3n de Ecuaciones<html>");
		btnsistemasDeEcuaciones.setIcon(null);
		btnsistemasDeEcuaciones.setBackground(Color.WHITE);
		btnsistemasDeEcuaciones.setBorder(null);
		btnsistemasDeEcuaciones.setBorderPainted(false);
		btnsistemasDeEcuaciones.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 11));
		btnsistemasDeEcuaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrar(panelSel);
				panelSel.setBounds(175, 11, 747, 669);

			}
		});
		panel.setLayout(new GridLayout(9, 1, 5, 5));

		JButton btnTaylor = new JButton("<html>Serie de Taylor<html>");
		btnTaylor.setIcon(new ImageIcon(WindPrincipal.class.getResource("/wallpapers/Function_8941.png")));
		btnTaylor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				mostrar(panelTaylor);
				panelTaylor.setBounds(175, 11, 747, 669);

			}
		});

		JButton btnInicio = new JButton("Inicio");
		btnInicio.setIcon(new ImageIcon(WindPrincipal.class.getResource("/wallpapers/Home_5699.png")));
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				mostrar(panel_1);
				panel_1.setBounds(165, 11, 747, 669);

			}
		});

		JLabel lblMenDeOpciones = new JLabel("Men\u00FA de Opciones");
		lblMenDeOpciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenDeOpciones.setIcon(new ImageIcon(WindPrincipal.class.getResource("/wallpapers/MainMenuControl_688.png")));
		lblMenDeOpciones.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblMenDeOpciones);
		btnInicio.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 11));
		btnInicio.setBorderPainted(false);
		btnInicio.setBorder(null);
		btnInicio.setBackground(Color.WHITE);
		panel.add(btnInicio);
		btnTaylor.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 11));
		btnTaylor.setBorderPainted(false);
		btnTaylor.setBorder(null);
		btnTaylor.setBackground(Color.WHITE);

		panel.add(btnTaylor);
		panel.add(btnsistemasDeEcuaciones);

		btnderivacinNumerica = new JButton("<html>Derivaci\u00F3n Numerica<html>");
		btnderivacinNumerica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				mostrar(panelDerivacionNumerica);
				panelDerivacionNumerica.setBounds(175, 11, 747, 669);
			}

		});
		btnderivacinNumerica.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 11));
		btnderivacinNumerica.setBorderPainted(false);
		btnderivacinNumerica.setBorder(null);
		btnderivacinNumerica.setBackground(Color.WHITE);
		panel.add(btnderivacinNumerica);

		btnnewtoncotes = new JButton("<html>Newton-Cotes<html>");
		btnnewtoncotes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				mostrar(panelNewtonCotes);
				panelNewtonCotes.setBounds(175, 11, 747, 669);

			}
		});
		btnnewtoncotes.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 11));
		btnnewtoncotes.setBorderPainted(false);
		btnnewtoncotes.setBorder(null);
		btnnewtoncotes.setBackground(Color.WHITE);
		panel.add(btnnewtoncotes);

		btncuadraturaGaussiana = new JButton("<html>Cuadratura Gaussiana<html>");
		btncuadraturaGaussiana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				mostrar(panelCuadraturaGaussiana);
				panelCuadraturaGaussiana.setBounds(175, 11, 747, 669);

			}
		});
		btncuadraturaGaussiana.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 11));
		btncuadraturaGaussiana.setBorderPainted(false);
		btncuadraturaGaussiana.setBorder(null);
		btncuadraturaGaussiana.setBackground(Color.WHITE);
		panel.add(btncuadraturaGaussiana);

		btnrungeKutta = new JButton("<html>Runge Kutta<html>");
		btnrungeKutta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrar(panelRungeKutta);
				panelRungeKutta.setBounds(175, 11, 747, 669);
			}
		});
		btnrungeKutta.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 11));
		btnrungeKutta.setBorderPainted(false);
		btnrungeKutta.setBorder(null);
		btnrungeKutta.setBackground(Color.WHITE);
		panel.add(btnrungeKutta);

		panel_1 = new JpanelFondo("/wallpapers/rawcoverimage.jpg");
		panel_1.setBounds(169, 0, 763, 700);
		frmProyectoMtodos.getContentPane().add(panel_1);

	}

}
