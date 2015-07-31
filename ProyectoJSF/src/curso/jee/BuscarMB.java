package curso.jee;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import servlet.dto.Employees;
import servlet.modelo.ConectaDB;
import servlet.modelo.DepartmentsDAO;
import servlet.modelo.EmployeesDAO;
import servlet.modelo.GenericDAO;
import servlet.modelo.InterfaceDAO;

@ManagedBean
@RequestScoped
public class BuscarMB {

	private int id;
	private Employees empleado;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Employees getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Employees empleado) {
		this.empleado = empleado;
	}
	
	public String buscarEmp() {
		String pagSig = null;
		InterfaceDAO edao = new EmployeesDAO();
	    ((GenericDAO) edao).setSesion(ConectaDB.getSesion());
		empleado = (Employees) edao.leerRegistro(id);
		pagSig = "vistaEmp";
		return pagSig;
	}
}
