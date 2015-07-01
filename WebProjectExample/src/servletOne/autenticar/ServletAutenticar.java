package servletOne.autenticar;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import servletOne.dao.AutenticarDAO;

public class ServletAutenticar extends HttpServlet{
	private static Logger log = LogManager.getRootLogger();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// super.doPost(req, resp);
		String nombre = (String) req.getParameter("nombre");
		String pass = (String) req.getParameter("pass");
		log.info("Pide login el usuario " + nombre);
		AutenticarDAO auth = new AutenticarDAO();
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
				
		if (auth.autenticar(nombre, pass)) {
			HttpSession s1 = null;
			if (null == (s1 = req.getSession(false))) {
				s1 = req.getSession(true);
				log.info("Sesión nueva creada.");
			} else {
				ServletContext sc = req.getServletContext();
				HashMap hm = (HashMap) sc.getAttribute("hm");
				hm.put(s1.getId(), s1);
				sc.setAttribute("hm", hm);
				log.info("Abierta la sesión existente");
			}

			//resp.sendRedirect("/WebProjectExample/logout.html");
			
			pw.println("Bienvenido " + nombre + "</br>");
			pw.println("<a href=\"/WebProjectExample/index.html\">Recuperar Empleados mediante Hibernate</a></br>");
			pw.println("<a href=\"/WebProjectExample/jdbc.html\">Recuperar Empleados mediante JDBC</a></br>");
			pw.println("<a href=\"/WebProjectExample/Cartelera\">Cartelera de cine</a></br>");
			RequestDispatcher rd = req.getRequestDispatcher("SesionesActivas");
			rd.include(req, resp);
			
			pw.println("<form action=\"Servletlogout\" method=\"get\">");
			pw.println("<input type=\"submit\" value=\"salir\">");
			pw.println("</form>");
		} else {
			pw.println("La contraseña o el usuario son incorrectos");
		}
	}
}
