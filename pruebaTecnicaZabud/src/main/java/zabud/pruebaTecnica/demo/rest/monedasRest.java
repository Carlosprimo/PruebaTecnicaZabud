package zabud.pruebaTecnica.demo.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import zabud.pruebaTecnica.demo.entity.moneda;
import zabud.pruebaTecnica.demo.dao.monedaDAO;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class monedasRest {

	 @Bean
     public WebMvcConfigurer corsConfigurer() {
         return new WebMvcConfigurer() {
             @Override
             public void addCorsMappings(CorsRegistry registry) {
                 registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE");
             }
         };
     }
	
	@Autowired
	private monedaDAO monedaDAO;
	
	@GetMapping
	public ResponseEntity<List<moneda>>  getMonedas(){
		List<moneda> m = monedaDAO.findAll();
		return ResponseEntity.ok(m);
	}
	
	@RequestMapping(value="{MonedaID}")
	public ResponseEntity<moneda> getMonedaByID(@PathVariable("MonedaID") Long monedaID){
		Optional<moneda> optionalMoneda = monedaDAO.findById(monedaID);
		if(optionalMoneda.isPresent()) {
			return ResponseEntity.ok(optionalMoneda.get());
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	@PutMapping
	public ResponseEntity<moneda> updateMoneda(@RequestBody moneda alcancia){
		Optional<moneda> optionalMoneda = monedaDAO.findById(alcancia.getId());
		if (optionalMoneda.isPresent()) {
			moneda updateMoneda = optionalMoneda.get();
			updateMoneda.setCantidad(alcancia.getCantidad());
			monedaDAO.save(updateMoneda);
			return ResponseEntity.ok(updateMoneda);
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
}
