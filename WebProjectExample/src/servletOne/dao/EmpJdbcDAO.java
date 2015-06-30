package servletOne.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import servletOne.Pool;
import servletOne.dto.Empleado;

public class EmpJdbcDAO {
	private static Logger log = LogManager.getRootLogger();
	private Connection con = null;
	
	public void setCon(Connection con) {
		this.con = con;
	}
	
	public Empleado recuperarEmpleado(Long id) throws SQLException {
		Empleado emp = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
		pst = con.prepareStatement("SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?");
		pst.setLong(1, id);
		rs = pst.executeQuery();
		while(rs.next()) {
			emp = new Empleado(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getString(7), rs.getLong(8), rs.getString(9), rs.getInt(10), rs.getInt(11));
		}
		}catch (SQLException ex) {
			log.error("Fallo al recuperar empleado mediante jdbc",ex);
		} finally {
			Pool.liberarRecursos(con,pst,rs);
		}
		return emp;
	}
}
