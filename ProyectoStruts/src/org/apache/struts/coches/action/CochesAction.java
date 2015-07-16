package org.apache.struts.coches.action;

import org.apache.struts.coches.Coche;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.conversion.annotations.TypeConversion;

public class CochesAction extends ActionSupport {

	private Coche coche;
	private String marca;
	private String matricula;
	
	public CochesAction() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Coche getCoche() {
		return coche;
	}

public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


@TypeConversion(converter="org.apache.struts.coches.ConversorCoches")
	public void setCoche(Coche coche) {
		this.coche = coche;
	}


	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
}
