package servletOne.listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RSListener implements ServletRequestListener{
	private static Logger log = LogManager.getRootLogger();

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		log.info("Ha sucedido un requestDestroyed");
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		log.info("Ha sucedido un requestInitialized");
		
	}

}
