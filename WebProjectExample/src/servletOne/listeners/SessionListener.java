package servletOne.listeners;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class SessionListener implements HttpSessionListener{
	private static Logger log = LogManager.getRootLogger();

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		HashMap hmt = null;
		HttpSession sesion = se.getSession();
		ServletContext sc = sesion.getServletContext();
		String sid = sesion.getId();
		
		hmt = (HashMap) sc.getAttribute("hm");
		hmt.put(sid, sesion);
		sc.setAttribute("hm", hmt);
		log.info("Se ha creado una sesión");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		HashMap hmt = null;
		ServletContext sc = se.getSession().getServletContext();
		hmt = (HashMap) sc.getAttribute("hm");
		String sid = se.getSession().getId();
		HttpSession sesion = (HttpSession) hmt.get(sid);
		log.info("Se elimina la sesión " + sesion);
		hmt.remove(sid);
		sc.setAttribute("hm", hmt);
		log.info("Se ha destruido una sesión");
	}

}
