package glovo.API.view;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import glovo.API.model.Restaurante;
import glovo.API.service.RestauranteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/restaurante")
@Api(tags = "restaurante")
public class RestauranteResource {
	private final RestauranteService restauranteService;

	public RestauranteResource(RestauranteService restauranteService) {
		this.restauranteService = restauranteService;
	}
	
	@GetMapping
	@ApiOperation(value="Listar Restaurantes", notes="Servicio para listar restaurantes")
	@ApiResponses(value= {@ApiResponse(code=201, message="Restaurantes listados correctamente"), @ApiResponse(code=400, message="Solicitud inválida")})
	public ResponseEntity<List<Restaurante>> findAll(){
		return ResponseEntity.ok(this.restauranteService.findAll());
	}
	
	
	@PostMapping
	@ApiOperation(value="Crear Restaurante", notes="Servicio para crear un nuevo restaurante")
	@ApiResponses(value= {@ApiResponse(code=201, message="Restaurante creado correctamente"), @ApiResponse(code=400, message="Solicitud inválida")})
	public ResponseEntity<Restaurante> create(@RequestBody Restaurante newRestaurante){
		Restaurante restaurante = new Restaurante();
		restaurante.setNombre(newRestaurante.getNombre());
		restaurante.setDescripcion(newRestaurante.getDescripcion());
		restaurante.setVentas(newRestaurante.getVentas());
		restaurante.setImagen(newRestaurante.getImagen());
		
		return new ResponseEntity<>(this.restauranteService.create(restaurante), 
				HttpStatus.CREATED);
	}
	
	

}
