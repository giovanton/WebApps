/**
 * 
 */
var xmlHttp = null;

function iniciaObjetoRequest ()
{
	
return new XMLHttpRequest();
}

function rellenaCaja()
{
	xmlHttp = iniciaObjetoRequest();
	xmlHttp.onreadystatechange = procesarEventos;
	xmlHttp.open('GET', 'CargaMenuSelect?num=30', true); //indicamos como vamos a enviar los datos, en este caso con el metodo GET al archivo meses.php?num= el valor que le indiquemos en el textbox
	xmlHttp.send(null);
	
}

function procesarEventos()
{
   //Obtenemos el control del TAG que contendrá la respuesta
  if(xmlHttp.readyState==4) //ya hemos recibido respuesta del servidor
  {
      if(xmlHttp.status==200)// y el código de la cabecera http es bueno
          {
			//alert("He recibido " + xmlHttp.responseText);
			//document.getElementById("cajatexto").value = xmlHttp.responseText;
			
			
          	var lista_dptos = xmlHttp.responseXML.getElementsByTagName("departamento");
          	var nelementos = lista_dptos.length;
          	var opcion;
          	var desplegable = document.getElementById("departamentos");
          	
          	var id = null;
          	var nombre = null;
      
			for (var i= 0; i < nelementos; i++) {
				
				
				/*var id = lista_dptos[i].children[0].textContent;
				var nombre = lista_dptos[i].children[1].textContent;*/ //FORMA MÁS ELEGANTE Y LÓGICA, PERO NO COMPATIBLE CON IE :S
				
				var elementoId= lista_dptos[i].getElementsByTagName("id")[0];
				var elementoNombre = lista_dptos[i].getElementsByTagName("nombre")[0];
				
				
				id = elementoId.childNodes[0].data; //también podría usar firstChild
				nombre = elementoNombre.childNodes[0].data;//en vez de childNodes[0]
				
				
				opcion = new Option(nombre, id);//Creo la opción
				desplegable.options[desplegable.options.length] = opcion;//la seteo. POdría haber usado como índice [i]
				 
				
			}
          }
      else
      {
          alert("Ha ocurrido un error"+ xmlHttp.status +":"+ xmlHttp.statusText);
      }
  }

}


function procesarTrabajadores()
{
   //Obtenemos el control del TAG que contendrá la respuesta
  if(xmlHttp.readyState==4) //ya hemos recibido respuesta del servidor
  {
      if(xmlHttp.status==200)// y el código de la cabecera http es bueno
          {
			//alert("He recibido " + xmlHttp.responseText);
			
			var parser = new DOMParser();
			var xmlDoc = parser.parseFromString(xmlHttp.responseText, "application/xml");
			
        	var lista_empleados = xmlDoc.getElementsByTagName("empleado");
          	var nelementos = lista_empleados.length;
          	var opcion;
          	var desplegable = document.getElementById("empleados");
          	
          	var id = null;
          	var nombre = null;
      
          	
          	for (var j=0; j <  desplegable.length; j++)
          	{
          		desplegable.options[j] = null;
          	}
          	
			for (var i= 0; i < nelementos; i++) {
				
				
				/*var id = lista_dptos[i].children[0].textContent;
				var nombre = lista_dptos[i].children[1].textContent;*/ //FORMA MÁS ELEGANTE Y LÓGICA, PERO NO COMPATIBLE CON IE :S
				
				 nombre = lista_empleados[i].childNodes[0].data;//en vez de childNodes[0]
				
				
				opcion = new Option(nombre, nombre);//Creo la opción
				desplegable.options[i] = opcion;//la seteo. POdría haber usado como índice [i]
				 
				
			}
          }
      else
      {
          alert("Ha ocurrido un error"+ xmlHttp.status +":"+ xmlHttp.statusText);
      }
  }

}

