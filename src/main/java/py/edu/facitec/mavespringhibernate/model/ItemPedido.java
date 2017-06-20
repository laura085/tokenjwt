package py.edu.facitec.mavespringhibernate.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemPedido {
	
	@Id
	@GeneratedValue
	private Long id;
	private int cantidadProducto;

	private double subtotal;
	
	@ManyToOne
	private Producto producto;
	
	
	
	

}
