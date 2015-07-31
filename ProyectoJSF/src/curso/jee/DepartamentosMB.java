package curso.jee;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import servlet.dto.Departments;
import servlet.dto.Employees;
import servlet.modelo.ConectaDB;
import servlet.modelo.DepartmentsDAO;
import servlet.modelo.EmployeesDAO;
import servlet.modelo.GenericDAO;
import servlet.modelo.InterfaceDAO;

@ManagedBean
@RequestScoped
public class DepartamentosMB {
	private List<Departments> ld;
	private int selected;
	private List<Employees> lem;
	
	public DepartamentosMB() {
		ld = new ArrayList<Departments>();
		lem = new ArrayList<Employees>();
	}
	
	public void setLd(List<Departments> ld) {
		this.ld = ld;
	}
	
	public List<Departments> getLd() {
		return ld;
	}
	
	
	public int getSelected() {
		return selected;
	}

	public void setSelected(int selected) {
		this.selected = selected;
	}

	public List<Employees> getLem() {
		return lem;
	}

	public void setLem(List<Employees> lem) {
		this.lem = lem;
	}

	@PostConstruct
	@SuppressWarnings("unchecked")
	public void obtenerDepts(){
		InterfaceDAO ddao = new DepartmentsDAO();
	    ((GenericDAO) ddao).setSesion(ConectaDB.getSesion());
		ld = ddao.consultarTodo();
	}
	
	public String buscar(){
		InterfaceDAO edao = new EmployeesDAO();
	    ((GenericDAO) edao).setSesion(ConectaDB.getSesion());
		lem = ((EmployeesDAO) edao).consultarPor("department_id",selected);		
		return "vistaEmp2";
	}
}
