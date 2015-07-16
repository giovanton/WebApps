package org.apache.struts.coches;

public class Coche {
	private String marca;
	private String matricula;
	
	public Coche() {
		// TODO Auto-generated constructor stub
	}

	public Coche(String marca, String matricula) {
		// TODO Auto-generated constructor stub
		this.marca = marca;
		this.matricula = matricula;
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

	@Override
	public String toString() {
		return "Coche [marca=" + marca + ", matricula=" + matricula + "]";
	}
	
	

}
