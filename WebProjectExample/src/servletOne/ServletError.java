package servletOne;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServletError extends HttpServlet{
	private static Logger log = LogManager.getRootLogger();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// super.doGet(req, resp);
		Throwable exception = (Throwable) req.getAttribute("javax.servlet.error.exception");
		Integer error_http = (Integer) req.getAttribute("javax.servlet.error.status_code");
		String nomServlet = (String) req.getAttribute("javax.servlet.error.servlet_name");
		String uriPedida = (String) req.getAttribute("javax.servlet.error.request_uri");
	
		if(null == nomServlet) {
			nomServlet = "Desconocido";
		}
		if(null == uriPedida ) {
			uriPedida = "Desconocida";
		}
		if(null == error_http) {
		log.error("Fallo en " + nomServlet + " con excepción " + exception);}
		else {
			log.error("Error al acceder a página " + uriPedida + " con código " +error_http);
		}
		resp.sendRedirect("/WebProjectExample/Error.html");
	}
	

}
