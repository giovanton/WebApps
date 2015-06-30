package servletOne;


import javax.servlet.ServletContext;

import org.apache.logging.log4j.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class ConectaDB {
	private static Logger log = LogManager.getLogger();
	private static SessionFactory factory;
	private static Session sesion;
	
	static {
		/*Configuración de la conexión para la creación de una factoría de sesiones
		 * static para que solo pueda existir una 
		 */
		Configuration conf = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
		factory = conf.buildSessionFactory(builder.build());
	}
	
	private ConectaDB() {
	}

	/**
	 * Método get que obtiene una sesión nueva de la SessionFactory
	 * @return Session una sesión nueva
	 */
	public static Session getSesion() {
		/* Método get para obtener una nueva sesión de la factoría
		 * devuelve una sesión nueva.
		 */
		
		sesion = factory.openSession();
		log.info("Se ha obtenido una sesión");
		return sesion;
	}
	
	/**
	 * Método para cerrar la sesión y la conexión con la base de datos.
	 * @param s Sesión en uso para su cierre.
	 */
	public static void cerrarSesion(Session s) {
		/*Método para cerrar la sesión una vez finalizada la transacción
		 * se le tiene que pasar una sesión y devuelve un mensaje de conexión cerrada. */ 
		s.close();
		log.info("Sesión cerrada con éxito.");
	}
}
