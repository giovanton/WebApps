package servletCartelera.pojo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Pelicula {
	
	private String Nombre;
	private String fechaEstreno;
	private String media;
	private String MasInfo;

	public Pelicula(String nombre, String fecha, String media, String info) {
		this.Nombre = nombre;
		this.fechaEstreno = fecha;
		this.media = media;
		this.MasInfo = info;
	}
	
	public String getNombre() {
		return Nombre;
	}
	
	public String getFechaEstreno() {
		return fechaEstreno;
	}
	
	public String getMedia() {
		return media;
	}
	
	public String getMasInfo() {
		return MasInfo;
	}
}