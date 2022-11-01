package puc.droneentrega.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import puc.droneentrega.model.Drone;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Long> {
}
