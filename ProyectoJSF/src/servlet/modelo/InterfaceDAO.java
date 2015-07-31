package servlet.modelo;

import java.util.List;
/**
 * 
 * @author giovanton
 *
 */
public interface InterfaceDAO {

	public abstract List consultarTodo();

	public abstract void modificar(Object o);
	
	public Object leerRegistro(int id);
	
	//public List consultarPor(String campo,int id);

}