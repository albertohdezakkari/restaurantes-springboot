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

import glovo.API.model.CategoriaRestaurante;
import glovo.API.service.CategoriaRestauranteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/categoriarestaurante")
@Api(tags = "categoriarestaurante")
public class CategoriaRestauranteResource {
	private final CategoriaRestauranteService categoriaRestauranteService;
	
	public CategoriaRestauranteResource(CategoriaRestauranteService categoriaRestauranteService) {
		this.categoriaRestauranteService = categoriaRestauranteService;
	}
	
	@GetMapping
	@ApiOperation(value="Listar Categorias Restaurantes", notes="Servicio para listar las categorías de los restaurantes")
	@ApiResponses(value= {@ApiResponse(code=201, message="Categorías de restaurantes listadas correctamente"), @ApiResponse(code=400, message="Solicitud inválida")})
	public ResponseEntity<List<CategoriaRestaurante>> findAll(){
		return ResponseEntity.ok(this.categoriaRestauranteService.findAll());
	}
	
	
	@PostMapping
	@ApiOperation(value="Crear categoría de restaurante", notes="Servicio para crear una nueva categoría de restaurante")
	@ApiResponses(value= {@ApiResponse(code=201, message="Categoría de restaurante creada correctamente"), @ApiResponse(code=400, message="Solicitud inválida")})
	public ResponseEntity<CategoriaRestaurante> create(@RequestBody CategoriaRestaurante newCatRestaurante){
		CategoriaRestaurante categoriaRestaurante = new CategoriaRestaurante();
		categoriaRestaurante.setCategoria(newCatRestaurante.getCategoria());
		
		return new ResponseEntity<>(this.categoriaRestauranteService.create(categoriaRestaurante), 
				HttpStatus.CREATED);
	}
	
	
	@PutMapping("/{id_categoria}")
	@ApiOperation(value="Actualizar categoría restaurante", notes="Servicio para actualizar la categoría de un restaurante")
	@ApiResponses(value= {@ApiResponse(code=201, message="Categoría de restaurante actualizada correctamente"), @ApiResponse(code=400, message="Solicitud inválida")})
	public ResponseEntity<CategoriaRestaurante> update(@PathVariable("id_categoria") Integer id_categoria, @RequestBody CategoriaRestaurante newCatRestaurante){
		CategoriaRestaurante categoriaRestaurante = this.categoriaRestauranteService.findByIdCategoriaResataurante(id_categoria);
		if(categoriaRestaurante != null) {
			categoriaRestaurante.setCategoria(newCatRestaurante.getCategoria());
		}
		return new ResponseEntity<>(this.categoriaRestauranteService.update(categoriaRestaurante), 
				HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/{id_categoria}")
	@ApiOperation(value="Eliminar categoría de restaurante", notes="Servicio para eliminar una categoría de restaurante")
	@ApiResponses(value= {@ApiResponse(code=201, message="Categoría de restaurante eliminada correctamente"), @ApiResponse(code=400, message="Solicitud inválida")})
	public void delete(@PathVariable("id_categoria") Integer id_categoria){
			CategoriaRestaurante categoriaRestaurante = this.categoriaRestauranteService.findByIdCategoriaResataurante(id_categoria);
			if(categoriaRestaurante != null) {
				this.categoriaRestauranteService.delete(categoriaRestaurante);
			}
	}
	
	@PostMapping("/getCategoriaRestauranteById/{id_categoria}")
	@ApiOperation(value="Buscar una categoría de restaurante por ID", notes="Servicio para buscar una categoría de restaurante por ID")
	@ApiResponses(value= {@ApiResponse(code=201, message="Categoría de restaurante listada correctamente"), @ApiResponse(code=400, message="Solicitud inválida")})
	public ResponseEntity<CategoriaRestaurante> getCategoriaRestauranteById(@RequestParam int id_categoria){		
		return ResponseEntity.ok(this.categoriaRestauranteService.findByIdCategoriaResataurante(id_categoria));
	}
}
