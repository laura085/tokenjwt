package py.edu.facitec.mavespringhibernate.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import py.edu.facitec.mavespringhibernate.dao.ProductoDAO;
import py.edu.facitec.mavespringhibernate.model.Producto;

//Para construir un controlador que soporte la arquitectura REST
@RestController

@Transactional

@RequestMapping("/productos")//Este es utilizado para todos los metodos de la clase
public class ProductoController {

	@Autowired
	private ProductoDAO productoDAO;
	
	
	//Si queremos agregar una url utilizamos value="/guardar"
@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)	
												//Se convierte de Json a objeto java
										//Mediante la libreria Japckson
															
public ResponseEntity<Producto>  registrar(@RequestBody Producto producto){
		
				System.out.println(producto);
	
				productoDAO.guardar(producto);

				
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}
	
@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<Producto>> listado(){
	
	
	List<Producto> productos=productoDAO.getLista();
	
	
	System.out.println(productos);
	
					//Al indicar que va producir Json dentro del Request Mapping
	
	//Convierte el objeto java en JSON  a travéz del ResponseEntity
	return new ResponseEntity<List<Producto>>(productos,HttpStatus.OK);
	
}	
                   //Parametro que recibe a travez de la url
@RequestMapping(value="/{id}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
									 //Convierte el parametro a un objeto java		
public ResponseEntity<Producto> buscar(@PathVariable Integer id){
	
	
		Producto producto=productoDAO.buscar(id);
	
													//representa el estado 200
												//que indica que la petición se realizo con exito
	return new ResponseEntity<Producto>(producto,HttpStatus.OK);
}



@RequestMapping(value="/{id}", method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Producto> eliminar(@PathVariable Integer id){

	
	Producto producto=productoDAO.buscar(id);
	
	System.out.println("Producto "+producto);
	
	if(producto==null){
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	productoDAO.eliminar(producto);
	
	
	
	
	return new ResponseEntity<>(HttpStatus.OK);
}



	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
