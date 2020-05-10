package glovo.API.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import glovo.API.controller.CategoriaRestauranteRepository;
import glovo.API.model.CategoriaRestaurante;

@Service
@Transactional(readOnly = true)
public class CategoriaRestauranteService {

	@Autowired
	private final CategoriaRestauranteRepository categoriaRestauranteRepository;
	
	public CategoriaRestauranteService(CategoriaRestauranteRepository categoriaRestauranteRepository) {
		this.categoriaRestauranteRepository = categoriaRestauranteRepository;
	}
	

	@Transactional
	public CategoriaRestaurante update(CategoriaRestaurante catRestaurante) {
		return this.categoriaRestauranteRepository.save(catRestaurante);
	}	
	@Transactional
	public CategoriaRestaurante create(CategoriaRestaurante catRestaurante) {
		return this.categoriaRestauranteRepository.save(catRestaurante);
	}
	@Transactional
	public void delete(CategoriaRestaurante catRestaurante) {
		this.categoriaRestauranteRepository.delete(catRestaurante);
	}
	public List<CategoriaRestaurante> findAll() {
		return this.categoriaRestauranteRepository.findAll();
	}
	public CategoriaRestaurante findByIdCategoriaResataurante(int id_categoria) {
		return this.categoriaRestauranteRepository.findIdRestaurantesByIdCategoria(id_categoria);
	}
}
