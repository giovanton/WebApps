package servletCartelera.servicios;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import servletCartelera.pojo.Pelicula;

public class ParseaXML {
	private static Logger log = LogManager.getRootLogger();

	public List extraerCartelera() {
		List<Pelicula> lista = new ArrayList<Pelicula>();
		SAXBuilder builder = new SAXBuilder();
		Document doc = null;
		String nombre = null;
		String fecha = null;
		String media = null;
		String info = null;
		try {
			URL xml = new URL("http://www.estrenosdecine.net/estrenos-rss.xml");
			doc = builder.build(xml);
			log.info("extrayendo elementos del xml");
		} catch (JDOMException | IOException e) {
			log.error("Fallo al obtener el xml a parsear", e);
		}
		List<Element> items = new ArrayList<Element>();
		try {
			Element rss = doc.getRootElement();
			Element channel = rss.getChild("channel");
			items = channel.getChildren();
		} catch (Exception e) {
			log.error("Fallo al parsear ", e);
		}

		for (Element item : items) {
			List<Element> detalles = item.getChildren();
			for (Element detalle : detalles) {
				String nombreItem = detalle.getName();
				//log.info(nombreItem);
				switch (nombreItem) {
				case "title":
					String nom = detalle.getValue();
					fecha = nom.substring((nom.lastIndexOf("(") + 1),
							nom.lastIndexOf(")"));
					nombre = nom.substring(0, nom.lastIndexOf("(") - 1);
					//log.info(nombre);
					break;
				case "link":
					info = detalle.getValue();
					//log.info(info);
					break;
				case "content":
					media = detalle.getAttribute("url").getValue();
					//log.info(media);
					break;
				default:
					break;
				}
			}
			Pelicula p = new Pelicula(nombre, fecha, media, info);
			log.info("añadiendo película " + p.getNombre());
			if (null != p.getNombre()) {
				lista.add(p);
			}
		}
		/*
		 * if (nombre.lastIndexOf("(") > 0) {
		 * 
		 * log.info(fecha); }
		 */

		return lista;

	}
}
