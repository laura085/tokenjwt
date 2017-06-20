package py.edu.facitec.mavespringhibernate.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Departamento {
	
	@Id
	@GeneratedValue


	private Integer Id;
	
	private String descripcion;
	@OneToOne(mappedBy="departamento")
	private Gerente gerente;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Gerente getGerente() {
		return gerente;
	}
	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}
	@Override
	public String toString() {
		return "Departamento [Id=" + Id + ", descripcion=" + descripcion + ", gerente=" + gerente + "]";
	}
	
	
	
	

}
