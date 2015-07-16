package servletOne.recupEmpDept;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servletOne.dao.EmpHiberDAO;
import servletOne.dao.Recuperable;
import servletOne.dto.Employees;
import servletOne.servicios.EmpService;

public class RecEmpHibernate extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 	super.doGet(req, resp);
		EmpService es = new EmpService();
		Recuperable rec = new EmpHiberDAO();
		es.setRecuperable(rec);
		Integer id = Integer.parseInt(req.getParameter("ID"));
		Employees emp = (Employees)es.leerEmpleado(id);
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.println("Nombre del empleado : " + emp.getFirstName() + 
				" Apellido : " + emp.getLastName() + " Salario : " +emp.getSalary());
		
	}

}
