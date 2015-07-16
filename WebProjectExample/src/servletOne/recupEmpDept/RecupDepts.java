package servletOne.recupEmpDept;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servletOne.ConectaDB;
import servletOne.dao.DepartmentsDAO;
import servletOne.dao.GenericDAO;
import servletOne.dao.InterfaceDAO;
import servletOne.dto.Departments;

/**
 * Servlet implementation class RecupDepts
 */
@WebServlet("/RecupDepts")
public class RecupDepts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecupDepts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		InterfaceDAO ddao = new DepartmentsDAO();
	    ((GenericDAO) ddao).setSesion(ConectaDB.getSesion());
		List<Departments> ld = ddao.consultarTodo();
		request.setAttribute("deps", ld);
		RequestDispatcher rd = request.getRequestDispatcher("vistaEmpDep.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		InterfaceDAO ddao = new DepartmentsDAO();
	    ((GenericDAO) ddao).setSesion(ConectaDB.getSesion());
		List<Departments> ld = ddao.consultarTodo();
		request.setAttribute("deps", ld);
		RequestDispatcher rd = request.getRequestDispatcher("vistaEmpDep.jsp");
		rd.forward(request, response);
	}

}
