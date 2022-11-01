package puc.droneentrega.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import puc.droneentrega.model.Viagem;

@Repository
public interface ViagemRepository extends JpaRepository<Viagem, Long> {
}
