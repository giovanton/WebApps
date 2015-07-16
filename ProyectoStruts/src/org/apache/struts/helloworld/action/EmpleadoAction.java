package org.apache.struts.helloworld.action;

import servicios.EmpService;

import com.opensymphony.xwork2.ActionSupport;

import dAOS.EmpHiberDAO;
import dAOS.Recuperable;
import entidades.Employees;

public class EmpleadoAction extends ActionSupport {

	private Employees emp;
	private int id;
	private EmpService es;
	
	public EmpleadoAction() {
		// TODO Auto-generated constructor stub
		emp = null;
		id = 0;
		es = new EmpService();
	}
	
	public Employees getEmp() {
		return emp;
	}
	
	public int getId() {
		return id;
	}
	
	public void setEmp(Employees emp) {
		this.emp = emp;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Recuperable rec = new EmpHiberDAO();
		es.setRecuperable(rec);
		emp = (Employees) es.leerEmpleado(id);
		return SUCCESS;
	}
}
