package glovo.API.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import glovo.API.model.CategoriaRestaurante;

public interface CategoriaRestauranteRepository extends JpaRepository<CategoriaRestaurante, Integer>{

	/*AYUDA*/
	/*CREAR NATIVE QUERY PARA PERSONALIZAR CONSULTAS*/
	@Query(value = "SELECT CR.ID_CATEGORIA, CR.CATEGORIA "
			+ "FROM CATEGORIA_RESTAURANTE CR WHERE "
			+ "CR.ID_CATEGORIA = :ID_CATEGORIA", nativeQuery = true)
	public CategoriaRestaurante 
				findIdRestaurantesByIdCategoria 
				
				(@Param("ID_CATEGORIA") int id_categoria);
}
