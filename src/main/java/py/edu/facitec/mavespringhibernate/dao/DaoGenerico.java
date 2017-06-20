package py.edu.facitec.mavespringhibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;

public abstract class DaoGenerico<T> {
private Class<T> entityClass;
public DaoGenerico(Class<T> entityClass){
this.entityClass=entityClass;
}
protected abstract EntityManager getEntityManager();
public void insertar(T entity){
getEntityManager().persist(entity);//Es manipulado por EM
}
//METODO PARA ACTUALIZAR
public void actualizar(T entity){
getEntityManager().merge(entity);//actualiza
}
//METODO PARA BUSCAR
public T buscar(Object id){
//System.out.println("Entidad: "+getEntityManager().find(entityClass, id));
return getEntityManager().find(entityClass, id);
}
//METODO PARA GUARDAR
public void guardar(T entity){
	
	//Obtener el id de una entidad pasada
Object id=getEntityManager().getEntityManagerFactory().
getPersistenceUnitUtil().getIdentifier(entity);	

	
	if(id==null){
		
		insertar(entity);
		
	}else{
	
	if(buscar(entity)==null){
		insertar(entity);
	}else{
		actualizar(entity);
	}

	}

}
//METODO QUE RETORNA UNA LISTA DE UNA ENTIDAD
public List<T> getLista(){
return getEntityManager().createQuery
("from "+entityClass.getSimpleName(), entityClass).getResultList();
}
//Inicia la transaccion
public void iniciarTransaccion(){
if(!getEntityManager().getTransaction().isActive()){
getEntityManager().getTransaction().begin();
}
}
//Cierra la transaccion
public void finalizarTransaccion(){
if(getEntityManager().getTransaction().isActive()){
getEntityManager().getTransaction().commit();//Cierre de la transaccion
}
}
//Metodo para eliminar
public void eliminar(T entity){
getEntityManager().remove(getEntityManager().contains(entity)?
entity: getEntityManager().merge(entity) );} }
