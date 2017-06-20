package py.edu.facitec.mavespringhibernate.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;


import py.edu.facitec.mavespringhibernate.model.Departamento;

@Repository
public class DepartamentoDAO extends DaoGenerico<Departamento>{
	
	public DepartamentoDAO() {
		super(Departamento.class);
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
