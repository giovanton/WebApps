package servletOne.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import servletOne.ConectaDB;
import servletOne.Pool;

public class AutenticarDAO {
	private Connection con= null;
	private static Logger log = LogManager.getRootLogger();
	
	public boolean autenticar(String n,String p) {
		boolean correcto = false;
		String pass = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
		con = Pool.getConnection();
		pst = con.prepareStatement("SELECT pass_usuario FROM usuarios where nombre_usuario = ?");
		pst.setString(1, n);
		rs = pst.executeQuery();
		while (rs.next()) { 
		pass = rs.getString(1);
		}
		if (pass.equalsIgnoreCase(p)) {
			correcto = true;
		}
		} catch (Exception e) {
			log.error("Fallo al recuperar usuario", e);
		} finally {
			Pool.liberarRecursos(con, pst, rs);
		}
		
		return correcto;
	}
}
