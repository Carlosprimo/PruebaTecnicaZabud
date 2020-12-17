package zabud.pruebaTecnica.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import zabud.pruebaTecnica.demo.entity.moneda;

public interface monedaDAO extends JpaRepository<moneda,Long> {

}
