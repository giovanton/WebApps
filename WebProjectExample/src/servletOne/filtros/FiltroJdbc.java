package servletOne.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FiltroJdbc implements Filter{

	private static Logger log = LogManager.getRootLogger();
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		ServletContext sc = request.getServletContext();
		HttpServletRequest hsr = (HttpServletRequest)request;
		HttpServletResponse hsresp = (HttpServletResponse)response;
		String dir = hsr.getRequestURI();
		HttpSession s1 = null;
		if (null == (s1 = hsr.getSession(false))) {
			if (dir.equals("/WebProjectExample/") || dir.equals("/WebProjectExample/login.html") || 
					dir.equals("/WebProjectExample/ServletAutenticar") || dir.equals("/WebProjectExample/Cartelera")) {
				chain.doFilter(request, response); 
				log.info("Te dejo pasar por esta vez...");
			} else {
				hsresp.sendRedirect("/WebProjectExample/login.html");
				log.info("Enviando a login...");		
			}
		} else {
			chain.doFilter(request, response);
			log.info("Pasa, que ya sé quien eres");
		}
		log.info("Va a " + dir);
	
		//Long n1 = System.currentTimeMillis();
			
		/*Long n2 = System.currentTimeMillis();
		//Long tiempo = (n2-n1);
		int cuentaPasos = (int) sc.getAttribute("cp");
		cuentaPasos++;
		sc.setAttribute("cp", cuentaPasos);
		
		log.info("Tiempo Transcurrido entre request/response = " + tiempo);
		log.info("Pasos hasta el momento " + cuentaPasos);*/
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
