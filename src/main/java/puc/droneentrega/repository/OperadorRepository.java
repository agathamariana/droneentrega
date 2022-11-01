package puc.droneentrega.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import puc.droneentrega.model.Operador;

@Repository
public interface OperadorRepository extends JpaRepository<Operador, Long> {
}
