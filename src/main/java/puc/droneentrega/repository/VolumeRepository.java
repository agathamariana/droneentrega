package puc.droneentrega.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import puc.droneentrega.model.Volume;

@Repository
public interface VolumeRepository extends JpaRepository<Volume, Long> {
}
