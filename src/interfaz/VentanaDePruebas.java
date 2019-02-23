package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.FlowLayout;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;

public class VentanaDePruebas {
JPanel panel1, panel2;

	private JFrame frame;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDePruebas window = new VentanaDePruebas();
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
	public VentanaDePruebas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		
		frame.setBounds(100, 100, 980, 486);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
			panel1 = new JpanelSel();
		frame.getContentPane().add(panel1);
			panel2 = new JpaneResta();
		frame.getContentPane().add(panel2);
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(SystemColor.activeCaption, 2));
		panel_1.setBounds(10, 11, 147, 426);
		frame.getContentPane().add(panel_1);
		
		
		
		JButton btnNewButton = new JButton("Multiplicar");
		btnNewButton.setBounds(10, 7, 127, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		panel2.setVisible(false);
		panel1.setVisible(true);
		panel1.setBounds(165, 11, 751, 480);
			}
		});
		panel_1.setLayout(null);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Resta");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel1.setVisible(false);
				panel2.setVisible(true);
				panel2.setBounds(165, 11, 751, 480);
			}
		});
		btnNewButton_1.setBounds(10, 35, 127, 23);
		panel_1.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setBounds(23, 228, 86, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		
	}
}
