package glovo.API.controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import glovo.API.model.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, Integer>{
	/*Query Methods*/
	
}
