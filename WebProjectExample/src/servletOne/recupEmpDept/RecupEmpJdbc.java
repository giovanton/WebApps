package servletOne.recupEmpDept;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;








import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import servletOne.Pool;
import servletOne.dao.EmpJdbcDAO;
import servletOne.dto.Empleado;

public class RecupEmpJdbc extends HttpServlet{
	private static Logger log = LogManager.getRootLogger();
	public RecupEmpJdbc() {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		EmpJdbcDAO sd = new EmpJdbcDAO();
		// super.doGet(req, resp);
		log.info("Se ha usado un doGet");
		String ids = req.getParameter("ID");
		Connection con = Pool.getConnection();
		log.info("Se ha obtenido una conexión");
		Long id = Long.parseLong(ids);
		sd.setCon(con);
		Empleado emp = null;
		try {
			emp = sd.recuperarEmpleado(id);
			log.info("Se ha recuperado el empleado con la id " + id);
		} catch (NumberFormatException | SQLException e) {
			log.error("Fallo al recuperar el empleado",e);
		}
		/*resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.println("Nombre del empleado : " + emp.getFirst_name() + 
				" Apellido : " + emp.getLast_name() + " Salario : " +emp.getSalary());*/
		/*req.setAttribute("first_name", emp.getFirst_name());
		req.setAttribute("last_name", emp.getLast_name());
		req.setAttribute("salary", emp.getSalary());*/
		req.setAttribute("emp", emp);
		RequestDispatcher rd = req.getRequestDispatcher("buscaEmpleado.jsp");
		rd.forward(req, resp);
	}

}
