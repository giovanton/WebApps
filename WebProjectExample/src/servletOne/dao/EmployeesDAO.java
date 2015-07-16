package servletOne.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import servletOne.ConectaDB;
import servletOne.dto.Employees;


public class EmployeesDAO extends GenericDAO implements InterfaceDAO{
	private static Logger log = LogManager.getRootLogger();

	public EmployeesDAO() {
	}
	
	/* (non-Javadoc)
	 * @see hiberDAO.InterfaceDAO#consultarEmpleados()
	 */

	@SuppressWarnings("unchecked")
	@Override
	public List<Employees> consultarTodo(){ 
		
		/*Método que consulta toda la tabla de empleados
		 * devolviendo una lista de empleados
		*/
		List<Employees> les =  null;
		try {
		les = sesion.createSQLQuery("SELECT * FROM employees").addEntity(Employees.class).list();
		log.info("Recuperada lista de empleados");}
		catch (Exception e) {
			log.error("Fallo al recuperar lista de empleados",e);
		} finally {
			ConectaDB.cerrarSesion(sesion);
		}
		return les;
	}

	/* (non-Javadoc)
	 * @see hiberDAO.InterfaceDAO#modificarEmpleados(entities.Employees)
	 */
	@Override
	public void modificar(Object o) {
		/*Método para modificar un registro de la tabla EMPLOYEES
		 * recibiendo un objeto employees. No devuelve nada en este
		 * método.
		 */
		
		Employees e = (Employees)o;
			sesion.merge(e);
	}

	@Override
	public Object leerRegistro(int id) {
		/*Método que recupera un registro de la tabla EMPLOYEES
		 * recibiendo como parámetro la id del empleado y
		 * devolviendo un objeto object
		 */
		Employees e = null;
		try {
			e = (Employees) sesion.get(Employees.class, id);	
		} catch (Exception ex) {
			log.error("Fallo al recuperar empleado " + id,ex);
		} finally {
			ConectaDB.cerrarSesion(sesion);
		}
		
		return e;
	}

	@SuppressWarnings("unchecked")
	public List<Employees> consultarPor(String campo,int id) {
		/* Método que recupera uno o varios registros de la tabla EMPLOYEES
		 * recibiendo un campo por el que realizar la búsqueda y la id
		 * del mismo y devolviendo una lista de empleados
		 */
		List <Employees> l = null;
		try {
		l = sesion.createSQLQuery("SELECT * FROM employees where " + campo + " = " + id).addEntity(Employees.class).list();
		log.info("Recuperada lista por " + campo);
		} catch (Exception e) {
			log.error("Fallo al recuperar por " + campo,e);
		} finally {
			ConectaDB.cerrarSesion(sesion);
		}
		return l;
	}
}
