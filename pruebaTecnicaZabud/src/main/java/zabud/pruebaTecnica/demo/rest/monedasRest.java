package zabud.pruebaTecnica.demo.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zabud.pruebaTecnica.demo.entity.moneda;
import zabud.pruebaTecnica.demo.dao.monedaDAO;

@RestController
@RequestMapping("Alcancía")
public class monedasRest {

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
