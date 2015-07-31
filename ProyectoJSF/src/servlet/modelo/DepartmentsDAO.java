package servlet.modelo;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import servlet.dto.Departments;



/**
 * 
 * @author giovanton
 *
 */

public class DepartmentsDAO extends GenericDAO implements InterfaceDAO {
	private static Logger log = LogManager.getRootLogger();

	@SuppressWarnings("unchecked")
	@Override
	public List<Departments> consultarTodo() {
		/**Método para consultar toda la tabla departments
		 * @return lista de departments
		 */
		List <Departments> ld = new ArrayList<Departments>();
		try {
	 ld = sesion.createSQLQuery("SELECT * FROM departments").addEntity(Departments.class).list();
			 log.info("Recuperada lista de empleados");
		} catch (Exception e) {
			log.error("Fallo al recuperar lista de departamentos",e);
		} finally {
			ConectaDB.cerrarSesion(sesion);
		}
		
		return ld;
	}

	@Override
	public void modificar(Object o) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object leerRegistro(int id) {
		/**Método para obtener un solo registro de la tabla departments
		 * @param entero id
		 * @return object
		 */
		Integer i = id;
		Departments dep = null;
		try {
		 dep = (Departments)sesion.get(Departments.class, i.shortValue());
		log.info("Recuperado departamento " + id);
		} catch (Exception e) {
			log.error("Fallo al recuperar departamento " + id,e);
		} finally {
			ConectaDB.cerrarSesion(sesion);
		}
		return dep;
	}

}
