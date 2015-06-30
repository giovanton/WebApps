package servletOne.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import servletOne.ConectaDB;
import servletOne.dto.Employees;

public class EmpHiberDAO implements Recuperable {
	private static Logger log = LogManager.getRootLogger();
	private Session s = null;
	//private SessionFactory factory = null;

	@Override
	public Employees leerEmpleado(int n) {
		Employees emp = null;
		try {
			/*Configuration conf = new Configuration().configure();
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
					.applySettings(conf.getProperties());
			factory = conf.buildSessionFactory(builder.build());*/
			s = ConectaDB.getSesion();

			emp = (Employees) s.get(Employees.class, n);
		} catch (Exception e) {
			log.error("Fallo al recuperar Empleado mediante Hibernate",e);
		} finally {
			ConectaDB.cerrarSesion(s);
		}
		return emp;
	}

}
