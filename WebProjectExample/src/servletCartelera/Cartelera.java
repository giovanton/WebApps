package servletCartelera;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import servletCartelera.pojo.Pelicula;
import servletCartelera.servicios.ParseaXML;

/**
 * Servlet implementation class Cartelera
 */
@WebServlet(description = "Servlet que muestra la cartelera de un cine.", urlPatterns = { "/Cartelera" })
public class Cartelera extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LogManager.getRootLogger();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cartelera() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ParseaXML px = new ParseaXML();
		@SuppressWarnings("unchecked")
		ArrayList<Pelicula> lista = (ArrayList<Pelicula>) px.extraerCartelera();
		//log.info("pasando por extraer");
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		//pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>");
		pw.println("Estrenos de Cine - Cartelera Semanal");
		pw.println("</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<u>Estrenos de Cine</u> </br>");
		for(Pelicula p:lista) {
			pw.println(p.getNombre() + "</br>");
			pw.println("Estreno día " + p.getFechaEstreno() + "</br>");
			pw.println("<img src=\"" + p.getMedia() + "\"/> </br>" );
			pw.println("Más Info en : <a href=\"" + p.getMasInfo() + "\">aqui</a></br></br>");
		}
		pw.println("</body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ParseaXML px = new ParseaXML();
		@SuppressWarnings("unchecked")
		ArrayList<Pelicula> lista = (ArrayList<Pelicula>) px.extraerCartelera();
		log.info("pasando por extraer");
		PrintWriter pw = response.getWriter();
		pw.println("Estrenos de Cine </br>");
		for(Pelicula p:lista) {
			pw.println(p.getNombre() + "</br>");
			pw.println("Estreno día " + p.getFechaEstreno() + "</br>");
			pw.println("<img src=\" " + p.getMedia() + "\"/> </br>" );
			pw.println("Más Info en : <a ref=\"" + p.getMasInfo() + "\">aqui</a></br></br>");
		}
	}

}
