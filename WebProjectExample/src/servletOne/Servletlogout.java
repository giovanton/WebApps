package servletOne;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet implementation class Servletlogout
 */
@WebServlet("/Servletlogout")
public class Servletlogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static Logger log = LogManager.getRootLogger();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servletlogout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession se = request.getSession(false);
		if (se != null) {
		se.invalidate();
		log.info("Sesión cerrada");

		}
		response.sendRedirect("/WebProjectExample/login.html");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession se = request.getSession(false);
		if (se != null) {
		se.invalidate();
		log.info("Sesión cerrada");

		}
		response.sendRedirect("/WebProjectExample/login.html");
	}

}
