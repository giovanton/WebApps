package curso.jee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import servletOne.dto.Empleado;

import com.google.gson.Gson;

/**
 * Servlet implementation class JsonHandler
 */
public class JsonHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LogManager.getRootLogger();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonHandler() {
        //super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conexion = null;
		Statement st = null;
		ResultSet rs = null;
		PrintWriter out = null;
		Gson gson = new Gson();
		Empleado emp = null;
		
		long employee_id;

		try 
			{
			
			
			employee_id = Long.parseLong(request.getParameter("eid"));
			log.info("Id del Empleado " + employee_id);
			conexion = Pool.getConnection();
			st = conexion.createStatement();
			rs = st.executeQuery("select first_name,last_name,salary from employees where employee_id = " + employee_id);
			
			while(rs.next()) {
				emp = new Empleado(rs.getString(1),rs.getString(2),rs.getFloat(3));
			}
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			String mJson = gson.toJson(emp);
			log.info(emp.getFirst_name() + " " + emp.getLast_name() + " " + emp.getSalary());
			
			response.getWriter().write(mJson);
			//log.info(mJson);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Error al recuperar registro ",e);
		}
		finally {
			Pool.liberarRecursos(conexion, st, rs);
		}
	}
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
