package org.apache.struts.coches;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class ConversorCoches extends StrutsTypeConverter {

	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		// TODO Auto-generated method stub
		Coche c = new Coche(arg1[0],arg1[1]);
		return c;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		// TODO Auto-generated method stub
		Coche c = (Coche)arg1;
		return c.toString();
	}

}
