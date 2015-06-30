package servletOne.listeners;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class ContextListener implements ServletContextListener{

	private static Logger log = LogManager.getRootLogger();
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		/*Configuration conf = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
		SessionFactory sf = conf.buildSessionFactory(builder.build());*/
		
		ServletContext sc = null;
		int cuentaPasos = 0;
		log.info("Se ha inicializado el contexto");
		HashMap<String,HttpSession> hm = new HashMap<String,HttpSession>(); 
		sc = sce.getServletContext();
		//sc.setAttribute("sf", sf);
		sc.setAttribute("cp", cuentaPasos);
		sc.setAttribute("hm", hm);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

		ServletContext sc = sce.getServletContext();
		/*SessionFactory sf = (SessionFactory) sc.getAttribute("sf");
		sf.close();*/
		log.info("Se ha finalizado el contexto");
		
	}

}
