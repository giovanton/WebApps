package servletOne;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletExample extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// super.doGet(req, resp);
		String st = req.getParameter("Nombre");
		System.out.println("Haciendo un GET me han pasado este nombre " + st);
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.println("El número de letras que tiene el nombre es " + st.length()+"<br/>");
		pw.println("y su fecha de nacimiento es 01/03/1979");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		super.doPost(req, resp);
		System.out.println("Haciendo un POST");
	}
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
		System.out.println("Estoy en el service");
	}

}
