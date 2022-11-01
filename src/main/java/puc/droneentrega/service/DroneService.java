package puc.droneentrega.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import puc.droneentrega.model.Drone;
import puc.droneentrega.repository.DroneRepository;

import java.util.Optional;

@Service
public class DroneService {

    DroneRepository droneRepository;

    @Autowired
    public DroneService(DroneRepository droneRepository){
        this.droneRepository = droneRepository;
    }

    public Drone save(Drone drone){
        return droneRepository.save(drone);
    }

    public Optional<Drone> get(Long id) {
        return droneRepository.findById(id);
    }

    public void delete(Drone drone) { droneRepository.delete(drone); }
}
