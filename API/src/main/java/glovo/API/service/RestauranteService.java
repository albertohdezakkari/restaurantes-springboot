package glovo.API.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import glovo.API.controller.RestauranteRepository;
import glovo.API.model.Restaurante;

@Service
@Transactional(readOnly = true)
public class RestauranteService {
	@Autowired
	private final RestauranteRepository restauranteRepository;
	
	public RestauranteService(RestauranteRepository restauranteRepository) {
		this.restauranteRepository = restauranteRepository;
	}
	
	@Transactional
	public Restaurante update(Restaurante restaurante) {
		return this.restauranteRepository.save(restaurante);
	}	
	@Transactional
	public Restaurante create(Restaurante restaurante) {
		return this.restauranteRepository.save(restaurante);
	}
	@Transactional
	public void delete(Restaurante restaurante) {
		this.restauranteRepository.delete(restaurante);
	}
	
	public List<Restaurante> findAll() {
		return this.restauranteRepository.findAll();
	}
	
}
