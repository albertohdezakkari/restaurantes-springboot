package glovo.API.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "RESTAURANTE")

public class Restaurante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_RESTAURANTE")
	private int id_restaurante;

	/*The value can be AUTO, TABLE, SEQUENCE, or IDENTITY.
	 * https://thoughts-on-java.org/jpa-generate-primary-keys/*/

	
	@Column(name="NOMBRE", unique=true, length = 50, nullable = false)
	private String nombre;
	@Column(name="DESCRIPCION", unique=false, length = 50, nullable = true)
	private String descripcion;
	@Column(name="VENTAS", unique=false, nullable = false)
	private int ventas;
	@Column(name="IMAGEN", unique=true, length = 50, nullable = true)
	private String imagen;
	
	
	private String categoria;
	private Double valoracion;
	
	
	public Restaurante() {
		
	}
}
