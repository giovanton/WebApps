package servletOne;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.tribes.group.interceptors.TwoPhaseCommitInterceptor.MapEntry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SesionesActivas extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger log = LogManager.getRootLogger();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// super.doGet(req, resp);
		ServletContext sc = req.getServletContext();
		HashMap map = (HashMap) sc.getAttribute("hm");
		Iterator it = map.entrySet().iterator(); //entryset es un conjunto de entradas
		Map.Entry e = null;
		while (it.hasNext()) {
			e = (Map.Entry)it.next();
			log.info(e.getKey() + " " + e.getValue());
		}
		/* se puede hacer con map.getValues.iterator y
		 * asignar los it.next a una variable HTTPSession
		 */
	}
	

}
