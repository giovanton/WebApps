package servletOne.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EjemploFiltro implements Filter{
	private static Logger log = LogManager.getRootLogger();

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		log.info("Se ha iniciado el filtro");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		ServletContext sc = request.getServletContext();
		Long n1 = System.currentTimeMillis();
		chain.doFilter(request, response);
		Long n2 = System.currentTimeMillis();
		Long tiempo = (n2-n1);
		int cuentaPasos = (int) sc.getAttribute("cp");
		cuentaPasos++;
		sc.setAttribute("cp", cuentaPasos);
		
		log.info("Tiempo Transcurrido entre request/response = " + tiempo);
		log.info("Pasos hasta ahora " + cuentaPasos);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		log.info("Se ha destruido un filtro");
	}
	

}
