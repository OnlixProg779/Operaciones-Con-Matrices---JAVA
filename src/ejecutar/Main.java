package ejecutar;

import java.awt.EventQueue;

import vista.WindPrincipal;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindPrincipal window = new WindPrincipal();
					window.frmProyectoMtodos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
