package py.edu.facitec.mavespringhibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import py.edu.facitec.mavespringhibernate.model.Producto;

@Repository
public class ProductoDAO extends DaoGenerico<Producto>{
	
	public ProductoDAO() {
		super(Producto.class);
		// TODO Auto-generated constructor stub
	}
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return manager;
	}

}
