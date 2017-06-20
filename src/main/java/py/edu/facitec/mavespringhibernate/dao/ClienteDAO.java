package py.edu.facitec.mavespringhibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.mavespringhibernate.model.Cliente;

@Repository
public class ClienteDAO extends DaoGenerico<Cliente>{
	
	public ClienteDAO() {
		super(Cliente.class);
		// TODO Auto-generated constructor stub
	}
	@PersistenceContext
	private EntityManager manager;
	public void save(Cliente cliente){
		
		manager.persist(cliente);
		
	}
	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return manager;
	}

}
