package servletOne.recupEmpDept;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import servletOne.ConectaDB;
import servletOne.dao.DepartmentsDAO;
import servletOne.dao.EmployeesDAO;
import servletOne.dao.GenericDAO;
import servletOne.dao.InterfaceDAO;
import servletOne.dto.Departments;
import servletOne.dto.Employees;

/**
 * Servlet implementation class RecupEmpDept
 */
@WebServlet("/RecupEmpDept")
public class RecupEmpDept extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LogManager.getRootLogger();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecupEmpDept() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		InterfaceDAO empdao = new EmployeesDAO();
		((GenericDAO) empdao).setSesion(ConectaDB.getSesion());
		String iDdep = (String) request.getParameter("departamentos");
	log.info(iDdep);
		List<Employees> le = ((EmployeesDAO)empdao).consultarPor("department_id", Integer.parseInt(iDdep));
		request.setAttribute("lem",le);
		RequestDispatcher rd = request.getRequestDispatcher("listaempleados.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		InterfaceDAO empdao = new EmployeesDAO();
		((GenericDAO) empdao).setSesion(ConectaDB.getSesion());
		String iDdep = (String) request.getParameter("departamentos");
	log.info(iDdep);
		((EmployeesDAO)empdao).consultarPor("department_id", Integer.parseInt(iDdep));
		RequestDispatcher rd = request.getRequestDispatcher("listaempleados.jsp");
		rd.forward(request, response);
		
		//((EmployeesDAO) empdao).consultarPor("department_id",Integer.parseInt(request.getParameter("departamentos")));
	}

}
