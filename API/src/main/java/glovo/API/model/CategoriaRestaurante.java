package glovo.API.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CATEGORIA_RESTAURANTE")
public class CategoriaRestaurante {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ID_CATEGORIA")
	private int id_categoria;
	
	@Column(name="CATEGORIA", unique=false, nullable = false)
	private String categoria;
	
	@ManyToMany
	@JoinTable(name = "tiporestaurante", 
		joinColumns = @JoinColumn(name = "ID_CATEGORIA", 
		referencedColumnName = "ID_CATEGORIA"), 
		inverseJoinColumns = 
		@JoinColumn(name = "ID_RESTAURANTE", referencedColumnName = "ID_RESTAURANTE"))
	private Set<Restaurante> restaurantes;
}
