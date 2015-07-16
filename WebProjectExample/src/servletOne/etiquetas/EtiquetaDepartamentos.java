package servletOne.etiquetas;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import servletOne.ConectaDB;
import servletOne.dao.EmpHiberDAO;
import servletOne.dao.EmployeesDAO;
import servletOne.dao.GenericDAO;
import servletOne.dto.Employees;

public class EtiquetaDepartamentos extends SimpleTagSupport{
	private int idDep;
	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		EmployeesDAO edao = new EmployeesDAO();
		((GenericDAO) edao).setSesion(ConectaDB.getSesion());
		List<Employees> le = ((EmployeesDAO)edao).consultarPor("department_Id",idDep);
		getJspContext().getOut().println("<table>");
		getJspContext().getOut().println("<th>Empleados del departamento " + idDep + "</th>");
		for(Employees e:le) {
			//TODO formatear la salida del empleado
			PageContext pc = (PageContext)getJspContext();
			HttpServletRequest req = (HttpServletRequest) pc.getRequest();
			req.setAttribute("emp", e);

			getJspContext().getOut().println("<tr>");
			getJspContext().getOut().println("<td>");
			getJspBody().invoke(null);
			getJspContext().getOut().println("</td>");
			getJspContext().getOut().println("</tr>");
		}
		getJspContext().getOut().println("</table>");
	}
	
	public void setIdDep(int idDep) {
		this.idDep = idDep;
	}
	
	public int getIdDep() {
		return idDep;
	}

}
