package servlet.modelo;

import org.hibernate.Session;
/**
 * 
 * @author giovanton
 *
 */
public class GenericDAO {
/**
 * Métodos a ser heredados por las clases DAO
 */
	protected Session sesion = null;

	public GenericDAO() {
	}

	public Session getSesion() {
		return sesion;
	}

	public void setSesion(Session s) {
		this.sesion = s;
		
	}

}