function entablarTrabajadores(){
	//Obtenemos el control del TAG que contendrá la respuesta
	  if(xmlHttp.readyState==4) //ya hemos recibido respuesta del servidor
	  {
	      if(xmlHttp.status==200)// y el código de la cabecera http es bueno
	          {
				//alert("He recibido " + xmlHttp.responseText);
				
				var parser = new DOMParser();
				var xmlDoc = parser.parseFromString(xmlHttp.responseText, "application/xml");
				
	        	var lista_empleados = xmlDoc.getElementsByTagName("empleado");
	          	var nelementos = lista_empleados.length;
	          	//var opcion;
	          	var tabla = document.getElementById("empleados");
	          	tabla.border = 1;
	          	var fila;
	          	var id = null;
	          	var nombre = null;
	      
	          	var eid = null;
	          	var enombre = null;
	          	
	          	for (var j = (tabla.rows.length-1); j >= 0; j--)
	          	{
	          		tabla.deleteRow(j);
	          	}
	          
				for (var i= 0; i < nelementos; i++) {
					
					
					/*var id = lista_dptos[i].children[0].textContent;
					var nombre = lista_dptos[i].children[1].textContent;*/ //FORMA MÁS ELEGANTE Y LÓGICA, PERO NO COMPATIBLE CON IE :S
					eid = lista_empleados[i].getElementsByTagName("id")[0];
					enombre = lista_empleados[i].getElementsByTagName("nombre")[0];
					
					 id = eid.childNodes[0].data;//en vez de childNodes[0]
					nombre = enombre.childNodes[0].data;

					fila = tabla.insertRow(-1);
					fila.addEventListener("mouseover",function(event){
							event.currentTarget.style.background = "red";
						},false)
					fila.addEventListener("mouseout",function(event){
							event.currentTarget.style.background = "";
						},false)
					fila.addEventListener("click",function(event){
						//alert(event.currentTarget.cells[0].textContent);
						detallarEmpleado(event.currentTarget.cells[0].textContent);
						},false)
					var celda1 = fila.insertCell(0);
					var celda2 = fila.insertCell(1);
					var celdaId = document.createTextNode(id);
					var celdaNombre = document.createTextNode(nombre);
					celda1.appendChild(celdaId);
					 celda2.appendChild(celdaNombre);
				
				}
	          }
	      else
	      {
	          alert("Ha ocurrido un error"+ xmlHttp.status +":"+ xmlHttp.statusText);
	      }
	  }
}

function listarTrabajadores()
{
	var desplegable = document.getElementById("departamentos");
	//alert ('Ha seleccionado el valor ' + desplegable[desplegable.selectedIndex].value);
	//alert ('Del departamento nombre' + desplegable[desplegable.selectedIndex].text);
	var dpto = desplegable[desplegable.selectedIndex].value;
	
	xmlHttp = new XMLHttpRequest();
	//xmlHttp.onreadystatechange = procesarTrabajadores;
	xmlHttp.onreadystatechange = entablarTrabajadores;
	xmlHttp.open('GET', 'CargarTrabajadores?dpto='+dpto, true); //indicamos como vamos a enviar los datos, en este caso con el metodo GET al archivo meses.php?num= el valor que le indiquemos en el textbox
	xmlHttp.send(null);
	
	
}

function detallarEmpleado(eid)
{
	xmlHttp = new XMLHttpRequest();

	xmlHttp.onreadystatechange = procesarDetalles;
	xmlHttp.open('GET', 'JsonHandler?eid='+eid, true);
	xmlHttp.send(null);
}

function procesarDetalles()
{
	 if(xmlHttp.readyState==4) //ya hemos recibido respuesta del servidor
	  {
	      if(xmlHttp.status==200)// y el código de la cabecera http es bueno
	          {
				alert("He recibido Json " + xmlHttp.responseText);
				var objetoJson = JSON.parse(xmlHttp.responseText);
				alert(objetoJson);
				document.getElementById("detalles").innerHTML = 
objetoJson.first_name + " " + objetoJson.last_name + " " +objetoJson.salary;
				
	          }
	      else
	      {
	          alert("Ha ocurrido un error"+ xmlHttp.status +":"+ xmlHttp.statusText);
	      }
	  }
}

