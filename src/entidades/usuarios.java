package entidades;

import java.util.ArrayList;
import java.util.List;

public class usuarios {
	private int id;
	private String usuario;
	private String password;

	
	public usuarios() {
		
	}

	public usuarios(int id, String usuario, String password) {
		this.id = id;
		this.usuario = usuario;
		this.password = password;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static List<usuarios> enlistar = new ArrayList<usuarios>();
	
	
}
