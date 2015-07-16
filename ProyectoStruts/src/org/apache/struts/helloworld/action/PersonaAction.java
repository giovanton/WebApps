package org.apache.struts.helloworld.action;

import com.opensymphony.xwork2.ActionSupport;

public class PersonaAction extends ActionSupport {

	private String nombre;
	private int edad;
	
	 public PersonaAction() {
		// TODO Auto-generated constructor stub
	}
	 
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(nombre+ " " +edad);
		return SUCCESS;
	}
}
